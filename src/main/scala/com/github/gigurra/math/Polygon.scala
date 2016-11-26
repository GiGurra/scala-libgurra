package com.github.gigurra.math

import spire.math.Numeric
import spire.implicits._

import scala.reflect.ClassTag
import scala.language.postfixOps

/**
  * Created by johan on 2016-10-24.
  */
case class Polygon[@specialized(Int,Long,Float,Double) T : Numeric : ClassTag](edge: Seq[Vec2[T]],
                                                                               clockwise: Boolean,
                                                                               area: T) {
  require(edge.length >= 3, s"Polygon of less than 3 points")

  final lazy val asElementArray: Array[T] = edge.toElementArray
  final lazy val sides: Seq[(Vec2[T], Vec2[T])] = edge.sliding(2, 1).toSeq.map(p => (p.head, p(1))) ++ Seq((edge.last, edge.head))
  final lazy val vectors: Seq[Vec2[T]] = sides.map{case (point, nextPoint) => nextPoint - point}
  final lazy val angleDeltas: Seq[Double] = {
    (vectors.last +: vectors).sliding(2, 1).map{ case Seq(v1, v2) => v1.angleTo(v2) }.toSeq
  }
  final lazy val outwardAngles: Seq[Double] = {
    def outwardAngle(v1: Vec2[T], v2: Vec2[T]): Double = {
      if (clockwise) v2.cwAngleTo(v1)
      else v2.ccwAngleTo(v1)
    }
    (vectors.last +: vectors).sliding(2, 1).map{ case Seq(v1, v2) => outwardAngle(v1, v2) }.toSeq
  }
  final lazy val inwardAngles: Seq[Double] = outwardAngles.map(360.0 - _)
  final lazy val cg: Vec2[T] = doCalcCg()

  def rotate(degrees: Double, origin: Vec2[T] = cg)(implicit double2T: Double2[T]): Polygon[T] = {

    val cos = double2T.cvt(math.cos(degrees.toRadians))
    val sin = double2T.cvt(math.sin(degrees.toRadians))

    def rotateVertex(vertex: Vec2[T]): Vec2[T] = {
      val localX = vertex.x - origin.x
      val localY = vertex.y - origin.y
      new Vec2[T](
        x = cos * localX - sin * localY + origin.x,
        y = sin * localX + cos * localY + origin.y
      )
    }

    new Polygon[T](
      edge = edge.map(rotateVertex),
      clockwise = clockwise,
      area = area
    )
  }

  def slice(i1: Int, i2: Int): (Polygon[T], Polygon[T]) = {
    require(i1 >= 0, s"Start index of slice is negative")
    require(i2 >= 0, s"End index of slice is negative")
    require(i1 < edge.length, s"Start index is >= edge.length")
    require(i2 < edge.length, s"End index is >= edge.length")
    require(i1 != i2, s"Start index must be different than End index")
    if (i1 > i2) {
      doSlice(i2, i1).swap
    } else {
      doSlice(i1, i2)
    }
  }

  /**
    * Checks if it is possible slice this polygon from i1 to i2 without cutting through air
    */
  def isCleanSlice(i1: Int, i2: Int): Boolean = {
    val validPoints = i1 >= 0 && i2 >= 0 && i1 < edge.length && i2 < edge.length && i1 != i2
    validPoints && (if (i1 > i2) {
      doIsCleanSlice(i2, i1)
    } else {
      doIsCleanSlice(i1, i2)
    })
  }

  /**
    * Not guaranteed to work for vertex coordinates
    */
  def contains(point: Vec2[T]): Boolean = {
    doContains(point.toDouble)
  }

  private def doIsCleanSlice(i1: Int, i2: Int): Boolean = {
    val n = edge.length
    val fwdDelta = i2 - i1
    val bwdDelta = fwdDelta - n

    if (fwdDelta >= 2 && bwdDelta <= -2) {
      val unscaledOrigin = edge(i1).toDouble
      val unscaledEnd = edge(i2).toDouble
      val unscaledVector = unscaledEnd - unscaledOrigin
      val origin = unscaledOrigin + unscaledVector * 1e-7
      val end = unscaledEnd - unscaledVector * 1e-7
      def toDouble(side: (Vec2[T], Vec2[T])): (Vec2[Double], Vec2[Double]) = (side._1.toDouble, side._2.toDouble)
      doContains(origin) && doContains(end) && sides.map(toDouble).forall(!LinesIntersect(_, (origin, end)))
    } else {
      false
    }
  }

  private def doContains(point: Vec2[Double]): Boolean =  {
    var i = 0
    var j = length - 1
    var result = false
    while (i < edge.length) {
      if ((edge(i).y.toDouble > point.y) != (edge(j).y.toDouble > point.y) &&
        (point.x < (edge(j).x.toDouble - edge(i).x.toDouble) * (point.y - edge(i).y.toDouble) / (edge(j).y.toDouble - edge(i).y.toDouble) + edge(i).x.toDouble)) {
        result = !result
      }
      j = i
      i += 1
    }
    result
  }

  /**
    * Here we know i2 > i1, as this was verified in slice(..)
    */
  private def doSlice(i1: Int, i2: Int): (Polygon[T], Polygon[T]) = {
    val n = edge.length
    val fwdDelta = i2 - i1
    val bwdDelta = fwdDelta - n
    require(fwdDelta >= 2, s"Difference from Start index to End index must be >= 2")
    require(bwdDelta <= -2, s"Difference from End index to from index must be <= -2")

    val fwdPolygon = Polygon(((0 to i1) ++ (i2 until n)).map(edge.apply))
    val bwdPolygon = Polygon((i1 to i2).map(edge.apply))

    (fwdPolygon, bwdPolygon)
  }

  /**
    * Taken from http://stackoverflow.com/questions/5271583/center-of-gravity-of-a-polygon
    */
  private def doCalcCg(): Vec2[T] = {
    var sum = Zero[T]
    var vsum: Vec2[T] = Vec2.zero

    var i = 0
    while (i < edge.length) {
      val v1 = edge(i)
      val v2 = edge((i + 1) % length)
      val cross = 2 * v1.x * v2.y - 2 * v1.y * v2.x // The 2 * is required for it to work with integral types
      sum += cross
      vsum += Vec2(v1.x + v2.x, v1.y + v2.y) * cross
      i += 1
    }

    Vec2(vsum.x, vsum.y) / (3 * sum)
  }

  final def counterClockWise: Boolean = !clockwise
  final def cw: Boolean = clockwise
  final def ccw: Boolean = counterClockWise
  final def size: Int = edge.length
  final def length: Int = size
}

object Polygon {

  def apply[@specialized(Int,Long,Float,Double) T : Numeric: ClassTag](edge: Seq[Vec2[T]]): Polygon[T] = {
    require(edge.length >= 3, s"Polygon is less than 3 points")
    val w = clockwiseWeight(edge)
    new Polygon[T](edge, w > Zero[T], w.abs() / Two[T])
  }

  // See http://stackoverflow.com/questions/1165647/how-to-determine-if-a-list-of-polygon-points-are-in-clockwise-order
  def clockwiseWeight[@specialized(Int,Long,Float,Double) T : Numeric](edge: Seq[Vec2[T]]): T = {
    require(edge.length >= 3, s"Polygon is less than 3 points")
    var sum = Zero[T]
    val n = edge.length
    var i = 0

    def segment(i1: Int, i2: Int): T = {
      val v1 = edge(i1)
      val v2 = edge(i2)
      (v2.x - v1.x) * (v2.y + v1.y)
    }

    while(i < n - 1) {
      sum += segment(i, i+1)
      i += 1
    }

    sum += segment(n-1, 0)

    sum
  }

  /**
    * Checks that a slice did not go through air
    */
  def isCompleteSlice[@specialized(Int,Long,Float,Double) T : Numeric](original: Polygon[T],
                                                                       piece1: Polygon[T],
                                                                       piece2: Polygon[T],
                                                                       i1: Int,
                                                                       i2: Int): Boolean = {
    if (i1 > i2) {
      doIsCompleteSlice(original, piece1, piece2, i2, i1)
    } else {
      doIsCompleteSlice(original, piece1, piece2, i1, i2)
    }
  }

  /**
    * Checks that a slice did not go through air, where i2 is guaranteed to be > i1
    */
  private def doIsCompleteSlice[@specialized(Int,Long,Float,Double) T : Numeric](original: Polygon[T],
                                                                                 piece1: Polygon[T],
                                                                                 piece2: Polygon[T],
                                                                                 i1: Int,
                                                                                 i2: Int): Boolean = {
    val areaEpsilon = original.area / implicitly[Numeric[T]].pow(10, 5)
    val cuttingEdge = (original.edge(i1), original.edge(i2))
    def hasCuttingEdgeVertex(line: (Vec2[T], Vec2[T])): Boolean = {
      // These can by definition never intersect
      line._1 == cuttingEdge._1 || line._1 == cuttingEdge._2 || line._2 == cuttingEdge._1 || line._2 == cuttingEdge._2
    }
    def noLineCross(piece: Polygon[T]): Boolean = piece.sides.filterNot(hasCuttingEdgeVertex).forall(!LinesIntersect(_, cuttingEdge))
    def areasAlmostSame: Boolean = (piece1.area + piece2.area - original.area).abs() <= areaEpsilon
    areasAlmostSame && noLineCross(piece1) && noLineCross(piece2)
  }
}

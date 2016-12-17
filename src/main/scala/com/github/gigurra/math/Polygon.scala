package com.github.gigurra.math

import scala.language.postfixOps

/**
  * Created by johan on 2016-10-24.
  */
case class Polygon(edge: Seq[Vec2],
                   clockwise: Boolean,
                   area: Float) {
  require(edge.length >= 3, s"Polygon of less than 3 points")

  final lazy val asElementArray: Array[Float] = edge.toElementArray
  final lazy val sides: Seq[(Vec2, Vec2)] = edge.sliding(2, 1).toSeq.map(p => (p.head, p(1))) ++ Seq((edge.last, edge.head))
  final lazy val vectors: Seq[Vec2] = sides.map{case (point, nextPoint) => nextPoint - point}
  final lazy val angleDeltas: Seq[Float] = {
    (vectors.last +: vectors).sliding(2, 1).map{ case Seq(v1, v2) => v1.angleTo(v2) }.toSeq
  }

  final lazy val outwardAngles: Seq[Float] = {
    def outwardAngle(v1: Vec2, v2: Vec2): Float = {
      if (clockwise) v2.ccwAngleTo(-v1)
      else v2.cwAngleTo(-v1)
    }
    (vectors.last +: vectors).sliding(2, 1).map{ case Seq(v1, v2) => outwardAngle(v1, v2) }.toSeq
  }
  final lazy val inwardAngles: Seq[Float] = outwardAngles.map(360.0f - _)
  final lazy val cg: Vec2 = doCalcCg()

  final lazy val sliceableIndices: Map[Int, Set[Int]] = (for {
    startIndex <- 0 to size
    endIndices = (0 to size).filter(isCleanSlice0(startIndex, _)).toSet
  } yield startIndex -> endIndices ) toMap

  def rotate(degrees: Float, origin: Vec2 = cg): Polygon = {

    val cos = math.cos(degrees.toRadians).toFloat
    val sin = math.sin(degrees.toRadians).toFloat

    def rotateVertex(vertex: Vec2): Vec2 = {
      val localX = vertex.x - origin.x
      val localY = vertex.y - origin.y
      new Vec2(
        x = cos * localX - sin * localY + origin.x,
        y = sin * localX + cos * localY + origin.y
      )
    }

    new Polygon(
      edge = edge.map(rotateVertex),
      clockwise = clockwise,
      area = area
    )
  }

  def offset(delta: Vec2): Polygon = {
    Polygon(edge.map(_ + delta), clockwise, area)
  }

  def slice(i1: Int, i2: Int): (Polygon, Polygon) = {
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
    sliceableIndices.getOrElse(i1, Nil)(i2)
  }

  /**
    * Not guaranteed to work for vertex coordinates
    */
  def contains(point: Vec2, includeEdgePoints: Boolean = true): Boolean = {
    if (isEdgePoint(point)) {
      includeEdgePoints
    } else {
      doContains(point)
    }
  }

  def resizeRelative(newRelativeSize: Float, center: Vec2 = cg): Polygon = {
    Polygon(this.edge.map(_ - center).map(_ * newRelativeSize).map(_ + center))
  }

  def overlaps(otherPolygon: Polygon, relativeTolerance: Float = 1e-6f): Boolean = {
    require(relativeTolerance > 0.0, s"relativeTolerance must be > 0.0")
    require(relativeTolerance < 1.0, s"relativeTolerance must be < 1.0")
    // Shrink both shapes with 1e-6
    val thisShrunk: Polygon = this.resizeRelative(1.0f - relativeTolerance)
    val otherShrunk: Polygon = otherPolygon.resizeRelative(1.0f - relativeTolerance)
    thisShrunk.sides.exists(sideA => otherShrunk.sides.exists(LinesIntersect(_, sideA))) || // Any edge lines intersect
    thisShrunk.contains(otherShrunk.edge.head) || // Points from other shape are contained in this
    otherShrunk.contains(thisShrunk.edge.head) // Points from this shape are contained in other
  }

  def isEdgePoint(point: Vec2): Boolean = {
    edge.contains(point)
  }

  private def isCleanSlice0(i1: Int, i2: Int): Boolean = {
    val validPoints = i1 >= 0 && i2 >= 0 && i1 < edge.length && i2 < edge.length && i1 != i2
    validPoints && (if (i1 > i2) {
      doIsCleanSlice(i2, i1)
    } else {
      doIsCleanSlice(i1, i2)
    })
  }

  private def doIsCleanSlice(i1: Int, i2: Int): Boolean = {
    val n = edge.length
    val fwdDelta = i2 - i1
    val bwdDelta = fwdDelta - n

    val segment1: Seq[Vec2] = edge.slice(i1, i2+1)
    val segment2: Seq[Vec2] = (edge ++ edge).slice(i2, i2 - bwdDelta + 1)
    def segmentAreasExist: Boolean = Polygon(segment1).area.toDouble > 0.1 && Polygon(segment2).area.toDouble > 0.1

    if (fwdDelta >= 2 && bwdDelta <= -2 && segmentAreasExist) {
      val unscaledOrigin = edge(i1)
      val unscaledEnd = edge(i2)
      val unscaledVector = unscaledEnd - unscaledOrigin
      val origin: Vec2 = unscaledOrigin + unscaledVector * 1e-7f
      val end: Vec2 = unscaledEnd - unscaledVector * 1e-7f
      doContains(origin) && doContains(end) && sides.forall(!LinesIntersect(_, (origin, end)))
    } else {
      false
    }
  }

  private def doContains(point: Vec2): Boolean =  {
    var i = 0
    var j = length - 1
    var result = false
    while (i < edge.length) {
      if ((edge(i).y > point.y) != (edge(j).y > point.y) &&
        (point.x < (edge(j).x - edge(i).x) * (point.y - edge(i).y) / (edge(j).y - edge(i).y) + edge(i).x)) {
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
  private def doSlice(i1: Int, i2: Int): (Polygon, Polygon) = {
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
  private def doCalcCg(): Vec2 = {
    var sum = 0.0f
    var vsum: Vec2 = Vec2.zero

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

  def apply(edge: Seq[Vec2]): Polygon = {
    require(edge.length >= 3, s"Polygon is less than 3 points")
    val w = clockwiseWeight(edge)
    new Polygon(edge, w > 0.0f, math.abs(w) / 2.0f)
  }

  // See http://stackoverflow.com/questions/1165647/how-to-determine-if-a-list-of-polygon-points-are-in-clockwise-order
  def clockwiseWeight(edge: Seq[Vec2]): Float = {
    require(edge.length >= 3, s"Polygon is less than 3 points")
    var sum = 0.0f
    val n = edge.length
    var i = 0

    def segment(i1: Int, i2: Int): Float = {
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
  def isCompleteSlice(original: Polygon,
                      piece1: Polygon,
                      piece2: Polygon,
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
  private def doIsCompleteSlice(original: Polygon,
                                piece1: Polygon,
                                piece2: Polygon,
                                i1: Int,
                                i2: Int): Boolean = {
    val areaEpsilon = original.area / math.pow(10, 5).toFloat
    val cuttingEdge = (original.edge(i1), original.edge(i2))
    def hasCuttingEdgeVertex(line: (Vec2, Vec2)): Boolean = {
      // These can by definition never intersect
      line._1 == cuttingEdge._1 || line._1 == cuttingEdge._2 || line._2 == cuttingEdge._1 || line._2 == cuttingEdge._2
    }
    def noLineCross(piece: Polygon): Boolean = piece.sides.filterNot(hasCuttingEdgeVertex).forall(!LinesIntersect(_, cuttingEdge))
    def areasAlmostSame: Boolean = math.abs(piece1.area + piece2.area - original.area) <= areaEpsilon
    areasAlmostSame && noLineCross(piece1) && noLineCross(piece2)
  }
}

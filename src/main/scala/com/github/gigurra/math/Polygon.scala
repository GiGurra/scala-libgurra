package com.github.gigurra.math

import spire.math.Numeric
import spire.implicits._

import scala.reflect.ClassTag

/**
  * Created by johan on 2016-10-24.
  */
case class Polygon[@specialized(Int,Long,Float,Double) T : Numeric : ClassTag](edge: Seq[Vec2[T]], clockwise: Boolean) {
  require(edge.length >= 3, s"Polygon of less than 3 points")

  lazy val asFloatArray: Array[T] = edge.toElementArray

  final def counterClockWise: Boolean = !clockwise
  final def cw: Boolean = clockwise
  final def ccw: Boolean = counterClockWise
}

object Polygon {

  def apply[@specialized(Int,Long,Float,Double) T : Numeric: ClassTag](edge: Seq[Vec2[T]]): Polygon[T] = {
    new Polygon[T](edge, isClockWise(edge))
  }

  def isClockWise[@specialized(Int,Long,Float,Double) T : Numeric](edge: Seq[Vec2[T]]): Boolean = {
    require(edge.length >= 3, s"Polygon of less than 3 points")
    val zero = implicitly[Numeric[T]].zero
    var area: T = zero
    var p1x: T = zero
    var p1y: T = zero
    var p2x: T = zero
    var p2y: T = zero
    var i = 0
    val n = edge.length * 2 - 3
    while (i < n) {
      p1x = edge(i / 2 + 0).x
      p1y = edge(i / 2 + 0).y
      p2x = edge(i / 2 + 1).x
      p2y = edge(i / 2 + 1).y
      area += p1x * p2y - p2x * p1y
      i += 2
    }
    p1x = edge(edge.length - 2).x
    p1y = edge(edge.length - 2).y
    p2x = edge.head.x
    p2y = edge.head.y
    area + p1x * p2y - p2x * p1y < 0
  }
}

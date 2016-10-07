package se.gigurra.math

import se.gigurra.lang.FixErasure
import spire.implicits._

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T) {
  def *(value: T): Vec2[T] = Vec2(x * value, y * value)
  def /(value: T): Vec2[T] = Vec2(x / value, y / value)
  def +(value: T): Vec2[T] = Vec2(x + value, y + value)
  def -(value: T): Vec2[T] = Vec2(x - value, y - value)
  def unary_- : Vec2[T] = Vec2(-x, -y)
  def |/(value: T): Vec2[T] = Vec2(value / x, value / y)
  def |-(value: T): Vec2[T] = Vec2(value - x, value - y)

  def +[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x + other.x, y + other.y)
  def -[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x - other.x, y - other.y)
  def dot(other: Vec2[T]): T = x * other.x + y * other.y
  def *|*(other: Vec2[T]): Vec2[T] = Vec2(x * other.x, y * other.y)
  def /|/(other: Vec2[T]): Vec2[T] = Vec2(x / other.x, y / other.y)

  def toInt: Vec2[Int] = Vec2(x.toInt, y.toInt)
  def toFloat: Vec2[Float] = Vec2(x.toFloat, y.toFloat)
  def toLong: Vec2[Long] = Vec2(x.toLong, y.toLong)
  def toDouble: Vec2[Double] = Vec2(x.toDouble, y.toDouble)
}

object Vec2 {
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric : Zero](): Vec2[T] = Vec2[T](Zero[T], Zero[T])
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric : Zero](x: T): Vec2[T] = Vec2[T](x, Zero[T])
}

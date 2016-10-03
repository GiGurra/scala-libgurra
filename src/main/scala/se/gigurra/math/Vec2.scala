package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._
import se.gigurra.lang.FixErasure

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2[@specialized(Primitives) T : VecComp](x: T, y: T) extends VecBase[T, Vec2[T]] {
  override def *(value: T): Vec2[T] = Vec2(x * value, y * value)
  override def /(value: T): Vec2[T] = Vec2(x / value, y / value)
  override def +(value: T): Vec2[T] = Vec2(x + value, y + value)
  override def -(value: T): Vec2[T] = Vec2(x - value, y - value)
  override def unary_- : Vec2[T] = Vec2(-x, -y)
  protected[math] override def |/(value: T): Vec2[T] = Vec2(value / x, value / y)
  protected[math] override def |-(value: T): Vec2[T] = Vec2(value - x, value - y)

  override def +[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x + other.x, y + other.y)
  override def -[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x - other.x, y - other.y)
  override def dot(other: Vec2[T]): T = x * other.x + y * other.y
  override def *|*(other: Vec2[T]): Vec2[T] = Vec2(x * other.x, y * other.y)
  override def /|/(other: Vec2[T]): Vec2[T] = Vec2(x / other.x, y / other.y)

  def toInt(implicit caster: Caster[T, Int]): Vec2[Int] = Vec2(caster.cast(x), caster.cast(y))
  def toFloat(implicit caster: Caster[T, Float]): Vec2[Float] = Vec2(caster.cast(x), caster.cast(y))
  def toLong(implicit caster: Caster[T, Long]): Vec2[Long] = Vec2(caster.cast(x), caster.cast(y))
  def toDouble(implicit caster: Caster[T, Double]): Vec2[Double] = Vec2(caster.cast(x), caster.cast(y))
}

object Vec2 {
  def apply[@specialized(Primitives) T: VecComp](): Vec2[T] = Vec2[T](Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec2[T] = Vec2[T](x, Zero[T])
}

package se.gigurra.math

import scala.Specializable.Primitives

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2[@specialized(Primitives) T : Numeric](x: T, y: T) {
  val z = implicitly[Numeric[T]].zero
}

object Vec2 {
  def apply[@specialized(Primitives) T: Numeric](): Vec2[T] = Vec2[T](Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: Numeric](x: T): Vec2[T] = Vec2[T](x, Zero[T])
}

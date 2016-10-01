package se.gigurra.math

import scala.Specializable.Primitives

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2[@specialized(Primitives) T : VecComp](x: T, y: T) {
}

object Vec2 {
  def apply[@specialized(Primitives) T: VecComp](): Vec2[T] = Vec2[T](Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec2[T] = Vec2[T](x, Zero[T])
}

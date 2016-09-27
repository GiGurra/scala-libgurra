package se.gigurra.math

import scala.Specializable.Primitives

/**
  * Created by johan on 2016-09-19.
  */
case class Vec4[@specialized(Primitives) T : Numeric](x: T, y: T, z: T, w: T) {

}

object Vec4 {
  def apply[@specialized(Primitives) T: Numeric](): Vec4[T] = Vec4[T](Zero[T], Zero[T], Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: Numeric](x: T): Vec4[T] = Vec4[T](x, Zero[T], Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: Numeric](x: T, y: T): Vec4[T] = Vec4[T](x, y, Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: Numeric](x: T, y: T, z: T): Vec4[T] = Vec4[T](x, y, z, Zero[T])
}

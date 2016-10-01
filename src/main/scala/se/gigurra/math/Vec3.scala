package se.gigurra.math

import scala.Specializable.Primitives

/**
  * Created by johan on 2016-09-19.
  */
case class Vec3[@specialized(Primitives) T : VecComp](x: T, y: T, z: T) {

}

object Vec3 {
  def apply[@specialized(Primitives) T: VecComp](): Vec3[T] = Vec3[T](Zero[T], Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec3[T] = Vec3[T](x, Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T, y: T): Vec3[T] = Vec3[T](x, y, Zero[T])
}

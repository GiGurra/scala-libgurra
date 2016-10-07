package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._
import se.gigurra.lang.FixErasure

/**
  * Created by johan on 2016-09-19.
  */
case class Vec3[@specialized(Primitives) T : VecComp](x: T, y: T, z: T) {
  def *(value: T): Vec3[T] = Vec3(x * value, y * value, z * value)
  def /(value: T): Vec3[T] = Vec3(x / value, y / value, z / value)
  def +(value: T): Vec3[T] = Vec3(x + value, y + value, z + value)
  def -(value: T): Vec3[T] = Vec3(x - value, y - value, z - value)
  def unary_- : Vec3[T] = Vec3(-x, -y, -z)
  def |/(value: T): Vec3[T] = Vec3(value / x, value / y, value / z)
  def |-(value: T): Vec3[T] = Vec3(value - x, value - y, value - z)

  def +[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x + other.x, y + other.y, z + other.z)
  def -[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x - other.x, y - other.y, z - other.z)
  def dot(other: Vec3[T]): T = x * other.x + y * other.y + z * other.z

  def x(other: Vec3[T]): Vec3[T] = cross(other)
  def cross(other: Vec3[T]): Vec3[T] = {
    val u = this
    val v = other
    Vec3(
      u.y * v.z - u.z * v.y,
      u.z * v.x - u.x * v.z,
      u.x * v.y - u.y * v.x
    )
  }

  def *|*(other: Vec3[T]): Vec3[T] = Vec3(x*other.x, y*other.y, z*other.z)
  def /|/(other: Vec3[T]): Vec3[T] = Vec3(x / other.x, y / other.y, z / other.z)
  def toVec4: Vec4[T] = Vec4(x, y, z, One[T])

  def toInt: Vec3[Int] = Vec3(x.toInt, y.toInt, z.toInt)
  def toFloat: Vec3[Float] = Vec3(x.toFloat, y.toFloat, z.toFloat)
  def toLong: Vec3[Long] = Vec3(x.toLong, y.toLong, z.toLong)
  def toDouble: Vec3[Double] = Vec3(x.toDouble, y.toDouble, z.toDouble)
}

object Vec3 {
  def apply[@specialized(Primitives) T: VecComp](): Vec3[T] = Vec3[T](Zero[T], Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec3[T] = Vec3[T](x, Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T, y: T): Vec3[T] = Vec3[T](x, y, Zero[T])
}

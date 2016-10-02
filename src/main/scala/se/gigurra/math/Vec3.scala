package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._
import se.gigurra.lang.FixErasure

/**
  * Created by johan on 2016-09-19.
  */
case class Vec3[@specialized(Primitives) T : VecComp](x: T, y: T, z: T) extends VecBase[T, Vec3[T]] {
  override def *(value: T): Vec3[T] = Vec3(x * value, y * value, z * value)
  override def /(value: T): Vec3[T] = Vec3(x / value, y / value, z / value)
  override def +(value: T): Vec3[T] = Vec3(x + value, y + value, z + value)
  override def -(value: T): Vec3[T] = Vec3(x - value, y - value, z - value)
  override def unary_- : Vec3[T] = Vec3(-x, -y, -z)
  protected[math] override def |/(value: T): Vec3[T] = Vec3(value / x, value / y, value / z)
  protected[math] override def |-(value: T): Vec3[T] = Vec3(value - x, value - y, value - z)

  override def +[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x + other.x, y + other.y, z + other.z)
  override def -[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x - other.x, y - other.y, z - other.z)
  override def dot(other: Vec3[T]): T = x * other.x + y * other.y + z * other.z

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

  override def *|*(other: Vec3[T]): Vec3[T] = Vec3(x*other.x, y*other.y, z*other.z)
  override def /|/(other: Vec3[T]): Vec3[T] = Vec3(x / other.x, y / other.y, z / other.z)
  def toVec4: Vec4[T] = Vec4(x, y, z, One[T])
}

object Vec3 {
  def apply[@specialized(Primitives) T: VecComp](): Vec3[T] = Vec3[T](Zero[T], Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec3[T] = Vec3[T](x, Zero[T], Zero[T])
  def apply[@specialized(Primitives) T: VecComp](x: T, y: T): Vec3[T] = Vec3[T](x, y, Zero[T])
}

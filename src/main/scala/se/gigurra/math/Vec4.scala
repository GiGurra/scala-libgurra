package se.gigurra.math

import scala.Specializable.Primitives
import VecCompImplicits._
import se.gigurra.lang.FixErasure

/**
  * Created by johan on 2016-09-19.
  */
case class Vec4[@specialized(Primitives) T : VecComp](x: T, y: T, z: T, w: T) extends VecBase[T, Vec4[T]] {
  override def *(value: T): Vec4[T] = Vec4(x * value, y * value, z * value, w)
  override def /(value: T): Vec4[T] = Vec4(x / value, y / value, z / value, w)
  override def +(value: T): Vec4[T] = Vec4(x + value, y + value, z + value, w)
  override def -(value: T): Vec4[T] = Vec4(x - value, y - value, z - value, w)
  override def unary_- : Vec4[T] = Vec4(-x, -y, -z, w)
  protected[math] override def |/(value: T): Vec4[T] = (toVec3 |/ value).toVec4
  protected[math] override def |-(value: T): Vec4[T] = (toVec3 |- value).toVec4

  override def +[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 + other.toVec3).toVec4
  override def -[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 - other.toVec3).toVec4
  override def dot(other: Vec4[T]): T = toVec3 dot other.toVec3
  override def *|*(other: Vec4[T]): Vec4[T] = (toVec3 *|* other.toVec3).toVec4
  override def /|/(other: Vec4[T]): Vec4[T] = (toVec3 /|/ other.toVec3).toVec4

  def x(other: Vec4[T]): Vec4[T] = cross(other)
  def cross(other: Vec4[T]): Vec4[T] = (toVec3 cross other.toVec3).toVec4

  def normalizeByW: Vec4[T] = Vec4(x/w, y/w, z/w, One[T])

  def toVec3: Vec3[T] = {
    val v = normalizeByW
    Vec3(v.x, v.y, v.z)
  }

  def toInt: Vec4[Int] = Vec4(x.toInt, y.toInt, z.toInt, w.toInt)
  def toFloat: Vec4[Float] = Vec4(x.toFloat, y.toFloat, z.toFloat, w.toFloat)
  def toLong: Vec4[Long] = Vec4(x.toLong, y.toLong, z.toLong, w.toLong)
  def toDouble: Vec4[Double] = Vec4(x.toDouble, y.toDouble, z.toDouble, w.toDouble)
}

object Vec4 {
  def apply[@specialized(Primitives) T: VecComp](): Vec4[T] = Vec4[T](Zero[T], Zero[T], Zero[T], One[T])
  def apply[@specialized(Primitives) T: VecComp](x: T): Vec4[T] = Vec4[T](x, Zero[T], Zero[T], One[T])
  def apply[@specialized(Primitives) T: VecComp](x: T, y: T): Vec4[T] = Vec4[T](x, y, Zero[T], One[T])
  def apply[@specialized(Primitives) T: VecComp](x: T, y: T, z: T): Vec4[T] = Vec4[T](x, y, z, One[T])
}

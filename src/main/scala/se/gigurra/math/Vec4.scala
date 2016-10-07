package se.gigurra.math


import se.gigurra.lang.FixErasure
import spire.implicits._

/**
  * Created by johan on 2016-09-19.
  */
case class Vec4[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T, z: T, w: T) {
  def *(value: T): Vec4[T] = Vec4(x * value, y * value, z * value, w)
  def /(value: T): Vec4[T] = Vec4(x / value, y / value, z / value, w)
  def +(value: T): Vec4[T] = Vec4(x + value, y + value, z + value, w)
  def -(value: T): Vec4[T] = Vec4(x - value, y - value, z - value, w)
  def unary_- : Vec4[T] = Vec4(-x, -y, -z, w)
  def |/(value: T): Vec4[T] = (toVec3 |/ value).toVec4
  def |-(value: T): Vec4[T] = (toVec3 |- value).toVec4

  def +[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 + other.toVec3).toVec4
  def -[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 - other.toVec3).toVec4
  def dot(other: Vec4[T]): T = toVec3 dot other.toVec3
  def *|*(other: Vec4[T]): Vec4[T] = (toVec3 *|* other.toVec3).toVec4
  def /|/(other: Vec4[T]): Vec4[T] = (toVec3 /|/ other.toVec3).toVec4

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
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric](): Vec4[T] = Vec4[T](Zero[T], Zero[T], Zero[T], One[T])
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric](x: T): Vec4[T] = Vec4[T](x, Zero[T], Zero[T], One[T])
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric](x: T, y: T): Vec4[T] = Vec4[T](x, y, Zero[T], One[T])
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric](x: T, y: T, z: T): Vec4[T] = Vec4[T](x, y, z, One[T])
}

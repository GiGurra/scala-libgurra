package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import spire.implicits._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec4[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T, z: T, w: T) {
  final def *(value: T): Vec4[T] = Vec4(x * value, y * value, z * value, w)
  final def /(value: T): Vec4[T] = Vec4(x / value, y / value, z / value, w)
  final def +(value: T): Vec4[T] = Vec4(x + value, y + value, z + value, w)
  final def -(value: T): Vec4[T] = Vec4(x - value, y - value, z - value, w)
  final def unary_- : Vec4[T] = Vec4(-x, -y, -z, w)
  final def |/(value: T): Vec4[T] = (toVec3 |/ value).toVec4
  final def |-(value: T): Vec4[T] = (toVec3 |- value).toVec4

  final def +[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 + other.toVec3).toVec4
  final def -[_: FixErasure](other: Vec4[T]): Vec4[T] = (toVec3 - other.toVec3).toVec4
  final def dot(other: Vec4[T]): T = toVec3 dot other.toVec3
  final def *|*(other: Vec4[T]): Vec4[T] = (toVec3 *|* other.toVec3).toVec4
  final def /|/(other: Vec4[T]): Vec4[T] = (toVec3 /|/ other.toVec3).toVec4

  final def x(other: Vec4[T]): Vec4[T] = cross(other)
  final def cross(other: Vec4[T]): Vec4[T] = (toVec3 cross other.toVec3).toVec4

  final def normalizeByW: Vec4[T] = Vec4(x/w, y/w, z/w, One[T])

  final def toVec3: Vec3[T] = {
    val v = normalizeByW
    Vec3(v.x, v.y, v.z)
  }

  final def toInt: Vec4[Int] = Vec4(x.toInt, y.toInt, z.toInt, w.toInt)
  final def toFloat: Vec4[Float] = Vec4(x.toFloat, y.toFloat, z.toFloat, w.toFloat)
  final def toLong: Vec4[Long] = Vec4(x.toLong, y.toLong, z.toLong, w.toLong)
  final def toDouble: Vec4[Double] = Vec4(x.toDouble, y.toDouble, z.toDouble, w.toDouble)
}

object Vec4 {

  implicit def tuple2Vec4[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](tuple: (T, T, T, T)): Vec4[T] = {
    new Vec4[T](tuple._1, tuple._2, tuple._3, tuple._4)
  }
}

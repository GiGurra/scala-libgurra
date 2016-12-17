package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec4(x: Float, y: Float, z: Float, w: Float) {
  final def *(value: Float): Vec4 = Vec4(x * value, y * value, z * value, w)
  final def /(value: Float): Vec4 = Vec4(x / value, y / value, z / value, w)
  final def +(value: Float): Vec4 = Vec4(x + value, y + value, z + value, w)
  final def -(value: Float): Vec4 = Vec4(x - value, y - value, z - value, w)
  final def unary_- : Vec4 = Vec4(-x, -y, -z, w)
  final def |/(value: Float): Vec4 = (toVec3 |/ value).toVec4
  final def |-(value: Float): Vec4 = (toVec3 |- value).toVec4

  final def +[_: FixErasure](other: Vec4): Vec4 = (toVec3 + other.toVec3).toVec4
  final def -[_: FixErasure](other: Vec4): Vec4 = (toVec3 - other.toVec3).toVec4
  final def dot(other: Vec4): Float = toVec3 dot other.toVec3
  final def *|*(other: Vec4): Vec4 = (toVec3 *|* other.toVec3).toVec4
  final def /|/(other: Vec4): Vec4 = (toVec3 /|/ other.toVec3).toVec4

  final def x(other: Vec4): Vec4 = cross(other)
  final def cross(other: Vec4): Vec4 = (toVec3 cross other.toVec3).toVec4

  final def normalizeByW: Vec4 = Vec4(x/w, y/w, z/w, 1.0f)

  final def toVec3: Vec3 = {
    val v = normalizeByW
    Vec3(v.x, v.y, v.z)
  }

  final def norm: Double = math.sqrt((this dot this).toDouble)
  final def length: Double = norm
}

object Vec4 {

  implicit def tuple2Vec4(tuple: (Float, Float, Float, Float)): Vec4 = {
    new Vec4(tuple._1, tuple._2, tuple._3, tuple._4)
  }

  val zero = Vec4(0.0f, 0.0f, 0.0f, 1.0f)
}

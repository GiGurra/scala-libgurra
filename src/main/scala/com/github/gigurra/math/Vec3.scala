package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec3(x: Float, y: Float, z: Float) {
  final def *(value: Float): Vec3 = Vec3(x * value, y * value, z * value)
  final def /(value: Float): Vec3 = Vec3(x / value, y / value, z / value)
  final def +(value: Float): Vec3 = Vec3(x + value, y + value, z + value)
  final def -(value: Float): Vec3 = Vec3(x - value, y - value, z - value)
  final def unary_- : Vec3 = Vec3(-x, -y, -z)
  final def |/(value: Float): Vec3 = Vec3(value / x, value / y, value / z)
  final def |-(value: Float): Vec3 = Vec3(value - x, value - y, value - z)

  final def +[_: FixErasure](other: Vec3): Vec3 = Vec3(x + other.x, y + other.y, z + other.z)
  final def -[_: FixErasure](other: Vec3): Vec3 = Vec3(x - other.x, y - other.y, z - other.z)
  final def dot(other: Vec3): Float = x * other.x + y * other.y + z * other.z

  final def x(other: Vec3): Vec3 = cross(other)
  final def cross(other: Vec3): Vec3 = {
    val u = this
    val v = other
    Vec3(
      u.y * v.z - u.z * v.y,
      u.z * v.x - u.x * v.z,
      u.x * v.y - u.y * v.x
    )
  }

  final def *|*(other: Vec3): Vec3 = Vec3(x*other.x, y*other.y, z*other.z)
  final def /|/(other: Vec3): Vec3 = Vec3(x / other.x, y / other.y, z / other.z)
  final def toVec4: Vec4 = Vec4(x, y, z, 1.0f)

  final def norm: Float = math.sqrt(this dot this).toFloat
  final def length: Float = norm
}

object Vec3 {

  implicit def tuple2Vec3(tuple: (Float, Float, Float)): Vec3 = {
    new Vec3(tuple._1, tuple._2, tuple._3)
  }

  val zero = Vec3(0.0f, 0.0f, 0.0f)
}
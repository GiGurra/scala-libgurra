package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import spire.implicits._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec3[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T, z: T) {
  final def *(value: T): Vec3[T] = Vec3(x * value, y * value, z * value)
  final def /(value: T): Vec3[T] = Vec3(x / value, y / value, z / value)
  final def +(value: T): Vec3[T] = Vec3(x + value, y + value, z + value)
  final def -(value: T): Vec3[T] = Vec3(x - value, y - value, z - value)
  final def unary_- : Vec3[T] = Vec3(-x, -y, -z)
  final def |/(value: T): Vec3[T] = Vec3(value / x, value / y, value / z)
  final def |-(value: T): Vec3[T] = Vec3(value - x, value - y, value - z)

  final def +[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x + other.x, y + other.y, z + other.z)
  final def -[_: FixErasure](other: Vec3[T]): Vec3[T] = Vec3(x - other.x, y - other.y, z - other.z)
  final def dot(other: Vec3[T]): T = x * other.x + y * other.y + z * other.z

  final def x(other: Vec3[T]): Vec3[T] = cross(other)
  final def cross(other: Vec3[T]): Vec3[T] = {
    val u = this
    val v = other
    Vec3(
      u.y * v.z - u.z * v.y,
      u.z * v.x - u.x * v.z,
      u.x * v.y - u.y * v.x
    )
  }

  final def *|*(other: Vec3[T]): Vec3[T] = Vec3(x*other.x, y*other.y, z*other.z)
  final def /|/(other: Vec3[T]): Vec3[T] = Vec3(x / other.x, y / other.y, z / other.z)
  final def toVec4: Vec4[T] = Vec4(x, y, z, One[T])

  final def toInt: Vec3[Int] = Vec3(x.toInt, y.toInt, z.toInt)
  final def toFloat: Vec3[Float] = Vec3(x.toFloat, y.toFloat, z.toFloat)
  final def toLong: Vec3[Long] = Vec3(x.toLong, y.toLong, z.toLong)
  final def toDouble: Vec3[Double] = Vec3(x.toDouble, y.toDouble, z.toDouble)
}

object Vec3 {

  implicit def tuple2Vec3[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](tuple: (T, T, T)): Vec3[T] = {
    new Vec3[T](tuple._1, tuple._2, tuple._3)
  }
}
package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import spire.implicits._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](x: T, y: T) {
  final def *(value: T): Vec2[T] = Vec2(x * value, y * value)
  final def /(value: T): Vec2[T] = Vec2(x / value, y / value)
  final def +(value: T): Vec2[T] = Vec2(x + value, y + value)
  final def -(value: T): Vec2[T] = Vec2(x - value, y - value)
  final def unary_- : Vec2[T] = Vec2(-x, -y)
  final def |/(value: T): Vec2[T] = Vec2(value / x, value / y)
  final def |-(value: T): Vec2[T] = Vec2(value - x, value - y)

  final def +[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x + other.x, y + other.y)
  final def -[_: FixErasure](other: Vec2[T]): Vec2[T] = Vec2(x - other.x, y - other.y)
  final def dot(other: Vec2[T]): T = x * other.x + y * other.y
  final def *|*(other: Vec2[T]): Vec2[T] = Vec2(x * other.x, y * other.y)
  final def /|/(other: Vec2[T]): Vec2[T] = Vec2(x / other.x, y / other.y)

  final def toInt: Vec2[Int] = Vec2(x.toInt, y.toInt)
  final def toFloat: Vec2[Float] = Vec2(x.toFloat, y.toFloat)
  final def toLong: Vec2[Long] = Vec2(x.toLong, y.toLong)
  final def toDouble: Vec2[Double] = Vec2(x.toDouble, y.toDouble)
}

object Vec2 {
  implicit def tuple2Vec2[@specialized(Int,Long,Float,Double) T : spire.math.Numeric](tuple: (T, T)): Vec2[T] = {
    new Vec2[T](tuple._1, tuple._2)
  }
}

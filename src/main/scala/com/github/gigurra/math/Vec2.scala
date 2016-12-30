package com.github.gigurra.math

import com.github.gigurra.lang.FixErasure
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-19.
  */
case class Vec2(x: Float, y: Float) {
  final def *(value: Float): Vec2 = Vec2(x * value, y * value)
  final def /(value: Float): Vec2 = Vec2(x / value, y / value)
  final def +(value: Float): Vec2 = Vec2(x + value, y + value)
  final def -(value: Float): Vec2 = Vec2(x - value, y - value)
  final def unary_- : Vec2 = Vec2(-x, -y)
  final def |/(value: Float): Vec2 = Vec2(value / x, value / y)
  final def |-(value: Float): Vec2 = Vec2(value - x, value - y)

  final def +[_: FixErasure](other: Vec2): Vec2 = Vec2(x + other.x, y + other.y)
  final def -[_: FixErasure](other: Vec2): Vec2 = Vec2(x - other.x, y - other.y)
  final def dot(other: Vec2): Float = x * other.x + y * other.y
  final def *|*(other: Vec2): Vec2 = Vec2(x * other.x, y * other.y)
  final def /|/(other: Vec2): Vec2 = Vec2(x / other.x, y / other.y)

  final def norm: Float = math.sqrt(this dot this).toFloat
  final def length: Float = norm
  final def angle: Float = math.atan2(y, x).toDegrees.toFloat
  final def angleTo(otherVector: Vec2): Float = (this.angle - otherVector.angle).normalizeDegreesPm180
  final def orthogonal: Vec2 = Vec2(-y, x)  // orth vec

  final def cwAngleTo(otherVector: Vec2): Float = {
    val thisAngle = this.angle
    val otherAngle = otherVector.angle
    (thisAngle - otherAngle).normalizeDegrees0360
  }

  final def ccwAngleTo(otherVector: Vec2): Float = {
    val thisAngle = this.angle
    val otherAngle = otherVector.angle
    (otherAngle - thisAngle).normalizeDegrees0360
  }
}

object Vec2 {
  implicit def tuple2Vec2(tuple: (Float, Float)): Vec2 = {
    new Vec2(tuple._1, tuple._2)
  }

  val zero: Vec2 = Vec2(0.0f, 0.0f)
}

package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
trait Zero[@specialized(Primitives) T] {
  def zero: T
}

object Zero {

  def apply[@specialized(Primitives) T: Zero]: T = implicitly[Zero[T]].zero

  implicit val intZero: Zero[Int] = new Zero[Int] { override val zero = 0 }
  implicit val floatZero: Zero[Float] = new Zero[Float] { override val zero = 0.0f }
  implicit val longZero: Zero[Long] = new Zero[Long] { override val zero = 0L }
  implicit val doubleZero: Zero[Double] = new Zero[Double] { override val zero = 0.0 }

  implicit val intVec2Zero: Zero[Vec2[Int]] = new Zero[Vec2[Int]] { override val zero = Vec2[Int]() }
  implicit val floatVec2Zero: Zero[Vec2[Float]] = new Zero[Vec2[Float]] { override val zero = Vec2[Float]() }
  implicit val longVec2Zero: Zero[Vec2[Long]] = new Zero[Vec2[Long]] { override val zero = Vec2[Long]() }
  implicit val doubleVec2Zero: Zero[Vec2[Double]] = new Zero[Vec2[Double]] { override val zero = Vec2[Double]() }

  implicit val intVec3Zero: Zero[Vec3[Int]] = new Zero[Vec3[Int]] { override val zero = Vec3[Int]() }
  implicit val floatVec3Zero: Zero[Vec3[Float]] = new Zero[Vec3[Float]] { override val zero = Vec3[Float]() }
  implicit val longVec3Zero: Zero[Vec3[Long]] = new Zero[Vec3[Long]] { override val zero = Vec3[Long]() }
  implicit val doubleVec3Zero: Zero[Vec3[Double]] = new Zero[Vec3[Double]] { override val zero = Vec3[Double]() }

  implicit val intVec4Zero: Zero[Vec4[Int]] = new Zero[Vec4[Int]] { override val zero = Vec4[Int]() }
  implicit val floatVec4Zero: Zero[Vec4[Float]] = new Zero[Vec4[Float]] { override val zero = Vec4[Float]() }
  implicit val longVec4Zero: Zero[Vec4[Long]] = new Zero[Vec4[Long]] { override val zero = Vec4[Long]() }
  implicit val doubleVec4Zero: Zero[Vec4[Double]] = new Zero[Vec4[Double]] { override val zero = Vec4[Double]() }
}

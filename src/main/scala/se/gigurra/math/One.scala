package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
trait One[@specialized(Primitives) T] {
  def one: T
}

object One {

  def apply[@specialized(Primitives) T: One]: T = implicitly[One[T]].one

  implicit val intOne = new One[Int] { override val one = 1 }
  implicit val floatOne = new One[Float] { override val one = 1.0f }
  implicit val longOne = new One[Long] { override val one = 1L }
  implicit val doubleOne = new One[Double] { override val one = 1.0 }

  implicit val intVec2One: One[Vec2[Int]] = new One[Vec2[Int]] { override val one = Vec2[Int](1,1) }
  implicit val floatVec2One: One[Vec2[Float]] = new One[Vec2[Float]] { override val one = Vec2[Float](1.0f, 1.0f) }
  implicit val longVec2One: One[Vec2[Long]] = new One[Vec2[Long]] { override val one = Vec2[Long](1L, 1L) }
  implicit val doubleVec2One: One[Vec2[Double]] = new One[Vec2[Double]] { override val one = Vec2[Double](1.0, 1.0) }

  implicit val intVec3One: One[Vec3[Int]] = new One[Vec3[Int]] { override val one = Vec3[Int](1,1,1) }
  implicit val floatVec3One: One[Vec3[Float]] = new One[Vec3[Float]] { override val one = Vec3[Float](1.0f, 1.0f, 1.0f) }
  implicit val longVec3One: One[Vec3[Long]] = new One[Vec3[Long]] { override val one = Vec3[Long](1L, 1L, 1L) }
  implicit val doubleVec3One: One[Vec3[Double]] = new One[Vec3[Double]] { override val one = Vec3[Double](1.0, 1.0, 1.0) }

  implicit val intVec4One: One[Vec4[Int]] = new One[Vec4[Int]] { override val one = Vec4[Int](1,1,1,1) }
  implicit val floatVec4One: One[Vec4[Float]] = new One[Vec4[Float]] { override val one = Vec4[Float](1.0f, 1.0f, 1.0f, 1.0f) }
  implicit val longVec4One: One[Vec4[Long]] = new One[Vec4[Long]] { override val one = Vec4[Long](1L, 1L, 1l, 1L) }
  implicit val doubleVec4One: One[Vec4[Double]] = new One[Vec4[Double]] { override val one = Vec4[Double](1.0, 1.0, 1.0, 1.0) }
}

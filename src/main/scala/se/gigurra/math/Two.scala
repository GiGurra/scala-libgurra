package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
trait Two[@specialized(Primitives) T] {
  def two: T
}

object Two {

  def apply[@specialized(Primitives) T: Two]: T = implicitly[Two[T]].two

  implicit val intTwo = new Two[Int] { override val two = 2 }
  implicit val floatTwo = new Two[Float] { override val two = 2.0f }
  implicit val longTwo = new Two[Long] { override val two = 2L }
  implicit val doubleTwo = new Two[Double] { override val two = 2.0 }

  implicit val intVec2Two: Two[Vec2[Int]] = new Two[Vec2[Int]] { override val two = Vec2[Int](2,2) }
  implicit val floatVec2Two: Two[Vec2[Float]] = new Two[Vec2[Float]] { override val two = Vec2[Float](2.0f, 2.0f) }
  implicit val longVec2Two: Two[Vec2[Long]] = new Two[Vec2[Long]] { override val two = Vec2[Long](2L, 2L) }
  implicit val doubleVec2Two: Two[Vec2[Double]] = new Two[Vec2[Double]] { override val two = Vec2[Double](2.0, 2.0) }

  implicit val intVec3Two: Two[Vec3[Int]] = new Two[Vec3[Int]] { override val two = Vec3[Int](2,2,2) }
  implicit val floatVec3Two: Two[Vec3[Float]] = new Two[Vec3[Float]] { override val two = Vec3[Float](2.0f, 2.0f, 2.0f) }
  implicit val longVec3Two: Two[Vec3[Long]] = new Two[Vec3[Long]] { override val two = Vec3[Long](2L, 2L, 2L) }
  implicit val doubleVec3Two: Two[Vec3[Double]] = new Two[Vec3[Double]] { override val two = Vec3[Double](2.0, 2.0, 2.0) }

  implicit val intVec4Two: Two[Vec4[Int]] = new Two[Vec4[Int]] { override val two = Vec4[Int](2,2,2,1) }
  implicit val floatVec4Two: Two[Vec4[Float]] = new Two[Vec4[Float]] { override val two = Vec4[Float](2.0f, 2.0f, 2.0f, 1.0f) }
  implicit val longVec4Two: Two[Vec4[Long]] = new Two[Vec4[Long]] { override val two = Vec4[Long](2L, 2L, 2l, 1L) }
  implicit val doubleVec4Two: Two[Vec4[Double]] = new Two[Vec4[Double]] { override val two = Vec4[Double](2.0, 2.0, 2.0, 1.0) }
}

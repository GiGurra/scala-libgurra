package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
trait Negative[@specialized(Primitives) T] {
  def negate(t: T): T
}

object Negative {

  def apply[@specialized(Primitives) T: Negative](t: T): T = implicitly[Negative[T]].negate(t)

  implicit val intNegative: Negative[Int] = new Negative[Int] { override def negate(t: Int): Int = -t }
  implicit val floatNegative: Negative[Float] = new Negative[Float] { override def negate(t: Float): Float = -t }
  implicit val longNegative: Negative[Long] = new Negative[Long] { override def negate(t: Long): Long = -t }
  implicit val doubleNegative: Negative[Double] = new Negative[Double] { override def negate(t: Double): Double = -t }

  implicit val intVec2Negative: Negative[Vec2[Int]] = new Negative[Vec2[Int]] { override def negate(t: Vec2[Int]): Vec2[Int] = Vec2[Int](-t.x, -t.y) }
  implicit val floatVec2Negative: Negative[Vec2[Float]] = new Negative[Vec2[Float]] { override def negate(t: Vec2[Float]): Vec2[Float] = Vec2[Float](-t.x, -t.y) }
  implicit val longVec2Negative: Negative[Vec2[Long]] = new Negative[Vec2[Long]] { override def negate(t: Vec2[Long]): Vec2[Long] = Vec2[Long](-t.x, -t.y) }
  implicit val doubleVec2Negative: Negative[Vec2[Double]] = new Negative[Vec2[Double]] { override def negate(t: Vec2[Double]): Vec2[Double] = Vec2[Double](-t.x, -t.y) }

  implicit val intVec3Negative: Negative[Vec3[Int]] = new Negative[Vec3[Int]] { override def negate(t: Vec3[Int]): Vec3[Int] = Vec3[Int](-t.x, -t.y, -t.z) }
  implicit val floatVec3Negative: Negative[Vec3[Float]] = new Negative[Vec3[Float]] { override def negate(t: Vec3[Float]): Vec3[Float] = Vec3[Float](-t.x, -t.y, -t.z) }
  implicit val longVec3Negative: Negative[Vec3[Long]] = new Negative[Vec3[Long]] { override def negate(t: Vec3[Long]): Vec3[Long] = Vec3[Long](-t.x, -t.y, -t.z) }
  implicit val doubleVec3Negative: Negative[Vec3[Double]] = new Negative[Vec3[Double]] { override def negate(t: Vec3[Double]): Vec3[Double] = Vec3[Double](-t.x, -t.y, -t.z) }

  implicit val intVec4Negative: Negative[Vec4[Int]] = new Negative[Vec4[Int]] { override def negate(t: Vec4[Int]): Vec4[Int] = Vec4[Int](-t.x, -t.y, -t.z, -t.w) }
  implicit val floatVec4Negative: Negative[Vec4[Float]] = new Negative[Vec4[Float]] { override def negate(t: Vec4[Float]): Vec4[Float] = Vec4[Float](-t.x, -t.y, -t.z, -t.w) }
  implicit val longVec4Negative: Negative[Vec4[Long]] = new Negative[Vec4[Long]] { override def negate(t: Vec4[Long]): Vec4[Long] = Vec4[Long](-t.x, -t.y, -t.z, -t.w) }
  implicit val doubleVec4Negative: Negative[Vec4[Double]] = new Negative[Vec4[Double]] { override def negate(t: Vec4[Double]): Vec4[Double] = Vec4[Double](-t.x, -t.y, -t.z, -t.w) }
}

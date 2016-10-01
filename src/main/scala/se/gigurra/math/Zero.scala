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

  implicit val intZero = new Zero[Int] { override val zero = 0 }
  implicit val floatZero = new Zero[Float] { override val zero = 0.0f }
  implicit val longZero = new Zero[Long] { override val zero = 0L }
  implicit val doubleZero = new Zero[Double] { override val zero = 0.0 }

  implicit val intVec2Zero = new Zero[Vec2[Int]] { override val zero = Vec2[Int]() }
  implicit val floatVec2Zero = new Zero[Vec2[Float]] { override val zero = Vec2[Float]() }
  implicit val longVec2Zero = new Zero[Vec2[Long]] { override val zero = Vec2[Long]() }
  implicit val doubleVec2Zero = new Zero[Vec2[Double]] { override val zero = Vec2[Double]() }

  implicit val intVec3Zero = new Zero[Vec3[Int]] { override val zero = Vec3[Int]() }
  implicit val floatVec3Zero = new Zero[Vec3[Float]] { override val zero = Vec3[Float]() }
  implicit val longVec3Zero = new Zero[Vec3[Long]] { override val zero = Vec3[Long]() }
  implicit val doubleVec3Zero = new Zero[Vec3[Double]] { override val zero = Vec3[Double]() }

  implicit val intVec4Zero = new Zero[Vec4[Int]] { override val zero = Vec4[Int]() }
  implicit val floatVec4Zero = new Zero[Vec4[Float]] { override val zero = Vec4[Float]() }
  implicit val longVec4Zero = new Zero[Vec4[Long]] { override val zero = Vec4[Long]() }
  implicit val doubleVec4Zero = new Zero[Vec4[Double]] { override val zero = Vec4[Double]() }
}

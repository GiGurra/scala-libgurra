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

  implicit val intZero = new Zero[Int] { override def zero = 0 }
  implicit val floatZero = new Zero[Float] { override def zero = 0.0f }
  implicit val longZero = new Zero[Long] { override def zero = 0L }
  implicit val doubleZero = new Zero[Double] { override def zero = 0.0 }

  implicit val intVec2Zero = new Zero[Vec2[Int]] { override def zero = Vec2() }
  implicit val floatVec2Zero = new Zero[Vec2[Float]] { override def zero = Vec2() }
  implicit val longVec2Zero = new Zero[Vec2[Long]] { override def zero = Vec2() }
  implicit val doubleVec2Zero = new Zero[Vec2[Double]] { override def zero = Vec2() }

  implicit val intVec3Zero = new Zero[Vec3[Int]] { override def zero = Vec3() }
  implicit val floatVec3Zero = new Zero[Vec3[Float]] { override def zero = Vec3() }
  implicit val longVec3Zero = new Zero[Vec3[Long]] { override def zero = Vec3() }
  implicit val doubleVec3Zero = new Zero[Vec3[Double]] { override def zero = Vec3() }

  implicit val intVec4Zero = new Zero[Vec4[Int]] { override def zero = Vec4() }
  implicit val floatVec4Zero = new Zero[Vec4[Float]] { override def zero = Vec4() }
  implicit val longVec4Zero = new Zero[Vec4[Long]] { override def zero = Vec4() }
  implicit val doubleVec4Zero = new Zero[Vec4[Double]] { override def zero = Vec4() }
}

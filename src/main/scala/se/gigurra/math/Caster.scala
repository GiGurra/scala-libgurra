package se.gigurra.math

import scala.Specializable._
import scala.language.implicitConversions

/**
  * Created by johan on 2016-10-03.
  */
trait Caster[@specialized(Primitives) From, @specialized(Primitives) To] {
  def cast(from: From): To
}

trait CasterImplicits {
  implicit val intToInt: Caster[Int, Int] = new Caster[Int, Int] { def cast(value: Int): Int = value }
  implicit val intToFloat: Caster[Int, Float] = new Caster[Int, Float] { def cast(value: Int): Float = value }
  implicit val intToLong: Caster[Int, Long] = new Caster[Int, Long] { def cast(value: Int): Long = value }
  implicit val intToDouble: Caster[Int, Double] = new Caster[Int, Double] { def cast(value: Int): Double = value }

  implicit val floatToInt: Caster[Float, Int] = new Caster[Float, Int] { def cast(value: Float): Int = value.toInt }
  implicit val floatToFloat: Caster[Float, Float] = new Caster[Float, Float] { def cast(value: Float): Float = value }
  implicit val floatToLong: Caster[Float, Long] = new Caster[Float, Long] { def cast(value: Float): Long = value.toLong }
  implicit val floatToDouble: Caster[Float, Double] = new Caster[Float, Double] { def cast(value: Float): Double = value }

  implicit val longToInt: Caster[Long, Int] = new Caster[Long, Int] { def cast(value: Long): Int = value.toInt }
  implicit val longToFloat: Caster[Long, Float] = new Caster[Long, Float] { def cast(value: Long): Float = value }
  implicit val longToLong: Caster[Long, Long] = new Caster[Long, Long] { def cast(value: Long): Long = value }
  implicit val longToDouble: Caster[Long, Double] = new Caster[Long, Double] { def cast(value: Long): Double = value }

  implicit val doubleToInt: Caster[Double, Int] = new Caster[Double, Int] { def cast(value: Double): Int = value.toInt }
  implicit val doubleToFloat: Caster[Double, Float] = new Caster[Double, Float] { def cast(value: Double): Float = value.toFloat }
  implicit val doubleToLong: Caster[Double, Long] = new Caster[Double, Long] { def cast(value: Double): Long = value.toLong }
  implicit val doubleToDouble: Caster[Double, Double] = new Caster[Double, Double] { def cast(value: Double): Double = value }

  private def vec2ToVec2[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](implicit caster: Caster[V1, V2]): Caster[Vec2[V1], Vec2[V2]] = {
    new Caster[Vec2[V1], Vec2[V2]] {
      override def cast(from: Vec2[V1]): Vec2[V2] = {
        Vec2[V2](caster.cast(from.x), caster.cast(from.y))
      }
    }
  }

  private def vec3ToVec3[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](implicit caster: Caster[V1, V2]): Caster[Vec3[V1], Vec3[V2]] = {
    new Caster[Vec3[V1], Vec3[V2]] {
      override def cast(from: Vec3[V1]): Vec3[V2] = {
        Vec3[V2](caster.cast(from.x), caster.cast(from.y), caster.cast(from.z))
      }
    }
  }

  private def vec4ToVec4[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](implicit caster: Caster[V1, V2]): Caster[Vec4[V1], Vec4[V2]] = {
    new Caster[Vec4[V1], Vec4[V2]] {
      override def cast(from: Vec4[V1]): Vec4[V2] = {
        Vec4[V2](caster.cast(from.x), caster.cast(from.y), caster.cast(from.z), caster.cast(from.w))
      }
    }
  }

  implicit def vecToVec2[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](v1: Vec2[V1])
                                                                                                     (implicit caster: Caster[V1, V2]): Vec2[V2] = {
    vec2ToVec2[V1, V2].cast(v1)
  }

  implicit def vecToVec3[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](v1: Vec3[V1])
                                                                                                     (implicit caster: Caster[V1, V2]): Vec3[V2] = {
    vec3ToVec3[V1, V2].cast(v1)
  }


  implicit def vecToVec4[@specialized(Primitives) V1 : VecComp, @specialized(Primitives) V2 : VecComp](v1: Vec4[V1])
                                                                                                     (implicit caster: Caster[V1, V2]): Vec4[V2] = {
    vec4ToVec4[V1, V2].cast(v1)
  }

}

object CasterImplicits extends CasterImplicits

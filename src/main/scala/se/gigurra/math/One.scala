package se.gigurra.math

import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */
object One {
  def apply[@specialized(Int,Long,Float,Double) T: spire.math.Numeric]: T = implicitly[spire.math.Numeric[T]].one

  val int: Int = 1
  val float: Float = 1.0f
  val long: Long = 1L
  val double: Double = 1.0

  val vec2i: Vec2[Int] = Vec2[Int](1, 1)
  val vec2f: Vec2[Float] = Vec2[Float](1.0f, 1.0f)
  val vec2l: Vec2[Long] = Vec2[Long](1L, 1L)
  val vec2d: Vec2[Double] = Vec2[Double](1.0, 1.0)

  val vec3i: Vec3[Int] = Vec3[Int](1, 1, 1)
  val vec3f: Vec3[Float] = Vec3[Float](1.0f, 1.0f, 1.0f)
  val vec3l: Vec3[Long] = Vec3[Long](1L, 1L, 1L)
  val vec3d: Vec3[Double] = Vec3[Double](1.0, 1.0, 1.0)

  val vec4i: Vec4[Int] = Vec4[Int](1, 1, 1, 1)
  val vec4f: Vec4[Float] = Vec4[Float](1.0f, 1.0f, 1.0f, 1.0f)
  val vec4l: Vec4[Long] = Vec4[Long](1L, 1L, 1L, 1L)
  val vec4d: Vec4[Double] = Vec4[Double](1.0, 1.0, 1.0, 1.0)

}

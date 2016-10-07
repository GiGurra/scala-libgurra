package se.gigurra.math

import scala.language.implicitConversions

/**
  * Created by johan on 2016-09-27.
  */

object Zero {

  implicit val int: Int = 0
  implicit val float: Float = 0.0f
  implicit val long: Long = 0L
  implicit val double: Double = 0.0

  implicit val vec2i: Vec2[Int] = Vec2[Int](0, 0)
  implicit val vec2f: Vec2[Float] = Vec2[Float](0.0f, 0.0f)
  implicit val vec2l: Vec2[Long] = Vec2[Long](0L, 0L)
  implicit val vec2d: Vec2[Double] = Vec2[Double](0.0, 0.0)

  implicit val vec3i: Vec3[Int] = Vec3[Int](0, 0, 0)
  implicit val vec3f: Vec3[Float] = Vec3[Float](0.0f, 0.0f, 0.0f)
  implicit val vec3l: Vec3[Long] = Vec3[Long](0L, 0L, 0L)
  implicit val vec3d: Vec3[Double] = Vec3[Double](0.0, 0.0, 0.0)

  implicit val vec4i: Vec4[Int] = Vec4[Int](0, 0, 0, 1)
  implicit val vec4f: Vec4[Float] = Vec4[Float](0.0f, 0.0f, 0.0f, 1.0f)
  implicit val vec4l: Vec4[Long] = Vec4[Long](0L, 0L, 0L, 1L)
  implicit val vec4d: Vec4[Double] = Vec4[Double](0.0, 0.0, 0.0, 1.0)

}

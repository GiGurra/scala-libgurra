package se.gigurra.math

import scala.language.implicitConversions

/**
  * Created by johan on 2016-10-02.
  */
trait VecBaseInfixImplicits {

  implicit class Vec2BaseInfixOpsInt(value: Int) {
    def *(vec: Vec2[Int]): Vec2[Int] = vec * value
    def /(vec: Vec2[Int]): Vec2[Int] = vec |/ value
    def +(vec: Vec2[Int]): Vec2[Int] = vec + value
    def -(vec: Vec2[Int]): Vec2[Int] = vec |- value
  }

  implicit class Vec2BaseInfixOpsFloat(value: Float) {
    def *(vec: Vec2[Float]): Vec2[Float] = vec * value
    def /(vec: Vec2[Float]): Vec2[Float] = vec |/ value
    def +(vec: Vec2[Float]): Vec2[Float] = vec + value
    def -(vec: Vec2[Float]): Vec2[Float] = vec |- value
  }

  implicit class Vec2BaseInfixOpsLong(value: Long) {
    def *(vec: Vec2[Long]): Vec2[Long] = vec * value
    def /(vec: Vec2[Long]): Vec2[Long] = vec |/ value
    def +(vec: Vec2[Long]): Vec2[Long] = vec + value
    def -(vec: Vec2[Long]): Vec2[Long] = vec |- value
  }

  implicit class Vec2BaseInfixOpsDouble(value: Double) {
    def *(vec: Vec2[Double]): Vec2[Double] = vec * value
    def /(vec: Vec2[Double]): Vec2[Double] = vec |/ value
    def +(vec: Vec2[Double]): Vec2[Double] = vec + value
    def -(vec: Vec2[Double]): Vec2[Double] = vec |- value
  }

  implicit class Vec3BaseInfixOpsInt(value: Int) {
    def *(vec: Vec3[Int]): Vec3[Int] = vec * value
    def /(vec: Vec3[Int]): Vec3[Int] = vec |/ value
    def +(vec: Vec3[Int]): Vec3[Int] = vec + value
    def -(vec: Vec3[Int]): Vec3[Int] = vec |- value
  }

  implicit class Vec3BaseInfixOpsFloat(value: Float) {
    def *(vec: Vec3[Float]): Vec3[Float] = vec * value
    def /(vec: Vec3[Float]): Vec3[Float] = vec |/ value
    def +(vec: Vec3[Float]): Vec3[Float] = vec + value
    def -(vec: Vec3[Float]): Vec3[Float] = vec |- value
  }

  implicit class Vec3BaseInfixOpsLong(value: Long) {
    def *(vec: Vec3[Long]): Vec3[Long] = vec * value
    def /(vec: Vec3[Long]): Vec3[Long] = vec |/ value
    def +(vec: Vec3[Long]): Vec3[Long] = vec + value
    def -(vec: Vec3[Long]): Vec3[Long] = vec |- value
  }

  implicit class Vec3BaseInfixOpsDouble(value: Double) {
    def *(vec: Vec3[Double]): Vec3[Double] = vec * value
    def /(vec: Vec3[Double]): Vec3[Double] = vec |/ value
    def +(vec: Vec3[Double]): Vec3[Double] = vec + value
    def -(vec: Vec3[Double]): Vec3[Double] = vec |- value
  }

  implicit class Vec4BaseInfixOpsInt(value: Int) {
    def *(vec: Vec4[Int]): Vec4[Int] = vec * value
    def /(vec: Vec4[Int]): Vec4[Int] = vec |/ value
    def +(vec: Vec4[Int]): Vec4[Int] = vec + value
    def -(vec: Vec4[Int]): Vec4[Int] = vec |- value
  }

  implicit class Vec4BaseInfixOpsFloat(value: Float) {
    def *(vec: Vec4[Float]): Vec4[Float] = vec * value
    def /(vec: Vec4[Float]): Vec4[Float] = vec |/ value
    def +(vec: Vec4[Float]): Vec4[Float] = vec + value
    def -(vec: Vec4[Float]): Vec4[Float] = vec |- value
  }

  implicit class Vec4BaseInfixOpsLong(value: Long) {
    def *(vec: Vec4[Long]): Vec4[Long] = vec * value
    def /(vec: Vec4[Long]): Vec4[Long] = vec |/ value
    def +(vec: Vec4[Long]): Vec4[Long] = vec + value
    def -(vec: Vec4[Long]): Vec4[Long] = vec |- value
  }

  implicit class Vec4BaseInfixOpsDouble(value: Double) {
    def *(vec: Vec4[Double]): Vec4[Double] = vec * value
    def /(vec: Vec4[Double]): Vec4[Double] = vec |/ value
    def +(vec: Vec4[Double]): Vec4[Double] = vec + value
    def -(vec: Vec4[Double]): Vec4[Double] = vec |- value
  }
}

object VecBaseInfixImplicits extends VecBaseInfixImplicits

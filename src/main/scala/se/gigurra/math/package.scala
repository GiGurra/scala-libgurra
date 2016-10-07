package se.gigurra

/**
  * Created by johan on 2016-10-07.
  */
package object math {

  implicit class Vec2BaseInfixOpsInt(val value: Int) extends AnyVal{
    def *(vec: Vec2[Int]): Vec2[Int] = vec * value
    def /(vec: Vec2[Int]): Vec2[Int] = vec |/ value
    def +(vec: Vec2[Int]): Vec2[Int] = vec + value
    def -(vec: Vec2[Int]): Vec2[Int] = vec |- value
  }

  implicit class Vec2BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec2[Float]): Vec2[Float] = vec * value
    def /(vec: Vec2[Float]): Vec2[Float] = vec |/ value
    def +(vec: Vec2[Float]): Vec2[Float] = vec + value
    def -(vec: Vec2[Float]): Vec2[Float] = vec |- value
  }

  implicit class Vec2BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec2[Long]): Vec2[Long] = vec * value
    def /(vec: Vec2[Long]): Vec2[Long] = vec |/ value
    def +(vec: Vec2[Long]): Vec2[Long] = vec + value
    def -(vec: Vec2[Long]): Vec2[Long] = vec |- value
  }

  implicit class Vec2BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec2[Double]): Vec2[Double] = vec * value
    def /(vec: Vec2[Double]): Vec2[Double] = vec |/ value
    def +(vec: Vec2[Double]): Vec2[Double] = vec + value
    def -(vec: Vec2[Double]): Vec2[Double] = vec |- value
  }

  implicit class Vec3BaseInfixOpsInt(val value: Int) extends AnyVal {
    def *(vec: Vec3[Int]): Vec3[Int] = vec * value
    def /(vec: Vec3[Int]): Vec3[Int] = vec |/ value
    def +(vec: Vec3[Int]): Vec3[Int] = vec + value
    def -(vec: Vec3[Int]): Vec3[Int] = vec |- value
  }

  implicit class Vec3BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec3[Float]): Vec3[Float] = vec * value
    def /(vec: Vec3[Float]): Vec3[Float] = vec |/ value
    def +(vec: Vec3[Float]): Vec3[Float] = vec + value
    def -(vec: Vec3[Float]): Vec3[Float] = vec |- value
  }

  implicit class Vec3BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec3[Long]): Vec3[Long] = vec * value
    def /(vec: Vec3[Long]): Vec3[Long] = vec |/ value
    def +(vec: Vec3[Long]): Vec3[Long] = vec + value
    def -(vec: Vec3[Long]): Vec3[Long] = vec |- value
  }

  implicit class Vec3BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec3[Double]): Vec3[Double] = vec * value
    def /(vec: Vec3[Double]): Vec3[Double] = vec |/ value
    def +(vec: Vec3[Double]): Vec3[Double] = vec + value
    def -(vec: Vec3[Double]): Vec3[Double] = vec |- value
  }

  implicit class Vec4BaseInfixOpsInt(val value: Int) extends AnyVal {
    def *(vec: Vec4[Int]): Vec4[Int] = vec * value
    def /(vec: Vec4[Int]): Vec4[Int] = vec |/ value
    def +(vec: Vec4[Int]): Vec4[Int] = vec + value
    def -(vec: Vec4[Int]): Vec4[Int] = vec |- value
  }

  implicit class Vec4BaseInfixOpsFloat(val value: Float) extends AnyVal {
    def *(vec: Vec4[Float]): Vec4[Float] = vec * value
    def /(vec: Vec4[Float]): Vec4[Float] = vec |/ value
    def +(vec: Vec4[Float]): Vec4[Float] = vec + value
    def -(vec: Vec4[Float]): Vec4[Float] = vec |- value
  }

  implicit class Vec4BaseInfixOpsLong(val value: Long) extends AnyVal {
    def *(vec: Vec4[Long]): Vec4[Long] = vec * value
    def /(vec: Vec4[Long]): Vec4[Long] = vec |/ value
    def +(vec: Vec4[Long]): Vec4[Long] = vec + value
    def -(vec: Vec4[Long]): Vec4[Long] = vec |- value
  }

  implicit class Vec4BaseInfixOpsDouble(val value: Double) extends AnyVal {
    def *(vec: Vec4[Double]): Vec4[Double] = vec * value
    def /(vec: Vec4[Double]): Vec4[Double] = vec |/ value
    def +(vec: Vec4[Double]): Vec4[Double] = vec + value
    def -(vec: Vec4[Double]): Vec4[Double] = vec |- value
  }
}
package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps
import VecImplicits._

class CasterSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Caster" should {

    "Cast between types (zeros)" in {
      Zero[Vec2[Int]] shouldBe (Zero[Vec2[Int]]: Vec2[Int])
      Zero[Vec2[Int]] shouldBe (Zero[Vec2[Float]]: Vec2[Int])
      Zero[Vec2[Int]] shouldBe (Zero[Vec2[Long]]: Vec2[Int])
      Zero[Vec2[Int]] shouldBe (Zero[Vec2[Double]]: Vec2[Int])

      Zero[Vec2[Float]] shouldBe (Zero[Vec2[Int]]: Vec2[Float])
      Zero[Vec2[Float]] shouldBe (Zero[Vec2[Float]]: Vec2[Float])
      Zero[Vec2[Float]] shouldBe (Zero[Vec2[Long]]: Vec2[Float])
      Zero[Vec2[Float]] shouldBe (Zero[Vec2[Double]]: Vec2[Float])

      Zero[Vec2[Long]] shouldBe (Zero[Vec2[Int]]: Vec2[Long])
      Zero[Vec2[Long]] shouldBe (Zero[Vec2[Float]]: Vec2[Long])
      Zero[Vec2[Long]] shouldBe (Zero[Vec2[Long]]: Vec2[Long])
      Zero[Vec2[Long]] shouldBe (Zero[Vec2[Double]]: Vec2[Long])

      Zero[Vec2[Double]] shouldBe (Zero[Vec2[Int]]: Vec2[Double])
      Zero[Vec2[Double]] shouldBe (Zero[Vec2[Float]]: Vec2[Double])
      Zero[Vec2[Double]] shouldBe (Zero[Vec2[Long]]: Vec2[Double])
      Zero[Vec2[Double]] shouldBe (Zero[Vec2[Double]]: Vec2[Double])

      Zero[Vec3[Int]] shouldBe (Zero[Vec3[Int]]: Vec3[Int])
      Zero[Vec3[Int]] shouldBe (Zero[Vec3[Float]]: Vec3[Int])
      Zero[Vec3[Int]] shouldBe (Zero[Vec3[Long]]: Vec3[Int])
      Zero[Vec3[Int]] shouldBe (Zero[Vec3[Double]]: Vec3[Int])

      Zero[Vec3[Float]] shouldBe (Zero[Vec3[Int]]: Vec3[Float])
      Zero[Vec3[Float]] shouldBe (Zero[Vec3[Float]]: Vec3[Float])
      Zero[Vec3[Float]] shouldBe (Zero[Vec3[Long]]: Vec3[Float])
      Zero[Vec3[Float]] shouldBe (Zero[Vec3[Double]]: Vec3[Float])

      Zero[Vec3[Long]] shouldBe (Zero[Vec3[Int]]: Vec3[Long])
      Zero[Vec3[Long]] shouldBe (Zero[Vec3[Float]]: Vec3[Long])
      Zero[Vec3[Long]] shouldBe (Zero[Vec3[Long]]: Vec3[Long])
      Zero[Vec3[Long]] shouldBe (Zero[Vec3[Double]]: Vec3[Long])

      Zero[Vec3[Double]] shouldBe (Zero[Vec3[Int]]: Vec3[Double])
      Zero[Vec3[Double]] shouldBe (Zero[Vec3[Float]]: Vec3[Double])
      Zero[Vec3[Double]] shouldBe (Zero[Vec3[Long]]: Vec3[Double])
      Zero[Vec3[Double]] shouldBe (Zero[Vec3[Double]]: Vec3[Double])

      Zero[Vec4[Int]] shouldBe (Zero[Vec4[Int]]: Vec4[Int])
      Zero[Vec4[Int]] shouldBe (Zero[Vec4[Float]]: Vec4[Int])
      Zero[Vec4[Int]] shouldBe (Zero[Vec4[Long]]: Vec4[Int])
      Zero[Vec4[Int]] shouldBe (Zero[Vec4[Double]]: Vec4[Int])

      Zero[Vec4[Float]] shouldBe (Zero[Vec4[Int]]: Vec4[Float])
      Zero[Vec4[Float]] shouldBe (Zero[Vec4[Float]]: Vec4[Float])
      Zero[Vec4[Float]] shouldBe (Zero[Vec4[Long]]: Vec4[Float])
      Zero[Vec4[Float]] shouldBe (Zero[Vec4[Double]]: Vec4[Float])

      Zero[Vec4[Long]] shouldBe (Zero[Vec4[Int]]: Vec4[Long])
      Zero[Vec4[Long]] shouldBe (Zero[Vec4[Float]]: Vec4[Long])
      Zero[Vec4[Long]] shouldBe (Zero[Vec4[Long]]: Vec4[Long])
      Zero[Vec4[Long]] shouldBe (Zero[Vec4[Double]]: Vec4[Long])

      Zero[Vec4[Double]] shouldBe (Zero[Vec4[Int]]: Vec4[Double])
      Zero[Vec4[Double]] shouldBe (Zero[Vec4[Float]]: Vec4[Double])
      Zero[Vec4[Double]] shouldBe (Zero[Vec4[Long]]: Vec4[Double])
      Zero[Vec4[Double]] shouldBe (Zero[Vec4[Double]]: Vec4[Double])
    }

    "Cast between types (ones)" in {
      One[Vec2[Int]] shouldBe (One[Vec2[Int]] : Vec2[Int])
      One[Vec2[Int]] shouldBe (One[Vec2[Float]] : Vec2[Int])
      One[Vec2[Int]] shouldBe (One[Vec2[Long]] : Vec2[Int])
      One[Vec2[Int]] shouldBe (One[Vec2[Double]] : Vec2[Int])

      One[Vec2[Float]] shouldBe (One[Vec2[Int]] : Vec2[Float])
      One[Vec2[Float]] shouldBe (One[Vec2[Float]] : Vec2[Float])
      One[Vec2[Float]] shouldBe (One[Vec2[Long]] : Vec2[Float])
      One[Vec2[Float]] shouldBe (One[Vec2[Double]] : Vec2[Float])

      One[Vec2[Long]] shouldBe (One[Vec2[Int]] : Vec2[Long])
      One[Vec2[Long]] shouldBe (One[Vec2[Float]] : Vec2[Long])
      One[Vec2[Long]] shouldBe (One[Vec2[Long]] : Vec2[Long])
      One[Vec2[Long]] shouldBe (One[Vec2[Double]] : Vec2[Long])

      One[Vec2[Double]] shouldBe (One[Vec2[Int]] : Vec2[Double])
      One[Vec2[Double]] shouldBe (One[Vec2[Float]] : Vec2[Double])
      One[Vec2[Double]] shouldBe (One[Vec2[Long]] : Vec2[Double])
      One[Vec2[Double]] shouldBe (One[Vec2[Double]] : Vec2[Double])

      One[Vec3[Int]] shouldBe (One[Vec3[Int]] : Vec3[Int])
      One[Vec3[Int]] shouldBe (One[Vec3[Float]] : Vec3[Int])
      One[Vec3[Int]] shouldBe (One[Vec3[Long]] : Vec3[Int])
      One[Vec3[Int]] shouldBe (One[Vec3[Double]] : Vec3[Int])

      One[Vec3[Float]] shouldBe (One[Vec3[Int]] : Vec3[Float])
      One[Vec3[Float]] shouldBe (One[Vec3[Float]] : Vec3[Float])
      One[Vec3[Float]] shouldBe (One[Vec3[Long]] : Vec3[Float])
      One[Vec3[Float]] shouldBe (One[Vec3[Double]] : Vec3[Float])

      One[Vec3[Long]] shouldBe (One[Vec3[Int]] : Vec3[Long])
      One[Vec3[Long]] shouldBe (One[Vec3[Float]] : Vec3[Long])
      One[Vec3[Long]] shouldBe (One[Vec3[Long]] : Vec3[Long])
      One[Vec3[Long]] shouldBe (One[Vec3[Double]] : Vec3[Long])

      One[Vec3[Double]] shouldBe (One[Vec3[Int]] : Vec3[Double])
      One[Vec3[Double]] shouldBe (One[Vec3[Float]] : Vec3[Double])
      One[Vec3[Double]] shouldBe (One[Vec3[Long]] : Vec3[Double])
      One[Vec3[Double]] shouldBe (One[Vec3[Double]] : Vec3[Double])

      One[Vec4[Int]] shouldBe (One[Vec4[Int]] : Vec4[Int])
      One[Vec4[Int]] shouldBe (One[Vec4[Float]] : Vec4[Int])
      One[Vec4[Int]] shouldBe (One[Vec4[Long]] : Vec4[Int])
      One[Vec4[Int]] shouldBe (One[Vec4[Double]] : Vec4[Int])

      One[Vec4[Float]] shouldBe (One[Vec4[Int]] : Vec4[Float])
      One[Vec4[Float]] shouldBe (One[Vec4[Float]] : Vec4[Float])
      One[Vec4[Float]] shouldBe (One[Vec4[Long]] : Vec4[Float])
      One[Vec4[Float]] shouldBe (One[Vec4[Double]] : Vec4[Float])

      One[Vec4[Long]] shouldBe (One[Vec4[Int]] : Vec4[Long])
      One[Vec4[Long]] shouldBe (One[Vec4[Float]] : Vec4[Long])
      One[Vec4[Long]] shouldBe (One[Vec4[Long]] : Vec4[Long])
      One[Vec4[Long]] shouldBe (One[Vec4[Double]] : Vec4[Long])

      One[Vec4[Double]] shouldBe (One[Vec4[Int]] : Vec4[Double])
      One[Vec4[Double]] shouldBe (One[Vec4[Float]] : Vec4[Double])
      One[Vec4[Double]] shouldBe (One[Vec4[Long]] : Vec4[Double])
      One[Vec4[Double]] shouldBe (One[Vec4[Double]] : Vec4[Double])

    }

    "Cast between types (1,2,3,4)" in {
      Vec2[Int](1,2) shouldBe (Vec2[Int](1,2) : Vec2[Int])
      Vec2[Int](1,2) shouldBe (Vec2[Float](1,2) : Vec2[Int])
      Vec2[Int](1,2) shouldBe (Vec2[Long](1,2) : Vec2[Int])
      Vec2[Int](1,2) shouldBe (Vec2[Double](1,2) : Vec2[Int])

      Vec2[Float](1,2) shouldBe (Vec2[Int](1,2) : Vec2[Float])
      Vec2[Float](1,2) shouldBe (Vec2[Float](1,2) : Vec2[Float])
      Vec2[Float](1,2) shouldBe (Vec2[Long](1,2) : Vec2[Float])
      Vec2[Float](1,2) shouldBe (Vec2[Double](1,2) : Vec2[Float])

      Vec2[Long](1,2) shouldBe (Vec2[Int](1,2) : Vec2[Long])
      Vec2[Long](1,2) shouldBe (Vec2[Float](1,2) : Vec2[Long])
      Vec2[Long](1,2) shouldBe (Vec2[Long](1,2) : Vec2[Long])
      Vec2[Long](1,2) shouldBe (Vec2[Double](1,2) : Vec2[Long])

      Vec2[Double](1,2) shouldBe (Vec2[Int](1,2) : Vec2[Double])
      Vec2[Double](1,2) shouldBe (Vec2[Float](1,2) : Vec2[Double])
      Vec2[Double](1,2) shouldBe (Vec2[Long](1,2) : Vec2[Double])
      Vec2[Double](1,2) shouldBe (Vec2[Double](1,2) : Vec2[Double])

      Vec3[Int](1,2,3) shouldBe (Vec3[Int](1,2,3) : Vec3[Int])
      Vec3[Int](1,2,3) shouldBe (Vec3[Float](1,2,3) : Vec3[Int])
      Vec3[Int](1,2,3) shouldBe (Vec3[Long](1,2,3) : Vec3[Int])
      Vec3[Int](1,2,3) shouldBe (Vec3[Double](1,2,3) : Vec3[Int])

      Vec3[Float](1,2,3) shouldBe (Vec3[Int](1,2,3) : Vec3[Float])
      Vec3[Float](1,2,3) shouldBe (Vec3[Float](1,2,3) : Vec3[Float])
      Vec3[Float](1,2,3) shouldBe (Vec3[Long](1,2,3) : Vec3[Float])
      Vec3[Float](1,2,3) shouldBe (Vec3[Double](1,2,3) : Vec3[Float])

      Vec3[Long](1,2,3) shouldBe (Vec3[Int](1,2,3) : Vec3[Long])
      Vec3[Long](1,2,3) shouldBe (Vec3[Float](1,2,3) : Vec3[Long])
      Vec3[Long](1,2,3) shouldBe (Vec3[Long](1,2,3) : Vec3[Long])
      Vec3[Long](1,2,3) shouldBe (Vec3[Double](1,2,3) : Vec3[Long])

      Vec3[Double](1,2,3) shouldBe (Vec3[Int](1,2,3) : Vec3[Double])
      Vec3[Double](1,2,3) shouldBe (Vec3[Float](1,2,3) : Vec3[Double])
      Vec3[Double](1,2,3) shouldBe (Vec3[Long](1,2,3) : Vec3[Double])
      Vec3[Double](1,2,3) shouldBe (Vec3[Double](1,2,3) : Vec3[Double])

      Vec4[Int](1,2,3,4) shouldBe (Vec4[Int](1,2,3,4) : Vec4[Int])
      Vec4[Int](1,2,3,4) shouldBe (Vec4[Float](1,2,3,4) : Vec4[Int])
      Vec4[Int](1,2,3,4) shouldBe (Vec4[Long](1,2,3,4) : Vec4[Int])
      Vec4[Int](1,2,3,4) shouldBe (Vec4[Double](1,2,3,4) : Vec4[Int])

      Vec4[Float](1,2,3,4) shouldBe (Vec4[Int](1,2,3,4) : Vec4[Float])
      Vec4[Float](1,2,3,4) shouldBe (Vec4[Float](1,2,3,4) : Vec4[Float])
      Vec4[Float](1,2,3,4) shouldBe (Vec4[Long](1,2,3,4) : Vec4[Float])
      Vec4[Float](1,2,3,4) shouldBe (Vec4[Double](1,2,3,4) : Vec4[Float])

      Vec4[Long](1,2,3,4) shouldBe (Vec4[Int](1,2,3,4) : Vec4[Long])
      Vec4[Long](1,2,3,4) shouldBe (Vec4[Float](1,2,3,4) : Vec4[Long])
      Vec4[Long](1,2,3,4) shouldBe (Vec4[Long](1,2,3,4) : Vec4[Long])
      Vec4[Long](1,2,3,4) shouldBe (Vec4[Double](1,2,3,4) : Vec4[Long])

      Vec4[Double](1,2,3,4) shouldBe (Vec4[Int](1,2,3,4) : Vec4[Double])
      Vec4[Double](1,2,3,4) shouldBe (Vec4[Float](1,2,3,4) : Vec4[Double])
      Vec4[Double](1,2,3,4) shouldBe (Vec4[Long](1,2,3,4) : Vec4[Double])
      Vec4[Double](1,2,3,4) shouldBe (Vec4[Double](1,2,3,4) : Vec4[Double])

    }
  }
}

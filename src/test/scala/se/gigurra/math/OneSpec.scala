package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class OneSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "One" should {

    "Expose one values" in {
      One[Vec2[Int]]    shouldBe Vec2[Int]   (1, 1)
      One[Vec2[Float]]  shouldBe Vec2[Float] (1.0f, 1.0f)
      One[Vec2[Long]]   shouldBe Vec2[Long]  (1L, 1L)
      One[Vec2[Double]] shouldBe Vec2[Double](1.0, 1.0)

      One[Vec3[Int]]    shouldBe Vec3[Int]   (1, 1, 1)
      One[Vec3[Float]]  shouldBe Vec3[Float] (1.0f, 1.0f, 1.0f)
      One[Vec3[Long]]   shouldBe Vec3[Long]  (1L, 1L, 1L)
      One[Vec3[Double]] shouldBe Vec3[Double](1.0, 1.0, 1.0)

      One[Vec4[Int]]    shouldBe Vec4[Int]   (1, 1, 1, 1)
      One[Vec4[Float]]  shouldBe Vec4[Float] (1.0f, 1.0f, 1.0f, 1.0f)
      One[Vec4[Long]]   shouldBe Vec4[Long]  (1L, 1L, 1L, 1L)
      One[Vec4[Double]] shouldBe Vec4[Double](1.0, 1.0, 1.0, 1.0)

      One[Int]    shouldBe 1
      One[Float]  shouldBe 1.0f
      One[Long]   shouldBe 1L
      One[Double] shouldBe 1.0
    }
  }
}

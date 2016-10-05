package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class TwoSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Two" should {

    "Expose two values" in {
      Two[Vec2[Int]]    shouldBe Vec2[Int]   (2, 2)
      Two[Vec2[Float]]  shouldBe Vec2[Float] (2.0f, 2.0f)
      Two[Vec2[Long]]   shouldBe Vec2[Long]  (2L, 2L)
      Two[Vec2[Double]] shouldBe Vec2[Double](2.0, 2.0)

      Two[Vec3[Int]]    shouldBe Vec3[Int]   (2, 2, 2)
      Two[Vec3[Float]]  shouldBe Vec3[Float] (2.0f, 2.0f, 2.0f)
      Two[Vec3[Long]]   shouldBe Vec3[Long]  (2L, 2L, 2L)
      Two[Vec3[Double]] shouldBe Vec3[Double](2.0, 2.0, 2.0)

      Two[Vec4[Int]]    shouldBe Vec4[Int]   (2, 2, 2, 1)
      Two[Vec4[Float]]  shouldBe Vec4[Float] (2.0f, 2.0f, 2.0f, 1.0f)
      Two[Vec4[Long]]   shouldBe Vec4[Long]  (2L, 2L, 2L, 1L)
      Two[Vec4[Double]] shouldBe Vec4[Double](2.0, 2.0, 2.0, 1.0)

      Two[Int]    shouldBe 2
      Two[Float]  shouldBe 2.0f
      Two[Long]   shouldBe 2L
      Two[Double] shouldBe 2.0
    }
  }
}

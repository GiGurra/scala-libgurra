package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class ZeroSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Zero" should {

    "Expose zero values" in {
      Zero[Vec2[Int]]    shouldBe Vec2[Int]   (0, 0)
      Zero[Vec2[Float]]  shouldBe Vec2[Float] (0.0f, 0.0f)
      Zero[Vec2[Long]]   shouldBe Vec2[Long]  (0L, 0L)
      Zero[Vec2[Double]] shouldBe Vec2[Double](0.0, 0.0)

      Zero[Vec3[Int]]    shouldBe Vec3[Int]   (0, 0, 0)
      Zero[Vec3[Float]]  shouldBe Vec3[Float] (0.0f, 0.0f, 0.0f)
      Zero[Vec3[Long]]   shouldBe Vec3[Long]  (0L, 0L, 0L)
      Zero[Vec3[Double]] shouldBe Vec3[Double](0.0, 0.0, 0.0)

      Zero[Vec4[Int]]    shouldBe Vec4[Int]   (0, 0, 0, 0)
      Zero[Vec4[Float]]  shouldBe Vec4[Float] (0.0f, 0.0f, 0.0f, 0.0f)
      Zero[Vec4[Long]]   shouldBe Vec4[Long]  (0L, 0L, 0L, 0L)
      Zero[Vec4[Double]] shouldBe Vec4[Double](0.0, 0.0, 0.0, 0.0)

      Zero[Int]    shouldBe 0
      Zero[Float]  shouldBe 0.0f
      Zero[Long]   shouldBe 0L
      Zero[Double] shouldBe 0.0
    }
  }
}

package se.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps
import VecImplicits._

class VecScalarOpsSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "VecBase" should {

    "Vec2" should {

      "Add " in {
        Vec2[Int](1, 2) + Vec2[Int](1, 2) shouldBe Vec2[Int](2, 4)
        Vec2[Int](1, 2) + 2 shouldBe Vec2[Int](3, 4)
        (2 + Vec2[Int](1, 2)) shouldBe Vec2[Int](3, 4)

        Vec2[Float](1.0f, 2.0f) + Vec2[Float](1.0f, 2.0f) shouldBe Vec2[Float](2.0f, 4.0f)
        Vec2[Float](1.0f, 2.0f) + 2.0f shouldBe Vec2[Float](3.0f, 4.0f)
        (2.0f + Vec2[Float](1.0f, 2.0f)) shouldBe Vec2[Float](3.0f, 4.0f)

        Vec2[Long](1L, 2L) + Vec2[Long](1L, 2L) shouldBe Vec2[Long](2L, 4L)
        Vec2[Long](1L, 2L) + 2L shouldBe Vec2[Long](3L, 4L)
        (2L + Vec2[Long](1L, 2L)) shouldBe Vec2[Long](3L, 4L)

        Vec2[Double](1.0, 2.0) + Vec2[Double](1.0, 2.0) shouldBe Vec2[Double](2.0, 4.0)
        Vec2[Double](1.0, 2.0) + 2.0 shouldBe Vec2[Double](3.0, 4.0)
        (2.0 + Vec2[Double](1.0, 2.0)) shouldBe Vec2[Double](3.0, 4.0)
      }

      "Subtract " in {
        Vec2[Int](11, 12) - Vec2[Int](1, 2) shouldBe Vec2[Int](10, 10)
        Vec2[Int](11, 12) - 2 shouldBe Vec2[Int](9, 10)
        (12 - Vec2[Int](1, 2)) shouldBe Vec2[Int](11, 10)
        Vec2[Float](11, 12) - Vec2[Float](1, 2) shouldBe Vec2[Float](10, 10)
        Vec2[Long](11, 12) - Vec2[Long](1, 2) shouldBe Vec2[Long](10, 10)
        Vec2[Double](11, 12) - Vec2[Double](1, 2) shouldBe Vec2[Double](10, 10)
      }
    }

    "Vec3" should {

    }

    "Vec4" should {

    }

  }
}

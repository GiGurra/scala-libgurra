package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class Vec2ScalarOpsSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Vec2" should {

    "Add" in {
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

    "Subtract" in {
      Vec2[Int](11, 12) - Vec2[Int](1, 2) shouldBe Vec2[Int](10, 10)
      Vec2[Int](11, 12) - 2 shouldBe Vec2[Int](9, 10)
      (12 - Vec2[Int](1, 2)) shouldBe Vec2[Int](11, 10)

      Vec2[Float](11.0f, 12.0f) - Vec2[Float](1.0f, 2.0f) shouldBe Vec2[Float](10.0f, 10.0f)
      Vec2[Float](11.0f, 12.0f) - 2.0f shouldBe Vec2[Float](9.0f, 10.0f)
      (12.0f - Vec2[Float](1.0f, 2.0f)) shouldBe Vec2[Float](11.0f, 10.0f)

      Vec2[Long](11L, 12L) - Vec2[Long](1L, 2L) shouldBe Vec2[Long](10L, 10L)
      Vec2[Long](11L, 12L) - 2L shouldBe Vec2[Long](9L, 10L)
      (12L - Vec2[Long](1L, 2L)) shouldBe Vec2[Long](11L, 10L)

      Vec2[Double](11.0, 12.0) - Vec2[Double](1.0, 2.0) shouldBe Vec2[Double](10.0, 10.0)
      Vec2[Double](11.0, 12.0) - 2.0 shouldBe Vec2[Double](9.0, 10.0)
      (12.0 - Vec2[Double](1.0, 2.0)) shouldBe Vec2[Double](11.0, 10.0)
    }

    "Multiply" in {
      Vec2[Int](11, 12) *|* Vec2[Int](1, 2) shouldBe Vec2[Int](11, 24)
      Vec2[Int](11, 12) * 2 shouldBe Vec2[Int](22, 24)
      (12 * Vec2[Int](1, 2)) shouldBe Vec2[Int](12, 24)

      Vec2[Float](11.0f, 12.0f) *|* Vec2[Float](1.0f, 2.0f) shouldBe Vec2[Float](11.0f, 24.0f)
      Vec2[Float](11.0f, 12.0f) * 2.0f shouldBe Vec2[Float](22.0f, 24.0f)
      (12.0f * Vec2[Float](1.0f, 2.0f)) shouldBe Vec2[Float](12.0f, 24.0f)

      Vec2[Long](11L, 12L) *|* Vec2[Long](1L, 2L) shouldBe Vec2[Long](11L, 24L)
      Vec2[Long](11L, 12L) * 2L shouldBe Vec2[Long](22L, 24L)
      (12L * Vec2[Long](1L, 2L)) shouldBe Vec2[Long](12L, 24L)

      Vec2[Double](11.0, 12.0) *|* Vec2[Double](1.0, 2.0) shouldBe Vec2[Double](11.0, 24.0)
      Vec2[Double](11.0, 12.0) * 2.0 shouldBe Vec2[Double](22.0, 24.0)
      (12.0 * Vec2[Double](1.0, 2.0)) shouldBe Vec2[Double](12.0, 24.0)
    }

    "Divide" in {
      Vec2[Int](11, 12) /|/ Vec2[Int](1, 2) shouldBe Vec2[Int](11, 6)
      Vec2[Int](11, 12) / 2 shouldBe Vec2[Int](5, 6)
      (12 / Vec2[Int](1, 2)) shouldBe Vec2[Int](12, 6)

      Vec2[Float](11.0f, 12.0f) /|/ Vec2[Float](1.0f, 2.0f) shouldBe Vec2[Float](11.0f, 6.0f)
      Vec2[Float](11.0f, 12.0f) / 2.0f shouldBe Vec2[Float](5.5f, 6.0f)
      (12.0f / Vec2[Float](1.0f, 2.0f)) shouldBe Vec2[Float](12.0f, 6.0f)

      Vec2[Long](11L, 12L) /|/ Vec2[Long](1L, 2L) shouldBe Vec2[Long](11L, 6L)
      Vec2[Long](11L, 12L) / 2L shouldBe Vec2[Long](5L, 6L)
      (12L / Vec2[Long](1L, 2L)) shouldBe Vec2[Long](12L, 6L)

      Vec2[Double](11.0, 12.0) /|/ Vec2[Double](1.0, 2.0) shouldBe Vec2[Double](11.0, 6.0)
      Vec2[Double](11.0, 12.0) / 2.0 shouldBe Vec2[Double](5.5, 6.0)
      (12.0 / Vec2[Double](1.0, 2.0)) shouldBe Vec2[Double](12.0, 6.0)
    }

    "Dot" in {
      val v1 = Vec2(3,4)
      val v2 = Vec2(5,1)
      v1 dot v2 shouldBe 19
    }

    /** No cross product exists in R2
    "Cross" in {
      ???
    }
    */

    "Negate" in {
      -Vec2[Int](3,4) shouldBe Vec2[Int](-3,-4)
      -Vec2[Float](3.0f,4.0f) shouldBe Vec2[Float](-3.0f,-4.0f)
      -Vec2[Long](3L,4L) shouldBe Vec2[Long](-3L,-4L)
      -Vec2[Double](3.0,4.0) shouldBe Vec2[Double](-3.0,-4.0)
    }
  }
}

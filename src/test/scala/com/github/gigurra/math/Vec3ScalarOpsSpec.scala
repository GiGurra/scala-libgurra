package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class Vec3ScalarOpsSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Vec3" should {

    "Add" in {
      Vec3[Int](1, 2, 3) + Vec3[Int](1, 2, 3) shouldBe Vec3[Int](2, 4, 6)
      Vec3[Int](1, 2, 3) + 2 shouldBe Vec3[Int](3, 4, 5)
      (2 + Vec3[Int](1, 2, 3)) shouldBe Vec3[Int](3, 4, 5)

      Vec3[Float](1.0f, 2.0f, 3.0f) + Vec3[Float](1.0f, 2.0f, 3.0f) shouldBe Vec3[Float](2.0f, 4.0f, 6.0f)
      Vec3[Float](1.0f, 2.0f, 3.0f) + 2.0f shouldBe Vec3[Float](3.0f, 4.0f, 5.0f)
      (2.0f + Vec3[Float](1.0f, 2.0f, 3.0f)) shouldBe Vec3[Float](3.0f, 4.0f, 5.0f)

      Vec3[Long](1L, 2L, 3L) + Vec3[Long](1L, 2L, 3L) shouldBe Vec3[Long](2L, 4L, 6L)
      Vec3[Long](1L, 2L, 3L) + 2L shouldBe Vec3[Long](3L, 4L, 5L)
      (2L + Vec3[Long](1L, 2L, 3L)) shouldBe Vec3[Long](3L, 4L, 5L)

      Vec3[Double](1.0, 2.0, 3.0) + Vec3[Double](1.0, 2.0, 3.0) shouldBe Vec3[Double](2.0, 4.0, 6.0)
      Vec3[Double](1.0, 2.0, 3.0) + 2.0 shouldBe Vec3[Double](3.0, 4.0, 5.0)
      (2.0 + Vec3[Double](1.0, 2.0, 3.0)) shouldBe Vec3[Double](3.0, 4.0, 5.0)
    }

    "Subtract" in {
      Vec3[Int](11, 12, 13) - Vec3[Int](1, 2, 3) shouldBe Vec3[Int](10, 10, 10)
      Vec3[Int](11, 12, 13) - 2 shouldBe Vec3[Int](9, 10, 11)
      (12 - Vec3[Int](1, 2, 3)) shouldBe Vec3[Int](11, 10, 9)

      Vec3[Float](11.0f, 12.0f, 13.0f) - Vec3[Float](1.0f, 2.0f, 3.0f) shouldBe Vec3[Float](10.0f, 10.0f, 10.0f)
      Vec3[Float](11.0f, 12.0f, 13.0f) - 2.0f shouldBe Vec3[Float](9.0f, 10.0f, 11.0f)
      (12.0f - Vec3[Float](1.0f, 2.0f, 3.0f)) shouldBe Vec3[Float](11.0f, 10.0f, 9.0f)

      Vec3[Long](11L, 12L, 13L) - Vec3[Long](1L, 2L, 3L) shouldBe Vec3[Long](10L, 10L, 10L)
      Vec3[Long](11L, 12L, 13L) - 2L shouldBe Vec3[Long](9L, 10L, 11L)
      (12L - Vec3[Long](1L, 2L, 3L)) shouldBe Vec3[Long](11L, 10L, 9L)

      Vec3[Double](11.0, 12.0, 13.0) - Vec3[Double](1.0, 2.0, 3.0) shouldBe Vec3[Double](10.0, 10.0, 10.0)
      Vec3[Double](11.0, 12.0, 13.0) - 2.0 shouldBe Vec3[Double](9.0, 10.0, 11.0)
      (12.0 - Vec3[Double](1.0, 2.0, 3.0)) shouldBe Vec3[Double](11.0, 10.0, 9.0)
    }

    "Multiply" in {
      Vec3[Int](11, 12, 13) *|* Vec3[Int](1, 2, 3) shouldBe Vec3[Int](11, 24, 39)
      Vec3[Int](11, 12, 13) * 2 shouldBe Vec3[Int](22, 24, 26)
      (12 * Vec3[Int](1, 2, 3)) shouldBe Vec3[Int](12, 24, 36)

      Vec3[Float](11.0f, 12.0f, 13.0f) *|* Vec3[Float](1.0f, 2.0f, 3.0f) shouldBe Vec3[Float](11.0f, 24.0f, 39.0f)
      Vec3[Float](11.0f, 12.0f, 13.0f) * 2.0f shouldBe Vec3[Float](22.0f, 24.0f, 26.0f)
      (12.0f * Vec3[Float](1.0f, 2.0f, 3.0f)) shouldBe Vec3[Float](12.0f, 24.0f, 36.0f)

      Vec3[Long](11L, 12L, 13L) *|* Vec3[Long](1L, 2L, 3L) shouldBe Vec3[Long](11L, 24L, 39L)
      Vec3[Long](11L, 12L, 13L) * 2L shouldBe Vec3[Long](22L, 24L, 26L)
      (12L * Vec3[Long](1L, 2L, 3L)) shouldBe Vec3[Long](12L, 24L, 36L)

      Vec3[Double](11.0, 12.0, 13.0) *|* Vec3[Double](1.0, 2.0, 3.0) shouldBe Vec3[Double](11.0, 24.0, 39.0)
      Vec3[Double](11.0, 12.0, 13.0) * 2.0 shouldBe Vec3[Double](22.0, 24.0, 26.0)
      (12.0 * Vec3[Double](1.0, 2.0, 3.0)) shouldBe Vec3[Double](12.0, 24.0, 36.0)
    }

    "Divide" in {
      Vec3[Int](11, 12, 13) /|/ Vec3[Int](1, 2, 3) shouldBe Vec3[Int](11, 6, 4)
      Vec3[Int](11, 12, 13) / 2 shouldBe Vec3[Int](5, 6, 6)
      (12 / Vec3[Int](1, 2, 3)) shouldBe Vec3[Int](12, 6, 4)

      Vec3[Float](11.0f, 12.0f, 13.0f) /|/ Vec3[Float](1.0f, 2.0f, 3.0f) shouldBe Vec3[Float](11.0f, 6.0f, 13.0f/3.0f)
      Vec3[Float](11.0f, 12.0f, 13.0f) / 2.0f shouldBe Vec3[Float](5.5f, 6.0f, 6.5f)
      (12.0f / Vec3[Float](1.0f, 2.0f, 3.0f)) shouldBe Vec3[Float](12.0f, 6.0f, 4.0f)

      Vec3[Long](11L, 12L, 13L) /|/ Vec3[Long](1L, 2L, 3L) shouldBe Vec3[Long](11L, 6L, 4L)
      Vec3[Long](11L, 12L, 13L) / 2L shouldBe Vec3[Long](5L, 6L, 6L)
      (12L / Vec3[Long](1L, 2L, 3L)) shouldBe Vec3[Long](12L, 6L, 4L)

      Vec3[Double](11.0, 12.0, 13.0) /|/ Vec3[Double](1.0, 2.0, 3.0) shouldBe Vec3[Double](11.0, 6.0, 13.0/3.0)
      Vec3[Double](11.0, 12.0, 13.0) / 2.0 shouldBe Vec3[Double](5.5, 6.0, 6.5)
      (12.0 / Vec3[Double](1.0, 2.0, 3.0)) shouldBe Vec3[Double](12.0, 6.0, 4.0)
    }

    "Dot" in {
      val v1 = Vec3(3,4,5)
      val v2 = Vec3(5,1,-2)
      v1 dot v2 shouldBe 9
    }

    "Cross" in {
      Vec3[Int](3,5,2) x Vec3[Int](1,7,8) shouldBe Vec3[Int](26,-22,16)
      Vec3[Float](3.0f,5.0f,2.0f) x Vec3[Float](1.0f,7.0f,8.0f) shouldBe Vec3[Float](26.0f,-22.0f,16.0f)
      Vec3[Long](3L,5L,2L) x Vec3[Long](1L,7L,8L) shouldBe Vec3[Long](26L,-22L,16L)
      Vec3[Double](3.0,5.0,2.0) x Vec3[Double](1.0,7.0,8.0) shouldBe Vec3[Double](26.0,-22.0,16.0)
    }

    "Negate" in {
      -Vec3[Int](3,4,5) shouldBe Vec3[Int](-3,-4,-5)
      -Vec3[Float](3.0f,4.0f,5.0f) shouldBe Vec3[Float](-3.0f,-4.0f,-5.0f)
      -Vec3[Long](3L,4L,5L) shouldBe Vec3[Long](-3L,-4L,-5L)
      -Vec3[Double](3.0,4.0,5.0) shouldBe Vec3[Double](-3.0,-4.0,-5.0)
    }
  }
}

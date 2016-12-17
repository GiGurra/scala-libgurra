package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class Vec4ScalarOpsSpec
  extends WordSpec
    with MockitoSugar
    with Matchers
    with OneInstancePerTest {

  "Vec4" should {

    "Add" in {
      Vec4(1.0f, 2.0f, 3.0f, 1) + Vec4(1.0f, 2.0f, 3.0f, 1) shouldBe Vec4(2.0f, 4.0f, 6.0f, 1)
      Vec4(1.0f, 2.0f, 3.0f, 1) + 2.0f shouldBe Vec4(3.0f, 4.0f, 5.0f, 1)
      (2.0f + Vec4(1.0f, 2.0f, 3.0f, 1)) shouldBe Vec4(3.0f, 4.0f, 5.0f, 1)
    }

    "Subtract" in {
      Vec4(11.0f, 12.0f, 13.0f, 1) - Vec4(1.0f, 2.0f, 3.0f, 1) shouldBe Vec4(10.0f, 10.0f, 10.0f, 1)
      Vec4(11.0f, 12.0f, 13.0f, 1) - 2.0f shouldBe Vec4(9.0f, 10.0f, 11.0f, 1)
      (12.0f - Vec4(1.0f, 2.0f, 3.0f, 1)) shouldBe Vec4(11.0f, 10.0f, 9.0f, 1)
    }

    "Multiply" in {
      Vec4(11.0f, 12.0f, 13.0f, 1) *|* Vec4(1.0f, 2.0f, 3.0f, 1) shouldBe Vec4(11.0f, 24.0f, 39.0f, 1)
      Vec4(11.0f, 12.0f, 13.0f, 1) * 2.0f shouldBe Vec4(22.0f, 24.0f, 26.0f, 1)
      (12.0f * Vec4(1.0f, 2.0f, 3.0f, 1)) shouldBe Vec4(12.0f, 24.0f, 36.0f, 1)
    }

    "Divide" in {
      Vec4(11.0f, 12.0f, 13.0f, 1) /|/ Vec4(1.0f, 2.0f, 3.0f, 1) shouldBe Vec4(11.0f, 6.0f, 13.0f/3.0f, 1)
      Vec4(11.0f, 12.0f, 13.0f, 1) / 2.0f shouldBe Vec4(5.5f, 6.0f, 6.5f, 1)
      (12.0f / Vec4(1.0f, 2.0f, 3.0f, 1)) shouldBe Vec4(12.0f, 6.0f, 4.0f, 1)
    }

    "Dot" in {
      val v1 = Vec4(3,4,5, 1)
      val v2 = Vec4(5,1,-2, 1)
      v1 dot v2 shouldBe 9
    }

    "Cross" in {
      Vec4(3.0f,5.0f,2.0f, 1) x Vec4(1.0f,7.0f,8.0f, 1) shouldBe Vec4(26.0f,-22.0f,16.0f, 1)
    }

    "Negate" in {
      -Vec4(3.0f,4.0f,5.0f, 1) shouldBe Vec4(-3.0f,-4.0f,-5.0f, 1)
    }
  }
}

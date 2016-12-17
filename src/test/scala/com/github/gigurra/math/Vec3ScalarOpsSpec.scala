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
      Vec3(1.0f, 2.0f, 3.0f) + Vec3(1.0f, 2.0f, 3.0f) shouldBe Vec3(2.0f, 4.0f, 6.0f)
      Vec3(1.0f, 2.0f, 3.0f) + 2.0f shouldBe Vec3(3.0f, 4.0f, 5.0f)
      (2.0f + Vec3(1.0f, 2.0f, 3.0f)) shouldBe Vec3(3.0f, 4.0f, 5.0f)
    }

    "Subtract" in {
      Vec3(11.0f, 12.0f, 13.0f) - Vec3(1.0f, 2.0f, 3.0f) shouldBe Vec3(10.0f, 10.0f, 10.0f)
      Vec3(11.0f, 12.0f, 13.0f) - 2.0f shouldBe Vec3(9.0f, 10.0f, 11.0f)
      (12.0f - Vec3(1.0f, 2.0f, 3.0f)) shouldBe Vec3(11.0f, 10.0f, 9.0f)
    }

    "Multiply" in {
      Vec3(11.0f, 12.0f, 13.0f) *|* Vec3(1.0f, 2.0f, 3.0f) shouldBe Vec3(11.0f, 24.0f, 39.0f)
      Vec3(11.0f, 12.0f, 13.0f) * 2.0f shouldBe Vec3(22.0f, 24.0f, 26.0f)
      (12.0f * Vec3(1.0f, 2.0f, 3.0f)) shouldBe Vec3(12.0f, 24.0f, 36.0f)
    }

    "Divide" in {
      Vec3(11.0f, 12.0f, 13.0f) /|/ Vec3(1.0f, 2.0f, 3.0f) shouldBe Vec3(11.0f, 6.0f, 13.0f/3.0f)
      Vec3(11.0f, 12.0f, 13.0f) / 2.0f shouldBe Vec3(5.5f, 6.0f, 6.5f)
      (12.0f / Vec3(1.0f, 2.0f, 3.0f)) shouldBe Vec3(12.0f, 6.0f, 4.0f)
    }

    "Dot" in {
      val v1 = Vec3(3,4,5)
      val v2 = Vec3(5,1,-2)
      v1 dot v2 shouldBe 9
    }

    "Cross" in {
      Vec3(3.0f,5.0f,2.0f) x Vec3(1.0f,7.0f,8.0f) shouldBe Vec3(26.0f,-22.0f,16.0f)
    }

    "Negate" in {
      -Vec3(3.0f,4.0f,5.0f) shouldBe Vec3(-3.0f,-4.0f,-5.0f)
    }
  }
}

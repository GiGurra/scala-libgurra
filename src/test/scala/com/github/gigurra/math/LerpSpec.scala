package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class LerpSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Lerp" should {

    "lerp zero" in {
      lerp(delta = 0, range = 3.0, 0.0, 2.0) shouldBe 0.0
    }

    "lerp half" in {
      lerp(delta = 1.5, range = 3.0, 0.0, 2.0) shouldBe 1.0
    }

    "lerp full" in {
      lerp(delta = 4.5, range = 4.5, 0.0, 2.0) shouldBe 2.0
    }

    "lerp zero Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      lerp(delta = 0, range = 3.0, min, max, clamp = false) shouldBe min
    }

    "lerp half Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      lerp(delta = 1.5, range = 3.0, min, max, clamp = false) shouldBe ((min + max) / 2.0)
    }

    "lerp full Vec2" in {
      val min = Vec2(2.0, 6.0)
      val max = Vec2(4.0, 8.0)

      lerp(delta = 3.0, range = 3.0, min, max, clamp = false) shouldBe max
    }
  }
}

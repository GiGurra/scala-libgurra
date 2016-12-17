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
      lerp(delta = 0f, range = 3.0f, 0.0f, 2.0f) shouldBe 0.0f
    }

    "lerp half" in {
      lerp(delta = 1.5f, range = 3.0f, 0.0f, 2.0f) shouldBe 1.0f
    }

    "lerp full" in {
      lerp(delta = 4.5f, range = 4.5f, 0.0f, 2.0f) shouldBe 2.0f
    }

    "lerp zero Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      lerp(delta = 0f, range = 3.0f, min, max, clamp = false) shouldBe min
    }

    "lerp half Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      lerp(delta = 1.5f, range = 3.0f, min, max, clamp = false) shouldBe ((min + max) / 2.0f)
    }

    "lerp full Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      lerp(delta = 3.0f, range = 3.0f, min, max, clamp = false) shouldBe max
    }
  }
}

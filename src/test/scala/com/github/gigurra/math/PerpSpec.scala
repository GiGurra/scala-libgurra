package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class PerpSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Perp" should {

    "perp zero" in {
      perp(delta = 0f, range = 3.0f, exponent = 0.5f, 0.0f, 2.0f, clamp = false) shouldBe 0.0f
      perp(delta = 0f, range = 3.0f, exponent = 1.0f, 0.0f, 2.0f, clamp = false) shouldBe 0.0f
      perp(delta = 0f, range = 3.0f, exponent = 2.0f, 0.0f, 2.0f, clamp = false) shouldBe 0.0f
    }

    "perp half" in {
      perp(delta = 1.5f, range = 3.0f, exponent = 0.5f, 0.0f, 2.0f, clamp = false) shouldBe math.sqrt(2.0f).toFloat
      perp(delta = 1.5f, range = 3.0f, exponent = 1.0f, 0.0f, 2.0f, clamp = false) shouldBe 1.0f
      perp(delta = 1.5f, range = 3.0f, exponent = 2.0f, 0.0f, 2.0f, clamp = false) shouldBe 0.5f
    }

    "perp full" in {
      perp(delta = 3.0f, range = 3.0f, exponent = 0.5f, 0.0f, 2.0f, clamp = false) shouldBe 2.0f
      perp(delta = 3.0f, range = 3.0f, exponent = 1.0f, 0.0f, 2.0f, clamp = false) shouldBe 2.0f
      perp(delta = 3.0f, range = 3.0f, exponent = 2.0f, 0.0f, 2.0f, clamp = false) shouldBe 2.0f
    }

    "perp zero Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      perp(delta = 0f, range = 3.0f, exponent = 0.5f, min, max, clamp = false) shouldBe min
      perp(delta = 0f, range = 3.0f, exponent = 1.0f, min, max, clamp = false) shouldBe min
      perp(delta = 0f, range = 3.0f, exponent = 2.0f, min, max, clamp = false) shouldBe min
    }

    "perp half Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      perp(delta = 1.5f, range = 3.0f, exponent = 0.5f, min, max, clamp = false) shouldBe (Vec2(math.sqrt(2.0f).toFloat, math.sqrt(2.0f).toFloat) + min)
      perp(delta = 1.5f, range = 3.0f, exponent = 1.0f, min, max, clamp = false) shouldBe (Vec2(1.0f, 1.0f) + min)
      perp(delta = 1.5f, range = 3.0f, exponent = 2.0f, min, max, clamp = false) shouldBe (Vec2(0.5f, 0.5f) + min)
    }

    "perp full Vec2" in {
      val min = Vec2(2.0f, 6.0f)
      val max = Vec2(4.0f, 8.0f)

      perp(delta = 3.0f, range = 3.0f, exponent = 0.5f, min, max, clamp = false) shouldBe max
      perp(delta = 3.0f, range = 3.0f, exponent = 1.0f, min, max, clamp = false) shouldBe max
      perp(delta = 3.0f, range = 3.0f, exponent = 2.0f, min, max, clamp = false) shouldBe max
    }
  }
}

package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class InterpolatorSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Interpolator" should {

    "perp half" in {
      Interpolator(range = 3.0, perp(_:Double, _:Double, exponent = 0.5, 0.0, 2.0, clamp = false)).interpolate(1.5) shouldBe math.sqrt(2.0)
    }

    "be chained" in {

      val i1 = Interpolator(range = 3.0, perp(_:Double, _:Double, exponent = 0.5, 0.0, 2.0, clamp = true))
      val i2 = Interpolator(range = 3.0, lerp(_:Double, _:Double, 0.0, 2.0, clamp = false))

      val ic = i1.andThen(i2).andThen(i1)

      ic.interpolate(-10.0) shouldBe 0.0
      ic.interpolate(0.0) shouldBe 0.0
      ic.interpolate(1.5) shouldBe math.sqrt(2.0)
      ic.interpolate(4.5) shouldBe 1.0
      ic.interpolate(7.5) shouldBe math.sqrt(2.0)
      ic.interpolate(9.0) shouldBe 2.0
      ic.interpolate(10.5) shouldBe 2.0
    }

  }
}

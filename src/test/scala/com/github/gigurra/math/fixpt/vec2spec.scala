package com.github.gigurra.math.fixpt

import com.github.gigurra.math.Vec2
import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class vec2spec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "vec2" should {

    "expose implicit methods" in {
      import com.github.gigurra.math.fixpt.vec2._
      val v1 = Vec2[Long](3,4)
      v1.lengthFixPt shouldBe 5
      v1.isZeroFixPt shouldBe false
    }
  }
}

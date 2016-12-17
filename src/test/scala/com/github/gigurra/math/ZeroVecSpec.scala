package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class ZeroVecSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "ZeroVec" should {

    "have Vec2.zero api" in {
      val vz: Vec2 = Vec2.zero
      vz shouldBe Vec2(0.0f, 0.0f)
    }

    "Convert tuple3 to vec3" in {
      val vz: Vec3 = Vec3.zero
      vz shouldBe Vec3(0.0f, 0.0f, 0.0f)
    }

    "Convert tuple4 to vec4" in {
      val vz: Vec4 = Vec4.zero
      vz shouldBe Vec4(0.0f, 0.0f, 0.0f, 1.0f)
    }

  }
}

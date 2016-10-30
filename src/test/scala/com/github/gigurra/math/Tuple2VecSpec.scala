package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class Tuple2VecSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "Tuple2Vec" should {

    "Convert tuple2 to vec2" in {
      val v2: Vec2[Float] = (1.0f, 2.0f)
      v2 shouldBe Vec2(1.0f, 2.0f)
    }

    "Convert tuple3 to vec3" in {
      val v3: Vec3[Float] = (1.0f, 2.0f, 3.0f)
      v3 shouldBe Vec3(1.0f, 2.0f, 3.0f)
    }

    "Convert tuple4 to vec4" in {
      val v4: Vec4[Float] = (1.0f, 2.0f, 3.0f, 4.0f)
      v4 shouldBe Vec4(1.0f, 2.0f, 3.0f, 4.0f)
    }

  }
}

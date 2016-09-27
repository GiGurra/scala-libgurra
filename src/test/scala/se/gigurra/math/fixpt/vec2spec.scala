package se.gigurra.math.fixpt

import org.scalatest._
import org.scalatest.mock._
import se.gigurra.math.Vec2

import scala.language.postfixOps

class vec2spec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  "vec2" should {

    "expose implicit methods" in {
      import se.gigurra.math.fixpt.vec2._
      val v1 = Vec2[Long](3,4)
      v1.length shouldBe 5
      v1.isZero shouldBe false
    }
  }
}

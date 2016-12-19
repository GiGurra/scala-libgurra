package com.github.gigurra.math

import org.scalatest.FunSuite
import org.scalatest._

/**
  * Created by gabriel on 2016-12-19.
  */
class LinesIntersectionPoint$Test extends WordSpec with Matchers {
  "LinesIntersectionPoint" should {

    "find intersection for non parallel lines" in {
      """
          intersect    |
              (1,4)    |
                     --|-----------* p2=(4,4)
                       |
                       |
                       |
                       *  p1=(1,0)

      """.
        stripMargin

      val p1 = Vec2(1, 0)
      val p2 = Vec2(4, 4)

      val d1 = Vec2(0,1)
      val d2 = Vec2(1,0)

      val point: Option[Vec2] = LinesIntersectionPoint(point1 = p1, directionVector1 =
        d1, point2 = p2,
        directionVector2 = d2)
      point shouldBe Some(Vec2(1,4))
    }

    "return None if lines are parallel" in {
      val p1 = Vec2(1, 0)
      val p2 = Vec2(4, 4)

      val d1 = Vec2(1,1)
      val d2 = Vec2(4,4)

      val point: Option[Vec2] = LinesIntersectionPoint(point1 = p1, directionVector1 =
        d1, point2 = p2,
        directionVector2 = d2)
      point shouldBe None
    }
  }
}

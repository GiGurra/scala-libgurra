package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class PolygonSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  val concaveCCWVertices = Seq(
    Vec2(0.0,0.0), // 0
    Vec2(2.0,1.0), // 1
    Vec2(4.0,0.0), // 2
    Vec2(4.0,4.0), // 3
    Vec2(2.0,3.0), // 4
    Vec2(0.0,4.0)  // 5
  )

  "Polygon" should {

    "Be created from 3 or more edge vertices" in {
      noException should be thrownBy Polygon(concaveCCWVertices)
      noException should be thrownBy Polygon(concaveCCWVertices.take(3))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(2))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(1))
      an[IllegalArgumentException] should be thrownBy Polygon[Float](Seq.empty)
    }

    "Calculate ccw properly" in {
      Polygon(concaveCCWVertices).clockwise shouldBe false
      Polygon(concaveCCWVertices.reverse).clockwise shouldBe true
      Polygon(concaveCCWVertices).ccw shouldBe true
      Polygon(concaveCCWVertices.reverse).cw shouldBe true
    }

    "Calculate area properly" in {
      Polygon(concaveCCWVertices).area shouldBe 12
      Polygon(concaveCCWVertices.reverse).area shouldBe 12
    }

    "Can slice into pieces" in {
      val original = Polygon(concaveCCWVertices)
      val i1 = 1
      val i2 = 4
      val (left, right) = original.slice(i1, i2)
      left.area shouldBe 6
      right.area shouldBe 6
      left.area + right.area shouldBe original.area

      Polygon.isCompleteSlice(original, left, right, i1, i2) shouldBe true
      original.isCleanSlice(i1, i2) shouldBe true
    }

    "Can slice through air, and then get an incomplete slice" in {
      val original = Polygon(concaveCCWVertices)
      val i1 = 3
      val i2 = 5
      val (left, right) = original.slice(i1, i2)

      Polygon.isCompleteSlice(original, left, right, i1, i2) shouldBe false
      original.isCleanSlice(i1, i2) shouldBe false
    }

    "Fail to slice when not enough vertices between points" in {
      val original = Polygon(concaveCCWVertices)
      original.size shouldBe 6
      an[IllegalArgumentException] should be thrownBy original.slice(0, 5)
      an[IllegalArgumentException] should be thrownBy original.slice(5, 0)
      an[IllegalArgumentException] should be thrownBy original.slice(1, 0)
      an[IllegalArgumentException] should be thrownBy original.slice(0, 1)
      an[IllegalArgumentException] should be thrownBy original.slice(5, 4)

      original.isCleanSlice(0, 5) shouldBe false
      original.isCleanSlice(5, 0) shouldBe false
      original.isCleanSlice(1, 0) shouldBe false
      original.isCleanSlice(0, 1) shouldBe false
      original.isCleanSlice(5, 4) shouldBe false
    }

    "Be transformed into a raw data array" in {
      Polygon(concaveCCWVertices).asElementArray shouldBe Array(0,0,2,1,4,0,4,4,2,3,0,4)
    }

    "Check if point is contained" in {
      val polygon = Polygon(concaveCCWVertices)
      polygon.contains(Vec2(0.00001, 0.00001)) shouldBe true
      polygon.contains(Vec2(-0.00001, -0.00001)) shouldBe false
    }

    "Check if point is contained (incl edge)" in {
      val polygon = Polygon(concaveCCWVertices)
      concaveCCWVertices.size should be > 3
      for (pt <- concaveCCWVertices) {
        polygon.contains(pt) shouldBe true
      }
    }

    "Check if point is contained (excl edge)" in {
      val polygon = Polygon(concaveCCWVertices)
      concaveCCWVertices.size should be > 3
      for (pt <- concaveCCWVertices) {
        polygon.contains(pt, includeEdgePoints = false) shouldBe false
      }
      polygon.contains(polygon.cg, includeEdgePoints = false) shouldBe true
    }

    "Check if point is contained (Square)" in {
      val polygon = Polygon(Seq(
        Vec2(0.0,0.0),
        Vec2(1.0,0.0),
        Vec2(1.0,1.0),
        Vec2(0.0,1.0)
      ))
      polygon.contains(Vec2(0.5, 0.5)) shouldBe true
      polygon.contains(Vec2(0.5, -0.5)) shouldBe false
    }

    "Check if point is contained (Pentagon)" in {
      val polygon = Polygon(Seq(
        Vec2(0.0,0.0),
        Vec2(1.0,0.0),
        Vec2(1.0,1.0),
        Vec2(0.5,1.2),
        Vec2(0.0,1.0)
      ))
      polygon.contains(Vec2(0.5, 0.5)) shouldBe true
      polygon.contains(Vec2(0.5, -0.5)) shouldBe false
    }

    "Polygon overlaps" in {

      val arrowHead = Polygon(Seq(
        Vec2(0.0,0.0),
        Vec2(1.0,0.1),
        Vec2(0.0,0.2)
      ))

      val box = Polygon(Seq(
        Vec2(0.5,0.0),
        Vec2(0.5,0.5),
        Vec2(1.5,0.5),
        Vec2(1.5,0.0)
      ))

      arrowHead.overlaps(box) shouldBe true
      arrowHead.rotate(90).overlaps(box) shouldBe false

      box.overlaps(arrowHead) shouldBe true
      box.overlaps(arrowHead.rotate(90)) shouldBe false

      box.overlaps(box) shouldBe true
    }

    "Two polygons with matching edges dont count as overlapping" in {

      val box1 = Polygon(Seq(
        Vec2(0.0,0.0),
        Vec2(0.0,1.0),
        Vec2(1.0,1.0),
        Vec2(1.0,0.0)
      ))

      val box2 = Polygon(Seq(
        Vec2(1.0,0.0),
        Vec2(1.0,1.0),
        Vec2(2.0,1.0),
        Vec2(2.0,0.0)
      ))

      val box1999 = Polygon(Seq(
        Vec2(1.0,0.0),
        Vec2(1.0,1.0),
        Vec2(2.0,1.0),
        Vec2(2.0,0.0)
      ).map(p => Vec2(p.x-0.00001, p.y)))

      box1.overlaps(box2) shouldBe false
      box1.overlaps(box1999) shouldBe true

    }

    "Calculate cg" in {
      Polygon(Seq(
        Vec2(0, 0),
        Vec2(2, 0),
        Vec2(2, 2),
        Vec2(0, 2)
      )).cg shouldBe Vec2(1,1)

      Polygon(Seq(
        Vec2(0.0, 0.0),
        Vec2(1.0, 0.0),
        Vec2(1.0, 1.0),
        Vec2(0.0, 1.0)
      )).cg shouldBe Vec2(0.5, 0.5)
    }

    "Rotate a polygon" in {
      import scala.math._

      def approxEquals(a: Double, b: Double): Boolean = {
        math.abs(a - b) < 1e-9
      }

      val polygon = Polygon(Seq(
        Vec2(0.0, 0.0),
        Vec2(2.0, 0.0),
        Vec2(2.0, 2.0),
        Vec2(0.0, 2.0)
      ))

      val rotatedPolygon = polygon.rotate(degrees = 45.0)

      val cgx = polygon.cg.x
      val cgy = polygon.cg.y

      approxEquals(polygon.cg.x, rotatedPolygon.cg.x) shouldBe true
      approxEquals(polygon.cg.y, rotatedPolygon.cg.y) shouldBe true

      approxEquals(rotatedPolygon.edge(0).x, 1.0) shouldBe true
      approxEquals(rotatedPolygon.edge(0).y, -sqrt(2.0) + cgy) shouldBe true

      approxEquals(rotatedPolygon.edge(1).x, sqrt(2.0) + cgx) shouldBe true
      approxEquals(rotatedPolygon.edge(1).y, 1.0) shouldBe true

      approxEquals(rotatedPolygon.edge(2).x, 1.0) shouldBe true
      approxEquals(rotatedPolygon.edge(2).y, sqrt(2.0) + cgy) shouldBe true

      approxEquals(rotatedPolygon.edge(3).x, -sqrt(2.0) + cgx) shouldBe true
      approxEquals(rotatedPolygon.edge(3).y, 1.0) shouldBe true
    }
  }

  "sides" in {
    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(2.0, 0.0),
      Vec2(2.0, 2.0),
      Vec2(0.0, 2.0)
    ))
    polygon.sides shouldBe Seq( (Vec2(0.0, 0.0), Vec2(2.0, 0.0)), (Vec2(2.0, 0.0), Vec2(2.0, 2.0)), (Vec2(2.0, 2.0), Vec2(0.0, 2.0)), (Vec2(0.0, 2.0), Vec2(0.0, 0.0)) )
  }

  "vectors" in {
    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(2.0, 0.0),
      Vec2(2.0, 2.0),
      Vec2(0.0, 2.0)
    ))

    polygon.vectors shouldBe Seq( Vec2(2.0, 0.0), Vec2(0.0, 2.0), Vec2(-2.0, 0.0), Vec2(0.0, -2.0) )
  }


  "outerward/inward angles for a triangle cw" in {
    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(0.0, 2.0),
      Vec2(2.0, 0.0)
    ))
    polygon.outwardAngles shouldBe Seq( 270.0, 315.0, 315.0  )
    polygon.inwardAngles shouldBe Seq( 90.0, 45.0, 45.0  )
  }

  "outerward/inward angles for a letter shape cw" in {

    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(0.0, 2.0),
      Vec2(1.0, 1.0),
      Vec2(2.0, 2.0),
      Vec2(2.0, 0.0)
    ))

    polygon.outwardAngles shouldBe Seq(270.0, 315.0, 90.0, 315.0, 270.0)
    polygon.inwardAngles shouldBe Seq(90.0, 45.0, 270.0, 45.0, 90.0)
  }

  "outerward/inward angles for a triangle ccw" in {
    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(0.0, 2.0),
      Vec2(2.0, 0.0)
    ).reverse)
    polygon.outwardAngles shouldBe Seq( 315.0, 315.0, 270.0  )
    polygon.inwardAngles shouldBe Seq( 45.0, 45.0, 90.0  )
  }

  "outerward/inward angles for a letter shape ccw" in {

    val polygon = Polygon(Seq(
      Vec2(0.0, 0.0),
      Vec2(0.0, 2.0),
      Vec2(1.0, 1.0),
      Vec2(2.0, 2.0),
      Vec2(2.0, 0.0)
    ).reverse)

    polygon.outwardAngles shouldBe Seq(270.0, 315.0, 90.0, 315.0, 270.0)
    polygon.inwardAngles shouldBe Seq(90.0, 45.0, 270.0, 45.0, 90.0)
  }

  "in a 30°–60°–90° triangle (known triangle from wikipedia)" in {
    """
                        B O
                          | \
                          |  \
                          |   \ 2
                  sqrt(3) |    \
                          |     \
                          |      \
                        A O-------O C
                              1
    """.stripMargin

    val sqrt3 = math.sqrt(3).toFloat

    val a = Vec2[Float](0.0f, 0.0f)
    val b = Vec2[Float](0.0f, sqrt3)
    val c = Vec2[Float](1.0f, 0.0f)

    val triangle = Polygon(Seq(a, b, c))

    triangle.outwardAngles.map(math.round) shouldBe Seq(270, 330, 300)
    triangle.inwardAngles.map(math.round) shouldBe Seq(90, 30, 60)

  }

  "in a 30°–60°–90° triangle (known triangle from wikipedia) reversed" in {
    """
                        B O
                          | \
                          |  \
                          |   \ 2
                  sqrt(3) |    \
                          |     \
                          |      \
                        A O-------O C
                              1
    """.stripMargin

    val sqrt3 = math.sqrt(3).toFloat

    val a = Vec2[Float](0.0f, 0.0f)
    val b = Vec2[Float](0.0f, sqrt3)
    val c = Vec2[Float](1.0f, 0.0f)

    val triangle = Polygon(Seq(c, b, a))

    triangle.outwardAngles.map(math.round) shouldBe Seq(270, 330, 300).reverse
    triangle.inwardAngles.map(math.round) shouldBe Seq(90, 30, 60).reverse

  }
}

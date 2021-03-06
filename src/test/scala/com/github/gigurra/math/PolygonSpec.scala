package com.github.gigurra.math

import org.scalatest._
import org.scalatest.mock._

import scala.language.postfixOps

class PolygonSpec
  extends WordSpec
  with MockitoSugar
  with Matchers
  with OneInstancePerTest {

  val concaveCCWVertices = Vector(
    Vec2(0.0f, 0.0f), // 0
    Vec2(2.0f, 1.0f), // 1
    Vec2(4.0f, 0.0f), // 2
    Vec2(4.0f, 4.0f), // 3
    Vec2(2.0f, 3.0f), // 4
    Vec2(0.0f, 4.0f)  // 5
  )

  "Polygon" should {

    "Be created from 3 or more edge vertices" in {
      noException should be thrownBy Polygon(concaveCCWVertices)
      noException should be thrownBy Polygon(concaveCCWVertices.take(3))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(2))
      an[IllegalArgumentException] should be thrownBy Polygon(concaveCCWVertices.take(1))
      an[IllegalArgumentException] should be thrownBy Polygon(Vector.empty)
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

    "Fail to slice, when points between vertices are on the same line" in {
      val list: Vector[Vec2] = Vector(Vec2(0.0f,2.0f), Vec2(0.0f,4.0f), Vec2(2.0f,2.0f), Vec2(4.0f,0.0f), Vec2(2.0f,0.0f), Vec2(1.0f,1.0f))
      val polygon = Polygon(list)

      polygon.isCleanSlice(4,0) shouldBe false
    }

    "Be transformed into a raw data array" in {
      Polygon(concaveCCWVertices).asElementArray shouldBe Array(0,0,2,1,4,0,4,4,2,3,0,4)
    }

    "Check if point is contained" in {
      val polygon = Polygon(concaveCCWVertices)
      polygon.contains(Vec2(0.00001f, 0.00001f)) shouldBe true
      polygon.contains(Vec2(-0.00001f, -0.00001f)) shouldBe false
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
      val polygon = Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(1.0f, 0.0f),
        Vec2(1.0f, 1.0f),
        Vec2(0.0f, 1.0f)
      ))
      polygon.contains(Vec2(0.5f, 0.5f)) shouldBe true
      polygon.contains(Vec2(0.5f, -0.5f)) shouldBe false
    }

    "Check if point is contained (Pentagon)" in {
      val polygon = Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(1.0f, 0.0f),
        Vec2(1.0f, 1.0f),
        Vec2(0.5f, 1.2f),
        Vec2(0.0f, 1.0f)
      ))
      polygon.contains(Vec2(0.5f, 0.5f)) shouldBe true
      polygon.contains(Vec2(0.5f, -0.5f)) shouldBe false
    }

    "Polygon overlaps" in {

      val arrowHead = Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(1.0f, 0.1f),
        Vec2(0.0f, 0.2f)
      ))

      val box = Polygon(Vector(
        Vec2(0.5f, 0.0f),
        Vec2(0.5f, 0.5f),
        Vec2(1.5f, 0.5f),
        Vec2(1.5f, 0.0f)
      ))

      arrowHead.overlaps(box) shouldBe true
      arrowHead.rotate(90).overlaps(box) shouldBe false

      box.overlaps(arrowHead) shouldBe true
      box.overlaps(arrowHead.rotate(90)) shouldBe false

      box.overlaps(box) shouldBe true
    }

    "Two polygons with matching edges dont count as overlapping" in {

      val box1 = Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(0.0f, 1.0f),
        Vec2(1.0f, 1.0f),
        Vec2(1.0f, 0.0f)
      ))

      val box2 = Polygon(Vector(
        Vec2(1.0f, 0.0f),
        Vec2(1.0f, 1.0f),
        Vec2(2.0f, 1.0f),
        Vec2(2.0f, 0.0f)
      ))

      val box1999 = Polygon(Vector(
        Vec2(1.0f, 0.0f),
        Vec2(1.0f, 1.0f),
        Vec2(2.0f, 1.0f),
        Vec2(2.0f, 0.0f)
      ).map(p => Vec2(p.x-0.00001f, p.y)))

      box1.overlaps(box2) shouldBe false
      box1.overlaps(box1999) shouldBe true

    }

    "Calculate cg" in {
      Polygon(Vector(
        Vec2(0, 0),
        Vec2(2, 0),
        Vec2(2, 2),
        Vec2(0, 2)
      )).cg shouldBe Vec2(1,1)

      Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(1.0f, 0.0f),
        Vec2(1.0f, 1.0f),
        Vec2(0.0f, 1.0f)
      )).cg shouldBe Vec2(0.5f, 0.5f)
    }

    "Rotate a polygon" in {
      import scala.math._

      def approxEquals(a: Float, b: Float): Boolean = {
        math.abs(a - b) < 1e-6
      }

      val polygon = Polygon(Vector(
        Vec2(0.0f, 0.0f),
        Vec2(2.0f, 0.0f),
        Vec2(2.0f, 2.0f),
        Vec2(0.0f, 2.0f)
      ))

      val rotatedPolygon = polygon.rotate(degrees = 45.0f)

      val cgx = polygon.cg.x
      val cgy = polygon.cg.y

      approxEquals(polygon.cg.x, rotatedPolygon.cg.x) shouldBe true
      approxEquals(polygon.cg.y, rotatedPolygon.cg.y) shouldBe true

      approxEquals(rotatedPolygon.edge(0).x, 1.0f) shouldBe true
      approxEquals(rotatedPolygon.edge(0).y, -sqrt(2.0).toFloat + cgy) shouldBe true

      approxEquals(rotatedPolygon.edge(1).x, sqrt(2.0).toFloat + cgx) shouldBe true
      approxEquals(rotatedPolygon.edge(1).y, 1.0f) shouldBe true

      approxEquals(rotatedPolygon.edge(2).x, 1.0f) shouldBe true
      approxEquals(rotatedPolygon.edge(2).y, sqrt(2.0).toFloat + cgy) shouldBe true

      approxEquals(rotatedPolygon.edge(3).x, -sqrt(2.0).toFloat + cgx) shouldBe true
      approxEquals(rotatedPolygon.edge(3).y, 1.0f) shouldBe true
    }
  }

  "sides" in {
    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(2.0f, 0.0f),
      Vec2(2.0f, 2.0f),
      Vec2(0.0f, 2.0f)
    ))
    polygon.sides shouldBe Vector( (Vec2(0.0f, 0.0f), Vec2(2.0f, 0.0f)), (Vec2(2.0f, 0.0f), Vec2(2.0f, 2.0f)), (Vec2(2.0f, 2.0f), Vec2(0.0f, 2.0f)), (Vec2(0.0f, 2.0f), Vec2(0.0f, 0.0f)) )
  }

  "vectors" in {
    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(2.0f, 0.0f),
      Vec2(2.0f, 2.0f),
      Vec2(0.0f, 2.0f)
    ))

    polygon.vectors shouldBe Vector( Vec2(2.0f, 0.0f), Vec2(0.0f, 2.0f), Vec2(-2.0f, 0.0f), Vec2(0.0f, -2.0f) )
  }


  "outerward/inward angles for a triangle cw" in {
    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(2.0f, 0.0f)
    ))
    polygon.outwardAngles shouldBe Vector( 270.0f, 315.0f, 315.0f  )
    polygon.inwardAngles shouldBe Vector( 90.0f, 45.0f, 45.0f  )
  }

  "outerward/inward angles for a letter shape cw" in {

    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(1.0f, 1.0f),
      Vec2(2.0f, 2.0f),
      Vec2(2.0f, 0.0f)
    ))

    polygon.outwardAngles shouldBe Vector(270.0, 315.0, 90.0, 315.0, 270.0)
    polygon.inwardAngles shouldBe Vector(90.0, 45.0, 270.0, 45.0, 90.0)
  }

  "outerward/inward angles for a triangle ccw" in {
    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(2.0f, 0.0f)
    ).reverse)
    polygon.outwardAngles shouldBe Vector( 315.0, 315.0, 270.0  )
    polygon.inwardAngles shouldBe Vector( 45.0, 45.0, 90.0  )
  }

  "outerward/inward angles for a letter shape ccw" in {

    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(1.0f, 1.0f),
      Vec2(2.0f, 2.0f),
      Vec2(2.0f, 0.0f)
    ).reverse)

    polygon.outwardAngles shouldBe Vector(270.0, 315.0, 90.0, 315.0, 270.0)
    polygon.inwardAngles shouldBe Vector(90.0, 45.0, 270.0, 45.0, 90.0)
  }

  "Bounds" in {

    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(1.0f, 1.0f),
      Vec2(2.0f, 2.0f),
      Vec2(2.0f, 0.0f)
    ).reverse)

    polygon.bounds shouldBe Box2(0.0f, 0.0f, 2.0f, 2.0f)
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

    val a = Vec2(0.0f, 0.0f)
    val b = Vec2(0.0f, sqrt3)
    val c = Vec2(1.0f, 0.0f)

    val triangle = Polygon(Vector(a, b, c))

    triangle.outwardAngles.map(math.round) shouldBe Vector(270, 330, 300)
    triangle.inwardAngles.map(math.round) shouldBe Vector(90, 30, 60)

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

    val a = Vec2(0.0f, 0.0f)
    val b = Vec2(0.0f, sqrt3)
    val c = Vec2(1.0f, 0.0f)

    val triangle = Polygon(Vector(c, b, a))

    triangle.outwardAngles.map(math.round) shouldBe Vector(270, 330, 300).reverse
    triangle.inwardAngles.map(math.round) shouldBe Vector(90, 30, 60).reverse

  }

  "Find all slice points in square with cut off corner" in {
    """
              O - - - - - O
              |            \
              |             O
              |              \
              O               O
              |               |
              |               |
              O - - - O - - - O

    """.stripMargin

    val polygon = Polygon(Vector(
      Vec2(0.0f, 0.0f),
      Vec2(0.0f, 2.0f),
      Vec2(0.0f, 4.0f),
      Vec2(2.0f, 4.0f),
      Vec2(3.0f, 3.0f),
      Vec2(4.0f, 2.0f),
      Vec2(4.0f, 0.0f),
      Vec2(2.0f, 0.0f)
    ))

    // From lower left corner
    polygon.isCleanSlice(0, 0) shouldBe false
    polygon.isCleanSlice(0, 1) shouldBe false
    polygon.isCleanSlice(0, 2) shouldBe false
    polygon.isCleanSlice(0, 3) shouldBe true
    polygon.isCleanSlice(0, 4) shouldBe true
    polygon.isCleanSlice(0, 5) shouldBe true
    polygon.isCleanSlice(0, 6) shouldBe false
    polygon.isCleanSlice(0, 7) shouldBe false

    // From left side
    polygon.isCleanSlice(1, 0) shouldBe false
    polygon.isCleanSlice(1, 1) shouldBe false
    polygon.isCleanSlice(1, 2) shouldBe false
    polygon.isCleanSlice(1, 3) shouldBe true
    polygon.isCleanSlice(1, 4) shouldBe true
    polygon.isCleanSlice(1, 5) shouldBe true
    polygon.isCleanSlice(1, 6) shouldBe true
    polygon.isCleanSlice(1, 7) shouldBe true

    // From top left corner
    polygon.isCleanSlice(2, 0) shouldBe false
    polygon.isCleanSlice(2, 1) shouldBe false
    polygon.isCleanSlice(2, 2) shouldBe false
    polygon.isCleanSlice(2, 3) shouldBe false
    polygon.isCleanSlice(2, 4) shouldBe true
    polygon.isCleanSlice(2, 5) shouldBe true
    polygon.isCleanSlice(2, 6) shouldBe true
    polygon.isCleanSlice(2, 7) shouldBe true

    // From top side
    polygon.isCleanSlice(3, 0) shouldBe true
    polygon.isCleanSlice(3, 1) shouldBe true
    polygon.isCleanSlice(3, 2) shouldBe false
    polygon.isCleanSlice(3, 3) shouldBe false
    polygon.isCleanSlice(3, 4) shouldBe false
    polygon.isCleanSlice(3, 5) shouldBe false
    polygon.isCleanSlice(3, 6) shouldBe true
    polygon.isCleanSlice(3, 7) shouldBe true

    // From new side (previous top right corner)
    polygon.isCleanSlice(4, 0) shouldBe true
    polygon.isCleanSlice(4, 1) shouldBe true
    polygon.isCleanSlice(4, 2) shouldBe true
    polygon.isCleanSlice(4, 3) shouldBe false
    polygon.isCleanSlice(4, 4) shouldBe false
    polygon.isCleanSlice(4, 5) shouldBe false
    polygon.isCleanSlice(4, 6) shouldBe true
    polygon.isCleanSlice(4, 7) shouldBe true

    // From right side
    polygon.isCleanSlice(5, 0) shouldBe true
    polygon.isCleanSlice(5, 1) shouldBe true
    polygon.isCleanSlice(5, 2) shouldBe true
    polygon.isCleanSlice(5, 3) shouldBe false
    polygon.isCleanSlice(5, 4) shouldBe false
    polygon.isCleanSlice(5, 5) shouldBe false
    polygon.isCleanSlice(5, 6) shouldBe false
    polygon.isCleanSlice(5, 7) shouldBe true

    // From lower right corner
    polygon.isCleanSlice(6, 0) shouldBe false
    polygon.isCleanSlice(6, 1) shouldBe true
    polygon.isCleanSlice(6, 2) shouldBe true
    polygon.isCleanSlice(6, 3) shouldBe true
    polygon.isCleanSlice(6, 4) shouldBe true
    polygon.isCleanSlice(6, 5) shouldBe false
    polygon.isCleanSlice(6, 6) shouldBe false
    polygon.isCleanSlice(6, 7) shouldBe false

    // From lower side
    polygon.isCleanSlice(7, 0) shouldBe false
    polygon.isCleanSlice(7, 1) shouldBe true
    polygon.isCleanSlice(7, 2) shouldBe true
    polygon.isCleanSlice(7, 3) shouldBe true
    polygon.isCleanSlice(7, 4) shouldBe true
    polygon.isCleanSlice(7, 5) shouldBe true
    polygon.isCleanSlice(7, 6) shouldBe false
    polygon.isCleanSlice(7, 7) shouldBe false
  }
}

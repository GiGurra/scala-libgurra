package com.github.gigurra.math

import spire.math.Numeric
import spire.implicits._

/**
  * Created by johan on 2016-10-24.
  * extracted from Java AWT.Line2D
  */
object LinesIntersect {

  def apply[@specialized(Int,Long,Float,Double) T : Numeric](line1: (Vec2[T], Vec2[T]),
                                                             line2: (Vec2[T], Vec2[T])): Boolean = {
    apply(
      x1 = line1._1.x,
      y1 = line1._1.y,
      x2 = line1._2.x,
      y2 = line1._2.y,

      x3 = line2._1.x,
      y3 = line2._1.y,
      x4 = line2._2.x,
      y4 = line2._2.y
    )
  }

  /**
    * @param x1 the X coordinate of the start point of the first
    *           specified line segment
    * @param y1 the Y coordinate of the start point of the first
    *           specified line segment
    * @param x2 the X coordinate of the end point of the first
    *           specified line segment
    * @param y2 the Y coordinate of the end point of the first
    *           specified line segment
    * @param x3 the X coordinate of the start point of the second
    *           specified line segment
    * @param y3 the Y coordinate of the start point of the second
    *           specified line segment
    * @param x4 the X coordinate of the end point of the second
    *           specified line segment
    * @param y4 the Y coordinate of the end point of the second
    *           specified line segment
    * @return <code>true</code> if the first specified line segment
    *         and the second specified line segment intersect
    *         each other; <code>false</code> otherwise.
    * @since 1.2
    */
  def apply[@specialized(Int,Long,Float,Double) T : Numeric](x1: T,
                                                             y1: T,
                                                             x2: T,
                                                             y2: T,
                                                             x3: T,
                                                             y3: T,
                                                             x4: T,
                                                             y4: T): Boolean = {
    (relativeCCW(x1, y1, x2, y2, x3, y3) * relativeCCW(x1, y1, x2, y2, x4, y4) <= 0) &&
      (relativeCCW(x3, y3, x4, y4, x1, y1) * relativeCCW(x3, y3, x4, y4, x2, y2) <= 0)
  }

  private def relativeCCW[@specialized(Int,Long,Float,Double) T : Numeric](_x1: T,
                                                                           _y1: T,
                                                                           _x2: T,
                                                                           _y2: T,
                                                                           _px: T,
                                                                           _py: T): Int = {

    var x1 = _x1
    var x2 = _x2
    var y1 = _y1
    var y2 = _y2
    var px = _px
    var py = _py

    x2 -= x1
    y2 -= y1
    px -= x1
    py -= y1
    var ccw: T = px * y2 - py * x2
    if (ccw == Zero[T]) {
      // The point is colinear, classify based on which side of
      // the segment the point falls on.  We can calculate a
      // relative value using the projection of px,py onto the
      // segment - a negative value indicates the point projects
      // outside of the segment in the direction of the particular
      // endpoint used as the origin for the projection.
      ccw = px * x2 + py * y2
      if (ccw > Zero[T]) {
        // Reverse the projection to be relative to the original x2,y2
        // x2 and y2 are simply negated.
        // px and py need to have (x2 - x1) or (y2 - y1) subtracted
        //    from them (based on the original values)
        // Since we really want to get a positive answer when the
        //    point is "beyond (x2,y2)", then we want to calculate
        //    the inverse anyway - thus we leave x2 & y2 negated.
        px -= x2
        py -= y2
        ccw = px * x2 + py * y2
        if (ccw < Zero[T]) ccw = Zero[T]
      }
    }
    if (ccw < Zero[T]) -1
    else if (ccw > Zero[T]) 1
    else 0
  }
}

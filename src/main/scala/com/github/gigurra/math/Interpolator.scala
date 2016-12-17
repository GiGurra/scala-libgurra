package com.github.gigurra.math

import scala.annotation.tailrec

/**
  * Created by johan on 2016-12-04.
  */
case class Interpolator[ValueType](range: Float,
                                   algorithm: (Float, Float) => ValueType,
                                   next: Option[Interpolator[ValueType]] = None) {

  @tailrec
  final def interpolate(delta: Float): ValueType = {
    if (delta <= range) {
      algorithm.apply(delta, range)
    } else {
      next match {
        case None => algorithm.apply(delta, range)
        case Some(nextInterpolator) => nextInterpolator.interpolate(delta - range)
      }
    }
  }

  def andThen(toAdd: Interpolator[ValueType]): Interpolator[ValueType] = {
    next match {
      case Some(storedNext) => this.copy(next = Some[Interpolator[ValueType]](storedNext.andThen(toAdd)))
      case None => this.copy(next = Some(toAdd))
    }
  }
}

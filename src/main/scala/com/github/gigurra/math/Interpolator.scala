package com.github.gigurra.math

import spire.implicits._

import scala.annotation.tailrec

/**
  * Created by johan on 2016-12-04.
  */
case class Interpolator[DeltaType : spire.math.Numeric, ValueType](range: DeltaType,
                                                                   algorithm: (DeltaType, DeltaType) => ValueType,
                                                                   next: Option[Interpolator[DeltaType, ValueType]] = None) {

  @tailrec
  final def interpolate(delta: DeltaType): ValueType = {
    if (delta <= range) {
      algorithm.apply(delta, range)
    } else {
      next match {
        case None => algorithm.apply(delta, range)
        case Some(nextInterpolator) => nextInterpolator.interpolate(delta - range)
      }
    }
  }

  def andThen(toAdd: Interpolator[DeltaType, ValueType]): Interpolator[DeltaType, ValueType] = {
    next match {
      case Some(storedNext) => this.copy(next = Some[Interpolator[DeltaType, ValueType]](storedNext.andThen(toAdd)))
      case None => this.copy(next = Some(toAdd))
    }
  }
}

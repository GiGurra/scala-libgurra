package com.github.gigurra.math

/**
  * Created by johan on 2016-12-04.
  */
object lerp {

  def apply(minInput: Double,
            maxInput: Double,
            input: Double,
            minOutput: Double,
            maxOutput: Double,
            clamp: Boolean): Double = {
    apply(
      delta = input - minInput,
      range = maxInput - minInput,
      minOutput = minOutput,
      maxOutput = maxOutput,
      clamp = clamp
    )
  }

  def apply(minInput: Double,
            maxInput: Double,
            input: Double,
            minOutput: Double,
            maxOutput: Double): Double = {
    apply(minInput, maxInput, input, minOutput, maxOutput, clamp = true)
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Double,
            maxOutput: Double,
            clamp: Boolean): Double = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > 1.0f) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Double,
            range: Double,
            minOutput: Double,
            maxOutput: Double): Double = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }
}

package com.github.gigurra.math

/**
  * Created by johan on 2016-12-04.
  */
object lerp {

  def apply(minInput: Float,
            maxInput: Float,
            input: Float,
            minOutput: Float,
            maxOutput: Float,
            clamp: Boolean): Float = {
    apply(
      delta = input - minInput,
      range = maxInput - minInput,
      minOutput = minOutput,
      maxOutput = maxOutput,
      clamp = clamp
    )
  }

  def apply(minInput: Float,
            maxInput: Float,
            input: Float,
            minOutput: Float,
            maxOutput: Float): Float = {
    apply(minInput, maxInput, input, minOutput, maxOutput, clamp = true)
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Float,
            maxOutput: Float,
            clamp: Boolean): Float = {
    if (clamp && delta < 0.0f) {
      minOutput
    } else if (clamp && delta > 1.0f) {
      maxOutput
    } else {
      minOutput + ((maxOutput - minOutput) * (delta / range))
    }
  }

  def apply(delta: Float,
            range: Float,
            minOutput: Float,
            maxOutput: Float): Float = {
    apply(delta, range, minOutput, maxOutput, clamp = true)
  }
}

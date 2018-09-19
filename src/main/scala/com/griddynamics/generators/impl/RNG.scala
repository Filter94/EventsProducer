package com.griddynamics.generators.impl

import scala.util.Random

object RNG {
  val rng = new Random()

  /**
    * Generates a random number with normal distribution by given parameters
    * @param mean expected average
    * @param sigma variance
    * @return random positive float Bounded by 0 and mean * 2.
    */
  def gaussianWithMeanAndSigma(mean: Float, sigma: Float): Float = {
    (((rng.nextGaussian() * sigma + mean) max 0) min mean * 2).toFloat
  }
}

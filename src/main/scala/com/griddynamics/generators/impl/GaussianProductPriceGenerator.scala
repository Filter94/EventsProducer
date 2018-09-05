package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.ProductPriceGenerator

object GaussianProductPriceGenerator {
  def apply(mean: Float, sigma: Float): GaussianProductPriceGenerator = new GaussianProductPriceGenerator(mean, sigma)
}

class GaussianProductPriceGenerator(val mean: Float, val sigma: Float) extends ProductPriceGenerator {
  def generateProductPrice(): Float = {
    RNG.gaussianWithMeanAndSigma(mean, sigma)
  }
}

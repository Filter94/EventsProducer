package com.griddynamics.impl.generators

import com.griddynamics.abs.generators.ProductPriceGenerator

object GaussianProductPriceGenerator {
  def apply(): GaussianProductPriceGenerator = new GaussianProductPriceGenerator()
}

class GaussianProductPriceGenerator extends ProductPriceGenerator {
  def generateProductPrice(): Float = {
    1.0f
  }
}

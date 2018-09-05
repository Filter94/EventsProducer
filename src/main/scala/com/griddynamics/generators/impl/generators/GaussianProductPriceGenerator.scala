package com.griddynamics.generators.impl.generators

import com.griddynamics.generators.abs.ProductPriceGenerator

object GaussianProductPriceGenerator {
  def apply(): GaussianProductPriceGenerator = new GaussianProductPriceGenerator()
}

class GaussianProductPriceGenerator extends ProductPriceGenerator {
  def generateProductPrice(): Float = {
    1.0f
  }
}

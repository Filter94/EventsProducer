package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.RandomEventsGenerator

object GridEventsProducer {
  def apply(): GridEventsProducer = new GridEventsProducer()
}

class GridEventsProducer extends RandomEventsGenerator {
  protected val productNameGenerator = UniformProductNameGenerator()
  protected val productPriceGenerator = GaussianProductPriceGenerator(50, 25)
  protected val purchaseDateGenerator = GUPurchaceDateGenerator()
  protected val productCategoryGenerator = UniformProductCategoryGenerator()
  protected val ipAddressGenerator = UniformIpAddressGenerator()
}

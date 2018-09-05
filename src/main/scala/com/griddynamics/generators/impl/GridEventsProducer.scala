package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.{IpAddressGenerator, RandomEventsGenerator}
import com.griddynamics.generators.impl.generators._

object GridEventsProducer {
  def apply(): GridEventsProducer = new GridEventsProducer()
}

class GridEventsProducer extends RandomEventsGenerator {
  protected val productNameGenerator = UniformProductNameGenerator()
  protected val productPriceGenerator = GaussianProductPriceGenerator()
  protected val purchaseDateGenerator = GUPurchaceDateGenerator()
  protected val productCategoryGenerator = UniformProductCategoryGenerator()
  protected val ipAddressGenerator: IpAddressGenerator = UniformIpAddressGenerator()
}

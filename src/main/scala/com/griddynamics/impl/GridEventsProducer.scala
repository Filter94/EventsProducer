package com.griddynamics.impl

import com.griddynamics.abs.RandomEventsGenerator
import com.griddynamics.abs.generators.IpAddressGenerator
import com.griddynamics.impl.generators._

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

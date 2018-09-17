package com.griddynamics.generators.impl

import com.griddynamics.generators.abstraction._

object RandomEventsGenerator {
  def apply(productNameGenerator: ProductNameGenerator,
            productPriceGenerator: ProductPriceGenerator,
            purchaseDateGenerator: PurchaseDateGenerator,
            productCategoryGenerator: ProductCategoryGenerator,
            ipAddressGenerator: IpAddressGenerator
           ): RandomEventsGenerator =
    new RandomEventsGenerator(productNameGenerator, productPriceGenerator, purchaseDateGenerator,
      productCategoryGenerator, ipAddressGenerator)
}

class RandomEventsGenerator(private val productNameGenerator: ProductNameGenerator,
                            private val productPriceGenerator: ProductPriceGenerator,
                            private val purchaseDateGenerator: PurchaseDateGenerator,
                            private val productCategoryGenerator: ProductCategoryGenerator,
                            private val ipAddressGenerator: IpAddressGenerator) extends EventsGenerator {
  override def hasNext: Boolean = true

  override def next(): Event = {
    Event(productNameGenerator.generateProductName(), productPriceGenerator.generateProductPrice(),
      purchaseDateGenerator.generatePurchaseDate(), productCategoryGenerator.generateProductCategory(),
      ipAddressGenerator.generateIpAddress())
  }
}

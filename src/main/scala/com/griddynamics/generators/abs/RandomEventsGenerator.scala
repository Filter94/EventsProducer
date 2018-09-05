package com.griddynamics.generators.abs

abstract class RandomEventsGenerator extends EventsGenerator {
  protected val productNameGenerator: ProductNameGenerator
  protected val productPriceGenerator: ProductPriceGenerator
  protected val purchaseDateGenerator: PurchaseDateGenerator
  protected val productCategoryGenerator: ProductCategoryGenerator
  protected val ipAddressGenerator: IpAddressGenerator

  override def hasNext: Boolean = true

  override def next(): Event = {
    Event(productNameGenerator.generateProductName(), productPriceGenerator.generateProductPrice(),
      purchaseDateGenerator.generatePurchaseDate(), productCategoryGenerator.generateProductCategory(),
      ipAddressGenerator.generateIpAddress())
  }
}

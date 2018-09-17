package com.griddynamics

import com.griddynamics.generators.impl._

object DefaultEventsGenerator {
  def apply(): RandomEventsGenerator = DefaultEventsGenerator(Config())

  def apply(config: Config): RandomEventsGenerator = {
    val config = Config()
    val productNameGenerator = UniformProductNameGenerator(config.productNames)
    val productPriceGenerator = GaussianProductPriceGenerator(config.priceMean, config.priceVariance)
    val purchaseDateGenerator = GUPurchaseDateGenerator(config.purchaseDateConfig)
    val productCategoryGenerator = UniformProductCategoryGenerator(config.productCategories)
    val ipAddressGenerator = UniformIpAddressGenerator()
    RandomEventsGenerator(productNameGenerator, productPriceGenerator, purchaseDateGenerator,
      productCategoryGenerator, ipAddressGenerator)
  }

  object Config {
    /**
      * Some default values
      */
    def apply(): Config = {
      Config("/product_names.txt", "/product_categories.txt", 50, 25, GUPurchaseDateGenerator.Config())
    }
  }

  case class Config(productNames: String, productCategories: String, priceMean: Float, priceVariance: Float,
                    purchaseDateConfig: GUPurchaseDateGenerator.Config)
}

package com.griddynamics

import com.griddynamics.generators.abs.RandomEventsGenerator
import com.griddynamics.generators.impl._

object GridEventsGenerator {
  def apply(): GridEventsGenerator = new GridEventsGenerator(Config())

  def apply(config: Config): GridEventsGenerator = new GridEventsGenerator(config)

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

class GridEventsGenerator(config: GridEventsGenerator.Config) extends RandomEventsGenerator {
  protected val productNameGenerator = UniformProductNameGenerator(config.productNames)
  protected val productPriceGenerator = GaussianProductPriceGenerator(config.priceMean, config.priceVariance)
  protected val purchaseDateGenerator = GUPurchaseDateGenerator(config.purchaseDateConfig)
  protected val productCategoryGenerator = UniformProductCategoryGenerator(config.productCategories)
  protected val ipAddressGenerator = UniformIpAddressGenerator()
}

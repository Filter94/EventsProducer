package com.griddynamics

import com.griddynamics.GridEventsGenerator.GridEventsGeneratorConfig
import com.griddynamics.generators.abs.RandomEventsGenerator
import com.griddynamics.generators.impl.GUPurchaseDateGenerator.GUPurchaseDateConfig
import com.griddynamics.generators.impl._
import org.joda.time.{DateTime, Days}

object GridEventsGenerator {
  def apply(): GridEventsGenerator = new GridEventsGenerator(GridEventsGeneratorConfig())

  object GridEventsGeneratorConfig {
    /**
      * Scala constructor wrapper
      */
    def apply(productNames: String, productCategories: String,
              priceMean: Float, priceVariance: Float,
              purchaseDateConfig: GUPurchaseDateConfig): GridEventsGeneratorConfig =
      new GridEventsGeneratorConfig(productNames, productCategories,
        priceMean, priceVariance, purchaseDateConfig)

    /**
      * Some default values
      * @return
      */
    def apply(): GridEventsGeneratorConfig = {
      GridEventsGeneratorConfig("/product_names.txt", "/product_categories.txt",
        50, 25, GUPurchaseDateConfig())
    }
  }

  class GridEventsGeneratorConfig(val productNames: String, val productCategories: String,
                                  val priceMean: Float, val priceVariance: Float,
                                  val purchaseDateConfig: GUPurchaseDateConfig)
}

class GridEventsGenerator(config: GridEventsGeneratorConfig) extends RandomEventsGenerator {
  protected val productNameGenerator = UniformProductNameGenerator(config.productNames)
  protected val productPriceGenerator = GaussianProductPriceGenerator(config.priceMean, config.priceVariance)
  protected val purchaseDateGenerator = GUPurchaseDateGenerator()
  protected val productCategoryGenerator = UniformProductCategoryGenerator(config.productCategories)
  protected val ipAddressGenerator = UniformIpAddressGenerator()
}

package com.griddynamics.generators.impl.generators

import com.griddynamics.generators.abs.ProductCategoryGenerator

object UniformProductCategoryGenerator {
  def apply(): UniformProductCategoryGenerator = new UniformProductCategoryGenerator()
}

class UniformProductCategoryGenerator extends ProductCategoryGenerator {
  def generateProductCategory(): String = {
    "Product category"
  }
}

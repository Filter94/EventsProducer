package com.griddynamics.impl.generators

import com.griddynamics.abs.generators.ProductCategoryGenerator

object UniformProductCategoryGenerator {
  def apply(): UniformProductCategoryGenerator = new UniformProductCategoryGenerator()
}

class UniformProductCategoryGenerator extends ProductCategoryGenerator {
  def generateProductCategory(): String = {
    "Product category"
  }
}

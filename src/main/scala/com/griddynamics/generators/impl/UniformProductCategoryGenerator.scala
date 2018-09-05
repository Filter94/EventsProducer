package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.ProductCategoryGenerator

object UniformProductCategoryGenerator {
  def apply(): UniformProductCategoryGenerator = new UniformProductCategoryGenerator()
}

class UniformProductCategoryGenerator extends ProductCategoryGenerator {
  def generateProductCategory(): String = {
    "Product category"
  }
}

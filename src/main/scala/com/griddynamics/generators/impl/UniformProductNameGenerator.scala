package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.ProductNameGenerator

object UniformProductNameGenerator {
  def apply(): UniformProductNameGenerator = new UniformProductNameGenerator()
}

class UniformProductNameGenerator extends ProductNameGenerator {
  def generateProductName(): String = {
    "Product name"
  }
}

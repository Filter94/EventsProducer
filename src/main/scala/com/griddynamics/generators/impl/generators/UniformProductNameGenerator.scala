package com.griddynamics.generators.impl.generators

import com.griddynamics.generators.abs.ProductNameGenerator

object UniformProductNameGenerator {
  def apply(): UniformProductNameGenerator = new UniformProductNameGenerator()
}

class UniformProductNameGenerator extends ProductNameGenerator {
  def generateProductName(): String = {
    "Product name"
  }
}

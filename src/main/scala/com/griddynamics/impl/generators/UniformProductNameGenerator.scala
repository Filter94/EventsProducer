package com.griddynamics.impl.generators

import com.griddynamics.abs.generators.ProductNameGenerator

object UniformProductNameGenerator {
  def apply(): UniformProductNameGenerator = new UniformProductNameGenerator()
}

class UniformProductNameGenerator extends ProductNameGenerator {
  def generateProductName(): String = {
    "Product name"
  }
}

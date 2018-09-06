package com.griddynamics.generators

import com.griddynamics.generators.impl.UniformProductNameGenerator
import org.scalatest.FunSuite

class ProductNameGeneratorTest extends FunSuite {
  test("Generator returns different names every call") {
    val generator = UniformProductNameGenerator("/product_names.txt")
    assert(generator.generateProductName() != generator.generateProductName())
  }
}
package com.griddynamics.generators

import com.griddynamics.generators.impl.UniformProductCategoryGenerator
import org.scalatest.FunSuite

class ProductCategoryGeneratorTest extends FunSuite {
  test("Generator returns different categories every call") {
    val generator = UniformProductCategoryGenerator("/product_categories.txt")
    assert(generator.generateProductCategory() != generator.generateProductCategory())
  }
}
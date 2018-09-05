package com.griddynamics.generators

import com.griddynamics.generators.impl.generators.UniformProductCategoryGenerator
import org.scalatest.FunSuite

class ProductCategoryGeneratorTest extends FunSuite {
  test("Generator returns different categories every call") {
    val generator = UniformProductCategoryGenerator()
    assert(generator.generateProductCategory() != generator.generateProductCategory())
  }
}
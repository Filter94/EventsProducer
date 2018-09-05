package com.griddynamics.generators

import com.griddynamics.generators.impl.generators.GaussianProductPriceGenerator
import org.scalatest.FunSuite

class ProductPriceGeneratorTest extends FunSuite {

  test("Generator returns different strings every call") {
    val generator = GaussianProductPriceGenerator()
    assert(generator.generateProductPrice() != generator.generateProductPrice())
  }
}
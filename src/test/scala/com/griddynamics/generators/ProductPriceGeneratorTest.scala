package com.griddynamics.generators

import com.griddynamics.generators.impl.GaussianProductPriceGenerator
import org.scalatest.FunSuite

class ProductPriceGeneratorTest extends FunSuite {

  test("Generator returns different strings every call") {
    val generator = GaussianProductPriceGenerator(50, 25)
    assert(generator.generateProductPrice() != generator.generateProductPrice())
  }
}
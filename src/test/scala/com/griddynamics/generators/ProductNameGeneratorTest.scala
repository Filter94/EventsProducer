package com.griddynamics.generators

import com.griddynamics.impl.generators.UniformProductNameGenerator
import org.scalatest.FunSuite

class ProductNameGeneratorTest extends FunSuite {

  test("Generator returns different names every call") {
    val generator = UniformProductNameGenerator()
    assert(generator.generateProductName() != generator.generateProductName())
  }
}
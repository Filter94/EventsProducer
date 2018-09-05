package com.griddynamics.generators

import com.griddynamics.generators.impl.generators.GUPurchaceDateGenerator
import org.scalatest.FunSuite

class PurchaseDateGeneratorTest extends FunSuite {

  test("Generator returns different dates every call") {
    val generator = GUPurchaceDateGenerator()
    assert(generator.generatePurchaseDate() != generator.generatePurchaseDate())
  }
}
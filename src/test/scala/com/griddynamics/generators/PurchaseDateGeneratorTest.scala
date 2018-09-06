package com.griddynamics.generators

import com.griddynamics.generators.impl.GUPurchaseDateGenerator
import org.scalatest.FunSuite

class PurchaseDateGeneratorTest extends FunSuite {
  test("Generator returns different dates every call") {
    val generator = GUPurchaseDateGenerator()
    assert(generator.generatePurchaseDate() != generator.generatePurchaseDate())
  }

  test("Generator returns different time every call") {
    val generator = GUPurchaseDateGenerator()
    assert(generator.generatePurchaseDate().getMinuteOfDay != generator.generatePurchaseDate().getMinuteOfDay)
  }
}
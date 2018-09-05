package com.griddynamics.generators.impl.generators

import com.griddynamics.generators.abs.PurchaseDateGenerator
import org.joda.time.DateTime

object GUPurchaceDateGenerator {
  def apply(): GUPurchaceDateGenerator = new GUPurchaceDateGenerator()
}

class GUPurchaceDateGenerator extends PurchaseDateGenerator {
  def generatePurchaseDate(): DateTime = new DateTime().minusDays(3)
}

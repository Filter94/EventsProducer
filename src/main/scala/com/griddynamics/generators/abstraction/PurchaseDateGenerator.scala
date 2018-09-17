package com.griddynamics.generators.abstraction

import org.joda.time.DateTime

trait PurchaseDateGenerator {
  def generatePurchaseDate(): DateTime
}

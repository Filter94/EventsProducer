package com.griddynamics.generators.abs

import org.joda.time.DateTime

trait PurchaseDateGenerator {
  def generatePurchaseDate(): DateTime
}

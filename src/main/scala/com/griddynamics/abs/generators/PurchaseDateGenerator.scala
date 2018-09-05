package com.griddynamics.abs.generators

import org.joda.time.DateTime

trait PurchaseDateGenerator {
  def generatePurchaseDate(): DateTime
}

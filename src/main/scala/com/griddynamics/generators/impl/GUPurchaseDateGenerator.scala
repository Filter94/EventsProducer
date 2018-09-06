package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.PurchaseDateGenerator
import com.griddynamics.generators.impl.GUPurchaseDateGenerator.GUPurchaseDateConfig
import org.joda.time.DateTime

object GUPurchaseDateGenerator {
  def apply(): GUPurchaseDateGenerator = new GUPurchaseDateGenerator(GUPurchaseDateConfig())

  object GUPurchaseDateConfig {
    /**
      *
      * @param purchaseDateStart - start date
      * @param purchaseDateDays - max days after start date
      * @param purchaseDateMean - mean in minutes within a day (up to 3600)
      * @param purchaseDateVariance - variance in minutes
      * @return generated dates will be in range (start date, start date + days).
      *         Time within a day will have a normal distribution with given parameters.
      */
    def apply(purchaseDateStart: DateTime, purchaseDateDays: Int,
              purchaseDateMean: Float, purchaseDateVariance: Float): GUPurchaseDateConfig =
      new GUPurchaseDateConfig(purchaseDateStart, purchaseDateDays, purchaseDateMean, purchaseDateVariance)

    private val DEFAULT_MEAN = 12 * 60

    /**
      * Some default values
      */
    def apply(): GUPurchaseDateConfig =
      GUPurchaseDateConfig(new DateTime("2007-09-20"), 7, DEFAULT_MEAN, DEFAULT_MEAN / 2)
  }

  class GUPurchaseDateConfig(val purchaseDateStart: DateTime, val purchaseDateDays: Int,
                             val purchaseTimeMean: Float, val purchaseTimeVariance: Float)
}

class GUPurchaseDateGenerator(config: GUPurchaseDateConfig) extends PurchaseDateGenerator {
  private def generateDate(): DateTime = {
    val daysOffset = RNG.rng.nextInt(config.purchaseDateDays)
    config.purchaseDateStart.plusDays(daysOffset)
  }

  def generatePurchaseDate(): DateTime = {
    val date = generateDate()
    val minuteOfTheDay = RNG.gaussianWithMeanAndSigma(config.purchaseTimeMean, config.purchaseTimeVariance)
    date.plusMinutes(minuteOfTheDay.toInt)
  }
}

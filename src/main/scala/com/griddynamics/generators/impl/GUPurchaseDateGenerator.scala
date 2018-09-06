package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.PurchaseDateGenerator
import org.joda.time.DateTime

object GUPurchaseDateGenerator {
  def apply(): GUPurchaseDateGenerator = new GUPurchaseDateGenerator(Config())

  def apply(config: Config): GUPurchaseDateGenerator = new GUPurchaseDateGenerator(config)

  object Config {
    private val DEFAULT_MEAN = 12 * 60

    /**
      * Some default values
      */
    def apply(): Config =
      Config(new DateTime("2007-09-20"), 7, DEFAULT_MEAN, DEFAULT_MEAN / 2)
  }

  /**
    * @param purchaseDateStart    - start date
    * @param purchaseDateDays     - max days after start date
    * @param purchaseTimeMean     - mean in minutes within a day (up to 3600)
    * @param purchaseTimeVariance - variance in minutes
    * @return generated dates will be in range (start date, start date + days).
    *         Time within a day will have a normal distribution with given parameters.
    */
  case class Config(purchaseDateStart: DateTime, purchaseDateDays: Int,
                    purchaseTimeMean: Float, purchaseTimeVariance: Float)

  protected val MINUTES_IN_A_DAY = 1440
}

class GUPurchaseDateGenerator(config: GUPurchaseDateGenerator.Config) extends PurchaseDateGenerator {
  private def generateDate(): DateTime = {
    val daysOffset = RNG.rng.nextInt(config.purchaseDateDays)
    config.purchaseDateStart.plusDays(daysOffset)  // days offset + start day = daysOffset + 1
  }

  def generatePurchaseDate(): DateTime = {
    val date = generateDate()
    val minuteOfTheDay = RNG.gaussianWithMeanAndSigma(config.purchaseTimeMean, config.purchaseTimeVariance)
    date.plusMinutes(minuteOfTheDay.toInt max 0 min (GUPurchaseDateGenerator.MINUTES_IN_A_DAY - 1))
  }
}

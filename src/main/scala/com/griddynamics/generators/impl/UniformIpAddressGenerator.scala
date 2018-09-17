package com.griddynamics.generators.impl

import com.griddynamics.generators.abstraction.IpAddressGenerator

object UniformIpAddressGenerator {
  def apply(): UniformIpAddressGenerator = new UniformIpAddressGenerator()
}

class UniformIpAddressGenerator extends IpAddressGenerator {
  private def randomPortion(): Int = RNG.rng.nextInt(256)

  def generateIpAddress(): String = {
    val portions = for {
      _ <- 0 until 4
    } yield {
      randomPortion()
    }
    portions.mkString(".")
  }
}

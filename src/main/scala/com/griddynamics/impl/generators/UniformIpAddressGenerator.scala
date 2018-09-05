package com.griddynamics.impl.generators

import com.griddynamics.abs.generators.IpAddressGenerator

object UniformIpAddressGenerator {
  def apply(): UniformIpAddressGenerator = new UniformIpAddressGenerator()
}

class UniformIpAddressGenerator extends IpAddressGenerator {
  def generateIpAddress(): String = {
    "Ip address"
  }
}

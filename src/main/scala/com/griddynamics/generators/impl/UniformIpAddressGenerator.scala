package com.griddynamics.generators.impl

import com.griddynamics.generators.abs.IpAddressGenerator

object UniformIpAddressGenerator {
  def apply(): UniformIpAddressGenerator = new UniformIpAddressGenerator()
}

class UniformIpAddressGenerator extends IpAddressGenerator {
  def generateIpAddress(): String = {
    "Ip address"
  }
}

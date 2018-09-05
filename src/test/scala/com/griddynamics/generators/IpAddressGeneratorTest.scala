package com.griddynamics.generators

import com.griddynamics.generators.impl.generators.UniformIpAddressGenerator
import org.scalatest.FunSuite

class IpAddressGeneratorTest extends FunSuite {

  test("Generator returns different IPs every call") {
    val generator = UniformIpAddressGenerator()
    assert(generator.generateIpAddress() != generator.generateIpAddress())
  }
}
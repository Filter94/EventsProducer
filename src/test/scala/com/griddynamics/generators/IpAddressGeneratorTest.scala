package com.griddynamics.generators

import com.griddynamics.generators.impl.UniformIpAddressGenerator
import org.scalatest.FunSuite

class IpAddressGeneratorTest extends FunSuite {

  test("Generator returns different IPs every call") {
    val generator = UniformIpAddressGenerator()
    assert(generator.generateIpAddress() != generator.generateIpAddress())
  }

  test("Generator returns something which looks like IPs") {
    val generator = UniformIpAddressGenerator()
    assert(generator.generateIpAddress().matches("\\d+.\\d+.\\d+.\\d+"))
  }
}
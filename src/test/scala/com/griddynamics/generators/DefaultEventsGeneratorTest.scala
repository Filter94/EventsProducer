package com.griddynamics.generators

import com.griddynamics.DefaultEventsGenerator
import org.scalatest.FunSuite

class DefaultEventsGeneratorTest extends FunSuite {
  test("Generator returns different events every call") {
    val generator = DefaultEventsGenerator()
    assert(generator.next() != generator.next())
  }
}

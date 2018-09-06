package com.griddynamics.generators

import com.griddynamics.GridEventsGenerator
import org.scalatest.FunSuite

class GridEventsGeneratorTest extends FunSuite {
  test("Generator returns different events every call") {
    val generator = GridEventsGenerator()
    assert(generator.next() != generator.next())
  }
}

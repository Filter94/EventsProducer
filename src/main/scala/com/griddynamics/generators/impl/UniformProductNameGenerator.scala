package com.griddynamics.generators.impl

import java.io.InputStream

import com.griddynamics.generators.abstraction.ProductNameGenerator

import scala.io.Source

object UniformProductNameGenerator {
  def apply(sourceFileName: String): UniformProductNameGenerator = new UniformProductNameGenerator(sourceFileName)
}

class UniformProductNameGenerator(val sourceFileName: String) extends ProductNameGenerator {
  private lazy val nameOptions: Array[String] = {
    val stream : InputStream = getClass.getResourceAsStream(sourceFileName)
    val result = Source.fromInputStream(stream).getLines().toArray
    stream.close()
    result
  }

  def generateProductName(): String = {
    val nextPosition = RNG.rng.nextInt(nameOptions.length)
    nameOptions(nextPosition)
  }
}

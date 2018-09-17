package com.griddynamics.generators.impl

import java.io.InputStream

import com.griddynamics.generators.abstraction.ProductCategoryGenerator

import scala.io.Source

object UniformProductCategoryGenerator {
  def apply(sourceFileName: String): UniformProductCategoryGenerator =
    new UniformProductCategoryGenerator(sourceFileName)
}

class UniformProductCategoryGenerator(val sourceFileName: String) extends ProductCategoryGenerator {
  private lazy val categoryOptions: Array[String] = {
    val stream : InputStream = getClass.getResourceAsStream(sourceFileName)
    val result = Source.fromInputStream(stream).getLines().toArray
    stream.close()
    result
  }

  def generateProductCategory(): String = {
    val nextPosition = RNG.rng.nextInt(categoryOptions.length)
    categoryOptions(nextPosition)
  }
}

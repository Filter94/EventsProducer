package com.griddynamics.generators.abstraction

import org.joda.time.DateTime
import org.joda.time.format.DateTimeFormat

case class Event(productName: String, productPrice: Float, purchaseDate: DateTime,
                 productCategory: String, clientIp: String) {
  override def toString: String = {
    Seq(
      productName,
      productPrice,
      DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss.SSSS").print(purchaseDate),
      productCategory,
      clientIp
    ).mkString(",")
  }
}

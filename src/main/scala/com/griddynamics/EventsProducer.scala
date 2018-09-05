package com.griddynamics

import java.io.PrintStream
import java.net.{InetAddress, Socket}

import com.griddynamics.generators.impl.GridEventsProducer
import org.apache.logging.log4j.scala.Logging

import scala.io.BufferedSource


object EventsProducer extends App with Logging {
  lazy val in = new BufferedSource(s.getInputStream).getLines()
  val eventsGenerator = GridEventsProducer()
  val s = new Socket(InetAddress.getByName("localhost"), 44444)
  val out = new PrintStream(s.getOutputStream)
  assert(s.isBound)
  assert(s.isConnected)
  eventsGenerator.foreach {
    e =>
      val eventString = e.toString
      out.println(eventString)
      in.next()  // to slow things down a bit.
      logger.debug(eventString)
  }
  s.close()
}

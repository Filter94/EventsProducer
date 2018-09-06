package com.griddynamics

import java.io.PrintStream
import java.net.{InetAddress, Socket}

import org.apache.logging.log4j.scala.Logging

import scala.io.BufferedSource


object EventsProducer extends App with Logging {
  lazy val in = new BufferedSource(s.getInputStream).getLines()
  val eventsGenerator = GridEventsGenerator()
  val s = new Socket(InetAddress.getByName("localhost"), 44444)
  val out = new PrintStream(s.getOutputStream)
  do {
      val eventString = eventsGenerator.next() .toString
      out.println(eventString)
      logger.debug(eventString)
  } while (in.hasNext && in.next() != null)   // to slow things down a bit.
  s.close()
}

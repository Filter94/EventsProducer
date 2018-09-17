package com.griddynamics

import java.io.PrintStream
import java.net.{InetAddress, Socket}

import org.apache.logging.log4j.scala.Logging

import scala.io.BufferedSource


object EventsProducer extends App with Logging {
  lazy val in = new BufferedSource(s.getInputStream).getLines()
  val eventsGenerator = DefaultEventsGenerator()
  val s = new Socket(InetAddress.getByName(args(0)), args(1).toInt)
  val out = new PrintStream(s.getOutputStream)
  var counter = 0
  sys.addShutdownHook({
    logger.info("Written %d events.".format(counter))
  })
  do {
    val eventString = eventsGenerator.next().toString
    out.println(eventString)
    logger.debug(eventString)
    counter += 1
  } while (in.hasNext && in.next() != null) // to slow things down a bit.
  s.close()
}

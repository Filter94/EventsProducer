package com.griddynamics

import java.io.PrintStream
import java.net.{InetAddress, Socket}

import org.apache.logging.log4j.scala.Logging

import scala.io.BufferedSource


object EventsProducer extends App with Logging {
  if (args.length == 2) {
    val eventsGenerator = DefaultEventsGenerator()
    val (host, port) = (args(0), args(1).toInt)
    val s = new Socket(InetAddress.getByName(host), port)
    lazy val in = new BufferedSource(s.getInputStream).getLines()
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
  } else {
    logger.error("This program accepts 2 arguments. " +
      "First one is the to which events to be sent, second one is the port.")
  }
}
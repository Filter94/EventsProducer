package com.griddynamics

import java.io.PrintStream
import java.net.{InetAddress, Socket}

import com.griddynamics.impl.GridEventsProducer

import scala.io.BufferedSource


object EventsProducer extends App {
  lazy val in = new BufferedSource(s.getInputStream).getLines()
  val eventsGenerator = GridEventsProducer()
  val s = new Socket(InetAddress.getByName("localhost"), 44444)
  val out = new PrintStream(s.getOutputStream)
  assert(s.isBound)
  assert(s.isConnected)
  eventsGenerator.foreach {
    e =>
      out.println(e.toString)
      in.next()  // to slow things down a bit.
  }
  s.close()
}

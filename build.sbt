name := "randomEventsGenerator"

version := "0.1-SNAPSHOT"
organization := "com.griddynamics"
scalaVersion := "2.11.12"

libraryDependencies += "joda-time" % "joda-time" % "2.10"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5"
libraryDependencies ++= Seq(
  "org.apache.logging.log4j" %% "log4j-api-scala" % "11.0",
  "org.apache.logging.log4j" % "log4j-api" % "2.11.0",
  "org.apache.logging.log4j" % "log4j-core" % "2.11.0" % Runtime
)

mainClass in assembly := Some("com.griddynamics.EventsProducer")
assemblyJarName in assembly := "EventsProducer.jar"


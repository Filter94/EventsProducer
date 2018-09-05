name := "randomEventsGenerator"

version := "0.1-SNAPSHOT"
organization := "com.griddynamics"
scalaVersion := "2.11.12"

resolvers += Resolver.bintrayRepo("eyeem", "maven")

libraryDependencies += "joda-time" % "joda-time" % "2.10"
libraryDependencies += "junit" % "junit" % "4.10"
libraryDependencies += "org.scalactic" %% "scalactic" % "3.0.5"
libraryDependencies += "org.scalacheck" %% "scalacheck" % "1.12.1"
libraryDependencies += "org.scalatest" %% "scalatest" % "3.0.5"

mainClass in assembly := Some("com.griddynamics.EventsProducer")
assemblyJarName in assembly := "EventsProducer.jar"
test in assembly := {}


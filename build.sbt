import sbt.Keys._

name := "QLoop-scala"

version := "0.01"

scalaVersion := "2.10.6"

scalacOptions ++= Seq("-encoding", "UTF-8")

libraryDependencies ++= Seq(
  "org.scalactic" %% "scalactic" % "2.2.6",
  "org.scalatest" %% "scalatest" % "2.2.6" % "test",
  "org.apache.spark" %% "spark-core" % "1.6.1",
  "org.apache.spark" %% "spark-mllib" % "1.6.1"
)
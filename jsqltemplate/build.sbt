import BuildSettings.BaseProject
import Dependencies._

name := "jsqltemplate"

version := "0.1"

scalaVersion := "2.12.11"

// Enable experimental cached SBT/Ivy library resolution to speed up compile
updateOptions := updateOptions.value.withCachedResolution(true)

val commonDeps = Seq(
  libraryDependencies ++=
    testDependencies(scalaTest, mockitoCore, jsql)
)
lazy val jsqltemplate = BaseProject("jsql")
  .settings(commonDeps)
  .settings(libraryDependencies ++= List(jsql))
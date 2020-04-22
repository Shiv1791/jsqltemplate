import sbt._

object Dependencies {


  def testDependencies(deps: ModuleID*): Seq[ModuleID] = deps.map(_ % Test)

  val mockitoCoreVersion = "2.23.0"
  val scalaTestVersion = "3.0.5"
  val jsql = "com.github.jsqlparser" % "jsqlparser" % "0.9"
  /**
    * Compile libraries
    */

  /**
    * Test libraries
    */

  val scalaTest = "org.scalatest" %% "scalatest" % scalaTestVersion

  val mockitoCore = "org.mockito"  % "mockito-core" % mockitoCoreVersion
}

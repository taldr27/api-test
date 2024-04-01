import com.typesafe.config.ConfigFactory

name := """play-scala-seed"""
organization := "com.example"

version := "1.0-SNAPSHOT"

lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    semanticdbEnabled := true
  )

scalaVersion := "3.3.0"

libraryDependencies += guice
libraryDependencies ++= Seq(
  "org.scalatestplus.play" %% "scalatestplus-play" % "7.0.1" % Test,
  "com.mysql" % "mysql-connector-j" % "8.3.0",
  "org.playframework" %% "play-slick" % "6.1.0",
  "org.playframework" %% "play-slick-evolutions" % "6.1.0",
  "com.typesafe.slick" %% "slick" % "3.5.0",
  "com.typesafe.slick" %% "slick-codegen" % "3.5.0",
  "mysql" % "mysql-connector-java" % "8.0.33"
)

lazy val slick = taskKey[Seq[File]]("Generate Tables.scala")

slick := {
  val conf = ConfigFactory.parseFile(new File("conf/application.conf")).resolve()

  val dir = sourceManaged.value
  val cp = (Compile / dependencyClasspath).value
  val s = streams.value

  val outputDir = "app"

  val profile = conf.getString("slick.dbs.default.profile").dropRight(1)
  val url = conf.getString("slick.dbs.default.db.url")
  val jdbcDriver = conf.getString("slick.dbs.default.db.driver")
  val user = conf.getString("slick.dbs.default.db.user")
  val password = conf.getString("slick.dbs.default.db.password")

  val pkg = "models"

  runner.value.run("slick.codegen.SourceCodeGenerator",
    cp.files,
    Array(profile, jdbcDriver, url, outputDir, pkg, user, password), s.log
  ).failed foreach (sys error _.getMessage)

  val fname = outputDir + s"/$pkg/Tables.scala"
  Seq(file(fname))
}

// run code generation
lazy val generateSlickTables = taskKey[Unit]("Generate Slick Tables.scala")

generateSlickTables := {
  slick.value
}

(Compile / compile) := ((Compile / compile) dependsOn generateSlickTables).value


// Some conflicts with these two, need to review.
//"com.typesafe.play" %% "play-slick" % "5.3.0"
//"com.typesafe.play" %% "play-slick-evolutions" % "5.3.0"
// possible solutions:
// jdbc
// evolutions

// Adds additional packages into Twirl
//TwirlKeys.templateImports += "com.example.controllers._"

// Adds additional packages into conf/routes
// play.sbt.routes.RoutesKeys.routesImport += "com.example.binders._"

import Dependencies._

ThisBuild / scalaVersion     := "2.13.6"
ThisBuild / version          := "0.1.0-SNAPSHOT"
ThisBuild / organization     := "local.example"
ThisBuild / organizationName := "example"

lazy val root = (project in file("."))
  .settings(
    name := "proof-scala",
    libraryDependencies += scalaTest % Test
  )

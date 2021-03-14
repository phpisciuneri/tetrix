lazy val buildSettings = Seq(
  version := "0.0.1-SNAPSHOT",
  organization := "com.github.phpisciuneri",
  scalaVersion := "2.12.13",
  scalacOptions := Seq("-deprecation", "-unchecked")
)

lazy val swingDependencies = Def.setting {
  "org.scala-lang.modules" %% "scala-swing" % "3.0.0"
}

lazy val root = (project in file(".")).
  settings(buildSettings: _*).
  settings(name := "tetrix")

lazy val library = (project in file("library")).
  settings(buildSettings: _*)

lazy val swing = (project in file("swing")).
  settings(buildSettings: _*).
  settings(
    fork in run := true,
    libraryDependencies += swingDependencies.value
  ).
  dependsOn(library)

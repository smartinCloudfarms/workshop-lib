val scala3Version = "3.6.4"

val credentialsViaEnvVariables = for {
  username <- sys.env.get("MAVEN_WRITE_USERNAME")
  password <- sys.env.get("MAVEN_WRITE_PASSWORD")
} yield Credentials("Sonatype Nexus Repository Manager", "repository.cloudfarms.online", username, password)

ThisBuild / credentials += credentialsViaEnvVariables.getOrElse(Credentials(Path.userHome / ".sbt" / ".credentials"))
ThisBuild /organization := "smartin-workshop"

lazy val root = project
  .in(file("."))
  .settings(
    name := "workshop-lib",
    version := "0.1.0-SNAPSHOT",

    scalaVersion := scala3Version,

    libraryDependencies += "org.scalameta" %% "munit" % "1.0.0" % Test
  )

publishTo := {
  val nexus = "https://repository.cloudfarms.online/repository/maven-workshop/"
  if (isSnapshot.value)
    Some("snapshots" at nexus)
  else
    Some("releases" at nexus)
},

import sbt._

object MyBuild extends Build {

  lazy val netLogo = RootProject(uri("git://github.com/NetLogo/NetLogo.git#hexy-extensions-task"))

  lazy val root = Project("root", file("."))
    .dependsOn(netLogo)

  lazy val extensionsKey =
    Def.ScopedKey[Task[Seq[File]]](Scope(This, This, This, This) in netLogo, AttributeKey[Task[Seq[File]]]("extensions"))
}

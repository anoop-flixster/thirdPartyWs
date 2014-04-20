name := "thirdPartyWs"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.newrelic.agent.java" % "newrelic-agent" % "3.5.1"
)     

play.Project.playJavaSettings

name := "thirdPartyWs"

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
  javaJdbc,
  javaEbean,
  cache,
  "com.newrelic.agent.java" % "newrelic-agent" % "2.11.0"
)     

play.Project.playJavaSettings

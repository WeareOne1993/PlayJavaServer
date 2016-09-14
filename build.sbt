name := """PlayJavaSpring"""

version := "1.0-SNAPSHOT"

libraryDependencies ++= Seq(
	javaCore,
	javaWs % "test",
	"mysql" % "mysql-connector-java" % "5.1.18",
	"com.h2database" % "h2" % "1.4.181",
	"org.springframework" % "spring-context" % "4.3.1.RELEASE",
	"org.springframework" % "spring-orm" % "4.3.1.RELEASE",
	"org.springframework" % "spring-jdbc" % "4.3.1.RELEASE",
	"org.springframework" % "spring-tx" % "4.3.1.RELEASE",
	"org.springframework" % "spring-expression" % "4.3.1.RELEASE",
	"org.springframework" % "spring-aop" % "4.3.1.RELEASE",
	"org.springframework" % "spring-test" % "4.3.1.RELEASE" % "test",
	"org.hibernate" % "hibernate-entitymanager" % "4.3.6.Final",
	"javax.inject" % "javax.inject" % "1",
	"c3p0" % "c3p0" % "0.9.1.2",
	"net.sourceforge.jtds" % "jtds" % "1.3.1"
)

lazy val root = (project in file(".")).enablePlugins(PlayJava)

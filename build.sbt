name := "jcterm"

organization := "net.java.linoleum"

description := "SSH2 Terminal Emulator in Pure Java"

licenses := Seq( "LGPL" -> url( "http://www.gnu.org/licenses/lgpl.txt" ))

publishTo := {
  val nexus = "https://oss.sonatype.org/"
  if (isSnapshot.value)
    Some("snapshots" at nexus + "content/repositories/snapshots") 
  else
    Some("releases"  at nexus + "service/local/staging/deploy/maven2")
}

credentials += Credentials(Path.userHome / ".ivy2" / ".credentials")

pomExtra :=
  <url>http://www.jcraft.com/jcterm/</url>
  <scm>
    <url>git@github.com:rjolly/jcterm.git</url>
    <connection>scm:git:git@github.com:rjolly/jcterm.git</connection>
  </scm>
  <developers>
    <developer>
      <id>ymnk</id>
      <name>Atsuhiko Yamanaka</name>
      <url>http://github.com/ymnk</url>
    </developer>
    <developer>
      <id>rjolly</id>
      <name>Raphael Jolly</name>
      <url>http://github.com/rjolly</url>
    </developer>
  </developers>

version := "0.0.11"

mainClass in (Compile, packageBin) := Some("com.jcraft.jcterm.JCTermSwingFrame")

mainClass in (Compile, run) := Some("com.jcraft.jcterm.JCTermSwingFrame")

libraryDependencies := Seq("com.jcraft" % "jsch" % "0.1.51" % "compile->master,optional", "net.java.linoleum" % "application" % "1.0")

autoScalaLibrary := false

crossPaths := false

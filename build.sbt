organization := "com.codurance"
name := "yahtzee"
version := "0.0.1"
scalaVersion  := "2.11.7"
scalacOptions := Seq("-unchecked", "-deprecation", "-feature", "-encoding", "utf8", "-target:jvm-1.8", "-Xfatal-warnings", "-Xfuture")

libraryDependencies ++=
		Seq(
			"org.scalatest"       %% "scalatest"    % "2.2.6" % Test,
			"org.mockito"          % "mockito-all"  % "1.10.19" % Test,
			"junit"                % "junit"        % "4.12" % Test
		)

unmanagedSourceDirectories in Compile := Seq(baseDirectory.value / "src/main/scala")

unmanagedSourceDirectories in Test := Seq(baseDirectory.value / "src/test/scala")

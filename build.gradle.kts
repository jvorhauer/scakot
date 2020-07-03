import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.jetbrains.kotlin.jvm") version "1.3.72"
  id("java-library")
  id("maven-publish")
  id("com.github.ben-manes.versions") version "0.28.0"
}

java {
  sourceCompatibility = JavaVersion.VERSION_11
  targetCompatibility = JavaVersion.VERSION_11
}

repositories {
  mavenLocal()
  mavenCentral()
  jcenter()
}

sourceSets["main"].withConvention(KotlinSourceSet::class) { kotlin.srcDir("src/main/kotlin") }
sourceSets["main"].resources.srcDir("src/main/resources")
sourceSets["test"].withConvention(KotlinSourceSet::class) { kotlin.srcDir("src/test/kotlin") }
sourceSets["test"].resources.srcDir("src/test/resources")

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.scala-lang:scala-library:2.13.3")

  testImplementation("io.kotest:kotest-runner-junit5-jvm:4.1.1")
  testImplementation("io.kotest:kotest-assertions-core-jvm:4.1.1")
  testImplementation("io.kotest:kotest-property-jvm:4.1.1")
  testImplementation("io.kotest:kotest-runner-console-jvm:4.1.1")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
  useJUnitPlatform()
}

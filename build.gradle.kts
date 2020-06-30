import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSet
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
  id("org.jetbrains.kotlin.jvm") version "1.3.72"
  `java-library`
}

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
  jcenter()
  mavenCentral()
}

sourceSets["main"].withConvention(KotlinSourceSet::class) { kotlin.srcDir("src/main/kotlin") }
sourceSets["main"].resources.srcDir("src/main/resources")
sourceSets["test"].withConvention(KotlinSourceSet::class) { kotlin.srcDir("src/test/kotlin") }
sourceSets["test"].resources.srcDir("src/test/resources")

dependencies {
  implementation(platform("org.jetbrains.kotlin:kotlin-bom"))
  implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
  implementation("org.scala-lang:scala-library:2.13.3")

  testImplementation("org.junit.platform:junit-platform-launcher:1.6.1")
  testImplementation("org.junit.platform:junit-platform-engine:1.6.1")
  testImplementation("org.junit.platform:junit-platform-commons:1.6.1")
  testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.1")
  testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.1")
  testImplementation("org.assertj:assertj-core:3.15.0")
}

tasks.withType<KotlinCompile>().configureEach {
  kotlinOptions.jvmTarget = "11"
}

tasks.withType<Test> {
  useJUnitPlatform {
    includeEngines = setOf("junit-jupiter")
    excludeEngines = setOf("junit-vintage")
  }
}

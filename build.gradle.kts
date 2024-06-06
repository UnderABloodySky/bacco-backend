import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
}

group = "com.example"
version = "0.0.1-SNAPSHOT"

java {
	sourceCompatibility = JavaVersion.VERSION_17
}

repositories {
	mavenCentral()
}

configurations.all {
	exclude(group = "commons-logging")
}
dependencies {
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")
	//implementation("com.h2database:h2")
	//runtimeOnly("com.h2database:h2")

	//testImplementation("org.neo4j.test:neo4j-harness:4.4.3")
	//testImplementation("org.neo4j:neo4j-ogm-embedded-driver:3.2.24")

	implementation("org.apache.httpcomponents:httpclient:4.5.13")
	implementation("org.apache.httpcomponents:httpmime:4.5.13")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation(platform("org.junit:junit-bom:5.9.3"))
	runtimeOnly("org.neo4j.driver:neo4j-java-driver")
	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
	implementation("org.springframework.data:spring-data-neo4j")
}

tasks.withType<KotlinCompile> {
	kotlinOptions {
		freeCompilerArgs += "-Xjsr305=strict"
		jvmTarget = "17"
	}

}

tasks.withType<Test> {
	useJUnitPlatform()
	systemProperty("spring.profiles.active", "test")
	systemProperty("spring.config.location", "classpath:application-test.properties")
}

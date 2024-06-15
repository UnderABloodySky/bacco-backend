import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("org.springframework.boot") version "3.2.4"
	id("io.spring.dependency-management") version "1.1.4"
	kotlin("jvm") version "1.9.23"
	kotlin("plugin.spring") version "1.9.23"
//	id("org.sonarqube") version "4.4.1.3373"
}
/*
sonar {
	properties {
		property("sonar.projectKey", "bacco_b-acco-backend")
		property("sonar.organization", "bacco")
		property("sonar.host.url", "https://sonarcloud.io")
		property("sonar.login", System.getenv("SONAR_TOKEN"))
		property("sonar.gradle.skipCompile", "true")
	}
}*/

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
	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.springframework.boot:spring-boot-starter-web")
		implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
		runtimeOnly("org.neo4j.driver:neo4j-java-driver")
		implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
		implementation("org.springframework.data:spring-data-neo4j")

		testImplementation("org.springframework.boot:spring-boot-starter-test") {
			exclude(group = "org.junit.vintage", module = "junit-vintage-engine")
		}
		testImplementation(platform("org.junit:junit-bom:5.9.3"))
		testImplementation("org.junit.jupiter:junit-jupiter-api")
		testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
		testImplementation("com.tngtech.archunit:archunit-junit5:0.14.1")
		testImplementation("com.tngtech.archunit:archunit:0.14.1")
		implementation("org.apache.httpcomponents:httpclient:4.5.13")
		implementation("org.apache.httpcomponents:httpmime:4.5.13")

		implementation("org.springframework.boot:spring-boot-starter-security")
		implementation("org.springframework.security:spring-security-crypto")
		testImplementation("org.springframework.security:spring-security-test")
	}
	/*
	implementation("org.springframework.boot:spring-boot-starter-data-jpa")



	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
	implementation("org.jetbrains.kotlin:kotlin-reflect")

	testImplementation("org.springframework.boot:spring-boot-starter-test")
	testImplementation("org.junit.jupiter:junit-jupiter")
	testImplementation(platform("org.junit:junit-bom:5.9.3"))
	runtimeOnly("org.neo4j.driver:neo4j-java-driver")
	implementation("org.springframework.boot:spring-boot-starter-data-neo4j")
	implementation("org.springframework.data:spring-data-neo4j")

	implementation("org.springframework.boot:spring-boot-starter")
	implementation("org.springframework.boot:spring-boot-starter-web")
	implementation("org.jetbrains.kotlin:kotlin-reflect")
	implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

	testImplementation("com.tngtech.archunit:archunit-junit5:0.14.1")
	testImplementation("com.tngtech.archunit:archunit:0.14.1")
	testImplementation("org.junit.jupiter:junit-jupiter-api:5.7.2")
	testImplementation("org.junit.jupiter:junit-jupiter-engine:5.7.2")*/
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

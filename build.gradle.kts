plugins {
    `java`
}

group = "auctionsniper"
version = "1.0-SNAPSHOT"

java {
    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

repositories {
    mavenCentral()
    maven { url = uri("https://oss.sonatype.org/content/repositories/snapshots") }
    flatDir {
        dirs("lib/deploy", "lib/develop")
    }
}

dependencies {
    implementation("commons-io:commons-io:1.4")
    implementation("commons-lang:commons-lang:2.4")
    testImplementation("junit:junit:4.6")
    testImplementation("org.hamcrest:hamcrest-core:1.2")
    testImplementation("org.hamcrest:hamcrest-library:1.2")
    testImplementation("org.jmock:jmock:2.6.0")

    implementation(fileTree("lib/deploy") {
        include("*.jar")
    })
    testImplementation(fileTree("lib/develop") {
        include("*.jar")
        exclude("*-src.jar")
    })
}

sourceSets {
    named("test") {
        java {
            setSrcDirs(
                listOf(
                    "src/test/java",
                    "src/test/unit",
                    "src/test/integration",
                    "src/test/end-to-end"
                )
            )
        }
    }
}

tasks.withType<Test> {
    jvmArgs(
        "--add-opens=java.logging/java.util.logging=ALL-UNNAMED",
        "--add-opens=java.base/java.lang=ALL-UNNAMED"
    )
    testLogging {
        events("passed", "skipped", "failed")
    }
}
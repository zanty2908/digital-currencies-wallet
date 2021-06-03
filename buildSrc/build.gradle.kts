plugins {
    `kotlin-dsl`
}

repositories {
    google()
    mavenCentral()
}

val compileKotlin: org.jetbrains.kotlin.gradle.tasks.KotlinCompile by tasks
compileKotlin.kotlinOptions {
    languageVersion = Plugin.Version.kotlin
}

object Plugin {
    object Version {
        const val spotless = "4.0.1"
        const val kotlin = "1.4.31"
        const val androidGradle = "4.2.0"
        const val daggerHiltAndroid = "2.35"
    }

    const val androidGradle = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.daggerHiltAndroid}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Version.spotless}"
}

dependencies {
    implementation(kotlin("gradle-plugin", Plugin.Version.kotlin))
    implementation(Plugin.androidGradle)
    implementation(Plugin.daggerHilt)
    implementation(Plugin.spotless)
}

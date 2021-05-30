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
        const val navigation = "2.3.0"
        const val daggerHiltAndroid = "2.35"
        const val protobuf = "0.8.8"
        const val googleServices = "4.3.3"
        const val crashlytics = "2.3.0"
    }

    const val androidGradle = "com.android.tools.build:gradle:${Version.androidGradle}"
    const val daggerHilt = "com.google.dagger:hilt-android-gradle-plugin:${Version.daggerHiltAndroid}"
    const val spotless = "com.diffplug.spotless:spotless-plugin-gradle:${Version.spotless}"

    //const val navigationSafeArgs = "androidx.navigation:navigation-safe-args-gradle-plugin:${Version.navigation}"
    //const val protobuf = "com.google.protobuf:protobuf-gradle-plugin:${Version.protobuf}"
    //const val googleServices = "com.google.gms:google-services:${Version.googleServices}"
    //const val crashlytics = "com.google.firebase:firebase-crashlytics-gradle:${Version.crashlytics}"
}

dependencies {
    implementation(kotlin("gradle-plugin", Plugin.Version.kotlin))
    implementation(Plugin.androidGradle)
    implementation(Plugin.daggerHilt)
    implementation(Plugin.spotless)
//    implementation(Plugin.navigationSafeArgs)
//    implementation(Plugin.protobuf)
//    implementation(Plugin.googleServices)
//    implementation(Plugin.crashlytics)
}

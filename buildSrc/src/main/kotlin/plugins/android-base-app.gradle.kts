import org.gradle.api.JavaVersion

plugins {
    id("com.android.application")
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-android-extensions`
    id("dagger.hilt.android.plugin")
//    id("androidx.navigation.safeargs.kotlin")
//    id("com.google.gms.google-services")
//    id("com.google.firebase.crashlytics")
}

android {
    compileSdkVersion(Versions.TARGET_ANDROID_SDK)
    buildToolsVersion = Versions.BUILD_TOOLS

    defaultConfig {
        minSdkVersion(Versions.MIN_ANDROID_SDK)
        targetSdkVersion(Versions.TARGET_ANDROID_SDK)
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    baseBuildType(
        release = {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    )

    baseProductFlavor(dev = { applicationIdSuffix = ".dev" })

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}

dependencies {
    appCompat()
    lifecycle()
    navigation()
    di()

    base()
    test()
    androidTest()
}

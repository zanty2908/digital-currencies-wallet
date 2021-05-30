plugins {
    id("com.android.application")
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
    id("dagger.hilt.android.plugin")
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
    hilt()

    base()
    test()
    androidTest()
}

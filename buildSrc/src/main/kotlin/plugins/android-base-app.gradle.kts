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
        multiDexEnabled = true
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

    packagingOptions {
        exclude("META-INF/AL2.0")
        exclude("META-INF/LGPL2.1")
    }
}

dependencies {
    appCompat()
    lifecycle()
    hilt()

    base()
    test()
    hiltTest()
    androidTest()
}

plugins {
    id("com.android.library")
    `kotlin-android`
    `kotlin-kapt`
    `kotlin-parcelize`
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(Versions.TARGET_ANDROID_SDK)

    defaultConfig {
        minSdkVersion(Versions.MIN_ANDROID_SDK)
        targetSdkVersion(Versions.TARGET_ANDROID_SDK)
    }

    baseBuildType(
        release = {
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    )

    baseProductFlavor(
        dev = { devConfig() },
        production = { productionConfig() }
    )

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
    hilt()
    appCompat()
    lifecycle()
    coil()
    base()
    test()
    androidTest()
    hiltTest()
}

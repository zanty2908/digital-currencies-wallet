plugins {
    `android-base-app`
}

android {
    defaultConfig {
        versionCode = 16
        versionName = "1.0.0"
        applicationId = "com.zanty.chresource.digitalcurrencieswallet"
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

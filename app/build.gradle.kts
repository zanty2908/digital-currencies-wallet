plugins {
    `android-base-app`
}

android {
    defaultConfig {
        versionCode = 16
        versionName = "1.0.0"
        applicationId = "com.zanty.chresource.digitalcurrencieswallet"
        testInstrumentationRunner = "com.zanty.chresource.digitalcurrencieswallet.HiltTestRunner"
    }
}

dependencies {
    api(project(":core"))
}

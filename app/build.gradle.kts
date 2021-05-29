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
    api(project(":core"))
}

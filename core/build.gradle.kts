plugins {
    `android-core-lib`
}

android {
    defaultConfig {
        testInstrumentationRunner = "com.zanty.chresource.core.HiltTestRunner"
    }
}

dependencies {
    // Modules
    api(project(":data:network"))
    api(project(":data:local"))
}

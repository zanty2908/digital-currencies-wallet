import com.android.build.gradle.internal.dsl.ProductFlavor

fun ProductFlavor.devConfig() {
    buildConfigField("String", "BASE_URL", "\"https://www.coinhako.com/api/v3\"")
}

fun ProductFlavor.productionConfig() {
    buildConfigField("String", "BASE_URL", "\"https://www.coinhako.com/api/v3\"")
}

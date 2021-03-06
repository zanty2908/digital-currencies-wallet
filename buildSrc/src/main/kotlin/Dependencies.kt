import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.kotlin

fun DependencyHandler.appCompat() = implementations(
    "androidx.core:core-ktx" version Versions.CORE_KTX,
    "androidx.fragment:fragment-ktx" version Versions.FRAGMENT_KTX,
    "androidx.appcompat:appcompat" version Versions.APP_COMPAT,
    "com.google.android.material:material" version Versions.MATERIAL_ANDROID,
    "androidx.constraintlayout:constraintlayout" version Versions.CONSTRAINT_LAYOUT,
    "androidx.recyclerview:recyclerview" version Versions.RECYCLER_VIEW,
    "androidx.swiperefreshlayout:swiperefreshlayout" version Versions.RECYCLER_VIEW
)

fun DependencyHandler.lifecycle() = implementations(
    "androidx.lifecycle:lifecycle-runtime" version Versions.LIFECYCLE,
    "androidx.lifecycle:lifecycle-extensions" version Versions.LIFECYCLE,
    "androidx.lifecycle:lifecycle-viewmodel-ktx" version Versions.LIFECYCLE,
    "androidx.lifecycle:lifecycle-livedata-ktx" version Versions.LIFECYCLE
)

fun DependencyHandler.base() = implementations(
    kotlin("stdlib"),
    "org.jetbrains.kotlinx:kotlinx-coroutines-core" version Versions.COROUTINES_ANDROID,
    "org.jetbrains.kotlinx:kotlinx-coroutines-android" version Versions.COROUTINES_ANDROID,
    "androidx.multidex:multidex" version Versions.MULTIDEX,
    "javax.inject:javax.inject" version Versions.JAVAX_INJECT
)

fun DependencyHandler.test() {
    implementation(kotlin("reflect"))
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}

fun DependencyHandler.androidTest() = androidTestImplementations(
    "androidx.test:runner" version Versions.ANDROID_TEST_RUNNER,
    "androidx.test.ext:junit" version Versions.ANDROID_TEST_EXT,
    "androidx.arch.core:core-testing" version Versions.ANDROID_CORE_TEST,
    "androidx.test.espresso:espresso-core" version Versions.ANDROID_TEST_ESPRESSO,
    "org.jetbrains.kotlinx:kotlinx-coroutines-test" version Versions.COROUTINES_ANDROID,
    "com.google.truth:truth:1.1"
)

fun DependencyHandler.retrofit() = apis(
    "com.squareup.retrofit2:retrofit" version Versions.RETROFIT,
    "com.squareup.retrofit2:converter-moshi" version Versions.RETROFIT,
    "com.squareup.okhttp3:logging-interceptor" version Versions.OKHTTP3
)

fun DependencyHandler.moshi() {
    api("com.squareup.moshi:moshi-kotlin" version Versions.MOSHI)
    kapt("com.squareup.moshi:moshi-kotlin-codegen" version Versions.MOSHI)
}

fun DependencyHandler.room() {
    api("androidx.room:room-runtime" version Versions.ROOM)
    api("androidx.room:room-ktx" version Versions.ROOM)
    kapt("androidx.room:room-compiler" version Versions.ROOM)
}

fun DependencyHandler.hilt() {
    api("com.google.dagger:hilt-android" version Versions.HILT)
    kapt("com.google.dagger:hilt-android-compiler" version Versions.HILT)
}

fun DependencyHandler.hiltTest() {
    androidTestImplementation("com.google.dagger:hilt-android-testing" version Versions.HILT)
    kaptAndroidTest("com.google.dagger:hilt-android-compiler" version Versions.HILT)
}

fun DependencyHandler.coil() {
    api("io.coil-kt:coil" version Versions.COIL)
}

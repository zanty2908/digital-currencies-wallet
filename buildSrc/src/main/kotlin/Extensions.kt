import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.plugin.use.PluginDependenciesSpec
import org.gradle.plugin.use.PluginDependencySpec

infix fun String.version(ver: String): String = "$this:$ver"

internal fun DependencyHandler.implementation(depName: Any) {
    add("implementation", depName)
}

internal fun DependencyHandler.implementations(vararg depName: Any) {
    depName.forEach { add("implementation", it) }
}

internal fun DependencyHandler.kapt(depName: String) {
    add("kapt", depName)
}

internal fun DependencyHandler.compileOnly(depName: String) {
    add("compileOnly", depName)
}

internal fun DependencyHandler.api(depName: String) {
    add("api", depName)
}

internal fun DependencyHandler.apis(vararg depName: String) {
    depName.forEach { add("api", it) }
}

internal fun DependencyHandler.testImplementation(depName: Any) {
    add("testImplementation", depName)
}

internal fun DependencyHandler.androidTestImplementation(depName: Any) {
    add("androidTestImplementation", depName)
}

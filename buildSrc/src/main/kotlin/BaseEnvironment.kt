import com.android.build.gradle.LibraryExtension
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import com.android.build.gradle.internal.dsl.BuildType
import com.android.build.gradle.internal.dsl.ProductFlavor
import org.gradle.api.NamedDomainObjectContainer

// Build Type
object BaseBuildType {
    const val DEBUG: String = "debug"
    const val RELEASE: String = "release"
}

fun BaseAppModuleExtension.baseBuildType(
    debug: BuildType.() -> Unit = {},
    release: BuildType.() -> Unit = {}
) = buildTypes { baseBuildType(debug, release) }

fun LibraryExtension.baseBuildType(
    debug: BuildType.() -> Unit = {},
    release: BuildType.() -> Unit = {}
) = buildTypes { baseBuildType(debug, release) }

fun NamedDomainObjectContainer<BuildType>.baseBuildType(
    debug: BuildType.() -> Unit,
    release: BuildType.() -> Unit
) {
    named(BaseBuildType.DEBUG) {
        isDebuggable = true
        isMinifyEnabled = false
        debug()
    }

    named(BaseBuildType.RELEASE) {
        isDebuggable = false
        isMinifyEnabled = true
        release()
    }
}

// Product Flavor
object BaseProductFlavor {
    const val DEV = "dev"
    const val PRODUCTION = "production"
}

fun NamedDomainObjectContainer<ProductFlavor>.baseFlavor(
    dev: ProductFlavor.() -> Unit = {},
    production: ProductFlavor.() -> Unit = {}
) {
    create(BaseProductFlavor.DEV) { dev() }
    create(BaseProductFlavor.PRODUCTION) { production() }
}

fun BaseAppModuleExtension.baseProductFlavor(
    dev: ProductFlavor.() -> Unit = {},
    production: ProductFlavor.() -> Unit = {}
) = productFlavors {
    flavorDimensions("default")
    baseFlavor(dev, production)
}

fun LibraryExtension.baseProductFlavor(
    dev: ProductFlavor.() -> Unit = {},
    production: ProductFlavor.() -> Unit = {}
) = productFlavors {
    flavorDimensions("default")
    baseFlavor(dev, production)
}

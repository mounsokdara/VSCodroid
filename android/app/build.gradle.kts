import java.util.Properties

plugins {
    alias(libs.plugins.android.application)
}

val signingProps = Properties()
rootProject.file("signing.properties").takeIf { it.exists() }?.inputStream()?.use { signingProps.load(it) }
fun signingProp(key: String, envVar: String, fallback: String = "") =
    signingProps.getProperty(key) ?: System.getenv(envVar) ?: fallback

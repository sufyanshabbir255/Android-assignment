plugins {
    `kotlin-dsl`
}
object Dependencies {
    const val AndroidBuildTools = "com.android.tools.build:gradle:4.2.1"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.10"
}
repositories {
    mavenCentral()
    google()
    gradlePluginPortal()
}
dependencies {
    implementation(Dependencies.AndroidBuildTools)
    implementation(Dependencies.kotlinGradlePlugin)
}

// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
    //TODO 1.3: Add the Compose plugin
    alias(libs.plugins.compose.compiler) apply false
}
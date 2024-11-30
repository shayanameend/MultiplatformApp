import org.jetbrains.compose.ExperimentalComposeLibrary
import org.jetbrains.compose.desktop.application.dsl.TargetFormat
import org.jetbrains.kotlin.gradle.ExperimentalKotlinGradlePluginApi
import org.jetbrains.kotlin.gradle.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.plugin.KotlinSourceSetTree

plugins {
  alias(libs.plugins.multiplatform)
  alias(libs.plugins.compose.compiler)
  alias(libs.plugins.compose)
  alias(libs.plugins.android.application)
  alias(libs.plugins.kotlinx.serialization)
  alias(libs.plugins.sqlDelight)
  alias(libs.plugins.apollo)
  alias(libs.plugins.buildConfig)
}

kotlin {
  jvmToolchain(17)

  androidTarget {
    @OptIn(ExperimentalKotlinGradlePluginApi::class)
    instrumentedTestVariant.sourceSetTree.set(KotlinSourceSetTree.test)
  }

  listOf(
    iosX64(),
    iosArm64(),
    iosSimulatorArm64()
  ).forEach {
    it.binaries.framework {
      baseName = "ComposeApp"
      isStatic = true
    }
  }

  jvm()

  @OptIn(ExperimentalWasmDsl::class)
  wasmJs {
    browser()
    binaries.executable()
  }

  sourceSets {
    commonMain.dependencies {
      implementation(compose.runtime)
      implementation(compose.foundation)
      implementation(compose.material3)
      implementation(compose.materialIconsExtended)
      implementation(compose.components.resources)
      implementation(compose.components.uiToolingPreview)
      implementation(libs.kermit)
      implementation(libs.kotlinx.coroutines.core)
      implementation(libs.ktor.client.core)
      implementation(libs.ktor.client.content.negotiation)
      implementation(libs.ktor.client.serialization)
      implementation(libs.ktor.client.logging)
      implementation(libs.androidx.lifecycle.viewmodel)
      implementation(libs.androidx.lifecycle.runtime.compose)
      implementation(libs.androidx.navigation.composee)
      implementation(libs.kotlinx.serialization.json)
      implementation(libs.koin.core)
      implementation(libs.koin.compose)
      implementation(libs.coil)
      implementation(libs.coil.network.ktor)
      implementation(libs.multiplatformSettings)
      implementation(libs.kotlinx.datetime)
      implementation(libs.apollo.runtime)
      implementation(libs.kstore)
      implementation(libs.composeIcons.featherIcons)
    }

    commonTest.dependencies {
      implementation(kotlin("test"))
      @OptIn(ExperimentalComposeLibrary::class)
      implementation(compose.uiTest)
      implementation(libs.kotlinx.coroutines.test)
    }

    androidMain.dependencies {
      implementation(compose.uiTooling)
      implementation(libs.androidx.activityCompose)
      implementation(libs.kotlinx.coroutines.android)
      implementation(libs.ktor.client.okhttp)
      implementation(libs.sqlDelight.driver.android)
    }

    iosMain.dependencies {
      implementation(libs.ktor.client.darwin)
      implementation(libs.sqlDelight.driver.native)
    }

    jvmMain.dependencies {
      implementation(compose.desktop.currentOs)
      implementation(libs.kotlinx.coroutines.swing)
      implementation(libs.ktor.client.okhttp)
      implementation(libs.sqlDelight.driver.sqlite)
    }
  }
}

android {
  namespace = "com.zedsols.multiplatformapp"
  compileSdk = 35

  defaultConfig {
    minSdk = 21
    targetSdk = 35

    applicationId = "com.zedsols.multiplatformapp.androidApp"
    versionCode = 1
    versionName = "1.0.0"

    testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
  }
}

dependencies {
  androidTestImplementation(libs.androidx.uitest.junit4)
  debugImplementation(libs.androidx.uitest.testManifest)
}

compose.desktop {
  application {
    mainClass = "MainKt"

    nativeDistributions {
      targetFormats(TargetFormat.Dmg, TargetFormat.Msi, TargetFormat.Deb)
      packageName = "MultiplatformApp"
      packageVersion = "1.0.0"

      linux {
        iconFile.set(project.file("desktopAppIcons/LinuxIcon.png"))
      }
      windows {
        iconFile.set(project.file("desktopAppIcons/WindowsIcon.ico"))
      }
      macOS {
        iconFile.set(project.file("desktopAppIcons/MacosIcon.icns"))
        bundleID = "com.zedsols.multiplatformapp.desktopApp"
      }
    }
  }
}

buildConfig {}

sqldelight {
  databases {
    create("MyDatabase") {
      packageName.set("com.zedsols.multiplatformapp.db")
    }
  }
}

apollo {
  service("api") {
    packageName.set("com.zedsols.multiplatformapp.graphql")
  }
}

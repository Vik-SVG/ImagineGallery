plugins {
    id(AppConfig.android_application)
    id(AppConfig.kotlin_android)
    id(AppConfig.kotlin_kapt)
    id(AppConfig.hilt_plugin)
    kotlin("plugin.serialization") version "1.5.0"
}

android {
    compileSdkVersion(AppConfig.compileSdk)
    buildToolsVersion = AppConfig.buildToolsVersion

    defaultConfig {
        applicationId = AppConfig.application_id
        minSdkVersion(AppConfig.minSdk)
        targetSdkVersion(AppConfig.targetSdk)
        versionCode(AppConfig.versionCode)
        versionName = AppConfig.versionName

        testInstrumentationRunner = AppConfig.androidTestInstrumentation
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile(AppConfig.proguard_android_optimize),
                AppConfig.proguard_rules
            )
        }
    }
    buildFeatures {
        dataBinding = true
        viewBinding = true
    }
    compileOptions {
        sourceCompatibility(JavaVersion.VERSION_1_8)
        targetCompatibility(JavaVersion.VERSION_1_8)
    }
    kotlinOptions {
        jvmTarget = AppConfig.jvmTarget
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation(AppDependencies.defaultDeps)
    implementation(AppDependencies.customLibraries)
    kapt(AppDependencies.kaptDeps)
    testImplementation(AppDependencies.testLibraries)
    androidTestImplementation(AppDependencies.androidTestLibraries)

    implementationProject(ModulesDeps.includeInnerModules)
}
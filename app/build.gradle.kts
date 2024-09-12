plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.mohanad.androidjavapractice"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.mohanad.androidjavapractice"
        minSdk = 28
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildFeatures{
        viewBinding = true
    }
}

dependencies {
    implementation(libs.retrofit)
    implementation(libs.retrofit2.converter.gson)
    implementation(libs.squareup.picasso)
    implementation (libs.room.runtime)
    annotationProcessor (libs.room.compiler)
    implementation(libs.appcompat)
    implementation(libs.material)
    implementation(libs.activity)
    implementation(libs.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.ext.junit)
    androidTestImplementation(libs.espresso.core)
}
plugins {
    id ("com.android.application")
    id ("kotlin-android")
    id ("kotlin-android-extensions")
}

android {
    compileSdkVersion (31)

    defaultConfig {
        applicationId= "com.example.android_assignment"
        minSdk= 23
        targetSdk = 31
        versionCode =1
        versionName ="1.0"

        testInstrumentationRunner ="androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
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
    kotlinOptions {
        jvmTarget ="1.8"
    }
}

dependencies {
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
    implementation (Dependencies.coreKtx)
    implementation (Dependencies.appCompat)
    implementation (Dependencies.appMaterial)
    implementation (Dependencies.constraintLayout)
    implementation (Dependencies.coroutines)
    implementation (Dependencies.jUnit)
    implementation (Dependencies.viewModel)
    implementation (Dependencies.glide)
    implementation (Dependencies.activityKtx)
    androidTestImplementation (Dependencies.jUnitTest)
    androidTestImplementation (Dependencies.espresso)
    annotationProcessor(Dependencies.glideAnnotation)
}
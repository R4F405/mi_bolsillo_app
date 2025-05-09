plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.ksp)
    alias(libs.plugins.hilt)

}

android {
    namespace = "com.rafa.mi_bolsillo_app"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.rafa.mi_bolsillo_app"
        minSdk = 26
        targetSdk = 35
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
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

dependencies {

    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)

    // Dependencias de Room (AÑADE/MODIFICA ESTAS LÍNEAS)
    implementation(libs.androidx.room.runtime)
    ksp(libs.androidx.room.compiler) // Usa ksp para el procesador de anotaciones de Room
    implementation(libs.androidx.room.ktx)   // Para extensiones Kotlin y soporte de Coroutines

    // Hilt
    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler) // Usa ksp para el compilador de Hilt

    // Lifecycle ViewModel KTX (para viewModelScope)
    implementation(libs.androidx.lifecycle.viewmodelktx)

    // Dependencias de Test
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}
plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-android")
    id("dagger.hilt.android.plugin")
    id("com.google.devtools.ksp")
    id("kotlin-kapt")
}

android {
    namespace = "com.messieyawo.recipemvvmcompose"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.messieyawo.recipemvvmcompose"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
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
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures {
        compose = true
    }
    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.0"
    }
    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}

dependencies {

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation("androidx.activity:activity-compose:1.8.0")
    implementation(platform("androidx.compose:compose-bom:2023.03.00"))
    implementation("androidx.compose.ui:ui")
    implementation("androidx.compose.ui:ui-graphics")
    implementation("androidx.compose.ui:ui-tooling-preview")
    implementation("androidx.compose.material3:material3")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
    androidTestImplementation(platform("androidx.compose:compose-bom:2023.03.00"))
    androidTestImplementation("androidx.compose.ui:ui-test-junit4")
    debugImplementation("androidx.compose.ui:ui-tooling")
    debugImplementation("androidx.compose.ui:ui-test-manifest")

    //implementation ("androidx.compose.material3:material3:1.2.0-alpha09")

    //compose dependencies



    implementation ("androidx.constraintlayout:constraintlayout-compose:1.0.0-beta02")


    implementation ("androidx.compose.ui:ui:1.5.3")
    implementation ("androidx.compose.foundation:foundation:1.5.4")
    implementation ("androidx.compose.runtime:runtime-livedata:1.5.3")
    implementation ("androidx.compose.runtime:runtime-rxjava2:1.5.3")
    implementation ("androidx.compose.material:material:1.5.3")
    implementation ("androidx.compose.material:material-icons-core:1.5.3")
    implementation ("androidx.compose.material:material-icons-extended:1.5.3")



    // def retrofit = "2.9.0"
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    // def hilt = "2.37"
//    implementation ("com.google.dagger:hilt-android:2.48")
//    kapt ("com.google.dagger:hilt-android-compiler:2.44.2")
//
//    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
//    kapt ("androidx.hilt:hilt-compiler:1.0.0")

    // implementation ("androidx.compose.ui:ui:1.6.0-alpha07")

    //implementation ("androidx.lifecycle:lifecycle-viewmodel-compose:2.6.2")


    //Dagger Hilt
    implementation ("com.google.dagger:hilt-android:2.48")
    kapt ("com.google.dagger:hilt-compiler:2.48")
    implementation ("androidx.hilt:hilt-navigation-compose:1.0.0")

    // def glide = "4.11.0"
    implementation ("com.github.bumptech.glide:glide:4.15.1")
    kapt ("com.github.bumptech.glide:compiler:4.15.1")

    // Navigational Components
    implementation ("androidx.navigation:navigation-fragment-ktx:2.7.4")
    implementation ("androidx.navigation:navigation-ui-ktx:2.7.4")

    implementation ("de.hdodenhof:circleimageview:3.1.0")


    // Architectural Components
    implementation ("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-runtime-ktx:2.6.2")
    implementation ("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // Lottie
    implementation ("com.github.ibrahimsn98:CirclesLoadingView:1.0")

    // Room
    implementation("androidx.room:room-runtime:2.5.2")
    implementation("androidx.room:room-ktx:2.5.2")
    ksp("androidx.room:room-compiler:2.5.2")

    implementation ("com.theartofdev.edmodo:android-image-cropper:2.8.0")
    implementation ("com.squareup.retrofit2:converter-gson:2.9.0")

    implementation ("id.zelory:compressor:3.0.1")

    implementation ("com.muddzdev:styleabletoast:2.3.0")
    implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    implementation("androidx.activity:activity-ktx:1.7.2")

    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")

    // Coroutines
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.7.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-play-services:1.7.3")

    //Hilt
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    // Gson
    implementation ("com.google.code.gson:gson:2.10.1")
    //Retrofit for internet request
    implementation ("com.squareup.retrofit2:retrofit:2.9.0")
    implementation  ("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation ("com.squareup.okhttp3:logging-interceptor:5.0.0-alpha.10")

    // OkHttp
    implementation(platform("com.squareup.okhttp3:okhttp-bom:4.9.3"))
    implementation ("com.squareup.okhttp3:okhttp")
    implementation ("com.squareup.okhttp3:logging-interceptor")

    // Image Loading library Coil
   // implementation ("io.coil-kt:coil:2.2.2")
   // implementation ("androidx.swiperefreshlayout:swiperefreshlayout:1.1.0")

    //circular button
    //implementation ("com.github.antonKozyriatskyi:CircularProgressIndicator:1.3.0")
   // implementation ("com.github.dmytrodanylyk:circular-progress-button:1.2")
    //in app update and review
    implementation ("com.google.android.play:core:1.10.3")
    // DataStore
    implementation ("androidx.datastore:datastore-preferences:1.0.0")

    implementation ("com.google.android.gms:play-services-auth:20.7.0")


}

object Versions {

    const val androidx_appCompat = "1.0.0-beta01"
    const val androidx_core = "1.0.0-beta01"
    const val androidx_recyclerView = "1.0.0"
    const val materialDesign = "1.2.0-alpha01"
    const val androidx_preference = "1.0.0-beta01"
    const val androidx_gridlayout = "1.0.0-beta01"
    const val androidx_cardView = "1.0.0-beta01"
    const val androidx_multidex = "2.0.0"
    const val picasso = "2.71828"
    const val materialDialog = "0.9.0.1"
    const val androidx_constraintLayout = "2.0.0-alpha2"
    const val parceler = "1.1.11"
    const val retrofit = "2.6.1"
    const val okHttp = "3.10.0"
    const val rx_binding = "2.0.0"
    const val rx_java = "2.2.0"
    const val rx_android = "2.0.2"
    const val rx_kotlin = "2.3.0"
    const val rx_lifeCycleComponent = "2.2.1"
    const val rx_permissions = "0.10.2"
    const val intuit = "1.0.5"
    const val koin = "2.0.1"
    const val arch_navigationFragment = "1.0.0"
    const val arch_navigationUi = "1.0.0"
    const val test_junit = "4.12"
    const val test_jUnitParams = "1.1.1"
    const val test_kotlinTestJunit5 = "3.4.0"
    const val test_kotlinTestExtKoin = "3.4.0"
    const val test_espressoCore = "3.1.0-alpha4"
    const val androidx_lifeCycle = "2.0.0-rc01"
    const val sha_formValidator = "1.0.0"
    const val sha_navigator = "1.5.0"
    const val sha_rxRequester = "0.6.0"
    const val sha_rxLocation = "1.9.0@aar"
    const val sha_appHead = "0.3.2"
    const val flashBar = "1.0.3"
    const val androidx_junit = "1.1.1"
    const val androidx_espressoCore = "3.2.0"
    const val androidx_coreKtx = "1.1.0"
    const val androidx_paging = "2.0.0-rc01"
    const val androidx_swipeRefreshLayout = "1.0.0"
    const val playServices_androidMaps = "17.0.0"
    const val playServices_maps = "0.10.0"
    const val playServices_location = "16.0.0"
    const val mapUtils = "0.6.2"

    const val mockito_core = "3.0.0"
    const val hamcrest_all = "1.3"
    const val androidx_core_testing = "2.1.0"
    const val kotlinx_coroutine_test = "1.3.0"
    const val robolectric = "4.3-beta-1"
    const val espresso_contrib = "3.2.0"
    const val esspresso_intent = "3.2.0"
    const val truth = "0.44"
    const val androidx_test_core_ktx = "1.2.1-alpha02"
    const val androidx_test_ext_junit_ktx = "1.1.2-alpha02"
    const val androidx_test_rules = "1.3.0-alpha02"
    const val mockito_kotlin = "2.2.0"

}

object Deps {

    // <editor-fold desc="intuit">
    const val sdp = "com.intuit.sdp:sdp-android:${Versions.intuit}"
    const val ssp = "com.intuit.ssp:ssp-android:${Versions.intuit}"
    // </editor-fold>

    // <editor-fold desc="koin">
    const val koin_android = "org.koin:koin-android:${Versions.koin}"
    const val koin_scope = "org.koin:koin-android-scope:${Versions.koin}"
    const val koin_viewModel = "org.koin:koin-android-viewmodel:${Versions.koin}"
    const val koin_java = "org.koin:koin-java:${Versions.koin}"
    const val koin_ext = "org.koin:koin-android-ext:${Versions.koin}"
    // </editor-fold>

    // <editor-fold desc="arch">
    const val arch_navigationFragment = "android.arch.navigation:navigation-fragment:${Versions.arch_navigationFragment}"
    const val arch_navigationUi = "android.arch.navigation:navigation-ui:${Versions.arch_navigationUi}"
    // </editor-fold>

    // <editor-fold desc="androidx">
    const val androidx_appCompat   = "androidx.appcompat:appcompat:${Versions.androidx_appCompat}"
    const val androidx_core  = "androidx.core:core:${Versions.androidx_core}"
    const val androidx_recyclerView  = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerView}"
    const val androidx_preference  = "androidx.preference:preference:${Versions.androidx_preference}"
    const val androidx_gridlayout  = "androidx.gridlayout:gridlayout:${Versions.androidx_gridlayout}"
    const val androidx_cardView  = "androidx.cardview:cardview:${Versions.androidx_cardView}"
    const val androidx_multidex  = "androidx.multidex:multidex:${Versions.androidx_multidex}"
    const val androidx_constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val androidx_lifeCycle = "androidx.lifecycle:lifecycle-extensions:${Versions.androidx_lifeCycle}"
    const val androidx_lifeCycleCommonJava8 = "androidx.lifecycle:lifecycle-common-java8:${Versions.androidx_lifeCycle}"
    const val androidx_coreKtx = "androidx.core:core-ktx:${Versions.androidx_coreKtx}"
    const val androidx_paging = "androidx.paging:paging-runtime:${Versions.androidx_paging}"
    const val androidx_swipeRefreshLayout= "androidx.swiperefreshlayout:swiperefreshlayout:${Versions.androidx_swipeRefreshLayout}"
    // </editor-fold>

    // <editor-fold desc="parceler">
    const val parceler = "org.parceler:parceler-api:${Versions.parceler}"
    const val parceler_annotaitionProcessor = "org.parceler:parceler:${Versions.parceler}"
    // </editor-fold>

    // <editor-fold desc="retrofit">
    const val retrofit_runtime = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
    const val retrofit_adapter = "com.squareup.retrofit2:adapter-rxjava2:${Versions.retrofit}"
    const val retrofit_converter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
    // </editor-fold>

    // <editor-fold desc="okhttp">
    const val picasso  = "com.squareup.picasso:picasso:${Versions.picasso}"
    const val okHttp_runtime = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
    const val okHttp_interceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"
    // </editor-fold>

    // <editor-fold desc="Googe Maps">
    const val playServices_androidMaps = "com.google.android.gms:play-services-maps:${Versions.playServices_androidMaps}"
    const val playServices_maps = "com.google.maps:google-maps-services:${Versions.playServices_maps}"
    const val playServices_location = "com.google.android.gms:play-services-location:${Versions.playServices_location}"
    const val mapUtils = "com.google.maps.android:android-maps-utils:${Versions.mapUtils}"
    // </editor-fold>

    // <editor-fold desc="google">
    const val rx_binding = "com.jakewharton.rxbinding2:rxbinding:${Versions.rx_binding}"
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
    const val rx_kotlin = "io.reactivex.rxjava2:rxkotlin:${Versions.rx_kotlin}"
    const val rx_lifeCycleComponent = "com.trello.rxlifecycle2:rxlifecycle-components:${Versions.rx_lifeCycleComponent}"
    const val rx_permissions = "com.github.tbruyelle:rxpermissions:${Versions.rx_permissions}"
    // </editor-fold>

    const val materialDesign  = "com.google.android.material:material:${Versions.materialDesign}"

    const val materilaDialog  = "com.afollestad.material-dialogs:core:${Versions.materialDialog}"

    const val sha_formValidator  = "com.github.ShabanKamell:FormValidator:${Versions.sha_formValidator}"
    const val sha_navigator = "com.github.ShabanKamell:Navigator:${Versions.sha_navigator}"
    const val sha_rxRequester = "com.github.ShabanKamell:RxRequester:${Versions.sha_rxRequester}"
    const val sha_rxLocation = "com.sha.kamel:rx-location:${Versions.sha_rxLocation}"
    const val sha_appHead = "com.github.ShabanKamell:AppHead:${Versions.sha_appHead}"

    const val flashBar = "com.andrognito.flashbar:flashbar:${Versions.flashBar}"


}

object TestDeps {
    const val koin_android_ext = "org.koin:koin-android-ext:${Versions.koin}"
    const val koin_test = "org.koin:koin-test:${Versions.koin}"
    const val androidx_espressoCore = "androidx.test.espresso:espresso-core:${Versions.androidx_espressoCore}"
    const val androidx_junit = "androidx.test.ext:junit:${Versions.androidx_junit}"

    const val test_jUnitParams = "pl.pragmatists:JUnitParams:${Versions.test_jUnitParams}"
    const val test_kotlinTestJunit5 = "io.kotlintest:kotlintest-runner-junit5:${Versions.test_kotlinTestJunit5}"
    const val test_kotlinTestExtKoin = "io.kotlintest:kotlintest-extensions-koin:${Versions.test_kotlinTestExtKoin}"
    const val test_espressoCore = "androidx.test.espresso:espresso-core:${Versions.test_espressoCore}"

    const val test_junit = "junit:junit:${Versions.test_junit}"

    // <editor-fold desc="mockito">
    const val mockito_core = "org.mockito:mockito-core:${Versions.mockito_core}"
    const val mockito_kotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:${Versions.mockito_kotlin}"
    // </editor-fold>

    const val hamcrest_all = "org.hamcrest:hamcrest-all:${Versions.hamcrest_all}"
    const val kotlinx_coroutine_test = "org.jetbrains.kotlinx:kotlinx-coroutines-test:${Versions.kotlinx_coroutine_test}"
    const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
    const val espresso_contrib = "androidx.test.espresso:espresso-contrib:${Versions.espresso_contrib}"
    const val esspresso_intent = "androidx.test.espresso:espresso-intents:${Versions.esspresso_intent}"
    const val truth = "com.google.truth:truth:${Versions.truth}"

    // <editor-fold desc="androidx">
    const val androidx_test_core_ktx = "androidx.test:core-ktx:${Versions.androidx_test_core_ktx}"
    const val androidx_test_ext_junit_ktx = "androidx.test.ext:junit-ktx:${Versions.androidx_test_ext_junit_ktx}"
    const val androidx_test_rules = "androidx.test:rules:${Versions.androidx_test_rules}"
    const val androidx_core_testing = "androidx.arch.core:core-testing:${Versions.androidx_core_testing}"
    // </editor-fold>

}
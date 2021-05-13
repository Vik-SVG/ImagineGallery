object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val coreKtxDeps = "androidx.core:core-ktx:${Versions.coreKtx}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private val andrx_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private const val constraintLay =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    private const val picassoDep = "com.squareup.picasso:picasso:${Versions.picassoVer}"
    private const val paginLibaryDep = "androidx.paging:paging-runtime:${Versions.paging_version}"


    //ktor
    private const val ktorDep = "io.ktor:ktor-client-android:${Versions.ktorVers}"
    private const val ktorEngine = "io.ktor:ktor-client-android:${Versions.ktorVers}"

    private const val hiltDeps = "com.google.dagger:hilt-android:${Versions.dagger_version}"
    private const val hiltKaptDeps = "com.google.dagger:hilt-compiler:${Versions.dagger_version}"

    private const val hilt_viewModel = "androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha03"
    private const val hilt_compiler_kapt = "androidx.hilt:hilt-compiler:1.0.0-alpha03"

    private const val gson_conv = "io.ktor:ktor-client-gson:${Versions.ktorVers}"
    private const val ktor_serialization = "io.ktor:ktor-client-serialization:${Versions.ktorVers}"
    private const val kotlinx_ktorSer = "io.ktor:ktor-client-serialization-jvm:${Versions.ktorVers}"

    //navigation
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    private const val navigationFeatureModule =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"

    private const val navigationTest =
        "androidx.navigation:navigation-testing:${Versions.nav_version}"

    //livedata
    private const val livedataDeps =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"

    //viewModel
    private const val viewModelDeps =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"
    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"

    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"
    private const val kotlinx_serialization =
        "org.jetbrains.kotlinx:kotlinx-serialization-json:1.2.0"

    //Coroutines
    private const val coroutinesDeps =
        "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlin}-RC"

    val defaultDeps = arrayListOf<String>().apply {
        add(kotlinStdLib)
        add(material)
        add(constraintLay)
        add(andrx_compat)
        add(coreKtxDeps)
        add(fragmentKtx)
        add(activityKtx)
    }

    val ktorDependencies = arrayListOf<String>().apply {
        add(ktorDep)
        add(ktorEngine)
    }

    val androidTestLibraries = arrayListOf<String>().apply {
        add(extJUnit)
        add(espressoCore)
        add(navigationTest)
    }

    val testLibraries = arrayListOf<String>().apply {
        add(junit)
    }

    val kaptDeps = arrayListOf<String>().apply {
        add(hiltKaptDeps)
        add(hilt_compiler_kapt)
    }

    val customLibraries = arrayListOf<String>().apply {
        add(picassoDep)
        add(paginLibaryDep)
        add(kotlinx_ktorSer)
        add(ktor_serialization)

        add(ktorEngine)
        add(ktorDep)

        add(gson_conv)
        add(kotlinx_serialization)
        add(hiltDeps)
        add(hilt_viewModel)

        add(viewModelDeps)
        add(kotlinx_serialization)
        add(navigationFragment)
        add(navigationUi)
        add(navigationFeatureModule)

        add(livedataDeps)
        add(coroutinesDeps)
    }
}

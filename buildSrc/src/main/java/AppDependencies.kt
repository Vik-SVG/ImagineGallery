object AppDependencies {
    //std lib
    val kotlinStdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    //android ui
    private val coreKtxDeps = "androidx.core:core-ktx:${Versions.coreKtx}"

    //test libs
    private val junit = "junit:junit:${Versions.junit}"
    private val extJUnit = "androidx.test.ext:junit:${Versions.extJunit}"
    private val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espresso}"

    private val androidx = "androidx.core:core-ktx:${Versions.coreKtx}"
    private val andrx_compat = "androidx.appcompat:appcompat:${Versions.appcompat}"
    private val material = "com.google.android.material:material:${Versions.material}"
    private val constraintLay =
        "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"

    private val picassoDep = "com.squareup.picasso:picasso:${Versions.picassoVer}"
    private val paginLibaryDep = "androidx.paging:paging-runtime:${Versions.paging_version}"
    private val pagingComposeIntegrationDep =
        "androidx.paging:paging-compose:${Versions.pagindComposeVersion}"


    //ktor
    private val ktorDep = "io.ktor:ktor-client-android:${Versions.ktorVers}"
    private val ktorEngine = "io.ktor:ktor-client-android:${Versions.ktorVers}"

    private val hiltDeps = "com.google.dagger:hilt-android:${Versions.hilt_version}"
    private val hiltKaptDeps = "com.google.dagger:hilt-compiler:${Versions.hilt_version}"

    //navigation
    private const val navigationFragment =
        "androidx.navigation:navigation-fragment-ktx:${Versions.nav_version}"
    private const val navigationUi = "androidx.navigation:navigation-ui-ktx:${Versions.nav_version}"
    private const val navigationFeatureModule =
        "androidx.navigation:navigation-dynamic-features-fragment:${Versions.nav_version}"
    private const val navigationTest =
        "androidx.navigation:navigation-testing:${Versions.nav_version}"
    private const val navigationCompose =
        "androidx.navigation:navigation-compose:${Versions.navigationComposeVers}"

    //livedata
    private const val livedataDeps =
        "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifecycle_version}"

    //viewModel
    private const val viewModelDeps =
        "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.lifecycle_version}"

    private const val fragmentKtx = "androidx.fragment:fragment-ktx:${Versions.fragmentKtx}"
    private const val activityKtx = "androidx.activity:activity-ktx:${Versions.activityKtx}"


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
    }

    val customLibraries = arrayListOf<String>().apply {
        add(picassoDep)
        add(paginLibaryDep)
        add(pagingComposeIntegrationDep)
        add(ktorEngine)
        add(ktorDep)
        add(hiltDeps)
        add(navigationFragment)
        add(navigationUi)
        add(navigationFeatureModule)
        add(navigationCompose)
        add(livedataDeps)
        add(viewModelDeps)
        add(coroutinesDeps)
    }
}

object ModulesDeps {

    const val base_module = ":modules:BaseClasses"


    val includeInnerModules = arrayListOf<String>().apply {
        add(base_module)
    }
}
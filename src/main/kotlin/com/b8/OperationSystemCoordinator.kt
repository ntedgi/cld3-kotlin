package com.b8


const val sharedLibrary = "libnative"

enum class SharedObject(private val postfix: String) {
    OSX("dylib"),
    UNIX("so"),
    WINDOWS("dll");

    fun libPath(): String {
        var sharedObjectsFolder = when (System.getProperty("os.name")) {
            "Windows" -> "${System.getProperty("user.dir")}src\\main\\lib\\${this.name.toLowerCase()}\\"
            else-> "${System.getProperty("user.dir")}/src/main/lib/${this.name.toLowerCase()}/"
        }
        return "$sharedObjectsFolder$sharedLibrary.$postfix"
    }
}


class OperationSystemCoordinator {

    private fun isWindows(OS: String): Boolean = OS.indexOf("win") >= 0

    private fun isMac(OS: String): Boolean = OS.indexOf("mac") >= 0

    fun getRunningOperationSystem(): String = System.getProperty("os.name").toLowerCase()

    fun getOperationSystemSharedObjects(OS: String): SharedObject {
        if (isWindows(OS)) return SharedObject.WINDOWS
        return if (isMac(OS)) SharedObject.OSX
        else SharedObject.UNIX
    }

}



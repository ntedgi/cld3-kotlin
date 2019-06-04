package com.b8


import org.junit.Test

internal class OperationSystemCoordinatorTest {
    @Test
    fun `Get Running Operation System`() {
        val operatingSystemCoordinator = OperationSystemCoordinator()
        assert(operatingSystemCoordinator.getRunningOperationSystem() == System.getProperty("os.name").toLowerCase())
    }

    @Test
    fun `Get Operation System Shared Objects On All Operation Systems`() {
        val operatingSystemCoordinator = OperationSystemCoordinator()
        val mapOs2SharedObject = mapOf(
            "windows 95" to SharedObject.WINDOWS,
            "windows vista" to SharedObject.WINDOWS,
            "windows xp" to SharedObject.WINDOWS,
            "windows 10" to SharedObject.WINDOWS,
            "linux" to SharedObject.UNIX,
            "mpe/ix" to SharedObject.UNIX,
            "freebsd" to SharedObject.UNIX,
            "irix" to SharedObject.UNIX,
            "digital unix" to SharedObject.UNIX,
            "unix" to SharedObject.UNIX,
            "mac os" to SharedObject.OSX,
            "sun os" to SharedObject.UNIX,
            "sunos" to SharedObject.UNIX,
            "solaris" to SharedObject.UNIX,
            "hp-ux" to SharedObject.UNIX,
            "aix" to SharedObject.UNIX
        )
        mapOs2SharedObject.forEach { OS, sharedObject ->
            assert(
                operatingSystemCoordinator.getOperationSystemSharedObjects(OS) == sharedObject
            ) { "$OS not as Expected :Retrieve ${operatingSystemCoordinator.getOperationSystemSharedObjects(OS)}" }
        }
    }
}
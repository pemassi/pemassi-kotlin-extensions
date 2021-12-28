package io.pemassi.kotlin.extensions.grammer

fun <T> tryOrDefault(defaultValue: T, f: () -> T): T {
    return try {
        f()
    } catch (e: Exception) {
        defaultValue
    }
}

fun tryOrIgnore(printException: Boolean = false, f: () -> Unit) {
    try
    {
        f()
    }
    catch(e: Exception)
    {
        e.printStackTrace()
    }
}
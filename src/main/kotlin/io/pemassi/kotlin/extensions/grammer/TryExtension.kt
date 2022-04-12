package io.pemassi.kotlin.extensions.grammer

fun <T> tryOrDefault(defaultValue: T, f: () -> T): T {
    return try {
        f()
    } catch (e: Throwable) {
        defaultValue
    }
}

fun tryOrIgnore(printException: Boolean = true, f: () -> Unit) {
    try
    {
        f()
    }
    catch(e: Throwable)
    {
        if(printException)
            e.printStackTrace()
    }
}
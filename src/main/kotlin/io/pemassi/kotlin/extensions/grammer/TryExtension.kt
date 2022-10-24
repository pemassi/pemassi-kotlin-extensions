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

inline fun <T, reified E: Throwable> catchOrDefault(default: T, f: () -> T): T {
    return try {
        f()
    }
    catch (e: Throwable)
    {
        when(e) {
            is E -> default
            else -> throw e
        }
    }
}

inline fun <T, reified E: Throwable> catchOrNull(f: () -> T): T? {
    return catchOrDefault<T?, E>(null, f)
}

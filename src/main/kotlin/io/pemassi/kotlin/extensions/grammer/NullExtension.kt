package io.pemassi.kotlin.extensions.grammer

/**
 * Check the object is null, if it is null will call handler
 * and then return self.
 */
inline fun <T> T?.guard(block: () -> Unit): T {
    if (this == null)
    {
        block()
        throw NullPointerException("The object is null (Guard).")
    }
    else
    {
        return this
    }
}

fun <T> T?.isNull(): Boolean = this == null
fun <T> T?.isNotNull(): Boolean = this != null
fun <T> T.asNullable(): T? = this

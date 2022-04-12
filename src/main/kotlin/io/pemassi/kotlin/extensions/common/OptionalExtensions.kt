package io.pemassi.kotlin.extensions.common

import java.util.*

/**
 * Convert Java's Optional object to Kotlin's Nullable object
 */
fun <T : Any> Optional<T>.toNullable(): T? = this.orElse(null)

/**
 * Convert Kotlin's Nullable object to Java's Optional object
 */
fun <T : Any> T?.toOptional(): Optional<T> = Optional.ofNullable(this)


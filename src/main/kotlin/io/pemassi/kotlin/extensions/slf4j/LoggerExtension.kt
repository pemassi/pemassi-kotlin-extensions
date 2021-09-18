package io.pemassi.kotlin.extensions.slf4j

import org.slf4j.Logger
import org.slf4j.LoggerFactory
import java.lang.invoke.MethodHandles

/**
 * Get logger with lazy
 *
 * Example : private val getLogger by getLogger()
 */
fun <R : Any> R.getLogger(): Lazy<Logger> {
    return lazy { LoggerFactory.getLogger(this.javaClass) }
}

/**
 * Get logger
 *
 * @param clazz default will be the class that call this method.
 */
fun getLogger(clazz: Class<*> = MethodHandles.lookup().lookupClass()): Logger {
    return LoggerFactory.getLogger(clazz)
}

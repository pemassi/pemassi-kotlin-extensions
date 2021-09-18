package io.pemassi.kotlin.extensions.common

import java.util.concurrent.CompletableFuture
import java.util.concurrent.ExecutionException
import java.util.concurrent.TimeUnit

fun <T: Any> CompletableFuture<T>.getResult(timeout: Long = 10, timeUnit: TimeUnit = TimeUnit.SECONDS) : T
{
    try
    {
        return this.get(timeout, timeUnit)
    }
    catch(e: ExecutionException)
    {
        throw e.cause ?: throw e
    }
}
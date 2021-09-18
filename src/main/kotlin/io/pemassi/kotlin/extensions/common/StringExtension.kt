package io.pemassi.kotlin.extensions.common

operator fun String.get(range: IntRange) : String
{
    return this.substring(range)
}

package io.pemassi.kotlin.extensions.common

import java.nio.charset.Charset
import java.security.MessageDigest

/**
 * Do hash with SHA256
 */
fun ByteArray.hashWithSHA256(): ByteArray = this.hash("SHA-256")

/**
 * Do hash with MD5
 */
fun ByteArray.hashWithMD5(): ByteArray = this.hash("MD5")

fun ByteArray.hash(algorithm: String): ByteArray = MessageDigest.getInstance(algorithm).digest(this)

fun ByteArray.hash(algorithm: String, provider: String): ByteArray = MessageDigest.getInstance(algorithm, provider).digest(this)

/**
 * Do hash with SHA256
 *
 * @param isUpperCase Default is true, if it is true, return upper case, otherwise, return lower case.
 * @return The result will be hex string.
 */
fun String.hashWithSHA256(
    charset: Charset = Charset.defaultCharset(),
    isUpperCase: Boolean = true,
): String = this.hash("SHA-256")

/**
 * Do hash with MD5
 * 
 * @param isUpperCase Default is true, if it is true, return upper case, otherwise, return lower case.
 * @return The result will be hex string.
 */
fun String.hashWithMD5(
    charset: Charset = Charset.defaultCharset(),
    isUpperCase: Boolean = true,
): String = this.hash("MD5")

fun String.hash(
    algorithm: String,
    charset: Charset = Charset.defaultCharset(),
    isUpperCase: Boolean = true,
): String = this.toByteArray(charset).hash(algorithm).encodeHexString(isUpperCase = isUpperCase)

fun String.hash(
    algorithm: String,
    provider: String,
    charset: Charset = Charset.defaultCharset(),
    isUpperCase: Boolean = true,
): String = this.toByteArray(charset).hash(algorithm, provider).encodeHexString(isUpperCase = isUpperCase)
package io.pemassi.kotlin.extensions.common

import java.security.InvalidParameterException
import kotlin.math.ceil
import kotlin.random.Random

operator fun String.get(range: IntRange) : String
{
    return this.substring(range)
}

/**
 * Generate random string with given [length] in [charPool]
 */
fun randomString(length: Int, charPool: List<Char> = ('a'..'z') + ('A'..'Z') + ('0'..'9')) : String
{
    return (1..length)
        .map { Random.nextInt(0, charPool.size) }
        .map(charPool::get)
        .joinToString("")
}

/**
 * Masking string with given [maskingChar]
 *
 * @param start start index
 * @param end end index
 * @param maskingChar masking character
 */
fun String.masking(start: Int = 0, end: Int = this.length, maskingChar: Char = '*') : String
{
    val builder = StringBuilder(this)
    for(i in start until end)
    {
        builder[i] = maskingChar
    }
    return builder.toString()
}

/**
 * Masking middle half string with given [maskingChar]
 *
 * ### Example
 * ``` kotlin
 * "" to ""
 * "1" to "*"
 * "12" to "1*"
 * "123" to "1*3"
 * "1234" to "1**4"
 * "12345" to "1***5"
 * "123456" to "1****6"
 * "1234567" to "1*****7"
 * "12345678" to "12****78"
 * ```
 */
fun String.middleHalfMasking(maskingChar: Char = '*') : String
{
    val length = this.length
    val start = when(length)
    {
        0, 1 -> 0
        2 -> 1
        else -> (length / 4).coerceAtLeast(1)
    }
    val end = when(length)
    {
        0, 1, 2 -> length
        else -> length - start
    }

    return this.masking(start, end, maskingChar)
}

/**
 * Masking last half string with given [maskingChar]
 *
 * ### Example
 * ``` kotlin
 * "" to ""
 * "1" to "*"
 * "12" to "1*"
 * "123" to "1**"
 * "1234" to "12**"
 * "12345" to "12***"
 * "123456" to "123***"
 * "1234567" to "123****"
 * "12345678" to "1234****"
 * ```
 */
fun String.lastHalfMasking(maskingChar: Char = '*') : String
{
    val length = this.length
    val start = length / 2
    val end = length

    return this.masking(start, end, maskingChar)
}

/**
 * Masking first half string with given [maskingChar]
 *
 * ### Example
 * ``` kotlin
 * "" to ""
 * "1" to "*"
 * "12" to "*2"
 * "123" to "**3"
 * "1234" to "**34"
 * "12345" to "***45"
 * "123456" to "***456"
 * "1234567" to "****567"
 * "12345678" to "****5678"
 * ```
 */
fun String.firstHalfMasking(maskingChar: Char = '*') : String
{
    val length = this.length
    val start = 0
    val end = ceil(length / 2.0).toInt()

    return this.masking(start, end, maskingChar)
}

/**
 * Masking middle of phone number with given [maskingChar]
 *
 * @throws InvalidParameterException if [this] is not followed South Korea phone number format.
 *
 * ### Example
 * ``` kotlin
 * "01012345678" to "010****5678"
 * "0101234567" to "010***4567"
 * "010-1234-5678" to "010-****-5678"
 * "010-123-4567" to "010-***-4567"
 * "+82-10-1234-5678" to "+82-10-****-5678"
 * "+82-10-123-4567" to "+82-10-***-4567"
 * ```
 */
fun String.middleKoreaPhoneNumberMasking(maskingChar: Char = '*') : String
{
    //With dash
    Regex("^(\\+\\d{2}-)?(\\d{2,3})-(\\d{3,4})-(\\d{4})$").find(this)?.let {
        val (countryCode, first, middle, last) = it.destructured
        return "$countryCode$first-${middle.masking()}-$last"
    }

    //Without dash
    Regex("^(\\+\\d{2})?(\\d+)$").find(this)?.let {
        val (countryCode, number) = it.destructured
        val maskedNumber= if(countryCode.isBlank())
        {
            if(number.length == 11)
            {
                number.masking(3, 7, maskingChar)
            }
            else
            {
                number.masking(3, 6, maskingChar)
            }
        }
        else
        {
            if(number.length == 10)
            {
                number.masking(2, 6, maskingChar)
            }
            else
            {
                number.masking(2, 5, maskingChar)
            }
        }

        return "$countryCode$maskedNumber"
    }

    throw InvalidParameterException("Invalid phone number format.")
}

package io.pemassi.kotlin.extensions.common

/**
 * Encode to upper case hex string.
 *
 *
 * @param isUpperCase Default is true, if it is true, return upper case, otherwise, return lower case.
 */
fun ByteArray.encodeHexString(
    isUpperCase: Boolean = true
) = byteArrayToHexString(this, if(isUpperCase) upperHexArray else lowerHexArray)

/**
 * Decode hex string to byte array.
 *
 * This method does not care case.
 */
fun String.decodeHex() = hexStringToByteArray(this)

/**
 * Encode to signed 4 bytes array.
 */
fun Int.encodeByteArray() = byteArrayOf(
    (this shr 24).toByte(),
    (this shr 16).toByte(),
    (this shr 8).toByte(),
    this.toByte()
)

/**
 *
 * @param isUpperCase Default is true, if it is true, return upper case, otherwise, return lower case.
 */
fun Int.encodeHexString(
    isUpperCase: Boolean = true
) = this.encodeByteArray().encodeHexString(isUpperCase = isUpperCase)

/**
 * Encode to unsigned 4 bytes array.
 */
fun UInt.encodeByteArray() = byteArrayOf(
    (this shr 24).toByte(),
    (this shr 16).toByte(),
    (this shr 8).toByte(),
    this.toByte()
)

/**
 *
 * @param isUpperCase Default is true, if it is true, return upper case, otherwise, return lower case.
 */
fun UInt.encodeHexString(
    isUpperCase: Boolean = true
) = this.encodeByteArray().encodeHexString(isUpperCase = isUpperCase)

/**
 * 
 * @param isUnsigned Default is ture
 */
fun ByteArray.decodeInt(isUnsigned: Boolean = true): Int
{
    return if(isUnsigned)
        this.decodeUnsignedInt().toInt()
    else
        this.decodeSignedInt()
}

fun ByteArray.decodeUnsignedInt() =
    ((this[0].toUInt() and 0xFFu) shl 24) or
    ((this[1].toUInt() and 0xFFu) shl 16) or
    ((this[2].toUInt() and 0xFFu) shl 8) or
    (this[3].toUInt() and 0xFFu)

fun ByteArray.decodeSignedInt() =
    ((this[0].toInt() and 0xFF) shl 24) or
    ((this[1].toInt() and 0xFF) shl 16) or
    ((this[2].toInt() and 0xFF) shl 8) or
    (this[3].toInt() and 0xFF)


private val upperHexArray = "0123456789ABCDEF".toCharArray()
private val lowerHexArray = "0123456789abcdef".toCharArray()
private fun byteArrayToHexString(bytes: ByteArray, map: CharArray): String
{
    val hexChars = CharArray(bytes.size * 2)
    for (j in bytes.indices)
    {
        val v: Int = bytes[j].toInt() and 0xFF
        hexChars[j * 2] = map[v ushr 4]
        hexChars[j * 2 + 1] = map[v and 0x0F]
    }
    return String(hexChars)
}

private fun hexStringToByteArray(str: String): ByteArray {
    check(str.length % 2 == 0) { "Must have an even length" }

    val temp = ByteArray(str.length / 2)
    for(i in str.indices step 2)
    {
        temp[i / 2] = (
                (str[i].digitToInt(16) shl 4) + (str[i + 1].digitToInt(16))
        ).toByte()
    }
    return temp
}
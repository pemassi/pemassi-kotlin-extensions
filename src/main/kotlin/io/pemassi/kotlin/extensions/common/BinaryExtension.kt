package io.pemassi.kotlin.extensions.common

private val hexToBCDMap = hashMapOf(
    "0" to "0000",
    "1" to "0001",
    "2" to "0010",
    "3" to "0011",
    "4" to "0100",
    "5" to "0101",
    "6" to "0110",
    "7" to "0111",
    "8" to "1000",
    "9" to "1001",
    "A" to "1010",
    "B" to "1011",
    "C" to "1100",
    "D" to "1101",
    "E" to "1110",
    "F" to "1111",
    "a" to "1010",
    "b" to "1011",
    "c" to "1100",
    "d" to "1101",
    "e" to "1110",
    "f" to "1111"
)

fun String.encodeBinaryString(): String
{
    val buffer = StringBuffer()
    for(c in this)
    {
        buffer.append(hexToBCDMap[c.toString()])
    }
    return buffer.toString()
}
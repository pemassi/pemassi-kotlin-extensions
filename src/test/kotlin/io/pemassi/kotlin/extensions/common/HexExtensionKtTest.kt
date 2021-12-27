package io.pemassi.kotlin.extensions.common

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class HexExtensionKtTest
{
    @Test
    fun `Hex String to Byte Array`()
    {
        val case = "12341234"
        val actual = byteArrayOf(0x12, 0x34, 0x12, 0x34)

        assertArrayEquals(case.decodeHex(), actual)
    }
}
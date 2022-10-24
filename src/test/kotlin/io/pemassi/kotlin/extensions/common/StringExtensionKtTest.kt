package io.pemassi.kotlin.extensions.common

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class StringExtensionKtTest
{
    @Test
    fun `Middle Half Masking`()
    {
        // When
        val cases = arrayListOf(
            "" to "",
            "1" to "*",
            "12" to "1*",
            "123" to "1*3",
            "1234" to "1**4",
            "12345" to "1***5",
            "123456" to "1****6",
            "1234567" to "1*****7",
            "12345678" to "12****78",
            "테스트" to "테*트"
        )

        // Then
        cases.forEach {
            assertEquals(it.second, it.first.middleHalfMasking())
        }
    }

    @Test
    fun `Last Half Masking`()
    {
        // When
        val cases = arrayListOf(
            "" to "",
            "1" to "*",
            "12" to "1*",
            "123" to "1**",
            "1234" to "12**",
            "12345" to "12***",
            "123456" to "123***",
            "1234567" to "123****",
            "12345678" to "1234****",
            "테스트" to "테**"
        )

        // Then
        cases.forEach {
            assertEquals(it.second, it.first.lastHalfMasking())
        }
    }

    @Test
    fun `First Half Masking`()
    {
        // When
        val cases = arrayListOf(
            "" to "",
            "1" to "*",
            "12" to "*2",
            "123" to "**3",
            "1234" to "**34",
            "12345" to "***45",
            "123456" to "***456",
            "1234567" to "****567",
            "12345678" to "****5678",
            "테스트" to "**트"
        )

        // Then
        cases.forEach {
            assertEquals(it.second, it.first.firstHalfMasking())
        }
    }

    @Test
    fun `Middle of Korea Phone Number Masking`()
    {
        // When
        val cases = arrayListOf(
            "010-1234-5678" to "010-****-5678",
            "010-123-4567" to "010-***-4567",
            "+82-10-1234-5678" to "+82-10-****-5678",
            "+82-10-123-4567" to "+82-10-***-4567",
            "01012345678" to "010****5678",
            "0101234567" to "010***4567",
            "+821012345678" to "+8210****5678",
            "+82101234567" to "+8210***4567",
        )

        // Then
        cases.forEach {
            assertEquals(it.second, it.first.middleKoreaPhoneNumberMasking())
        }
    }
}

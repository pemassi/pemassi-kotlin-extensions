package io.pemassi.kotlin.extensions.common

import java.nio.charset.Charset

val Charsets.EUC_KR: Charset
    get() = Charset.forName("EUC-KR")
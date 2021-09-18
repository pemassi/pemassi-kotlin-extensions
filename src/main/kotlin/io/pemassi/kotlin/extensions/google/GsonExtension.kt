package io.pemassi.kotlin.extensions.google

import com.google.gson.Gson
import com.google.gson.GsonBuilder

val globalGson: Gson by lazy {
    Gson()
}

val globalPrettyGson: Gson by lazy {
    GsonBuilder().setPrettyPrinting().create()
}

fun <R : Any> R.toJson(): String {
    return globalGson.toJson(this)
}

inline fun <reified T> String.fromJson(): T {
    return globalGson.fromJson(this, T::class.java)
}
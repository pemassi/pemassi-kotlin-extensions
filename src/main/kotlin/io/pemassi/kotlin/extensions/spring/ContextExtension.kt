package io.pemassi.kotlin.extensions.spring

import org.springframework.context.ApplicationContext
import kotlin.reflect.KClass

fun <T : Any> ApplicationContext.getBean(requiredType: KClass<T>): T = this.getBean(requiredType.java)
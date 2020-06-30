package nl.vorhauer.scakot

import scala.collection.immutable.List
import scala.collection.immutable.`List$`

inline fun <reified T> emptyList(): List<T> = `List$`.`MODULE$`.empty()
inline fun <reified T> list(vararg t: T): List<T> = list(t.asList())
inline fun <reified T> list(l: kotlin.collections.List<T>): List<T> = l.fold(emptyList()) { acc, t -> acc.`$colon$colon`(t) }

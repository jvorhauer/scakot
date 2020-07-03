package nl.vorhauer.scakot

import scala.Option
import scala.Tuple2
import scala.collection.immutable.List
import scala.collection.immutable.Set
import scala.collection.mutable.Map
import scala.jdk.javaapi.CollectionConverters
import kotlin.collections.List as KList
import kotlin.collections.Set as KSet

inline fun <reified T> list(): List<T>               = list(emptyList())
inline fun <reified T> list(i: Iterator<T>): List<T> = CollectionConverters.asScala(i).toList()
inline fun <reified T> list(vararg t: T): List<T>    = list(t.iterator())
inline fun <reified T> list(l: KList<T>): List<T>    = CollectionConverters.asScala(l).toList()

fun <T> List<T>.get(i: Int): Option<T> = if (i < this.size()) some(this.apply(i)) else none()

inline fun <reified T> set(): Set<T> = set(emptyList<T>().iterator())
inline fun <reified T> set(i: Iterator<T>): Set<T> = CollectionConverters.asScala(i).toSet()
inline fun <reified T> set(vararg t: T): Set<T> = set(t.iterator()).toSet()
inline fun <reified T> set(s: KSet<T>): Set<T> = CollectionConverters.asScala(s).toSet()

inline fun <reified K, V> map(m: kotlin.collections.Map<K, V>): Map<K, V> = CollectionConverters.asScala(m)
inline fun <reified K, V> map(): Map<K, V> = map(emptyMap())
inline fun <reified K, V> map(vararg pairs: Pair<K, V>): Map<K, V> = map(mapOf(*pairs))
inline fun <reified K, V> map(vararg tuples: Tuple2<K, V>): Map<K, V> = map(tuples.map { it._1 to it._2 }.toMap())

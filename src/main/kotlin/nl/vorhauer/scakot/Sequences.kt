package nl.vorhauer.scakot

import scala.collection.immutable.Seq
import scala.jdk.javaapi.CollectionConverters

inline fun <reified T> seq(): Seq<T>               = seq(emptyList<T>().iterator())
inline fun <reified T> seq(i: Iterator<T>): Seq<T> = CollectionConverters.asScala(i).toSeq()
inline fun <reified T> seq(vararg t: T): Seq<T>    = seq(t.iterator())
inline fun <reified T> seq(s: Sequence<T>): Seq<T> = seq(s.iterator())

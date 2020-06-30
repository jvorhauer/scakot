package nl.vorhauer.scakot

import scala.Tuple1
import scala.Tuple2
import scala.Tuple3

fun <T> tuple(t: T): Tuple1<T> = Tuple1(t)
fun <T1, T2> tuple(t1: T1, t2: T2): Tuple2<T1, T2> = Tuple2(t1, t2)
fun <T1, T2, T3> tuple(t1: T1, t2: T2, t3: T3): Tuple3<T1, T2, T3> = Tuple3(t1, t2, t3)

fun <T1, T2> Pair<T1, T2>.tuple(): Tuple2<T1, T2> = tuple(this.first, this.second)
fun <T1, T2> Tuple2<T1, T2>.pair(): Pair<T1, T2> = Pair(this._1, this._2)

operator fun <T1, T2> Tuple2<T1, T2>.component1(): T1 = this._1
operator fun <T1, T2> Tuple2<T1, T2>.component2(): T2 = this._2

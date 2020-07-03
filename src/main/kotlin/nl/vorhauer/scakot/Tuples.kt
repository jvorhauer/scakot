package nl.vorhauer.scakot

import scala.Tuple1
import scala.Tuple2
import scala.Tuple3
import scala.Tuple4
import scala.Tuple5
import scala.Tuple6

fun <T> tuple(t: T): Tuple1<T> = Tuple1(t)

fun <T1, T2> tuple(t1: T1, t2: T2) = Tuple2(t1, t2)
fun <T1, T2, T3> tuple(t1: T1, t2: T2, t3: T3) = Tuple3(t1, t2, t3)
fun <T1, T2, T3, T4> tuple(t1: T1, t2: T2, t3: T3, t4: T4) = Tuple4(t1, t2, t3, t4)
fun <T1, T2, T3, T4, T5> tuple(t1: T1, t2: T2, t3: T3, t4: T4, t5: T5) = Tuple5(t1, t2, t3, t4, t5)

fun <T1, T2> Pair<T1, T2>.tuple(): Tuple2<T1, T2> = tuple(this.first, this.second)
fun <T1, T2> Tuple2<T1, T2>.pair(): Pair<T1, T2> = Pair(this._1, this._2)


operator fun <T> Tuple1<T>.component1(): T = this._1

operator fun <T1, T2> Tuple2<T1, T2>.component1(): T1 = this._1
operator fun <T1, T2> Tuple2<T1, T2>.component2(): T2 = this._2

operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component1(): T1 = this._1()
operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component2(): T2 = this._2()
operator fun <T1, T2, T3> Tuple3<T1, T2, T3>.component3(): T3 = this._3()

operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component1(): T1 = this._1()
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component2(): T2 = this._2()
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component3(): T3 = this._3()
operator fun <T1, T2, T3, T4> Tuple4<T1, T2, T3, T4>.component4(): T4 = this._4()

operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component1(): T1 = this._1()
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component2(): T2 = this._2()
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component3(): T3 = this._3()
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component4(): T4 = this._4()
operator fun <T1, T2, T3, T4, T5> Tuple5<T1, T2, T3, T4, T5>.component5(): T5 = this._5()

operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component1(): T1 = this._1()
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component2(): T2 = this._2()
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component3(): T3 = this._3()
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component4(): T4 = this._4()
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component5(): T5 = this._5()
operator fun <T1, T2, T3, T4, T5, T6> Tuple6<T1, T2, T3, T4, T5, T6>.component6(): T6 = this._6()

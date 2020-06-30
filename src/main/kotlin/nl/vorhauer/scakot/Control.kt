package nl.vorhauer.scakot

import scala.Option
import scala.Some
import scala.util.Either
import scala.util.Failure
import scala.util.Left
import scala.util.Right
import scala.util.Success
import scala.util.Try
import java.util.*

fun <A> A?.option(): Option<A> = if (this == null) none() else some(this)
fun <A> Optional<A>.option(): Option<A> = if (this.isPresent) some(this.get()) else none()
fun <A> none(): Option<A> = Option.empty()
fun <A> some(a: A): Option<A> = Some(a)

fun <A, B> left(a: A): Either<A, B> = Left(a)
fun <A, B> right(b: B): Either<A, B> = Right(b)

fun <A> Try(f: () -> A): Try<A> = Try.apply(f)
fun <A> success(a: A): Try<A> = Success.apply(a)
fun <A> failure(e: Exception): Try<A> = Failure.apply(e)

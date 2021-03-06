# scakot

Make Scala List, Set, Map, Option, Either, Try and Tuples a bit more usable from Kotlin.

![Build](https://github.com/jvorhauer/scakot/workflows/Build/badge.svg)

Inspired by (actually: stolen from) [vavr-kotlin](https://github.com/vavr-io/vavr-kotlin). 
[Vavr](https://www.vavr.io/) is really great, but if your
project is already depending on the Scala standard library, then Vavr duplicates a lot of stuff already on the classpath.

My specific case here is the usage of Akka Persistence in a Kotlin project. I noticed that a lot of IntelliJ suggestions included
classes and objects from the Scala standard library and I started experimenting with replacing Vavr stuff with Scala equivalents.

The *real* reason for this project is that I miss Scala when I'm forced to use Java or Kotlin. The latter is way better than
Java, even with Lombok and Vavr, but still leaves much to be desired. To introduce Scala in a company that is scared of 
switching to Scala, this project and Akka (as an example) can start the awareness of the awesomeness of Scala :-) 

## Scala Library in any JVM language?

With the amount of effort going in to maintaining and improving the Scala standard library, the quality will have to 
be outstanding! 

Another reason I would love to have Scala Lib everywhere: from a functional perspective the Scala standard lib is very
complete and feels more familiair from the more accepted naming conventions, like in Haskell. 

## Kotest

An absolute eye-opener was me stumbling on [Kotest](https://github.com/kotest/kotest), 
which brings a lot of goodies from [ScalaTest](https://www.scalatest.org/) to Kotlin!

package nl.vorhauer.scakot

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import scala.collection.Seq

class SequencesTest : WordSpec() {
  init {
    "A Sequence" should {
      "support creating empty" {
        val s: Seq<String> = seq()
        s.isEmpty shouldBe true
      }

      "convert from Kotlin" {
        val s : Sequence<String> = sequenceOf("One", "Two", "Three")
        val ss: Seq<String> = seq(s)
        ss.size() shouldBe 3
      }

      "create one from varargs" {
        val s = seq("One", "Two", "Three")
        s.size() shouldBe 3
        s.isEmpty shouldBe false
        s.apply(0) shouldBe "One"
        s.apply(1) shouldBe "Two"
        s.apply(2) shouldBe "Three"
      }
    }
  }
}

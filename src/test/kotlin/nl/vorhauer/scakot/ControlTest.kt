package nl.vorhauer.scakot

import io.kotest.core.spec.style.WordSpec
import io.kotest.matchers.shouldBe
import io.kotest.matchers.shouldNotBe
import scala.Option
import scala.Some
import scala.util.Either
import java.util.*

class ControlTest : WordSpec() {

  init {
    "Option" should {
      "have 'some'" {
        val oa: Option<String> = some("Hallo")
        oa.isDefined shouldBe true
        oa.map { "$it, World" } shouldBe Some("Hallo, World")
      }

      "have 'none'" {
        val oe: Option<String> = none()
        oe.isDefined shouldBe false
        oe.map { "$it, Emptiness" } shouldBe none<String>()
      }

      "not be bothered by null" {
        val na: Any? = null
        na.option() shouldNotBe null
        na.option().isEmpty shouldBe true
      }

      "handle optional correctly" {
        val o = Optional.of("Maybe")
        o.option() shouldBe Some("Maybe")
      }
    }

    "Either" should {
      "handle Left" {
        val el: Either<String, Any> = left("Left")
        el.isLeft shouldBe true
        el.toSeq().size() shouldBe 0
        el.toOption() shouldBe none<String>()
      }

      "handle Right" {
        val er: Either<Any, String> = right("Right")
        er.isRight shouldBe true
        er.toSeq().size() shouldBe 1
        er.toOption() shouldBe some("Right")
      }
    }

    "Try" should {
      "handle Failure" {
        val t = Try { boomer() }
        t.isFailure shouldBe true

        failure<Nothing>(RuntimeException("Failure")).isFailure shouldBe true

        val e = t.toEither()
        e.isLeft shouldBe true
      }

      "handle Success" {
        success("Success!").isSuccess shouldBe true
        success("Success!").get() shouldBe "Success!"
      }
    }
  }

  private fun boomer(): Nothing = throw RuntimeException("boom!")
}

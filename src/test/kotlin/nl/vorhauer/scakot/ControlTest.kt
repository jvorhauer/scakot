package nl.vorhauer.scakot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import scala.Option
import scala.Some
import scala.util.Either
import java.util.*

class ControlTest {
  @Test
  fun optionTest() {
    val oa: Option<String> = some("Hello")
    val oe: Option<String> = none()

    assertThat(oa.isDefined).isTrue()
    assertThat(oe.isEmpty).isTrue()

    assertThat(oa.map { "$it, World" }).isEqualTo(Some("Hello, World"))
    assertThat(oe.map { "$it, Emptiness"}).isEqualTo(none<String>())

    val na: Any? = null
    assertThat(na.option()).isNotNull()
    assertThat(na.option().isEmpty).isTrue()

    val opta = Optional.of("Maybe")
    assertThat(opta.option().isEmpty).isFalse()
  }

  @Test
  fun eitherTest() {
    val er: Either<Any, String> = right("Hello")
    assertThat(er).isNotNull()
    assertThat(er.isLeft).isFalse()
    assertThat(er.toSeq().size()).isEqualTo(1)

    val el: Either<String, Any> = left("Bye")
    assertThat(el).isNotNull()
    assertThat(el.isLeft).isTrue()
  }

  @Test
  fun tryTest() {
    val t = Try { boomer() }
    assertThat(t).isNotNull()
    assertThat(t.isFailure).isTrue()

    assertThat(success("Success!").isSuccess).isTrue()
    assertThat(failure<Nothing>(RuntimeException("fail")).isFailure).isTrue()

    val e = t.toEither()
    assertThat(e.isLeft).isTrue()
    assertThat(e.toSeq().size()).isEqualTo(0)

    assertThat(success("Yes!").toEither().isLeft).isFalse()
  }

  private fun boomer(): Nothing = throw RuntimeException("boom!")
}

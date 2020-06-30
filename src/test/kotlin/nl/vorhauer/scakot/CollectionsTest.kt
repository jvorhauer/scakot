package nl.vorhauer.scakot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import scala.collection.immutable.List
import scala.collection.immutable.`List$`

class CollectionsTest {
  @Test
  fun listTest() {
    val l: List<String> = `List$`.`MODULE$`.empty()
    val ll = l.`$colon$colon`("Een")
    assertThat(ll.size()).isEqualTo(1)

    val empty: List<String> = `List$`.`MODULE$`.empty()
    assertThat(empty.size()).isEqualTo(0)

    val strs = listOf("Een", "Twee")
    assertThat(strs.size).isEqualTo(2)

    val res = strs.fold(empty) { acc, s -> acc.`$colon$colon`(s) }
    assertThat(res.size()).isEqualTo(2)

    val lll = list("One", "Two", "Three")
    assertThat(lll.size()).isEqualTo(3)

    val el = emptyList<Any>()
    assertThat(el.size()).isEqualTo(0)
  }

}

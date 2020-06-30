package nl.vorhauer.scakot

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class TuplesTest {
  @Test
  fun tuple1Test() {
    val t1 = tuple("Hi")
    assertThat(t1._1).isEqualTo("Hi")
    assertThat(t1.productElement(0)).isEqualTo("Hi")
    assertThat(t1.productArity()).isEqualTo(1)
    assertThat(t1.productElementName(0)).isEqualTo("_1")
  }

  @Test
  fun tuple2Test() {
    val t2 = tuple("String", 42)
    assertThat(t2._1).isEqualTo("String")
    assertThat(t2._2).isEqualTo(42)

    val p = t2.pair()
    assertThat(p.first).isEqualTo("String")
    assertThat(p.second).isEqualTo(42)

    val (v1, v2) = t2
    assertThat(v1).isEqualTo("String")
    assertThat(v2).isEqualTo(42)

    val pt = Pair(43, "Integer").tuple()
    assertThat(pt._1).isEqualTo(43)
    assertThat(pt._2).isEqualTo("Integer")

    val ts = pt.swap()
    val (x1, x2) = ts
    assertThat(x1).isEqualTo("Integer")
  }
}

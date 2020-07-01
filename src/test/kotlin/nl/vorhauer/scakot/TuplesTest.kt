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
    assertThat(x2).isEqualTo(43)
  }

  @Test
  fun tuple3Test() {
    val t3 = tuple("String", 42, false)
    assertThat(t3._1()).isEqualTo("String")
    assertThat(t3._2()).isEqualTo(42)
    assertThat(t3._3()).isEqualTo(false)

    val (v1, v2, v3) = t3
    assertThat(v1).isEqualTo("String")
    assertThat(v2).isEqualTo(42)
    assertThat(v3).isEqualTo(false)
  }


  @Test
  fun tuple4Test() {
    val t4 = tuple("String", 42, false, 5.4)
    assertThat(t4._1()).isEqualTo("String")
    assertThat(t4._2()).isEqualTo(42)
    assertThat(t4._3()).isEqualTo(false)
    assertThat(t4._4()).isEqualTo(5.4)

    val (v1, v2, v3, v4) = t4
    assertThat(v1).isEqualTo("String")
    assertThat(v2).isEqualTo(42)
    assertThat(v3).isEqualTo(false)
    assertThat(v4).isEqualTo(5.4)
  }
}

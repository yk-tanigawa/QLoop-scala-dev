import org.scalatest.FunSuite


/**
  * Created by yosuke on 5/6/16.
  */
class FeatureTest extends FunSuite {
  /**
    * Feature class counts k-mer frequency of a given sequence
    */

  def compOptAry(a1: Option[Array[Int]], a2: Option[Array[Int]]): Boolean ={

    def compAry(ary1: Array[Int], ary2: Array[Int]) : Boolean= {
      ary1.sameElements(ary2)
    }

    (a1, a2) match {
      case (Some(ary1), Some(ary2)) =>
        compAry(ary1, ary2);
      case (None, None) =>
        true;
      case _ =>
        false;
    }
  }


  test("If the sequence contains N, it returns None") {

    val seq1 = "NNNNN"
    val seq2 = "nnnnn"

    val f1 = new Feature(seq1, 5)
    val f2 = new Feature(seq2, 5)

    assert(f1.f.isEmpty)
    assert(f2.f.isEmpty)
  }

  test("It counts k-mer frequency of a given sequence") {

    val seq1 = "AAAAA"

    val f1 = new Feature(seq1, 1)
    val a1 = Some(Array(5, 0, 0, 0))
    assert(compOptAry(a1, f1.f))

    val f2 = new Feature(seq1, 2)
    val a2 = Some(Array(4, 0, 0, 0,
                        0, 0, 0, 0,
                        0, 0, 0, 0,
                        0, 0, 0, 0))
    assert(compOptAry(a2, f2.f))

  }

}

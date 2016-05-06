import org.scalatest.FunSuite


/**
  * Created by yosuke on 5/6/16.
  */
class FastaTest extends FunSuite {
  test("Fasta class reads a fasta file") {
    val testFasta = "data/n450.fasta"

    val fasta = new Fasta(testFasta)

    assert(fasta.toStr == "N" * 450)
    assert(fasta.head == "N450")
    assert(fasta.len == 450)
  }
}

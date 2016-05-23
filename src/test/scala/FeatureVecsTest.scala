import org.scalatest.FunSuite

/**
  * Created by yosuke on 5/23/16.
  */
class FeatureVecsTest extends FunSuite {
  test("Fasta class reads a fasta file") {

    val FastaFile = "data/n450.fasta"
    val res = 1
    val k = 1
    val mar = 1

    val fv = new FeatureVecs (FastaFile, res, k, mar)

    println(fv.count(2))
    //println(fv.count(2).f)
    assert(fv.size == 450)
  }
}

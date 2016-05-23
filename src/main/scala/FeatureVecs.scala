/**
  * Created by yosuke on 5/23/16.
  */
class FeatureVecs (FastaFile : String, res : Int, k : Int, mar : Int) {

  def size = count.size

  private val fasta = new Fasta(FastaFile)

  private val f_select_bin ={
    /**
      * Function that checks if the index of bin is valid
      */
    (fastaLen : Int, res: Int, mar : Int, index : Int) =>
      if((mar <= index * res) &&
        ((index + 1) * res + mar + k - 1 < fastaLen)){
        Some(index)
      }else{
        None
      }
  }.curried

  private val f_kmer_freq = {
    /**
      * Function that computes k-mer frequency of a given bin.
      * Args:
      *  - res   : resolution of bin
      *  - k     : size of k-mer
      *  - mar   : overlapping margin of the bin
      *  - seq   : Nucleotide sequence
      *  - index : index that specifies a bin
      */
    (res: Int, k: Int, mar:Int, seq:String, index : Option[Int]) =>
      index match {
        case Some(i) =>
          new Feature (seq slice (i * res - mar, (i + 1) * res + k - 1 + mar), k);
        case _ =>
          None
      }
  }.curried




  val count = (0 until fasta.n_bins(res)).map(f_select_bin(fasta.len)(res)(mar)).map(f_kmer_freq(res)(k)(mar)(fasta.toStr))

  /**
    *

  val count_sum = count.reduce((x, y) => {
    (x, y) match {
      case (None, None) =>
    }
  }
    */

}

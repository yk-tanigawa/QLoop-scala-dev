import java.io.{BufferedReader, FileReader}


/**
  * Created by yosuke on 5/6/16.
  */


object QLoop {
  val progName = "QLoop"
  val version = "0.01"

  def showInfo(): Unit ={
    println(progName)
  }

  def main(args: Array[String]) {
    showInfo()


    /**
      * Configure parameters
      */

    val FastaFile = "data/n450.fasta"
    val res = 1
    val k = 1
    val mar = 1


    val fasta = new Fasta(FastaFile)



    val f_kmer_freq = {
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

    val f_select_bin ={
      /**
        * select bins
        */
      (fastaLen : Int, res: Int, mar : Int, index : Int) =>
        if((mar <= index * res) &&
          ((index + 1) * res + mar < fastaLen)){
          Some(index)
        }else{
          None
        }
    }.curried




    val vs = (0 until fasta.len).map(f_select_bin(fasta.len)(res)(mar)).map(f_kmer_freq(res)(k)(mar)(fasta.toStr))

    print(vs.size)
  }

}

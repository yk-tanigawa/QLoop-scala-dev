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


    val testFasta = "data/n450.fasta"

    val fasta = new Fasta(testFasta)

    val f = new Feature(fasta.toStr, 5)
    println(f.f)


    val res = 1
    val k = 1
    val mar = 1

    val f_kmer_freq = {
      (res: Int, k: Int, mar:Int, seq:String, i : Int) =>
        new Feature(seq slice (i * res - mar, (i + 1) * res + k - 1 + mar), k)
    }.curried



    val vs = (1 until fasta.len - 1).map(f_kmer_freq(res)(k)(mar)(fasta.toStr))


    print(vs)
  }

}

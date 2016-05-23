import java.io.{BufferedReader, FileReader}

/**
  * Created by yosuke on 5/6/16.
  *
  * This class reads a fasta file
  *
  */
class Fasta(file : String){

  def toStr: String ={
    sequence.result
  }

  def head: String = header

  def len: Int = toStr.length

  def n_bins(res : Int): Int = len / res

  private def open[U](fileName:String)(body:Iterator[String] => U) {
    val in = new BufferedReader(new FileReader(fileName))
    try
      body(new LineIterator(in))
    finally
      in.close()
  }

  private val sequence = new StringBuilder
  private var header = ""

  open(file) { f =>
    for(line <- f) {
      if(line(0) == '>'){
        header = line drop 1
      }else {
        sequence.append(line)
      }
    }
  }

}
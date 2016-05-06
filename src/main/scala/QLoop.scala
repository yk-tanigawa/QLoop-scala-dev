import java.io.{BufferedReader, FileReader}


/**
  * Created by yosuke on 5/6/16.
  */


object QLoop {
  val progName = "QLoop"
  val version = "1.0"

  def showInfo(): Unit ={
    println(progName)
  }

  def main(args: Array[String]) {
    showInfo()


    val testFasta = "data/n450.fasta"

    val fasta = new Fasta(testFasta)


    val f = new Feature(fasta.toStr, 5)

    println(f.f)

    val g = new Feature("AAAAA", 5)

    println(g.f)
  }

}

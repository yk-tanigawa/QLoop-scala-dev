import java.io.{BufferedReader, FileReader}

/**
  * Created by yosuke on 5/6/16.
  */

class LineIterator(in:BufferedReader) extends Iterator[String] {
  /**
    * This class provides an iterator to read a text file
    */

  private var nextLine : String = null
  def hasNext = {
    if(nextLine == null)
      nextLine = in.readLine
    nextLine != null
  }
  def next : String = {
    if(hasNext) {
      val line = nextLine
      nextLine = null
      line
    }
    else
      Iterator.empty.next
  }
}

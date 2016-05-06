/**
  * Created by yosuke on 5/6/16.
  */
class Feature (seq: String, k: Int) {

  val c2i = Map('A' -> 0, 'C' -> 1, 'G' -> 2, 'T' -> 3,
                'a' -> 0, 'c' -> 1, 'g' -> 2, 't' -> 3)

  def freqCount(seq: String, k: Int) = {
    if(seq.contains('N') || seq.contains('n')){
      None
    }else{
      val kmer_mask = (1 << (2 * k)) - 1

      val c = new Array[Int](1 << (2 * k))
      var kmer = 0

      for(i <- 0 until (k - 1)){
        kmer <<= 2
        kmer += c2i(seq(i))
      }
      for(i <- (k - 1) until seq.length){
        kmer <<= 2
        kmer = kmer & kmer_mask
        kmer += c2i(seq(i))
        c(kmer) += 1
      }

      Some(c)
    }
  }


  val f = freqCount(seq, k)
}

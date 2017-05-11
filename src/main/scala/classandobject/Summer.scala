package classandobject

/**
 * Created by weizy on 2017/5/11.
 */
import  ChecksumAccumulator.calculate
object Summer {
  def main(args: Array[String]) {
    for (arg <- args)
      println(arg + " : " + calculate(arg))
  }
}

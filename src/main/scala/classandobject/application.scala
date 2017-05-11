package classandobject

/**
 * Created by weizy on 2017/5/11.
 *
 * App 特质 : xx extends App, 当main方法使用
 */
import ChecksumAccumulator.calculate
object application extends App{
  for (season <- List("1", "2"))
    println(season + ": " + calculate(season))
}

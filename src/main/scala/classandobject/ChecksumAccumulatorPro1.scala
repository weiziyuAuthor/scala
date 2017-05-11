package classandobject

/**
 * Created by weizy on 2017/5/11.
 *
 * 某个方法仅计算单个结果表达式， 则可以去掉大括号
 */
class ChecksumAccumulatorPro1 {

  private var sum = 0

  def add(b:Byte) :Unit = sum += b

  def checksum() :Int = ~(sum & 0xFF) + 1
}

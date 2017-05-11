package classandobject

/**
 * Created by weizy on 2017/5/11.
 */
class ChecksumAccumulatorPro2 {

  private var sum = 0

  //带有大括号但没有等号，本质上当作是显式定义结果类型为Unit的方法
  def add(b:Byte){sum += b}

  def checksum() :Int = ~(sum & 0xFF) + 1
}

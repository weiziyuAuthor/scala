package classandobject

/**
 * Created by weizy on 2017/5/11.
 */


class ChecksumAccumulator {

  private var sum = 0

  def add(b:Byte) :Unit ={
//    b += 1 编译不过, 因为b是val, 方法参数一个重要特征是他们都是val
    sum += b
  }

  def checksum() :Int = {
    return ~(sum & 0xFF) + 1
  }
}

/*
Scala比java更面向对象的一个方面是Scala没有静态成员
Scala有单例对象: singleton object。除object关键字以外，单例对象的定义看上去就像是类定义
当单例对象与某个类共享同一个名称时，他被称为这个类的伴生对象: companion object
    必须在同一个源文件里定义类和它的伴生对象，类和伴生对象可以互相访问其私有成员

如果只是ChecksumAccumulator对象的定义，就建立不了ChecksumAccumulator类型的变量。即：ChecksumAccumulator类型是由单例对象的伴生类定义的

单例对象不带参数，而类可以。不能用new关键字实例化一个单例对象，所以没有机会传递给它参数

不与伴生类共享名称的单例对象被称为孤立对象:standalone object

Scala隐式引用了包java.lang和scala的成员，和名为Predef的单例对象的成员，到每个Scala源文件中
 */
import scala.collection.mutable.Map
object ChecksumAccumulator{

  private val cache = Map[String, Int]()

  def calculate(s: String) : Int = {
    if (cache.contains(s))
      cache(s)
    else{
      val acc = new ChecksumAccumulator
      for (c <- s)
          acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)

      cs
    }
  }
//  def main(args: Array[String]) {
//    println("hi");
//  }
}
package funcObject

/**
 * Created by weizy on 2017/5/11.
 */
class Rational2(n:Int, d:Int) {
  println("Created " + n + "/" + d)

  //先决条件 precondition
  require(d != 0)

  //重载
  override def toString = n + "/" +d
}

object  Rational2{
  def main(args: Array[String]) {
    new Rational2(1, 2)
  }
}

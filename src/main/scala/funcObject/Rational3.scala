package funcObject

/**
 * Created by weizy on 2017/5/12.
 */
class Rational3 (n:Int, d:Int){

  require(d != 0)

//  if not exsits below two lines, n and d is not number of Rational3
  val numer : Int = n
  val denom : Int = d

  override def toString = numer + "/" + denom

  // 从构造器
  def this(n: Int) = this(n, 1)

  def add(that: Rational3) :Rational3 = new Rational3(numer * that.denom +  that.numer * denom, denom * that.denom)

  //自指向
  def  lessThan(that: Rational3) = this.numer * that.denom < that.numer * this.denom
  def max(that: Rational3) = if (this.lessThan(that)) that else this

  //私有字段
  private val g = gcd(n.abs, d.abs)
  //私有方法
  private def gcd(a:Int, b:Int) : Int = if (b == 0) a else gcd(b, a % b)

  //方法重载

  //隐式转换
  implicit def intToRational3(x:Int) = new Rational3(x)

}

object Rational3{
  def main(args: Array[String]) {
    val rational3Val = new Rational3(2,3)
    print(rational3Val.toString)
  }
}

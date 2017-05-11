package script

/**
 * Created by weizy on 2017/5/9.
 */
object ArrayTest {
  def main (args: Array[String]):Unit = {
    var greetString = new Array[String](3)
    greetString(0) = "Hello"
    greetString(1) = "World"
    greetString(2) = "!"

    for (i <- 0 to 2)
      println(greetString(i))

    // list是不可变的数据结构
    var list1 = List("a", "b", "c")
    var list2 = List("d")
    var list3 = list1 ::: list2
    list3.foreach(list => print(list + " "))


  }
}

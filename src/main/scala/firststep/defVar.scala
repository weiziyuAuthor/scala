package firststep

/**
 * Created by weizy on 2017/5/11.
 */
object defVar {
  val msg = "Hello world!"
  val msg2:java.lang.String = "Hello world, again"
  val msg3: String = "Hello yet again, world"

// error reassignment to val
//  msg3 = "Goodbye world"

  // var allow to reassign
  var greeting = "Hello world"
  greeting = "greeting hello world"

  //常规函数 => def + 函数名 + 括号中的参数列表 + 函数返回值类型 + 等号 + 大括号中的函数体
  def max(x:Int, y:Int) : Int = {
    if (x > y) x
    else y
  }

  def max2(x:Int, y:Int) = if (x>y) x else y

  //既不带参数也不返回有用结果的函数定义
  def greet() = println("Hello, world")

  def printArgs(args : Array[String]): Unit = {
    var i = 0
    while(i<args.length){
      println(args(i))
      i += 1
    }
  }

  //用val定义一个变量，那么这个变量就不能重新赋值，但它指向的对象却仍可以暗自改变

  def  arrayTest1(): Unit ={
    val greetStrings = new Array[String](3)
    greetStrings(0) = "Hello"
    greetStrings(1) = ", "
    greetStrings(2) = "world!\n"
    for (i <- 0 to 2){
      print(greetStrings(i))
    }
  }

  def updateArray():Unit ={
    val greetStrings = new Array[String](3)
    greetStrings.update(0, "Hello")
    greetStrings.update(1, ", ")
    greetStrings.update(2, "world!\n")
    for (i <- 0.to(2))
      print(greetStrings.apply(i))
  }

  // 1 + 2 等价于 (1).+(2) Sacala里所有的操作符都是方法调用

  //init array Array是可变的对象(元素值可变)
//  val numNames = Array("zero", "two")
//  val numNames2 = Array.apply("zero", "two")

  def listTest():Unit={
    val oneTwo = List(1,2)
    val threeFour = List(3,4)
    val one234 = oneTwo:::threeFour //List 有个叫“:::”的方法实现叠加功能
    println(oneTwo + " and" + threeFour + " were not mutated.")
    println("Thus, " + one234 + " is a new List")
  }

  def listCons():Unit={
    val threeFour = List(3,4)
//    threeFour.::(1)
    val newArr = 1 :: threeFour //发音"cons", Cons是一个新元素组合到已有list的最前端， 然后返回结果list
    println("Thus, " + newArr)
  }

//元组也是不可变的，与列表不同， 元组可以包含不同类型的元素； _N数字是基于1
  def tupleTest: Unit ={
    val pair =(99, "tupleTest")
    println(pair._1)
    println(pair._2)
  }

  /*
  Set: 可变集将把元素加入自身，不可变集将创建并返回一个包含了添加元素的新集

   */
  def setTest: Unit ={
    //默认为不可变集
    var jetSet = Set("Boing", "Airbus")
    jetSet+="Lear"
    println(jetSet.contains("Cessna"))

    import scala.collection.mutable.Set
    val movieSet = Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)

    import scala.collection.immutable.HashSet
    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet+"Coriander")
  }

//减少var的使用
  def funcStyle(args:Array[String]): Unit ={
    //m1
    var i = 0
    while(i<args.length){
      println(args(i))
      i += 1
    }

    //m2
    for (arg <- args) {
      println(arg)
    }

    //m3
    args.foreach(println)
  }

  def readFromFile: Unit ={
    import scala.io.Source
    val path = "C:\\Users\\weizy\\Downloads\\ttt.txt"
    for (line <- Source.fromFile(path).getLines())
      println(line.length + " " + line)
  }


  def main (args: Array[String]){
    println(msg)
    println(msg2);
    println(msg3);
    println(greeting);

    println(max(3,7))

    printArgs(args);
    println("-----------------------")
    args.foreach(arg => println(arg))

    println("-----------------------")
    for(arg <- args)
      println(arg)
    println("-----------------------")
    arrayTest1

    println("------------updateArray-----------")
    updateArray

    println("------------listTest-----------")
    listTest()

    println("------------setTest-----------")
    setTest

    println("------------readFromFile-----------")
    readFromFile
  }
}

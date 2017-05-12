package innercontrolstructure

import java.io.File

/**
 * Created by weizy on 2017/5/12.
 *
 * 内建控制结构
 *
 * Scala仅包含if, while, for, try, match和函数的调用
 */
object InitObject {

//  制造新集合 for {子句} yield {循环体}
  def makeNewCollection: Unit ={
    val filesHere = (new java.io.File(".")).listFiles()
    def scalaFiles =
      for {
        file <- filesHere
        if file.getName.endsWith(".scala")
      } yield file
  }

//  mid-stream(留间) 变量绑定
  def filterPro1Example(): Unit = {
    val filesHere = (new java.io.File(".")).listFiles()

    def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

    def grep(pattern : String) =
    //for 表达式中使用多个发生器
      for {
        file <- filesHere
        if  file.getName.endsWith(".scala")
        line <- fileLines(file)
        trimmed = line.trim //this is mid-stream
        if trimmed.matches(pattern)
      } println(file + ": " + line.trim)

    grep(".*gcd.*")
  }

//嵌套枚举
  def filterProExample(): Unit = {
    val filesHere = (new java.io.File(".")).listFiles()

    def fileLines(file: java.io.File) = scala.io.Source.fromFile(file).getLines().toList

    def grep(pattern : String) =
    //for 表达式中使用多个发生器
      for {
        file <- filesHere
        if  file.getName.endsWith(".scala")
        line <- fileLines(file)
        if line.trim.matches(pattern)
      } println(file + ": " + line.trim)

    grep(".*gcd.*")
  }

  def filterExample(): Unit = {
    val filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere if file.getName.endsWith(".scala"))
      println(file)

//    以 ; 分隔
    for (file <- filesHere if file.isFile; if file.getName.endsWith(".scala"))
      println(file)
  }

  def forExample(): Unit = {
    val filesHere = (new java.io.File(".")).listFiles()
    for (file <- filesHere)
      println(file)

    for (i <- 1 to 4)
      println("Interation: " + i)

    //不枚举Range的上边界
    for(i <- 1 until 4)
      println("Iteration: " + i)
  }

//  != 比较类型为Unit, 和String的值将永远产生true
//  var line = ""
//  while ((line = readLine()) != "")

  def doWhile(): Unit = {
    var line = ""
    do {
      line = readLine()
      println("Read: " + line)
    }while(line != null)
  }

  //while usage, 计算最大公约数
  def gcdLoop(x:Long, y:Long) :Long = {
    var a = x
    var b = y
    while(a != 0){
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
  def main(args: Array[String]) {

    // if usage
    val filenamme =
      if (!args.isEmpty) args(0)
        else "default.txt"


  }
}

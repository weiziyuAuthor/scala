package innercontrolstructure

/**
 * Created by weizy on 2017/5/12.
 *
 * 1. 任何类的常量，或者其他什么东西， 都能用作scala里的case
 * 2. 每个选项最后并没有break
 */
object MatchExpression {

  def matchPro(args:Array[String]): Unit ={
    val firstArg = if (!args.isEmpty) args(0) else ""
    val friend =
      firstArg match {
        case "salt" => "pepper"
        case "chips" => "salsa"
        case "eggs" => "bacon"
        case _ =>"huh?"
      }
    println(friend)
  }
  def main(args: Array[String]) {
    val firstArg = if (args.length > 0) args(0) else ""

    firstArg match{
      case "salt" => println("pepper")
      case "chips" => println("salsa")
      case "eggs" => println("bacon")
      case _ => println("huh?")
    }
  }
}

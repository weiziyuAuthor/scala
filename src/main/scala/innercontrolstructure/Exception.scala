package innercontrolstructure

/**
 * Created by weizy on 2017/5/12.
 */
class Exception {
  import java.io.FileReader
  import java.io.FileNotFoundException
  import java.io.IOException

  try{
    val f = new FileReader("input.txt")
  }catch{
    case ex: FileNotFoundException => //Handle missing file
    case ex: IOException => //Handle other I/O error
  }


//  val file = openFile()
  //  try{
  //
  //  }finally {
  //    file.close()
  //  }

}

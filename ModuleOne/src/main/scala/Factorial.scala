
import com.typesafe.scalalogging.Logger

class Factorial {

  val loggerObject = Logger(getClass)

  def factorial(number: Int): Int = {
    if (number <= 1) {
      loggerObject.info("factorial of 0 is 1")
      1
    }
    else {
      val result: Int = number * factorial(number - 1)
      loggerObject.info(s"factorial of $number is $result")
      result
    }
  }
}

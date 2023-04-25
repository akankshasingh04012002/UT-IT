
import com.typesafe.scalalogging.Logger

import scala.io.StdIn.readLine
import scala.util.{Failure, Success, Try}

class PasswordCheck {
  val loggerObject = Logger(getClass)

  def isStrong(password: String, name: String): Boolean = {
    val containsUpperCase = password.matches(".*[A-Z].*")
    val containsLowerCase = password.matches(".*[a-z].*")
    val containsAlphanumeric = password.matches(".*\\d.*")
    val containsAllowedMetacharacters = password.matches(".*[%@#&$].*")
    val containsName = password.toLowerCase.contains(name.toLowerCase)
    val isStrongPassword = containsUpperCase && containsLowerCase && containsAlphanumeric && containsAllowedMetacharacters && !containsName

    if (isStrongPassword) {
      true
    } else {
      false
    }
  }
}

object PasswordChecker extends App {
  private val password = new PasswordCheck
  private val name = readLine("Enter your full name: ")
  val email = readLine("Enter your email ID: ")
  private val userPassword = Try(readLine("Enter your password:"))

  userPassword match {
    case Success(userPassword) =>
      if (password.isStrong(userPassword, name)) {
        password.loggerObject.info("password is strong")
      }
      else {
        password.loggerObject.warn("password is weak")
      }
    case Failure(exception) => password.loggerObject.error(s"Error while reading the password: ${exception.getMessage}")
  }
}
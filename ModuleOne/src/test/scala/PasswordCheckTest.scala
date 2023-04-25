
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.should.Matchers

class PasswordCheckTest extends AnyFlatSpec with Matchers {
  val passwordValidator = new PasswordCheck

  "isStrong" should "return true for a strong password" in {
    val strongPassword = "Aa1%@bC2&$dE3"
    val name = "Akanksha Singh"
    passwordValidator.isStrong(strongPassword, name) shouldBe true
  }

  it should "return false for a password containing the user's name" in {
    val password = "Shivani123"
    val name = "Shivani Singh"
    passwordValidator.isStrong(s"$password$name", name) shouldBe false
  }

  it should "return false for a password missing an uppercase letter" in {
    val password = "pass1%@b2&$d3"
    val name = "Shiva Singh"
    passwordValidator.isStrong(password, name) shouldBe false
  }

  it should "return false for a password missing a lowercase letter" in {
    val password = "AABBCCDDEEFF11%@#$"
    val name = "Akanks Rajput"
    passwordValidator.isStrong(password, name) shouldBe false
  }

  it should "return false for a password missing a digit" in {
    val password = "Aa%@bC&$dE"
    val name = "Shivi Gautam"
    passwordValidator.isStrong(password, name) shouldBe false
  }

  it should "return false for a password missing an allowed metacharacter" in {
    val password = "Aa1bcdEfGhIjKlmN"
    val name = "Iksha"
    passwordValidator.isStrong(password, name) shouldBe false
  }
}

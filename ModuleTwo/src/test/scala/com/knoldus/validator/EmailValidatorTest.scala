
import org.scalatest.flatspec.AnyFlatSpec
import com.knoldus.validator.EmailValidator

class EmailValidatorTest extends AnyFlatSpec {

  val emailValidator = new EmailValidator()

  "EmailValidator" should "return true for a valid email" in {
    assert(emailValidator.emailIdIsValid("akanksha.singh@knoldus.com") === true)
    assert(emailValidator.emailIdIsValid("shiva@gmail.com") === true)
    assert(emailValidator.emailIdIsValid("singhakanksha@gmail.com") === true)
  }

  it should "return false for an invalid email" in {
    assert(emailValidator.emailIdIsValid("akanks.singh@") === false)
    assert(emailValidator.emailIdIsValid("akanksha singh@gmail.com") === false)
    assert(emailValidator.emailIdIsValid("singh@gmail") === false)
    assert(emailValidator.emailIdIsValid("akku.@gmail..com") === false)
  }
}


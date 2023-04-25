
import org.scalatest.flatspec.AnyFlatSpec
import org.scalatest.matchers.must.Matchers
import org.scalatest.matchers.should.Matchers.convertToAnyShouldWrapper

class FactorialTest extends AnyFlatSpec with Matchers {
  val factorialObj = new Factorial

  "Factorial of 0" should "return 1" in {
    factorialObj.factorial(0) shouldBe 1
  }

  "Factorial of a positive number" should "return the correct result" in {
    factorialObj.factorial(5) shouldBe (120)
  }

  "Factorial of a negative number" should "return 1" in {
    factorialObj.factorial(-3) shouldBe (1)
  }
}

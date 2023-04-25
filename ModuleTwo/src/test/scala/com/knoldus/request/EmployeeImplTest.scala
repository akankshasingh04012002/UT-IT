
import com.knoldus.db.CompanyReadDto
import com.knoldus.models.Employee
import com.knoldus.request.EmployeeImpl
import com.knoldus.validator.{EmailValidator, EmployeeValidator, UserValidator}
import org.scalatest.flatspec.AnyFlatSpec


class EmployeeImplTest extends AnyFlatSpec {
  val companyReadDto = new CompanyReadDto
  val emailValidator = new EmailValidator
  val userValidator = new UserValidator(companyReadDto, emailValidator)
  val employeeValidator = new EmployeeValidator(userValidator)
  val employeeImpl = new EmployeeImpl(employeeValidator)

  "EmployeeImpl#createEmployee" should "return Some(emailId) if employee is valid" in {
    val validEmployee = Employee("Shivani", "Singh", 23, 10000.0, "Developer", "Knoldus", "shiva@knoldus.com")
    assert(employeeImpl.createEmployee(validEmployee) == Some(validEmployee.emailId))
  }

  it should "return None if employee is invalid" in {
    val invalidEmployee = Employee("Akanksha", "Singh", 21, 18000.0, "Intern", "Knoldus", "invalid_email_id")
    assert(employeeImpl.createEmployee(invalidEmployee) == None)
  }
}



import com.typesafe.scalalogging.Logger

class DuplicateChecker {

  val loggerObject = Logger(getClass)

  def hasDuplicates(list: List[Int]): Boolean = {
    val distinctList = list.distinct
    val hasDuplicates = distinctList.size != list.size

    if (hasDuplicates) {
      loggerObject.info("List has duplicates")
    } else {
      loggerObject.warn("List does not have duplicates")
    }
    hasDuplicates
  }
}
import quoted._
import scala.quoted.staging._

object Test {
  given Toolbox = Toolbox.make(getClass.getClassLoader)
  def main(args: Array[String]): Unit = withQuotes {

    val q = '{(using q: Quotes) =>
      val a = '{4}
      ${'{(using q2: Quotes) =>
        '{${a}}
      }}

    }

    println(q.show)
  }
}

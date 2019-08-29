import Examples._

object Main {
  def main(args: Array[String]): Unit = {

    val a = A(0)

    val func = (a: Examples.A) => Examples.B(a.num)

    val r = Examples.myMethod(a, func)
    println(identity(r))   // probably B()

    // the following also produces a value of type B()
    // but we have an additional side effect because of the println from
    // within the method
    val r2 = Examples.mySideEffect(a, func)
    println(identity(r2))   // probably B()

    // the following also produces a value of type B()
    // but we have an additional side effect by changing
    // a globally defined variable
    val r3 = Examples.mySideEffectGlobal(a, func)
    println(identity(r3))   // probably B()
  }
}

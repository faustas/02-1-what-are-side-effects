object Examples {

  var changeMe = "FOO"

  final case class A(num: Int)
  final case class B(num: Int)

  /**
   * Simple method that gets two parameters.
   *
   * @param a A variable of type A
   * @param f Function that returns a value of type B
   * @return Value of type B
   */
  def myMethod(a: A, f: A => B ) : B =
    f(a)

  /**
   * Same functionality as within the method above.
   * But side effect because of println to the STDOUT.
   *
   * @param a A variable of type A
   * @param f Function that returns a value of type B
   * @return Value of type B
   */
  def mySideEffect(a: A, f: A => B ) : B = {
    println("SIDE_EFFECT")
    f(a)
  }

  /**
   * Same functionality as first method above.
   * But side effect because of changing global variable and
   * therefore an internal state.
   *
   * @param a A variable of type A
   * @param f Function that returns a value of type B
   * @return Value of type B
   */
  def mySideEffectGlobal(a: A, f: A => B ) : B = {
    println(s"Unchanged global value: $changeMe")
    changeMe = "BAR"
    println(s"SIDE_EFFECT changed global value: $changeMe")
    f(a)
  }

}


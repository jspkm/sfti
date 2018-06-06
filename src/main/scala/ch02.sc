import java.time.LocalDate

object ch02 {

  // 1. The signum of a number is 1 if the number is positive, –1 if it is negative, and 0 if it is zero. Write a function that computes this value.
  def signum(num: Int) = if (num > 0) 1 else if (num < 0) -1 else 0

  signum(100)   // res0: Int = 1
  signum(-11)   // res1: Int = -1
  signum(0)     // res2: Int = 0


  // 2. What is the value of an empty block expression {}? What is its type? 3. Come up with one situation where the assignment x = y = 1 is valid in Scala.
  {}    // res3: Unit = ()

  // value is (), type is Unit

  // 3. Come up with one situation where the assignment x = y = 1 is valid in Scala. (Hint: Pick a suitable type for x.)
  var y = 1
  val x = y = 1
  x

  // 4. Write a Scala equivalent for the Java loop
  // for (int i = 10; i > = 0; i--) System.out.println( i);
  for(i <- 10 to 0 by -1) println(i)

  //  10
  //  9
  //  8
  //  7
  //  6
  //  5
  //  4
  //  3
  //  2
  //  1
  //  0
  //  res5: Unit = ()

  // 5. Write a procedure countdown( n: Int) that prints the numbers from n to 0.

  def countdown(n: Int){
    for (i <- n to 0 by -1) print(f"$i ")
  }

  countdown(10)   // 10 9 8 7 6 5 4 3 2 1 0 res6: Unit = ()

  // 6. Write a for loop for computing the product of the Unicode codes of all letters in a string. For example, the product of the characters in "Hello" is 9415087488L.
  var uv:Long = 1
  for(c <- "Hello") uv *= c.toInt
  uv                    // res8: Long = 9415087488

  //7. Solve the preceding exercise without writing a loop. (Hint: Look at the StringOps Scaladoc.)
  "Hello".foldLeft(1: Long)((a, b) => a * b)


  // 8. Write a function product( s : String) that computes the product, as described in the preceding exercises.
  def product(s: String) = s.foldLeft(1: Long)((a, b) => a * b)

  product("Hello")      // res10: Long = 9415087488

  // 9. Make the function of the preceding exercise a recursive function.
  def productRecursive(s: String): Long = {
    if (s.length == 0) 1 else s.head.toInt * productRecursive(s.tail)
  }

  productRecursive("Hello")     // res9: Long = 9415087488


  // 10. Write a function that computes xn, where n is an integer.
  // Use the following recursive definition:
  // • xn = y · y if n is even and positive, where y = xn / 2.
  // • xn = x · xn – 1 if n is odd and positive.
  // • x0 = 1. • xn = 1 / x– n if n is negative.

  def pw(x: Long, n: Int): Double = {
    if (n == 0) 1
    else if (n < 0) 1 / pw(x, -n)
    else if (n % 2 > 0) x * pw(x, n - 1)
    else pw(x, n / 2) * pw(x, n / 2)
  }

  pw(100, 0)      // res12: Double = 1.0
  pw(2, 4)        // res13: Double = 16.0
  pw(2, 3)        // res14: Double = 8.0
  pw(2, -1)       // res15: Double = 0.5


  // 11. Define a string interpolator date so that you can define a java.time.LocalDate as date"$year-$month-$day".
  // You need to define an “implicit” class with a date method, like this:
  //
  // implicit class DateInterpolator( val sc: StringContext) extends AnyVal { def date( args: Any*): LocalDate = . . . } args( i) is the value of the ith expression. Convert each to a string and then to an integer, and pass them to the LocalDate.of method. If you already know some Scala, add error handling. Throw an exception if there aren’t three arguments, or if they aren’t integers, or if they aren’t separated by dashes. (You get the strings in between the expressions as sc.parts.)
  // args(i) is the value of the ith expression. Convert each to a string and then to an integer, and pass them to the LocalDate.of method. If you already know some Scala, add error handling. Throw an exception if there aren’t three arguments, or if they aren’t integers, or if they aren’t separated by dashes. (You get the strings in between the expressions as sc.parts.)
  //

//  implicit class DateInterpolator(val sc: StringContext) extends AnyVal {
//    def date(args: Any*): LocalDate = {
//
//      LocalDate.of(0, 0, 0)
//    }
//  }
//
//  val year = 2018
//  val month = 6
//  val day = 5
//
//  val bd = date"$year-$month-$day"
//  print(bd)





  //// Scratch section

  for (i <- 1 to 3;
       j <- 1 to 3)
    print(f"i=${i} - j=${j},  ")    // i=1 - j=1,  i=1 - j=2,  i=1 - j=3,  i=2 - j=1,  i=2 - j=2,  i=2 - j=3,  i=3 - j=1,  i=3 - j=2,  i=3 - j=3,  res3: Unit = ()


  for (i <- 1 to 10) yield i % 3

  def sum(args: Int*) = {
    def add(ints: Int*): Int = if (ints.length == 0) 0 else ints.head + add(ints.tail: _*)
    add(args: _*)
  }

  sum(1 to 5: _*)       // res5: Int = 15

}
import math._
import math.BigInt._
import scala.util.Random

object ch01 {
  // 1. In the Scala REPL, type 3. followed by the Tab key. What methods can be applied?
  // scala> 3.
  //  !=   /%   >>>          charValue     floor           isPosInfinity     isValidShort   modPow       to               toHexString     unary_-
  //  %    <    ^            clearBit      gcd             isProbablePrime   isWhole        pow          toBinaryString   toInt           unary_~
  //  &    <<   abs          compare       getClass        isValidByte       longValue      round        toByte           toLong          underlying
  //  &~   <=   bigInteger   compareTo     intValue        isValidChar       lowestSetBit   self         toByteArray      toOctalString   until
  //  *    ==   bitCount     doubleValue   isInfinite      isValidDouble     max            setBit       toChar           toRadians       |
  //  +    >    bitLength    equals        isInfinity      isValidFloat      min            shortValue   toDegrees        toShort
  //  -    >=   byteValue    flipBit       isNaN           isValidInt        mod            signum       toDouble         toString
  //  /    >>   ceil         floatValue    isNegInfinity   isValidLong       modInverse     testBit      toFloat          unary_+

  // 2. In the Scala REPL, compute the square root of 3, and then square that value. By how much does the result differ from 3? (Hint: The res variables are your friend.)
  3 - pow(sqrt(3), 2)       // res0: Double = 4.440892098500626E-16

  // 3. Are the res variables val or var?
  // res0 = 123 results in syntax error
  // val

  // 4. Scala lets you multiply a string with a number— try out "crazy" * 3 in the REPL. What does this operation do? Where can you find it in Scaladoc?
  "crazy" * 3             // res1: String = crazycrazycrazy
  // Found at https://www.scala-lang.org/api/current/scala/collection/immutable/StringOps.html#*(n:Int):String

  // 5. What does 10 max 2 mean? In which class is the max method defined?
  10 max 2                // res2: Int = 10
  // Means return greater of the two
  // Defined in Int class

  // 6. Using BigInt, compute 2^1024.
  BigInt(2) pow 1024    // res3: scala.math.BigInt = 179769313486231590772930519078902473361797697894230657273430081157732675805500963132708477322407536021120113879871393357658789768814416622492847430639474124377767893424865485276302219601246094119453082952085005768838150682342462881473913110540827237163350510684586298239947245938479716304835356329624224137216

  // 7. What do you need to import so that you can get a random prime as probablePrime( 100, Random), without any qualifiers before probablePrime and Random?
  probablePrime(100, Random)    // res4: scala.math.BigInt = 1005721668116123958461819398453

  // import math.BigInt._
  // import scala.util.Random

  // 8. One way to create random file or directory names is to produce a random BigInt and convert it to base 36, yielding a string such as "qsnvbevtomcj38o06kul". Poke around Scaladoc to find a way of doing this in Scala.
  probablePrime(100, Random).toString(36)   // res5: String = 3a3lf9j3ph8rnhrorpvp

  // 9. How do you get the first character of a string in Scala? The last character?
  "hello".head      // res6: Char = h
  "hello".last      // res7: Char = o

  // What do the take, drop, takeRight, and dropRight string functions do? What advantage or disadvantage do they have over using substring?
  "hello".take(2)           // res8: String = he
  "hello".drop(2)           // res9: String = llo
  "hello".takeRight(2)      // res10: String = lo
  "hello".dropRight(2)      // res11: String = hel

  // These are more semantically pleasant than substring
}
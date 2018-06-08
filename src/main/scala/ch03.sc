import java.awt.datatransfer.SystemFlavorMap

import scala.collection.mutable.ArrayBuffer

object ch03 {
  // 1. Write a code snippet that sets a to an array of n random integers between 0 (inclusive) and n (exclusive).
  val random = new scala.util.Random()
  val a = 0 to random.nextInt(10)   // a: scala.collection.immutable.Range.Inclusive = Range(0, 1, 2, 3, 4, 5, 6)

  // 2. Write a loop that swaps adjacent elements of an array of integers.
  // For example, Array( 1, 2, 3, 4, 5) becomes Array( 2, 1, 4, 3, 5).
  val b = Array( 1, 2, 3, 4, 5)
  for (i <- 0 until (if (b.length % 2 == 0) b.length else b.length -1) if (i % 2 != 0)) {
    val temp = b(i)
    b(i) = b(i-1)
    b(i-1) = temp
  }
  b         // res1: Array[Int] = Array(2, 1, 4, 3, 5)

  // 3. Repeat the preceding assignment, but produce a new array with the swapped values. Use for/ yield.
  val c = Array( 1, 2, 3, 4, 5)
  for (i <- 0 until c.length)
    yield if (i % 2 == 1) c(i - 1) else { if (i == c.length - 1) c(i) else c(i + 1) }
  // res2: scala.collection.immutable.IndexedSeq[Int] = Vector(2, 1, 4, 3, 5)


  // 4. Given an array of integers, produce a new array that contains all positive values of the
  // original array, in their original order, followed by all values that are zero or negative,
  // in their original order.
  val d = Array(-5, 5, -4, 4, -3, 3, -2, 2, -1, 1, 0)
  val d2 = d.filter(_ > 0) ++ d.filter(_ <= 0)
  // d2: Array[Int] = Array(5, 4, 3, 2, 1, -5, -4, -3, -2, -1, 0)


  // 5. How do you compute the average of an Array[ Double]?
  val e = Array[Double](1, 2, 3, 4, 5)
  e.sum / e.length

  // 6. How do you rearrange the elements of an Array[ Int] so that they appear in reverse sorted order?
  // How do you do the same with an ArrayBuffer[ Int]?
  e.sortWith(_ > _)             // res4: Array[Double] = Array(5.0, 4.0, 3.0, 2.0, 1.0)
  e.toBuffer.sortWith(_ > _)    // res5: scala.collection.mutable.Buffer[Double] = ArrayBuffer(5.0, 4.0, 3.0, 2.0, 1.0)

  // res5: scala.collection.mutable.Buffer[Double] = ArrayBuffer(5.0, 4.0, 3.0, 2.0, 1.0)


  // 7. Write a code snippet that produces all values from an array with duplicates removed. (Hint: Look at Scaladoc.)
  val f = Array(1, 1, 2, 2, 3, 4, 5, 5, 5, 6)
  f.distinct    // res6: Array[Int] = Array(1, 2, 3, 4, 5, 6)


  // 8. Suppose you are given an array buffer of integers and want to remove all but the first negative number.
  // Here is a sequential solution that sets a flag when the first negative number is called, then removes all
  // elements beyond.
  //    var first = true
  //    var n = a.length
  //    var i = 0
  //    while (i < n) {
  //      if (a( i) > = 0) i + = 1
  //      else {
  //        if (first) { first = false; i + = 1 }
  //        else { a.remove( i); n -= 1 }
  //        }
  //    }
  // This is a complex and inefficient solution. Rewrite it in Scala by collecting positions of the
  // negative elements, dropping the first element, reversing the sequence, and calling a.remove(i)
  // for each index.

  val g = ArrayBuffer[Int](1, 2, 3, -1, -2, 4, -3)
  var index = for(i <- 0 until g.length if g(i) < 0) yield i
  index = index.drop(1)
  for(i <- index.reverse) g.remove(i)
  g     // res8: scala.collection.mutable.ArrayBuffer[Int] = ArrayBuffer(1, 2, 3, -1, 4)

  // 10. Make a collection of all time zones returned by java.util.TimeZone.getAvailableIDs
  // that are in America. Strip off the "America/" prefix and sort the result.

  java.util.TimeZone.getAvailableIDs().filter(_.startsWith("America/")).map(i => i.stripPrefix("America/")).sorted
  // res9: Array[String] = Array(Adak, Anchorage, Anguilla, Antigua, Araguaina, Argentina/Buenos_Aires, Argentina/Catamarca, Argentina/ComodRivadavia, Argentina/Cordoba, Argentina/Jujuy, Argentina/La_Rioja, Argentina/Mendoza, Argentina/Rio_Gallegos, Argentina/Salta, Argentina/San_Juan, Argentina/San_Luis, Argentina/Tucuman, Argentina/Ushuaia, Aruba, Asuncion, Atikokan, Atka, Bahia, Bahia_Banderas, Barbados, Belem, Belize, Blanc-Sablon, Boa_Vista, Bogota, Boise, Buenos_Aires, Cambridge_Bay, Campo_Grande, Cancun, Caracas, Catamarca, Cayenne, Cayman, Chicago, Chihuahua, Coral_Harbour, Cordoba, Costa_Rica, Creston, Cuiaba, Curacao, Danmarkshavn, Dawson, Dawson_Creek, Denver, Detroit, Dominica, Edmonton, Eirunepe, El_Salvador, Ensenada, Fort_Nelson, Fort_Wayne, Fortaleza, Glace_Bay, Godthab, Goose_Bay, Grand_Turk, Grenada, Guadeloupe, Guatemala, Guayaquil, Guyana, Halifax, Havana, Hermosillo, Indiana/Indianapolis, Indiana/Knox, Indiana/Marengo, Indiana/Petersburg, Indiana/Tell_City, Indiana/Vevay, Indiana/Vincennes, Indiana/Winamac, Indianapolis, Inuvik, Iqaluit, Jamaica, Jujuy, Juneau, Kentucky/Louisville, Kentucky/Monticello, Knox_IN, Kralendijk, La_Paz, Lima, Los_Angeles, Louisville, Lower_Princes, Maceio, Managua, Manaus, Marigot, Martinique, Matamoros, Mazatlan, Mendoza, Menominee, Merida, Metlakatla, Mexico_City, Miquelon, Moncton, Monterrey, Montevideo, Montreal, Montserrat, Nassau, New_York, Nipigon, Nome, Noronha, North_Dakota/Beulah, North_Dakota/Center, North_Dakota/New_Salem, Ojinaga, Panama, Pangnirtung, Paramaribo, Phoenix, Port-au-Prince, Port_of_Spain, Porto_Acre, Porto_Velho, Puerto_Rico, Punta_Arenas, Rainy_River, Rankin_Inlet, Recife, Regina, Resolute, Rio_Branco, Rosario, Santa_Isabel, Santarem, Santiago, Santo_Domingo, Sao_Paulo, Scoresbysund, Shiprock, Sitka, St_Barthelemy, St_Johns, St_Kitts, St_Lucia, St_Thomas, St_Vincent, Swift_Current, Tegucigalpa, Thule, Thunder_Bay, Tijuana, Toronto, Tortola, Vancouver, Virgin, Whitehorse, Winnipeg, Yakutat, Yellowknife)


  // 11. Import java.awt.datatransfer._ and make an object of type SystemFlavorMap with
  // the call
  // val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]
  //
  // Then call the getNativesForFlavor method with parameter DataFlavor.imageFlavor
  // and get the return value as a Scala buffer. (Why this obscure class? It's hard
  // to find uses of java.util.List in the standard Java library.)


  val flavors = SystemFlavorMap.getDefaultFlavorMap().asInstanceOf[SystemFlavorMap]


  //// Scratches
  val arr = Array(1, 7, 2, 4)

  //scala.util.Sorting.quickSort(a)
  arr.sortWith(_<_)
}
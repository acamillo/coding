object AddBigNumberAsListOfDigits extends App {

    val l1 = List(1,0,1,4)
    val l2 = List(8,7)

  val a1 = List(9,9,9,9)
  val a2 = List(9)

//  val ll =  l1.reverse.zipAll(l2.reverse, 0, 0)
  val ll =  a1.reverse.zipAll(a2.reverse, 0, 0)

  val (result, carry) =
  ll.foldLeft(List.empty[Int] -> 0) {
    case ((xs, c), (a,b)) =>
      println(s"xs $xs, c: $c, t: ($a,$b)")
      val digit = (a+b + c) % 10
      val rem = (a+b + c) / 10
      (digit :: xs, rem)
  }

  val xl =  if (carry > 0) 1 :: result else result
  println(s"xl: $xl")

  //tpolcat version
  val bi =
  (BigInt(a1.mkString) + BigInt(a2.mkString))
    .toString
    .toList
    .map(_ - '0')

  println(s"bi: $bi")

  def add(a1: List[Int], a2: List[Int]) = {

    def loop(a1: List[Int], a2: List[Int], carry: Int): List[Int] = {
      (a1, a2) match {
        case (a :: as, b :: bs) =>
          val digit = (a + b + carry) % 10
          val rem = (a + b + carry) / 10
          digit :: loop(as, bs, rem)

        case (a :: as, Nil) =>
          val digit = (a + carry) % 10
          val rem = (a  + carry) / 10
          digit :: loop(as, Nil, rem)

        case (Nil, Nil) if carry == 1 => List(1)
        case _ => Nil
      }
    }

    val r = loop(a1,a2,0).reverse
    println(s"result: $r")
  }
}

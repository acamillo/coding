object DeliverooMenu extends App {

  val food: Map[String, List[String]] = Map(
    "starters" -> List("s1", "s2", "s3", "s4", "s5"),
    "mains" -> List("m1", "m2", "m3", "m4"),
    "desserts" -> List("d1", "d2", "d3")
  )

  val chef: Set[String] = Set(
    "s1", "s3", "s5", "s100", "s101", "s102",
    "m2", "m3", "m100", "m101", "m102",
    "d1", "d2", "d100", "d200"
  )

  case class Menu(starters: List[String], mains: List[String], desserts: List[String]) {
    override def toString: String =
      "\nStarters\n" + starters.mkString(",") +
        "\nMains\n" + mains.mkString(",") +
        "\nDesserts\n" + desserts.mkString(",")
  }

  def menu: Menu = {
    val menuItems = food.mapValues(_.filter(chef.contains))
    val notAvailable = List("N/A")
    Menu(
      menuItems.getOrElse("starters", notAvailable),
      menuItems.getOrElse("mains", notAvailable),
      menuItems.getOrElse("desserts", notAvailable),
    )
  }

  def printMenu =
    System.out.println(menu)

  printMenu
}

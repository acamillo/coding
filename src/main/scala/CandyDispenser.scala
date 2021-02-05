
sealed trait Input

case object Coin extends Input

case object Turn extends Input

case class Machine(locked: Boolean, candies: Int, coins: Int)

// Rules:
//   - inserting a coin into a locked machine causes it to unlock itself
//   - turning the knob on an unlocked machine will cause it to dispense candy and become locked
//   - turning the knob on a locked machine or inserting a coin into an unlocked machine does nothing
//   - a machine that's out of candy ignores all inputs

// The simulateMachine method should operate the machine based on the list of inputs and return
// the number of coins and candies left at the end. For example, if the input machine
// has 10 coins and 5 candies, and a total of 4 candies are successfully bought, the output should be (14, 1).

case class State[S, +A](run: S => (A, S)) {
  def map[A2](f: A => A2): State[S, A2] = State(s => {
    val (a, s2) = run(s)
    (f(a), s2)
  })

  def flatMap[A2](f: A => State[S, A2]): State[S, A2] = State(s => {
    val (a, s2) = run(s)
    f(a).run(s2)
  })
}

object State {
//  def unit[S, A](a: A): State[S, A] = State(s => (a, s))

  def modify2[S](f: S => S): State[S, Unit] =
    get.flatMap( fs => set(f(fs)))

  def modify[S](f: S => S): State[S, Unit] = for {
    s <- get // Gets the current state and assigns it to `s`.
    _ <- set(f(s)) // Sets the new state to `f` applied to `s`.
  } yield ()

  def get[S]: State[S, S] = State(s => (s, s))

  def set[S](s: S): State[S, Unit] = State(_ => ((), s))

  def sequence[S, A](states: List[State[S, A]]): State[S, List[A]] = {
    def go(action: S, acc: List[A], states: List[State[S, A]]): (List[A], S) = {

      states match {
        case Nil => (acc.reverse, action)

        case s :: t => s.run(action) match {
          case (a, s2) => go(s2, a :: acc, t)
        }
      }
    }

    State(s => go(s, Nil, states))
  }
}


import State._

object CandyDispenser {

  //  val xyz: Input => Machine => Machine = input => m =>
  private val update = (input: Input) => (m: Machine) =>
    (input, m) match {
      case (Coin, Machine(true, _, coins)) => m.copy(locked = false, coins = coins + 1)
      case (Turn, Machine(false, candies, _)) => m.copy(locked = true, candies = candies - 1)
      case (Turn, Machine(true, _, _)) => m
      case (Coin, Machine(false, _, _)) => m
      case (_, Machine(_, 0, 0)) => m
    }

  def simulateMachine2(inputs: List[Input]): State[Machine, (Int, Int)] = {
    val v1 = sequence(inputs.map(i => modify[Machine](m => update(i)(m))))
    v1.flatMap( _ => get.map( m => (m.candies, m.coins)))
  }


  def simulateMachine(inputs: List[Input]): State[Machine, (Int, Int)] = for {
    _ <- sequence(inputs.map(i => modify[Machine](m => update(i)(m))))
    m <- get
  } yield (m.candies, m.coins)

}

object Main extends App {

  val initialState = Machine(locked = true, 100, 10)

  val inputs = List(Coin, Turn, Coin, Turn, Turn)
  val turn = List(Turn)

  val res = CandyDispenser.simulateMachine(inputs).run(initialState)

  println(s"$res")
}
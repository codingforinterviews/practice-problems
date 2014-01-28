
object CoinChangeSolution {

  def main(args: Array[String]) = {

    val input = io.Source.stdin.bufferedReader
    val coins = input.readLine().split(",").map(_.toInt).toList
    val amt = input.readLine().toInt

    println(count(coins, amt))
  }

  def count(coins: List[Int], amt: Int) = {

    val solutions = Array.fill(amt + 1)(0)
    solutions(0) = 1

    coins.foreach(coin => for (c <- coin to amt)
      solutions(c) = solutions(c) + solutions(c - coin))

    solutions(amt)
  }
}

package solutions

object FactorialSolution {

  def main(args: Array[String]) = {
    val input = io.Source.stdin.bufferedReader.readLine()
    println(factorial(input.toInt))
  }

  def factorial(n: Int): BigInt = {
    
    def calc(acc: BigInt, n: Int): BigInt =
      if (n == 0) acc
      else calc(acc * n, n - 1)

    calc(1, n)
  }

}

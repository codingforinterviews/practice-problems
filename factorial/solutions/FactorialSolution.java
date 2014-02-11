package solutions

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;


public class FactorialSolution {

  public static void main(String[] args) throws Exception {
    // read STDIN 
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    BigInteger n = BigInteger.valueOf(Integer.parseInt(br.readLine()));
    // write STDOUT
    System.out.println(factorial(n, BigInteger.ONE));
  }

  /*
   *  Factorial of n 
   *  @param  n   input
   *  @param  acc accumulator (tail call optimization)
   *  @return n!   
   */
  public static BigInteger factorial(BigInteger n, BigInteger acc) {
    
    if (n.equals(BigInteger.ZERO))
      return acc;
    else
      return factorial(n.subtract(BigInteger.ONE), n.multiply(acc));      
  }    
}


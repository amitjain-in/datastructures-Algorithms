package amit.problems

object Fibonacci {

    def main(args: Array[String]): Unit = {
        val fib = new Fibonacci()
        var i = 0
        for(i <- 2 to 92) {//Beyond 92 we get long overflow
            println("n = " + i + " fib = " + fib.fibonaccci(i));
        }
    }
}

class Fibonacci {

    def fibonaccci(n: Int): Long = {
        var n2 = 0L;
        var n1 = 1L;
        var fib = n2 + n1;

        for (_ <- 1 until n) {
            fib = n2 + n1;
            n2 = n1
            n1 = fib
        }
        fib
    }
}
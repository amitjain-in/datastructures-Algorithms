package amit.problems

import scala.collection.mutable

object LongestValidParentheses {
    def main(args: Array[String]): Unit = {
        val lvp = new LongestValidParentheses
        println(lvp.longestValidParentheses("(()")) //2
        println(lvp.longestValidParentheses(")()())")) //4
        println(lvp.longestValidParentheses("")) //0
    }
}

class LongestValidParentheses {

    def longestValidParentheses(s: String): Int = {
        var longest = 0
        var current = 0
        val stack = new mutable.Stack[Char]()


        s.foreach(c => {
            if (c == '(') {
                if (current < 0) {

                }
                stack.push(c)
                current += 1
            } else {
                current -= 1
                if (current >= 0) {
                    //                    longest = math.max(i + 1 - start, longest)
                    //                } else if (current < 0) {
                    //                    current = 0
                    //                    start = i + 1
                    //                }
                }
                //            i += 1
            }
        })

        longest
    }
}

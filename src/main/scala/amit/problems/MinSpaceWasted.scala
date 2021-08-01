package amit.problems

/**
 *
 * You have n packages that you are trying to place in boxes, one package in each box. There are m suppliers that each produce boxes of different sizes (with infinite supply).
 * A package can be placed in a box if the size of the package is less than or equal to the size of the box.
 * The package sizes are given as an integer array packages, where packages[i] is the size of the ith package.
 * The suppliers are given as a 2D integer array boxes, where boxes[j] is an array of box sizes that the jth supplier produces.
 * You want to choose a single supplier and use boxes from them such that the total wasted space is minimized.
 * For each package in a box, we define the space wasted to be size of the box - size of the package. The total wasted space is the sum of the space wasted in all the boxes.
 * For example, if you have to fit packages with sizes [2,3,5] and the supplier offers boxes of sizes [4,8],
 * you can fit the packages of size-2 and size-3 into two boxes of size-4 and the package with size-5 into a box of size-8. This would result in a waste of (4-2) + (4-3) + (8-5) = 6.
 * Return the minimum total wasted space by choosing the box supplier optimally, or -1 if it is impossible to fit all the packages inside boxes.
 * Since the answer may be large, return it modulo 10^9 + 7
 */
object MinSpaceWasted {
    def main(args: Array[String]): Unit = {
        val minSpaceWasted = new MinSpaceWasted()
        println(minSpaceWasted.minWastedSpace(Array.apply(2, 3, 5), Array.apply(Array.apply(4, 8), Array.apply(2, 8))))
        println(minSpaceWasted.minWastedSpace(Array.apply(2, 3, 5), Array.apply(Array.apply(1, 4), Array.apply(2, 3), Array.apply(3, 4))))
        println(minSpaceWasted.minWastedSpace(Array.apply(3, 5, 8, 10, 11, 12), Array.apply(Array.apply(12), Array.apply(11, 9), Array.apply(10, 5, 14))))
        println(minSpaceWasted.minWastedSpace(Array.fill(40000)(1), Array.apply(Array.apply(40000))))
    }
}

class MinSpaceWasted {

    //naive approach. Functionally works, performance poor.
    def minWastedSpace(packages: Array[Int], boxes: Array[Array[Int]]): Int = {

        var minSpaceWasted = Int.MaxValue

        packages.sortInPlace()
        boxes.foreach(supplier => {
            supplier.sortInPlace()
            var supplierIdx = 0
            var waste: Long = 0
            var packagesFit = true
            packages.foreach(pack => {
                while (supplierIdx < supplier.length && pack > supplier(supplierIdx)) {
                    supplierIdx += 1
                }
                if (supplierIdx < supplier.length) {
                    waste += supplier(supplierIdx) - pack
                } else {
                    packagesFit = false;
                }
            })
            if (packagesFit) {
                minSpaceWasted = math.min(minSpaceWasted, (waste % 1_000_000_007).toInt)
            }
        })
        if (minSpaceWasted == Int.MaxValue) {
            return -1
        }
        minSpaceWasted
    }
}

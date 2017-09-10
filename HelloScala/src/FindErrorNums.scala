/**
  * Created by samar.kumar on 8/31/17.
  */
object FindErrorNums {
  def findErrorNums(nums: Array[Int]): Array[Int] = {
    var i = 0
    val res = new Array[Int](2)
    for (i <- nums) {
      if (nums(scala.math.abs(i) - 1) < 0) res(0) = Math.abs(i)
      else nums(scala.math.abs(i) - 1) *= -1;
    }

    for (i <- 0 to nums.length) {
      if (nums(i) > 0) res(1) = i + 1
    }
    res;

  }

}

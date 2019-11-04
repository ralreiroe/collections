package example

import scala.collection.mutable
import scala.collection.mutable.ListBuffer


class Hackerrank extends Spec {

  /**
    * randomizedSet with two maps
v to idx
idx to v
for getrandom, get random 0...size-1, then use that for idx
    */
  class RandomizedSet() {



    val vToIdx = mutable.Map.empty[Int, Int]
    val idxToV = mutable.Map.empty[Int, Int]

    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    def insert(v: Int): Boolean = {

      val alreadycontains = vToIdx.isDefinedAt(v)
      if (alreadycontains) return false

      val idx = idxToV.size
      idxToV.+=((idx, v))
      vToIdx.+=((v,idx))

      !alreadycontains
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    def remove(v: Int): Boolean = {

      val contains = vToIdx.isDefinedAt(v)
      if (!contains) return false

      idxToV.remove(vToIdx(v))
      vToIdx.remove(v)
      true

    }

    /** Get a random element from the set. */
    def getRandom(): Int = {

      println(idxToV)
      println(vToIdx)

      if (idxToV.size==0) return -1
      val r = scala.util.Random
      val randnum = r.nextInt(idxToV.size)
      idxToV(randnum)
    }

  }

  "sfjksjh" in {

    val rs = new RandomizedSet()
    println(rs.getRandom())
    println(rs.insert(11))
    println(rs.remove(22))
    println(rs.insert(22))
    println(rs.getRandom())
    println(rs.remove(11))
    println(rs.insert(22))
    println(rs.getRandom())

//    for (i <- 1 to 100) print(rs.getRandom)






  }



  "indices of two numbers that add up to target" in {


    def twoSum(nums: Array[Int], target: Int): Array[Int] = {


      for (i1 <- 0 until nums.size) {
        for (i2 <- i1+1 until nums.size) {
          if (nums(i1)+nums(i2)==target) return Array(i1,i2)
        }
      }

      Array(0,0)

    }

    twoSum(Array(3,2,4), 6)
  }

  "twoSum class" in {

    class TwoSum {

      val arr = ListBuffer.empty[Int]

      //O(1)
      def add(n: Int) = {
        arr.+=(n)
        this
      }

      //O(n^2)
      def find(n: Int): Boolean = {
        for (e <- arr) {
          for (e2 <- arr) {
            if (e+e2==n) return true
          }
        }

        return false
      }
    }

    val ts = new TwoSum

    println(ts.add(3).add(2).add(4).find(6))
    println(ts.add(1).add(3).add(5).find(4))
    println(ts.add(1).add(3).add(5).find(7))
  }

}

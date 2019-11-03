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

      println(idxToV)
      println(vToIdx)

      !alreadycontains
    }

    /** Removes a value from the set. Returns true if the set contained the specified element. */
    def remove(v: Int): Boolean = {

      val contains = vToIdx.isDefinedAt(v)
      if (!contains) return false

      vToIdx.remove(v)
      idxToV.remove(vToIdx(idxToV(v)))
      true

    }

    /** Get a random element from the set. */
    def getRandom(): Int = {

      if (idxToV.size==0) return -1
      val r = scala.util.Random

      val randnum = r.nextInt(idxToV.size)

      idxToV(randnum)
    }

  }

  "sfjksjh" in {

    val rs = new RandomizedSet()
    println(rs.getRandom())
    println(rs.remove(1))
    println(rs.insert(1))
    println(rs.insert(1))
    println(rs.getRandom())
    println(rs.insert(2))
    println(rs.insert(3))

    for (i <- 1 to 100) print(rs.getRandom)






  }

}

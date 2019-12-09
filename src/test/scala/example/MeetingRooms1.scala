package example

class MeetingRooms1 extends Spec {

  """Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
    |
    |For example,
    |Given [[0, 30],[5, 10],[15, 20]],
    |return false.""" in {

    val intervals = List((0,30), (5, 10), (15,20))
    val intervals2 = List((0,30), (31, 50), (60,90))



    def doesOverlap(int1: (Int, Int), int2: (Int, Int)): Boolean = {

      if (int1==int2) return false
      val s1 = int1._1
      val e1 = int1._2
      val s2 = int2._2
      val e2 = int2._2

      s2>s1 && s2<e1

    }

    /**
      * O(n^2) as it requires to compare every meeting with every other one
      */
    def canAttendAllMeetings (intervals: List[(Int, Int)]): Boolean = {

      if (intervals.size==1) return true

      //0 with 1,2
      //1 with 2
      for (i <- intervals.indices) {
        for (i2 <- i+1 to intervals.size-1) {
          if (doesOverlap(intervals(i), intervals(i2))) return false
        }
      }
      true
    }

    println(canAttendAllMeetings(intervals))
    println(canAttendAllMeetings(intervals2))
    println(canAttendAllMeetings(List((0,30), (5, 10))))
    println(canAttendAllMeetings(List((0,30), (31, 50))))

  }

}

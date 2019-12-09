package example

class MeetingRooms1 extends Spec {

  """Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
    |
    |For example,
    |Given [[0, 30],[5, 10],[15, 20]],
    |return false.""" in {

    val intervals = List((0,30), (5, 10), (15,20))
    val intervals2 = List((0,30), (31, 50), (32,33))



    def doesOverlap(int1: (Int, Int), int2: (Int, Int)): Boolean = {

      if (int1==int2) return false
      val s1 = int1._1
      val e1 = int1._2
      val s2 = int2._2
      val e2 = int2._2

      s2>s1 && s2<e1

    }

    /**
      * if we sort, we only need to compare adjacent meetings => O(nlogn) + O(n)
      *
      * (a,b), (c,d), (e,f) -
      * if (a,b) does not overlap with (c,d) and (e,f) starts later than (c,d) then
      * we know (a,b) cannot overlap with (e,f) without explicitly testing this
      */
    def canAttendAllMeetings (intervals: List[(Int, Int)]): Boolean = {

      if (intervals.size == 1) return true

      //sorted.size>=2
      val sorted: List[(Int, Int)] = intervals.sorted
      for (idx <- 0 to sorted.size-2) {
        if (doesOverlap(sorted(idx), sorted(idx+1))) return false
      }
      true
    }


    println(canAttendAllMeetings(intervals))
    println(canAttendAllMeetings(intervals2))
    println(canAttendAllMeetings(List((0,30), (5, 10))))
    println(canAttendAllMeetings(List((0,30), (31, 50))))

  }

}

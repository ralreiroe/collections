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

    def canAttendAllMeetings (intervals: List[(Int, Int)]): Boolean = {

      for (int <- intervals) {
        for (into <- intervals) {
          if (doesOverlap(int, into)) return false
        }
      }
      true
    }

    println(canAttendAllMeetings(intervals))
    println(canAttendAllMeetings(intervals2))

  }

}

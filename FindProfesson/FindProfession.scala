object FindProfession extends App {

  def findProfession(level: Int, pos: Int): String = {
    var curProf = ProfessionEngineer

    // convert to base-0
    var curLevel = level -1
    var curPos = pos

    while(curLevel > 0) {
      // each iteration performs calculations relative to the 'virtual root'
      // of a subtree defined as level - curLevel - 1, relative to the target position 'pos'

      // the number of postions on the subtree level
      val numLevelPos = Math.pow(2,curLevel).toInt

      // segmentation of the level's positions between the two branches stemming off of the virtual root
      val break = numLevelPos / 2

      // Profession and position are recalculated when navigating down the right branch
      // off the virtual root
      if (curPos > break) {
        curProf = if(curProf == ProfessionEngineer) ProfessionDoctor else ProfessionEngineer
        curPos = curPos - break;
      }
      // re-root to next level down
      curLevel = curLevel - 1
    }
    curProf
  }

  def test() : Unit = {
    val ProfessionDoctor = "Doctor"
    val ProfessionEngineer = "Engineer"

    val levelParam = 3
    val posParam = 3
    val expectedProfession = ProfessionDoctor

    val actualProfession = findProfession(levelParam,posParam)
    print(s"Looking for a '${expectedProfession}' on level ${levelParam}, position ${posParam}.....")
    val result = if(expectedProfession == actualProfession) "Sucessful!" else s"Failure: found a '${actualProfession}' instead"
    println(s"${result}'")
  }

  test()
}

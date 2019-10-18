object FindProfession extends App {

  def findProfession(level: Int, pos: Int): String = {
    var curProf = "Engineer"
    var curLevel = level -1
    var curPos = pos
    while(curLevel > 0) {
      val numLevelPos = Math.pow(2,curLevel).toInt
      val break = numLevelPos / 2
      if (curPos > break) {
        curProf = if(curProf == "Engineer") "Doctor" else "Engineer"
        curPos = curPos - break;
      }
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

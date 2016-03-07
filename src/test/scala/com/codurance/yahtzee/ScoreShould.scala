package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.mockito.Mockito._
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class ScoreShould extends UnitSpec {

	"print the score" in {
		val console = mock[Console]
		val score = Score(Category("Ones"), 2)

		score print(console)

		verify(console) printLine("Yahtzee score")
		verify(console) printLine("Ones: 4")
	}

}

package com.codurance.yahtzee

import com.codurance.UnitSpec
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class CategoryShould extends UnitSpec {

	"calculate points for OnesCategory" in {
		OnesCategory pointsFor "D1:2 D2:4 D3:1 D4:6 D5:1" should be(2)
		OnesCategory pointsFor "D1:2 D2:1 D3:1 D4:6 D5:1" should be(3)
		OnesCategory pointsFor "D1:2 D2:3 D3:4 D4:2 D5:6" should be(0)
	}

	"calculate points for TwosCategory" in {
		TwosCategory pointsFor "D1:2 D2:4 D3:1 D4:6 D5:1" should be(2)
		TwosCategory pointsFor "D1:2 D2:1 D3:1 D4:2 D5:1" should be(4)
		TwosCategory pointsFor "D1:4 D2:3 D3:4 D4:1 D5:6" should be(0)
	}

	"calculate points for ThreesCategory" in {
		ThreesCategory pointsFor "D1:3 D2:4 D3:1 D4:6 D5:1" should be(3)
		ThreesCategory pointsFor "D1:2 D2:3 D3:1 D4:2 D5:3" should be(6)
		ThreesCategory pointsFor "D1:4 D2:1 D3:4 D4:1 D5:6" should be(0)
	}

}

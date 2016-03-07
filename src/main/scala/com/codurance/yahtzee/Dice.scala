package com.codurance.yahtzee

class Dice(randomDieValue: RandomDieValue) {

	def roll(): String = {
		var result = ""
		for (d <- 1 to 5) {
			result += s"D${d}:" + randomDieValue.next()
			if (d < 5) result += " "
		}
		result
	}

}

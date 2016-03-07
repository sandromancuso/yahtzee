package com.codurance.yahtzee

class Dice(randomDieValue: RandomDieValue) {

	def rollAll(): String = {
		var result = ""
		for (d <- 1 to 5) {
			result += s"D${d}:" + randomDieValue.next()
			if (d < 5) result += " "
		}
		result
	}

}

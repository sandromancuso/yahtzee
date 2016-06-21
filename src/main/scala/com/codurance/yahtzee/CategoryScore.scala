package com.codurance.yahtzee

case class CategoryScore(category: Category, points: Int) {

	def print(console: Console): Unit = {
		console printLine "Yahtzee score"
		console printLine s"${category.name}: ${points}"
	}

}

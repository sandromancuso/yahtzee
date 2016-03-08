package com.codurance.yahtzee

sealed trait Category {
	def name: String

	def pointsFor(rollResult: String): Int =
		pointsFor(rollResult.split(" ")
							.map(d => d.split(":").apply(1).toInt)
							.toList)


	def pointsFor(diceValues: List[Int]): Int
}

case object OnesCategory extends Category {
	override def name: String = "Ones"

	override def pointsFor(diceValues: List[Int]): Int =
		diceValues
				.map(n => if (n == 1) n else 0)
				.sum
}

case object TwosCategory extends Category {
	override def name: String = "Twos"

	override def pointsFor(diceValues: List[Int]): Int =
		diceValues
				.map(n => if (n == 2) n else 0)
				.sum
}

case object ThreesCategory extends Category {
	override def name: String = "Threes"

	override def pointsFor(diceValues: List[Int]): Int =
		diceValues
				.map(n => if (n == 3) n else 0)
				.sum
}


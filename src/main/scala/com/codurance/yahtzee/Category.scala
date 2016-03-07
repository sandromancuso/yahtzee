package com.codurance.yahtzee

case class Category(name: String) {
	def pointsFor(rollResult: String): Int =
		rollResult.split(" ")
			        .map(d => d.split(":").apply(1).toInt)
					.map(n => if (n == 1) n else 0)
					.sum

}

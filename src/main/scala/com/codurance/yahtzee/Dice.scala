package com.codurance.yahtzee

import com.codurance.yahtzee.DieNumber._

class Dice(randomDieValue: RandomDieValue) {

	implicit val randomValue = randomDieValue

	var dieList: List[Die] = List()

	def rollAll(): String = {
		dieList = DieNumber rollAll()
		generateRollStringFor(dieList)
	}

	def roll(diceString: String): String = {
		if (dieList.isEmpty) dieList = DieNumber rollAll()
		val reRollDieNumbers = diceString.split(" ").map(s => s.split("")).map(_(1).toInt)
		val newDieList = dieList.map(d => if (reRollDieNumbers.contains(d.number())) Die(valueOf(d.number())) else d)
		dieList = newDieList
		generateRollStringFor(dieList)
	}

	private def generateRollStringFor(dieList: List[Die]): String = {
		var result = ""
		dieList.foreach(d => {
			result += d
			if (d.number() < 5) result += " "
		})
		result
	}


}

sealed trait DieNumber {
	def number: Int
	override def toString(): String = s"D${number}"
}

object DieNumber {
	case object D1 extends DieNumber {val number = 1}
	case object D2 extends DieNumber {val number = 2}
	case object D3 extends DieNumber {val number = 3}
	case object D4 extends DieNumber {val number = 4}
	case object D5 extends DieNumber {val number = 5}

	val all: List[DieNumber] = List(D1, D2, D3, D4, D5)

	def rollAll()(implicit randomDieValue: RandomDieValue) = all.map(Die(_))

	def valueOf(number: Int) = all.find(dn => dn.number == number).get
}

class Die(dieNumber: DieNumber, value: Int) {
	override def toString(): String = s"${dieNumber}:${value}"

	def number() = dieNumber.number
}

object Die {
	def apply(number: DieNumber)(implicit randomDieValue: RandomDieValue): Die = new Die(number, randomDieValue.next())
}


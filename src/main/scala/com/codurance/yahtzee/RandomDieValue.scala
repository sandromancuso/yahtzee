package com.codurance.yahtzee

import scala.util.Random

class RandomDieValue {

	val DIE_SIDES = 6

	def next(): Int = Random.nextInt(DIE_SIDES)

}

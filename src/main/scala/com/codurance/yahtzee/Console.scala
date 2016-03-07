package com.codurance.yahtzee

import scala.io.StdIn

class Console {

	def printLine(text: String): Unit = println(text)

	def read(text: String): String = {
		print(text)
		StdIn.readLine()
	}

}

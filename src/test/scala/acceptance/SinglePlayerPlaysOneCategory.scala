package acceptance

import com.codurance.UnitSpec
import com.codurance.yahtzee._
import org.mockito.BDDMockito.given
import org.mockito.Mockito

class SinglePlayerPlaysOneCategory extends UnitSpec {

	"single player plays one category" in {
		val console = mock[Console]
		val randomDieValue = mock[RandomDieValue]
		val dice = new Dice(randomDieValue)
		val one_category = Category("Ones")
		val turn = new Turn(dice, console)

		given(randomDieValue next()) willReturn(
				2, 4, 1, 6, 1,
				1, 5, 2,
				1, 5)

		given(console read "[1] Dice to re-run: ") willReturn "D1 D2 D4"
		given(console read "[2] Dice to re-run: ") willReturn "D2 D4"

		val yahtzee = new Yahtzee(List(one_category), turn, console)

		yahtzee startGame()

		val inOrder = Mockito.inOrder(console)
		inOrder.verify(console) printLine "Category: Ones"
		inOrder.verify(console) printLine "Dice: D1:2 D2:4 D3:1 D4:6 D5:1"
		inOrder.verify(console) read "[1] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:1 D2:5 D3:1 D4:2 D5:1"
		inOrder.verify(console) read "[2] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:1 D2:1 D3:1 D4:5 D5:1"

		inOrder.verify(console) printLine "Yahtzee score"
		inOrder.verify(console) printLine "Ones: 4"
		inOrder.verify(console) printLine "Final score: 4"
	}

	"single player plays two categories" in {
		val console = mock[Console]
		val randomDieValue = mock[RandomDieValue]
		val dice = new Dice(randomDieValue)
		val ones_category = Category("Ones")
		val twos_category = Category("Twos")
		val turn = new Turn(dice, console)

		given(randomDieValue next()) willReturn(
				2, 4, 1, 6, 1,
				1, 5, 2,
				1, 5,
				2, 4, 1, 6, 1,
				4, 2, 2, 1,
				2, 3
				)

		given(console read "[1] Dice to re-run: ") willReturn ("D1 D2 D4", "D2 D3 D4 D5")
		given(console read "[2] Dice to re-run: ") willReturn ("D2 D4", "D2 D5")

		val yahtzee = new Yahtzee(List(ones_category, twos_category), turn, console)

		yahtzee startGame()

		val inOrder = Mockito.inOrder(console)
		inOrder.verify(console) printLine "Category: Ones"
		inOrder.verify(console) printLine "Dice: D1:2 D2:4 D3:1 D4:6 D5:1"
		inOrder.verify(console) read "[1] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:1 D2:5 D3:1 D4:2 D5:1"
		inOrder.verify(console) read "[2] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:1 D2:1 D3:1 D4:5 D5:1"

		inOrder.verify(console) printLine "Category: Twos"
		inOrder.verify(console) printLine "Dice: D1:2 D2:4 D3:1 D4:6 D5:1"
		inOrder.verify(console) read "[1] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:2 D2:4 D3:2 D4:2 D5:1"
		inOrder.verify(console) read "[2] Dice to re-run: "
		inOrder.verify(console) printLine "Dice: D1:2 D2:2 D3:2 D4:2 D5:3"

		inOrder.verify(console) printLine "Yahtzee score"
		inOrder.verify(console) printLine "Ones: 4"
		inOrder.verify(console) printLine "Twos: 8"
		inOrder.verify(console) printLine "Final score: 12"
	}


}

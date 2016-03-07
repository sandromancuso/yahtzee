package acceptance

import com.codurance.UnitSpec
import com.codurance.yahtzee._
import org.mockito.BDDMockito.given
import org.mockito.Mockito.verify

class SinglePlayerPlaysOneCategory extends UnitSpec {

	"single player plays one category" in {
		val console = mock[Console]
		val dice = mock[Dice]
		val one_category = Category("Ones")
		val turn = new Turn(dice, console)

		given(dice roll()) willReturn(
				"D1:2 D2:4 D3:1 D4:6 D5:1",
				"D1:1 D2:5 D3:1 D4:2 D5:1",
				"D1:1 D2:1 D3:1 D4:5 D5:1")

		given(console read("Dices to re-run: ")) willReturn(
				"D1 D2 D4",
				"D2 D4")

		val yahtzee = new Yahtzee(one_category, turn, console)

		yahtzee startGame()

		verify(console) printLine("Category: Ones")
		verify(console) printLine("Dice: D1:2 D2:4 D3:1 D4:6 D5:1")
		verify(console) printLine("Dice to re-run: D1 D2 D4")
		verify(console) printLine("Dice: D1:1 D2:5 D3:1 D4:2 D5:1")
		verify(console) printLine("Dice to re-run: D2 D4")
		verify(console) printLine("Dice: D1:1 D2:1 D3:1 D4:5 D5:1")
		verify(console) printLine("Category Ones score: 4")

		verify(console) printLine("Yahtzee score")
		verify(console) printLine("Ones: 4")
		verify(console) printLine("Final score: 4")
	}


}

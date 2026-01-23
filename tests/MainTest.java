import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;


class MainTest {

    @Test
    void testStringToArray() {
        Main main = new Main();

        String input = "Hello is this thing on";
        String[] result = main.stringToArray(input);

        assertArrayEquals(new String[]{"Hello", "is", "this", "thing", "on"}, result);

    }

    @Test
    void testCensorWord() {
        assertEquals("______", Main.censorWord("Bingus"), "Answer should be '______'");
    }

    @Test
    void testWinOrLoss() {
        Main main = new Main();

        main.mysteryWord = "67";
        main.winOrLoss("sybau");

        assertEquals(1, main.losses, "Losses should equal 1");
        assertEquals(0, main.wins, "Wins should equal 0");

    }
}
package guessing_words.helpers;

import guessing_words.models.GamePlayer;

public class Pair {
    private GamePlayer firstPlayer;
    private GamePlayer secondPlayer;

    public Pair(GamePlayer firstPlayer, GamePlayer secondPlayer) {
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
    }

    public static Pair of(GamePlayer firstPlayer, GamePlayer secondPlayer) {
        return new Pair(firstPlayer, secondPlayer);
    }

    public GamePlayer getFirstPlayer() {
        return firstPlayer;
    }

    public void setFirstPlayer(GamePlayer firstPlayer) {
        this.firstPlayer = firstPlayer;
    }

    public GamePlayer getSecondPlayer() {
        return secondPlayer;
    }

    public void setSecondPlayer(GamePlayer secondPlayer) {
        this.secondPlayer = secondPlayer;
    }
}

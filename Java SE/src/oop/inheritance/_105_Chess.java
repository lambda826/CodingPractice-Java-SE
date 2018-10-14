package oop.inheritance;

import static utils.Print.*;

class Game {

    Game(int i) {
        print("Game constructor");
    }

}

class BoardGame extends Game {

    BoardGame(int i) {
        super(i);
        print("BoardGame constructor");
    }

}

public class _105_Chess extends BoardGame {

    _105_Chess() {
        super(11);
        print("Chess constructor");
    }

    public static void main(String[] args) {
        _105_Chess x = new _105_Chess();
    }

}
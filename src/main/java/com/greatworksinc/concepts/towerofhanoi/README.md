Two classes are needed, one representing the peg, and the other representing the rung.

## Rung
#### Attributes
* (int) Size
#### Methods
* (Rung) isBigger (boolean)

## Peg
#### Attributes
* (Stack) Rungs
#### Methods
* (Rung) addRung
* removeRung (Rung)
* getSize (int)

## Board
#### Attributes
* (Peg) leftPeg
* (Peg) middlePeg
* (Peg) rightPeg
* (int) Number of Rungs
#### Methods
* (Peg from) (Peg to) transferRung (boolean)
* isGameDone (boolean)
* getTransitions()

## Player
#### Attributes
* (Board) board
#### Methods
* getFrom (Peg)

* (Peg from) getTo (Peg)
* play
    while(!board.isGameDone())
        for transition in getTransitions():
            result = transferPeg(transition.getFrom(), transition.getTo())
            if result:
              break;
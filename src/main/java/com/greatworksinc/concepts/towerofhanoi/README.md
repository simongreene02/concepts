Two classes are needed, one representing the peg, and the other representing the disc.

## Disc
#### Attributes
* (int) Size
#### Methods
* (Rung) isBigger (boolean)

## Peg
#### Attributes
* (Stack) Discs
#### Methods
* (Disc) addDisc
* removeDisc (Disc)
* getSize (int)

## Board
#### Attributes
* (Peg) leftPeg
* (Peg) middlePeg
* (Peg) rightPeg
* (int) Number of Discs
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
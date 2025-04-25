Monster Hunter Wilds
Interactive Hunter Handbook

Changes since showing you in lab:
As suggested, I moved the formatUnixDate() function into NewsState.kt since it was not a composable,
more of a helper function.

Purpose: 
To help hunters quickly visualize a monster's elemental weakness to save time looking it up in game.
(The colours of the monster cards corresponds to it's elemental weakness)

Home:
Show newest official game updates from Capcom with links to the article on Steam using Steam API

Large Monsters:
Additional monster information shown when clicking the monster cards also includes more elemental 
weaknesses/resistances, status weaknesses/resistances, and locations on where the monster may spawn.

Small Monsters:
Additional monster location information shown when clicking the monster cards. Includes an expanded 
number of locations as each small monster may live in more than one locale. 

Log Crown:
Log crowns (largest/second largest and smallest/second smallest monster) discovered for each monster
while fighting and add notes for fun. 
Stores and displays crown info in RoomDB which persists between sessions.





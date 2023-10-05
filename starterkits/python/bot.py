

import game_message
from game_message import *
from actions import *


class Bot:
    def __init__(self):
        self.direction = 1
        print("Initializing your super mega duper bot")

    def get_next_move(self, game_message: GameMessage):
        """
        Here is where the magic happens, for now the moves are not very good. I bet you can do better ;)
        """
        #tire les smalls si reverse=True, si pas reverse tire large
        listePriorite = sorted(game_message.meteors, key=lambda meteor: meteor.meteorType)


        a = game_message.constants.rockets.speed**2 - (game_message.constants.meteorInfos[listePriorite[0].meteorType.value].approximateSpeed**2)
        #print(a)
        b = 2 * (game_message.cannon.position.x * listePriorite[0].position.x + game_message.cannon.position.y * listePriorite[0].position.y)
        #print(b)
        c = -(((game_message.cannon.position.x - listePriorite[0].position.x)**2 + (game_message.cannon.position.y - listePriorite[0].position.y)**2)**0.5)**2
        #print(c)
        d = (b**2) - (4 * a * c)

        sol1 = (-b-(d**0.5))/(2*a)
        sol2 = (-b+(d**0.5)) / (2 * a)
        if sol1 < 0 and sol2 < 0:
            return []
        if sol1 > 0 and sol2 > 0:
            temps = min(sol1, sol2)
        else:
            temps = max(sol1, sol2)

        positionx = listePriorite[0].position.x + listePriorite[0].velocity.x * temps
        positiony = listePriorite[0].position.y + listePriorite[0].velocity.y * temps
        #print(positionx, positiony)
        if game_message.tick % 100 == 0:
            print('Score ---------->', game_message.score)
        if game_message.cannon.cooldown == 0:
            return [
                LookAtAction(Vector(x=positionx,y=positiony)),
                ShootAction(),
            ]
        else:
            return []

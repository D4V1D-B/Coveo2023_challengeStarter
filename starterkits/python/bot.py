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
        #tire les smalls si reverse=True
        game_message.meteors.sort(key=lambda meteor: meteor.meteorType)

        if game_message.tick % 100 == 0:
            print('Score ---------->',game_message.score)
        if game_message.cannon.cooldown == 0:
            return [
                LookAtAction(game_message.meteors[0].position),
                ShootAction(),
            ]
        else:
            return []


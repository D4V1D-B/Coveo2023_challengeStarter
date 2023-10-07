import queue

import game_message
from game_message import *
from actions import *
from collections import deque


class Bot:

    def __init__(self):
        self.direction = 1
        print("Initializing your super mega duper bot")


    def get_next_move(self, game_message: GameMessage):
        """
        Here is where the magic happens, for now the moves are not very good. I bet you can do better ;)
        """
        # tire les smalls si reverse=True, si pas reverse tire large

        #Queue de priorité
        #mettre le size dans la queue
        #mettre la distance
        #pt faire 1 queue en fonction du la taille, size et distance
        queue = deque()

        for m in game_message.meteors:
            if not len(queue) == 0:
                if self.score_pr_distance(m, game_message) > queue[0][0]:
                    queue.appendleft((self.score_pr_distance(m, game_message), m))
            else:
                queue.append((self.score_pr_distance(m, game_message), m))

        if game_message.tick % 100 == 0 or game_message.tick == 999:
            print('Score ---------->', game_message.score)
        if game_message.cannon.cooldown == 0:
            if not len(queue) == 0:
                return [LookAtAction(self.vecteurIntercepte(game_message.cannon, queue.popleft()[1], game_message)), ShootAction(),]
        else:
            return []

    def distanceEucledienne(self, vec_1, vec_2):
        return float(((vec_1.x - vec_2.x) ** 2 + (vec_1.y - vec_2.y) ** 2)**0.5)

    def vecteurIntercepte(self, canon, meteor, game):
        a: float = (game.constants.rockets.speed ** 2) - (game.constants.meteorInfos[meteor.meteorType.value].approximateSpeed ** 2)
        # print(a)
        Dx: float = canon.position.x - meteor.position.x
        Dy: float = canon.position.y - meteor.position.y
        b: float = 2 * (Dx * meteor.velocity.x + Dy * meteor.velocity.y)
        # print(b)
        c: float = -((self.distanceEucledienne(canon.position, meteor.position)) ** 2)
        # print(c)
        d: float = (b ** 2) - (4 * a * c)
        if d < 0:
            return []
        else:
            sol1: float = (-b - (d ** 0.5)) / (2 * a)
            sol2: float = (-b + (d ** 0.5)) / (2 * a)
            if sol1 < 0 and sol2 < 0:
                return []
            if sol1 > 0 and sol2 > 0:
                temps = min(sol1, sol2)
            else:
                temps = max(sol1, sol2)
        if float(meteor.position.x + meteor.velocity.x * temps) > game.constants.world.width and float(meteor.position.y + meteor.velocity.y * temps) > game.constants.world.height:
            return Vector(0, 0)
        return Vector(float(meteor.position.x + meteor.velocity.x * temps), float(meteor.position.y + meteor.velocity.y * temps))

    def score_pr_distance(self, meteor, game):
        return (self.distanceEucledienne(Vector(game.constants.world.width, game.constants.world.height/2), meteor.position)* game.constants.meteorInfos[meteor.meteorType.value].score)
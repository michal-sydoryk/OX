from GameFlowScenario import GameFlowScenario


class Diagonal1Scenario(GameFlowScenario):
    def __init__(self, board_size, combination_size):

        self.number_of_wining_combination_in_column = board_size - combination_size + 1
        GameFlowScenario.__init__(self, board_size, combination_size)

    def create_scenario(self):
        new_game_scenario_counter = 0
        gf = ""
        sgf = ""  # single game flow
        gf_list = []

        p2x = 0
        p2y = 0

        #------------before max diagonal-------------
        for i in range(self.board_size - self.combination_size):
            p1y = self.combination_size - 1 + i
            for k in range(p1y + 2 - self.combination_size):
                for j in range(self.combination_size - 1):
                    sgf += str(j + k) + "\n"
                    sgf += str(p1y - j - k) + "\n"
                    sgf += str(p2x + j) + "\n"
                    sgf += str(p2y) + "\n"

                sgf += str(self.combination_size - 1 + k) + "\n"
                sgf += str(p1y - (self.combination_size - 1) - k) + "\n"
                sgf += "\n"

                gf += sgf
                sgf = ""

                new_game_scenario_counter += 1
                if (new_game_scenario_counter % 3) == 0:
                    print("dupa")
                    gf_list.append(gf)
                    gf = ""

        # ------------after max diagonal-------------
        for i in range(self.board_size - self.combination_size + 1):
            p1y = self.board_size - self.combination_size - i
            for k in range(self.board_size - self.combination_size - p1y + 1):
                for j in range(self.combination_size - 1):
                    sgf += str(self.board_size - 1 - (j + k)) + "\n"
                    sgf += str(p1y + j + k) + "\n"
                    sgf += str(p2x + j) + "\n"
                    sgf += str(p2y) + "\n"

                sgf += str(self.board_size - self.combination_size - k) + "\n"
                sgf += str(p1y + (self.combination_size - 1) + k) + "\n"
                sgf += "\n"

                gf += sgf
                new_game_scenario_counter += 1

                if i == (self.board_size - self.combination_size) and k == (self.board_size - self.combination_size - p1y) and \
                        new_game_scenario_counter % 3 != 0:
                    print("dupa")
                    while new_game_scenario_counter % 3 != 0:
                        gf += sgf
                        new_game_scenario_counter += 1

                sgf = ""

                if (new_game_scenario_counter % 3) == 0:
                    gf_list.append(gf)
                    gf = ""

        return gf_list
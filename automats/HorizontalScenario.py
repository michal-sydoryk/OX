from GameFlowScenario import GameFlowScenario


class HorizontalScenario(GameFlowScenario):
    def __init__(self, board_size, combination_size):

        self.number_of_wining_combination_in_column = board_size - combination_size + 1
        GameFlowScenario.__init__(self, board_size, combination_size)

    def create_scenario(self):
        new_game_scenario_counter = 0
        p1x = 0
        p1y = 0
        p2x = 0
        p2y = 1
        gf = ""
        sgf = ""  # single game flow
        gf_list = []
        for i in range(self.board_size):
            for j in range(self.number_of_wining_combination_in_column):
                if i < self.board_size - 1:
                    for k in range(self.combination_size - 1):
                        sgf += str(p1x + k + j) + "\n"
                        sgf += str(p1y + i) + "\n"
                        sgf += str(p2x + k + j) + "\n"
                        sgf += str(p2y + i) + "\n"
                    sgf += str(p1x + self.combination_size - 1 + j) + "\n"
                    sgf += str(p1y + i) + "\n"
                    sgf += "\n"
                else:
                    for k in range(self.combination_size - 1):
                        sgf += str(p1y + k + j) + "\n"
                        sgf += str(self.board_size - 1) + "\n"
                        sgf += str(p2x + k + j) + "\n"
                        sgf += str(0) + "\n"
                    sgf += str(p1x + self.combination_size - 1 + j) + "\n"
                    sgf += str(self.board_size - 1) + "\n"
                    sgf += "\n"

                gf += sgf
                new_game_scenario_counter += 1
                if i == (self.board_size - 1) and j == (self.number_of_wining_combination_in_column - 1) and \
                        new_game_scenario_counter % 3 != 0:
                    while new_game_scenario_counter % 3 != 0:
                        gf += sgf
                        new_game_scenario_counter += 1

                sgf = ""

                if new_game_scenario_counter % 3 == 0:
                    gf_list.append(gf)
                    gf = ""

        return gf_list



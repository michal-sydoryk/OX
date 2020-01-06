from GameFlowScenario import GameFlowScenario


class DrawScenario(GameFlowScenario):
    def __init__(self, board_size, combination_size):
        GameFlowScenario.__init__(self, board_size, combination_size)

    def create_scenario(self):
        gf = ""  # game flow

        if board_size_int % 2 == 0:

        else:
            half_board_size = int((board_size_int - 1) / 2)
            for j in range(half_board_size):
                p1x = p1x_start + step * j
                p2x = p2x_start + step * j
                if j % 2 == 0:
                    for i in range(half_board_size):
                        gf += str(p1x) + "\n"
                        gf += str(p1y + step * i) + "\n"
                        gf += str(p2x) + "\n"
                        gf += str(p2y + step * i) + "\n"
                        gf += str(p1x + 1) + "\n"
                        gf += str(p1y + step * i) + "\n"
                        gf += str(p2x + 1) + "\n"
                        gf += str(p2y + step * i) + "\n"
                else:
                    for i in range(half_board_size):
                        gf += str(p1x) + "\n"
                        gf += str(board_size_int - 2 - step * i) + "\n"
                        gf += str(p2x) + "\n"
                        gf += str(board_size_int - 3 - step * i) + "\n"
                        gf += str(p1x + 1) + "\n"
                        gf += str(board_size_int - 2 - step * i) + "\n"
                        gf += str(p2x + 1) + "\n"
                        gf += str(board_size_int - 3 - step * i) + "\n"

        p1x = p1x_start
        p2x = p2x_start

    def __even_board_size(self):
        gf = ""
        step = 2
        p1x_start = 0
        p1y = 0
        p2x_start = 0
        p2y = 1
        half_board_size = int(self.board_size / 2)
        for j in range(half_board_size):
            p1x = p1x_start + step * j
            p2x = p2x_start + step * j
            if j % 2 == 0:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(p1y + step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(p2y + step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(p1y + step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(p2y + step * i) + "\n"
            else:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.board_size - 1 - step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.board_size - 2 - step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.board_size - 1 - step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.board_size - 2 - step * i) + "\n"

    def __odd_board_size(self):
        gf = ""
        step = 2
        p1x_start = 0
        p1y = 0
        p2x_start = 0
        p2y = 1
        half_board_size = int((self.board_size - 1) / 2)
        for j in range(half_board_size):
            p1x = p1x_start + step * j
            p2x = p2x_start + step * j
            if j % 2 == 0:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(p1y + step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(p2y + step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(p1y + step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(p2y + step * i) + "\n"
            else:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.board_size - 2 - step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.board_size - 3 - step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.board_size - 2 - step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.board_size - 3 - step * i) + "\n"
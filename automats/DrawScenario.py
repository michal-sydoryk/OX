from GameFlowScenario import GameFlowScenario


class DrawScenario(GameFlowScenario):
    def __init__(self, board_size, combination_size):
        self.step = 2
        self.p1x_start = 0
        self.p1y = 0
        self.p2x_start = 0
        self.p2y = 1
        GameFlowScenario.__init__(self, board_size, combination_size)

    def create_scenario(self):
        gf = ""  # game flow

        if self.board_size % 2 == 0:
            gf += self.__even_board_size()
        else:
            gf += self.__odd_board_size()

        return gf + "\n" + gf + "\n" + gf + "\n"

    def __even_board_size(self):
        gf = ""
        half_board_size = int(self.board_size / 2)
        for j in range(half_board_size):
            p1x = self.p1x_start + self.step * j
            p2x = self.p2x_start + self.step * j
            if j % 2 == 0:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.p1y + self.step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.p2y + self.step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.p1y + self.step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.p2y + self.step * i) + "\n"
            else:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.board_size - 1 - self.step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.board_size - 2 - self.step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.board_size - 1 -self.step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.board_size - 2 - self.step * i) + "\n"
        return gf

    def __odd_board_size(self):
        gf = ""
        half_board_size = int((self.board_size - 1) / 2)
        for j in range(half_board_size):
            p1x = self.p1x_start + self.step * j
            p2x = self.p2x_start + self.step * j
            if j % 2 == 0:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.p1y + self.step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.p2y + self.step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.p1y + self.step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.p2y + self.step * i) + "\n"
            else:
                for i in range(half_board_size):
                    gf += str(p1x) + "\n"
                    gf += str(self.board_size - 2 - self.step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(self.board_size - 3 - self.step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(self.board_size - 2 - self.step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(self.board_size - 3 - self.step * i) + "\n"

        p1x = self.p1x_start
        p2x = self.p2x_start

        for i in range(half_board_size):
            gf += str(p1x + self.step * i) + "\n"
            gf += str(self.board_size - 1) + "\n"
            gf += str(p2x + self.step * i + 1) + "\n"
            gf += str(self.board_size - 1) + "\n"

        p1x = self.board_size - 1
        p2x = self.board_size - 1
        for i in range(half_board_size):
            gf += str(p1x) + "\n"
            gf += str(self.p1y + self.step * i) + "\n"
            gf += str(p2x) + "\n"
            gf += str(self.p2y + self.step * i) + "\n"

        gf += str(p1x) + "\n"
        gf += str(p1x) + "\n"

        return gf
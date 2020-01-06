class InputFormatter:
    def __init__(self, args):
        self.args = args

    def format_input(self):
        if len(self.args) != 7:
            raise Exception("Pattern of input arguments:\n"
                            "python3 ./automats/automat.py LANGUAGE BOARD_SIZE "
                            "COMBINATION_SIZE WHO_STARTS GAME_RESULT WINING_COMBINATION\n"
                            "Where:\n"
                            "LANGUAGE = ENG or PL\n"
                            "BOARD_SIZE = 3 =< integer =< 40\n"
                            "COMBINATION_SIZE = 3 =< integer <= BOARD_SIZE\n"
                            "WHO_STARTS = X or O\n"
                            "GAME_RESULT = W (win) or D (draw)\n"
                            "WINING_COMBINATION = H (horizontal), V (vertical), D1 or D2 (diagonal)")
        else:
            variables = {
                "language": self.__language_chooser(self.args[1]),
                "board_size": self.__valid_board_size(self.args[2]),
                "combination_size": self.__valid_combination_size(self.args[2], self.args[3]),
                "who_starts": self.__valid_who_starts(self.args[4]),
                "game_result": self.__valid_winning_combination(self.args[5]),
                "winning_combination": self.__valid_winning_combination(self.args[6])
            }
        return variables

    def __language_chooser(self, language):
        if language == "ENG":
            return 1
        elif language == "PL":
            return 2
        else:
            raise Exception("LANGUAGE should be ENG or PL.")

    def __valid_board_size(self, board_size):
        board_size = int(board_size)
        if board_size < 3 or board_size > 40:
            raise Exception("BOARD_SIZE should be in range form 3 to 40 including this numbers.")
        return board_size

    def __valid_combination_size(self, board_size, combination_size):
        board_size = int(board_size)
        combination_size = int(combination_size)
        if combination_size > board_size or combination_size < 3:
            raise Exception("COMBINATION_SIZE should be in range from 3 to BOARD_SIZE including this numbers.")
        return combination_size

    def __valid_who_starts(self, who_starts):
        if who_starts == "x" or who_starts == "X":
            return 0
        elif who_starts == "o" or who_starts == "O":
            return 1
        else:
            raise Exception("WHO_STARTS should be X or O.")

    def __valid_winning_combination(self, wining_combination):
        if not (wining_combination == "V" or wining_combination == "v" or wining_combination == "H" or
                wining_combination == "h" or wining_combination == "D1" or wining_combination == "d1" or
                wining_combination == "D2" or wining_combination == "d2"):
            raise Exception("WINING_COMBINATION should be V, H, D1 or D2.")
        return wining_combination

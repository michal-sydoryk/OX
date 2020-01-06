from subprocess import run, PIPE
import sys
import InputFormater


def run_scenario(scenario):
    process = run(['java', '-jar', 'target/ox-0.1.jar'], stdout=PIPE, encoding='utf-8', input=scenario)
    game_flow = process.stdout

    results = open("automated_tests.txt", "a")
    results.write(game_flow)
    results.write("\n------------------------------------------------------------------\n")


# -----------input formatter--------------------
inputFormatter = InputFormater(sys.argv)
variables = inputFormatter.format_input()





def language_chooser(arg1):
    if arg1 == "ENG":
        return "1\n"
    else:
        return "2\n"

'''
def board_size_formatter(arg2):
    return str(arg2) + "\n"


def combination_size_formatter(arg3):
    return str(arg3) + "\n"

'''


def starts_player_formatter(arg4):
    if arg4 == "x" or arg4 == "X":
        return "0\n"
    else:
        return "1\n"


def result_type_formatter(arg5):
    if arg5 == "w" or arg5 == "W":
        return "WIN"
    else:
        return "DRAW"


def create_scenario():
    if result_type == "DRAW":
        return base_scenario + draw_combination()
    else:
        if combination_type == "V" or combination_type == "v":
            scenarios_list = win_combinations_vertical()
        elif combination_type == "H" or combination_type == "h":
            scenarios_list = win_combinations_horizontal()
        full_scenario_list = []
        for s in scenarios_list:
            full_scenario_list.append(base_scenario + s)
        return full_scenario_list


def draw_combination():
    board_size_int = int(board_size)
    gf = ""  # game flow
    step = 2
    p1x_start = 0
    p1y = 0
    p2x_start = 0
    p2y = 1
    if board_size_int%2 == 0:
        half_board_size = int(board_size_int / 2)
        for j in range(half_board_size):
            p1x = p1x_start + step*j
            p2x = p2x_start + step*j
            if j%2 == 0:
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
                    gf += str(board_size_int - 1 - step * i) + "\n"
                    gf += str(p2x) + "\n"
                    gf += str(board_size_int - 2 - step * i) + "\n"
                    gf += str(p1x + 1) + "\n"
                    gf += str(board_size_int - 1 - step * i) + "\n"
                    gf += str(p2x + 1) + "\n"
                    gf += str(board_size_int - 2 - step * i) + "\n"
    else:
        half_board_size = int((board_size_int - 1) / 2)
        for j in range(half_oard_size):
            p1x = p1x_start + step*j
            p2x = p2x_start + step*j
            if j%2 == 0:
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

    for i in range(half_board_size):
        gf += str(p1x + step * i) + "\n"
        gf += str(board_size_int - 1) + "\n"
        gf += str(p2x + step * i + 1) + "\n"
        gf += str(board_size_int - 1) + "\n"

    p1x = board_size_int - 1
    p2x = board_size_int - 1
    for i in range(half_board_size):
        gf += str(p1x) + "\n"
        gf += str(p1y + step * i) + "\n"
        gf += str(p2x) + "\n"
        gf += str(p2y + step * i) + "\n"

    gf += str(p1x) + "\n"
    gf += str(p1x) + "\n"

    return gf + "\n" + gf + "\n" + gf + "\n"


def win_combinations_vertical():
    board_size_int = int(board_size)
    combination_size_int = int(combination_size)
    number_of_wining_combination_in_column = board_size_int - combination_size_int + 1
    new_game_scenario_counter = 0
    p1x = 0
    p1y = 0
    p2x = 1
    p2y = 0
    gf_list = []
    gf = ""
    sgf = ""  # single game flow
    for i in range(board_size_int):
        for j in range(number_of_wining_combination_in_column):
            if i < board_size_int - 1:
                for k in range(combination_size_int - 1):
                    sgf += str(p1x + i) + "\n"
                    sgf += str(p1y + k + j) + "\n"
                    sgf += str(p2x + i) + "\n"
                    sgf += str(p2y + k + j) + "\n"
                sgf += str(p1x + i) + "\n"
                sgf += str(p1y + combination_size_int - 1 + j) + "\n"
                sgf += "\n"
            else:
                for k in range(combination_size_int - 1):
                    sgf += str(board_size_int - 1) + "\n"
                    sgf += str(p1y + k + j) + "\n"
                    sgf += str(0) + "\n"
                    sgf += str(p2y + k + j) + "\n"
                sgf += str(board_size_int - 1) + "\n"
                sgf += str(p1y + combination_size_int - 1 + j) + "\n"
                sgf += "\n"

            gf += sgf
            new_game_scenario_counter += 1
            if i == (board_size_int - 1) and j == (number_of_wining_combination_in_column - 1) and \
                    new_game_scenario_counter%3 != 0:
                while new_game_scenario_counter%3 != 0:
                    gf += sgf
                    new_game_scenario_counter += 1

            sgf = ""

            if new_game_scenario_counter%3 == 0:
                gf_list.append(gf)
                gf = ""

    return gf_list


def win_combinations_horizontal():
    board_size_int = int(board_size)
    combination_size_int = int(combination_size)
    number_of_wining_combination_in_column = board_size_int - combination_size_int + 1
    new_game_scenario_counter = 0
    p1x = 0
    p1y = 0
    p2x = 0
    p2y = 1
    gf_list = []
    gf = ""
    sgf = ""  # single game flow
    for i in range(board_size_int):
        for j in range(number_of_wining_combination_in_column):
            if i < board_size_int - 1:
                for k in range(combination_size_int - 1):
                    sgf += str(p1x + k + j) + "\n"
                    sgf += str(p1y + i) + "\n"
                    sgf += str(p2x + k + j) + "\n"
                    sgf += str(p2y + i) + "\n"
                sgf += str(p1x + combination_size_int - 1 + j) + "\n"
                sgf += str(p1y + i) + "\n"
                sgf += "\n"
            else:
                for k in range(combination_size_int - 1):
                    sgf += str(p1y + k + j) + "\n"
                    sgf += str(board_size_int - 1) + "\n"
                    sgf += str(p2x + k + j) + "\n"
                    sgf += str(0) + "\n"
                sgf += str(p1x + combination_size_int - 1 + j) + "\n"
                sgf += str(board_size_int - 1) + "\n"
                sgf += "\n"

            gf += sgf
            new_game_scenario_counter += 1
            if i == (board_size_int - 1) and j == (number_of_wining_combination_in_column - 1) and \
                    new_game_scenario_counter%3 != 0:
                while new_game_scenario_counter%3 != 0:
                    gf += sgf
                    new_game_scenario_counter += 1

            sgf = ""

            if new_game_scenario_counter%3 == 0:
                gf_list.append(gf)
                gf = ""

    return gf_list


language = language_chooser(args[1])
player1 = "Player1\n"
player2 = "Player2\n"
board_size = args[2]
accept_board_size = "0\n"
combination_size = args[3]
starts_player = starts_player_formatter(args[4])
result_type = result_type_formatter(args[5])
combination_type = args[6]
#combination_type = combination_type_formatter()

base_scenario = language + player1 + player2 + board_size + "\n" + accept_board_size + combination_size \
           + "\n" + starts_player

scenarios = create_scenario()

for scenario in scenarios:
    run_scenario(scenario)
    #print(scenario)

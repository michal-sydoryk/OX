from DrawScenario import DrawScenario
from HorizontalScenario import HorizontalScenario
from VerticalScenario import VerticalScenario
from Diagonal1Scenario import Diagonal1Scenario
from Diagonal2Scenario import Diagonal2Scenario

class ScenarioCreator:
    def __init__(self, variables):
        self.variables = variables

    def create_scenario(self):
        result = self.variables["game_result"]
        board_size = self.variables["board_size"]
        combination_size = self.variables["combination_size"]
        wining_combination = self.variables["winning_combination"]
        if result == "DRAW":
            game_flow_scenario = DrawScenario(board_size, combination_size)
            scenario = self.__create_base_scenario() + game_flow_scenario.create_scenario()
        elif result == "WIN":
            if wining_combination == "H":
                game_flow_scenario = HorizontalScenario(board_size, combination_size).create_scenario()
            elif wining_combination == "V":
                game_flow_scenario = VerticalScenario(board_size, combination_size).create_scenario()
            elif wining_combination == "D1":
                game_flow_scenario = Diagonal1Scenario(board_size, combination_size).create_scenario()
            elif wining_combination == "D2":
                game_flow_scenario = Diagonal2Scenario(board_size, combination_size).create_scenario()
            scenario = []

            for i in range(len(game_flow_scenario)):
                scenario.append(self.__create_base_scenario() + game_flow_scenario[i])
        else:
            print("unknown error")
            exit()

        return scenario

    def __create_base_scenario(self):
        accept_board_size = "0"

        base_scenario = ""
        base_scenario += str(self.variables["language"]) + "\n"
        base_scenario += "Player1" + "\n"
        base_scenario += "Player2" + "\n"
        base_scenario += str(self.variables["board_size"]) + "\n"
        base_scenario += accept_board_size + "\n"
        base_scenario += str(self.variables["combination_size"]) + "\n"
        base_scenario += str(self.variables["who_starts"]) + "\n"

        return base_scenario

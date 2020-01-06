class ScenarioCreator:
    def __init__(self, variables):
        self.variables = variables

    def create_scenario(self):
        pass

    def __create_base_scenario(self):
        accept_board_size = "0"

        base_scenario = ""
        base_scenario += str(self.variables["language"]) + "\n"
        base_scenario += "Player1" + "\n"
        base_scenario += "Player2" + "\n"
        base_scenario += str(self.variables["board_size"]) + "\n"
        base_scenario += accept_board_size + "\n"
        base_scenario += self.variables["combination_size"] + "\n"
        base_scenario += self.variables["who_starts"] + "\n"

        return base_scenario

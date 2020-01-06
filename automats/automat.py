from subprocess import run, PIPE
import sys
from InputFormatter import InputFormatter
from ScenarioCreator import ScenarioCreator


def run_scenario(scenario):
    process = run(['java', '-jar', 'target/ox-0.1.jar'], stdout=PIPE, encoding='utf-8', input=scenario)
    game_flow = process.stdout

    results = open("automated_tests.txt", "a")
    results.write(game_flow)
    results.write("\n------------------------------------------------------------------\n")


inputFormatter = InputFormatter(sys.argv)
try:
    variables = inputFormatter.format_input()
except Exception as exception:
    print(exception)
    exit()

scenario_creator = ScenarioCreator(variables)

scenarios = scenario_creator.create_scenario()

for scenario in scenarios:
    print(scenario)
    run_scenario(scenario)




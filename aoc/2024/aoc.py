import sys
from io import StringIO
def read_problem_input():
    filename = f'{sys.argv[0].split('/')[-1].strip('.py')}.in'
    sys.stdin = open(f"../inputs/advent-of-code/{filename}", "r")

def str_to_stdin(s):
    sys.stdin = StringIO(s)
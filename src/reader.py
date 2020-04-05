import pandas as pd
import sys

command = sys.argv[1]
file = sys.argv[2]

data = pd.read_csv(file)
if (command == "show_all"):
    print(data)
if (command == "columns"):
    print(data.columns.values)

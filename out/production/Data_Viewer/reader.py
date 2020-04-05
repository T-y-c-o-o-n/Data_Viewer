import pandas as pd
import sys

command = sys.argv[1]
file = sys.argv[len(sys.argv)-1]

data = pd.read_csv(file)
if (command == "show_all"):
    print(data)
if (command == "frame"):
    print(data.iloc[sys.argv[2]:sys.argv[3], sys.argv[4], sys.argv[5]])

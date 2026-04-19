#!/bin/bash

# Compile the project
echo "Compiling..."
mkdir -p bin
javac -d bin -sourcepath src src/egoproject/*.java

# Run the game
if [ $? -eq 0 ]; then
    echo "Launching game..."
    java -cp bin:res egoproject.Game
else
    echo "Compilation failed."
fi

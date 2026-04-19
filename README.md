# The EGO Project

A classic narrative-driven text adventure game with a graphical user interface, developed in Java.

## Story
You wake up on a normal school day, but things quickly take a dark turn. From missing shoes to mysterious kidnappings, you find yourself at the heart of the **EGO Project** (EGOMANIACS CORPORATION). Foil the mad scientist's plans, use your wits (and whatever items you can find), and save the world!

## Features
- **Interactive Dialogue**: Engage in branching conversations with various characters.
- **Inventory System**: Collect and combine items like raw eggs, pencil sharpeners, and dangerous gadgets to solve puzzles.
- **Classic UI**: A nostalgic Java Swing interface featuring location images and character icons.
- **Environmental Navigation**: Explore diverse rooms from your bedroom to a high-security dungeon and a mad scientist's lab.

## Project Structure
The repository is organized following standard Java project conventions:
- `src/`: Contains the Java source code files.
- `res/`: Contains game assets, including all location and character images.
- `bin/`: (Generated) Contains the compiled Java `.class` files.
- `run.sh` / `run.bat`: Quick-start scripts for running the game.

## Getting Started

### Prerequisites
- **Java Development Kit (JDK)**: Version 8 or higher is recommended.

### How to Run
We have provided easy-to-use scripts for both Windows and Unix-based systems.

#### On macOS and Linux:
1. Open your terminal.
2. Navigate to the project root directory.
3. Run the following command:
   ```bash
   ./run.sh
   ```

#### On Windows:
1. Navigate to the project root directory in File Explorer.
2. Double-click `run.bat` or run it from CMD/PowerShell:
   ```cmd
   run.bat
   ```

## Development
To manually compile and run the project, use the following commands from the root directory:

**Compile:**
```bash
javac -d bin -sourcepath src src/egoproject/*.java
```

**Run:**
```bash
java -cp "bin:res" egoproject.Game   # On macOS/Linux
java -cp "bin;res" egoproject.Game   # On Windows
```

## Credits
Developed by **Demetrios Eliades**.

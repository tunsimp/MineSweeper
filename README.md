# Minesweeper Game

## Introduction

This project is a Java implementation of the classic Minesweeper game, featuring a graphical user interface (GUI) built using Java Swing. The game includes various difficulty levels, undo functionality, and a user-friendly interface.

## Features

- **Multiple Difficulty Levels**: Choose between Easy, Medium, and Hard difficulty levels.
- **Undo Functionality**: Undo your last moves to correct mistakes.
- **Graphical User Interface**: Intuitive and interactive UI built with Java Swing.
- **Settings Menu**: Easily switch between different difficulty levels through a settings menu.

## Installation

### Clone the Repository or Download the ZIP file

1.1: Using Git:
```sh
git clone https://github.com/tunsimp/MineSweeper.git
cd MineSweeper-main
```

1.2: Download the ZIP file,unzip it, and then run this:
```sh
cd MineSweeper-main
```

### Compile the Code:
```sh
javac -d bin *.java
```

### Run the Game:
```sh
cd bin
java App
```

## Class Overview

### App

The entry point for the application. It initializes and starts the Minesweeper game.
```java
public class App {
    public static void main(String[] args) {
        MineSweeperFrame mineSweeperFrame = MineSweeperFrame.getInstance();
        mineSweeperFrame.play();
    }
}
```

### MineSweeperFrame

Manages the main game window and its components, including the game board, settings menu, and status display.

### BoardPanel

Handles the game logic, including mine placement, tile checking, and user interactions.

### BoardPanelFactory

Implements the Factory design pattern to create BoardPanel instances based on the selected difficulty level.

### CareTaker and Memento

Implement the Memento design pattern to manage game state saving and restoring, enabling undo functionality.

### MineTile

Represents each cell on the Minesweeper game board. Extends JButton to handle user interactions.

### SettingsMenu

Provides a settings menu to switch between different difficulty levels.

### SettingsPanel

Displays buttons for selecting the game's difficulty level and handles user interactions to set the difficulty.

### TextPanel

Displays text messages such as game status updates within the game window.

## How to Play

1. **Start the Game**:
   - Run the application. The main game window will appear.

2. **Select Difficulty**:
   - Use the settings menu to choose between Easy, Medium, and Hard difficulty levels.

3. **Play the Game**:
   - Left-click to uncover a cell.
   - Right-click to flag a suspected mine.
   - The goal is to uncover all cells that do not contain mines without detonating any mines.

4. **Undo Moves**:
   - Use the undo button in the Game Over frame to revert the last move if you make a mistake.
   - Another undo button is used to return to the last move you made.

## Contributors

- **Nguyen Quoc Tuan** – ITITIU22177
- **Bui Nguyen Thao Van** – ITITIU22218
- **Luong Quang Huy** – ITITIU22076

Feel free to reach out for any questions or suggestions regarding this project. Enjoy playing Minesweeper!

# Interactive Minesweeper Game

Welcome to the Interactive Minesweeper Game! This project is developed as part of a Data Structures and Algorithms course, with a focus on implementing design patterns and interactive gameplay. The game is built using Java and Swing for the GUI.

## Table of Contents

- [Overview](#overview)
- [Gameplay and Rules](#gameplay-and-rules)
- [Level Design](#level-design)
- [Design Patterns](#design-patterns)
- [Usage](#usage)
- [Conclusion](#conclusion)

## Overview

The Interactive Minesweeper Game is a classic puzzle game where players uncover tiles on a grid, avoiding mines and using numerical clues to identify the locations of the mines. The game includes features such as different difficulty levels, an undo functionality, and a user-friendly interface.

![image](https://github.com/tunsimp/MineSweeper/assets/125936708/83ca4943-d258-418a-9ba8-7635a4585001)

## Gameplay and Rules

### Objective
The objective of the game is to uncover all tiles that do not contain mines. If a player clicks on a tile that contains a mine, the game is over.

### Controls
- **Left Click**: Uncover a tile.
- **Right Click**: Flag or unflag a tile as a mine.

### Game States
- **Game Over**: The game ends when a mine is uncovered.
- **Victory**: The game is won when all non-mine tiles are uncovered.

## Undo Feature

The game includes two different undo buttons:

### 1. Undo Button on the Game Board
- This button is located at the top of the game board.
- It allows the player to undo their last move even they have not click the mine.
- To use this feature, simply click the "Undo" button on the top of the game window.
- Player can freely use this feature until the game is over.

### 2. Undo Button on the Game Over Frame
- When a player clicks on a mine and the game is over, a game over frame is displayed.
- This frame includes an "Undo" button that allows the player to undo their last move and continue playing.
- The same undo count limits apply as per the difficulty level.
- The number of undos available depends on the difficulty level:
  - **Easy**: 3 undos.
  - **Medium**: 2 undos.
  - **Hard**: 1 undo.
- To use this feature, click the "Undo" button on the game over frame when it appears.
If you run out of undos, you can either click undo or restart buttonfrom the game over frame to restart.

![image](https://github.com/tunsimp/MineSweeper/assets/125936708/2c3b5f9d-660d-4764-9cc9-49da74e278ac)

## Level Design

The game features three difficulty levels:
- **Easy**: 8x8 grid with 10 mines.
- **Medium**: 15x15 grid with 40 mines.
- **Hard**: 16x30 grid with 99 mines.

Each level offers a different grid size and number of mines, increasing the challenge as the difficulty level increases.

## Design Patterns

The project employs several design patterns to enhance its structure and maintainability:

### Singleton Pattern
- **MineSweeperFrame**: Ensures that there is only one instance of the main game frame.

### Memento Pattern
- **Memeto**: Stores the state of the game to allow undo functionality.
- **CareTaker**: Manages the stack of saved states.

### Factory Pattern
- **BoardPanelFactory**: Creates instances of `BoardPanel` based on the selected difficulty level.


## Usage

Once the game is running,the default level is easy. You can select the difficulty level from the settings menu and start playing by clicking on the tiles. Use the undo button if you make a mistake and want to revert your last move.

## Conclusion

This project demonstrates the application of design patterns in a fun and interactive way. The use of the Singleton, Memento, and Factory patterns enhances the maintainability and scalability of the code. Enjoy playing the Interactive Minesweeper Game!

## Authors

- **Nguyen Quoc Tuan**
- **Bui Nguyen Thao Van**
- **Luong Quang Huy**

We hope you enjoy the game and appreciate the efforts put into developing it! If you have any questions or suggestions, please feel free to reach out.

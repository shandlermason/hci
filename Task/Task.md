Please see the sample user story and acceptance criteria below.

User Story
Feature: Winning Tic-Tac-Toe
As a player I want to check if I have won the game in order to assess the current status of the
game.

Acceptance Criteria
A player wins when placing three of their marks in a horizontal, vertical, or diagonal row.
A player may only play once before the next player marks a space.
The game can have no winners, resulting in a tie.

Scenario
Player with three columns should win
Given a Tic-Tac-Toe game
When I play row 0, column 0
And I play row 1, column 0
And I play row 2, column 0
Then I should have won the game
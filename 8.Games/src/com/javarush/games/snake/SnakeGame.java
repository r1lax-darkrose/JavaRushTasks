package com.javarush.games.snake;
import com.javarush.engine.cell.*;

public class SnakeGame extends Game {

    public static final int WIDTH = 15;
    public static final int HEIGHT = 15;
    private final static int GOAL = 30;
    private int score;
    private Snake snake;
    private int turnDelay;
    private Apple apple;
    private boolean isGameStopped;

    public void initialize(){
        setScreenSize(WIDTH,HEIGHT);
        createGame();
    }

    private void drawScene(){
        for(int i = 0; i < WIDTH; i++){
            for (int j = 0; j < HEIGHT; j++){
                setCellValueEx(i, j, Color.DARKSEAGREEN, "");
            }
        }
        snake.draw(this);
        apple.draw(this);
    }

    private void createGame(){
        snake = new Snake(WIDTH/2, HEIGHT/2);
        isGameStopped = false;
        score = 0;
        setScore(score);
        createNewApple();
        drawScene();
        turnDelay = 300;
        setTurnTimer(turnDelay);


    }

    public void onTurn(int step) {
        snake.move(apple);
        if (!apple.isAlive){
            createNewApple();
            score += 5;
            setScore(score);
            turnDelay -= 10;
            setTurnTimer(turnDelay);
        }
        if (!snake.isAlive){
            gameOver();
        }
        if (GOAL < snake.getLength()){
            win();
        }

        drawScene();
    }


    public void onKeyPress(Key key) {
        if (key == Key.DOWN){
            snake.setDirection(Direction.DOWN);
        }
        else if (key == Key.LEFT){
            snake.setDirection(Direction.LEFT);
        }
        else if (key == Key.UP){
            snake.setDirection(Direction.UP);
        }
        else if (key == Key.RIGHT){
            snake.setDirection(Direction.RIGHT);
        }
        else if (key == Key.SPACE && isGameStopped){
            createGame();
        }
    }
    private void createNewApple(){
        do {
            apple = new Apple(getRandomNumber(WIDTH), getRandomNumber(HEIGHT));
        }while(snake.checkCollision(apple));
        }
    

    private void gameOver(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.BLACK, "GAME OVER", Color.RED, 75);
    }

    private void win(){
        stopTurnTimer();
        isGameStopped = true;
        showMessageDialog(Color.GREEN, "YOU WIN", Color.YELLOW,75);
    }
}
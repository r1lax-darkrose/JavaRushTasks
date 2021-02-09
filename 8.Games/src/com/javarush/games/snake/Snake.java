package com.javarush.games.snake;

import com.javarush.engine.cell.*;

import java.util.ArrayList;
import java.util.List;

public class Snake {

    private List<GameObject> snakeParts;
    private final static String HEAD_SIGN = "\uD83D\uDE95";
    private final static String BODY_SIGN = "\uD83D\uDE4E";
    private final static Color HEAD_COLOR = Color.BLUE;
    private final static Color BODY_COLOR = Color.BLUE;
    private final static Color DEATH_COLOR = Color.RED;
    public boolean isAlive;
    private Direction direction;

    public Snake(int x, int y){
        snakeParts = new ArrayList<>();
        snakeParts.add(new GameObject(x, y));
        snakeParts.add(new GameObject(x + 1, y));
        snakeParts.add(new GameObject(x + 2, y));
        isAlive = true;
        direction = Direction.LEFT;
    }

    public void draw(Game game){
        GameObject head = snakeParts.get(0);
        game.setCellValueEx(head.x, head.y, Color.NONE, HEAD_SIGN, isAlive ? HEAD_COLOR : DEATH_COLOR, 75);
        for (int i = 1; i < snakeParts.size(); i++) {
            GameObject body = snakeParts.get(i);
            game.setCellValueEx(body.x, body.y, Color.NONE, BODY_SIGN, isAlive ? BODY_COLOR : DEATH_COLOR, 75);
        }
    }



    public void move(Apple apple){

        GameObject newHead = createNewHead();
        if (checkCollision(newHead)){
            isAlive = false;
            return;
        }
        if (newHead.x < 0 || newHead.x >= SnakeGame.WIDTH ||
                newHead.y < 0 || newHead.y >= SnakeGame.HEIGHT){
            isAlive = false;
            return;
        }
        if (apple.x == newHead.x && apple.y == newHead.y){
            apple.isAlive = false;
        } else {
            removeTail();
        }
        snakeParts.add(0, newHead);

    }

    public GameObject createNewHead(){
        GameObject head = snakeParts.get(0);
        int x = head.x;
        int y = head.y;
        switch (direction){
            case UP: y--;
                break;
            case DOWN: y++;
                break;
            case LEFT: x--;
                break;
            case RIGHT: x++;
                break;
        }
        return new GameObject(x, y);
    }

    public void removeTail(){
        snakeParts.remove(snakeParts.size() - 1);
    }

    public void setDirection(Direction direction) {
        switch (direction) {
            case UP:
                if (this.direction == Direction.UP || this.direction == Direction.DOWN) return;
                break;
            case RIGHT:
                if (this.direction == Direction.RIGHT || this.direction == Direction.LEFT) return;
                break;
            case DOWN:
                if (this.direction == Direction.DOWN || this.direction == Direction.UP) return;
                break;
            case LEFT:
                if (this.direction == Direction.LEFT || this.direction == Direction.RIGHT) return;
                break;
        }
        this.direction = direction;
    }

    public boolean checkCollision(GameObject o){
        for (GameObject object : snakeParts) {
            if (object.x == o.x && object.y == o.y){
                return true;
            }
        }
        return false;
    }

    public int getLength(){
        return snakeParts.size();
    }


}

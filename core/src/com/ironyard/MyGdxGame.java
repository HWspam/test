package com.ironyard;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import javafx.animation.Animation;
import javafx.scene.effect.ColorInputBuilder;

public class MyGdxGame extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	TextureRegion up, down, left, right, stand;
	boolean faceRight = true;
	boolean faceLeft = true;
	boolean faceUp = true;
	boolean faceDown = true;
	Animation face;
	float time;
	float x, y;




	public void move() {
		if(Gdx.input.isKeyPressed(Input.Keys.DOWN)) {
			y--;
			faceUp = false;
		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP)) {
			y++;
			faceUp = true;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) {
			x--;

			faceRight = false;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			x++;

			faceRight = true;

		}

		if(Gdx.input.isKeyPressed(Input.Keys.DOWN) && (Gdx.input.isKeyPressed(Input.Keys.SPACE))) {
			y = y * 1.05f;
			faceUp=false;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.UP) && (Gdx.input.isKeyPressed(Input.Keys.SPACE))) {
			y = y * 1.05f;
			faceUp=true;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT) && (Gdx.input.isKeyPressed(Input.Keys.SPACE))) {
			x = x * 1.05f;


			faceRight = false;

		}
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT) && (Gdx.input.isKeyPressed(Input.Keys.SPACE))) {

			x = x * 1.05f;

			faceRight = true;

		}
		if(x < 0) {
			x = Gdx.graphics.getWidth();
		}
		if (x > Gdx.graphics.getWidth()) {
			x = 0;
		}
		if(y < 0) {
			y = Gdx.graphics.getHeight();
		}
		if (y>Gdx.graphics.getHeight()) {
			y = 0;
		}


	}
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		Texture tiles = new Texture("tiles.png");
		TextureRegion[][] grid = TextureRegion.split(tiles, 16, 16);
		stand = grid[6][4];
		down = grid[6][0];
		 up = grid[6][1];
		 right = grid[6][3];
		left = new TextureRegion(right);
		left.flip(true, false);
	}

	@Override
	public void render () {

		move();


		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		if (Gdx.input.isKeyPressed(Input.Keys.RIGHT)) {
			batch.draw(right, x, y);
		}else if (Gdx.input.isKeyPressed(Input.Keys.LEFT)){
			batch.draw(left, x,y);
		}else if (Gdx.input.isKeyPressed(Input.Keys.UP)) {
			batch.draw(up, x, y);

		}else {
			batch.draw(down, x, y);
		}
		batch.end();
	}


	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}

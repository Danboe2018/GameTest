package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

public class MyGdxGame extends ApplicationAdapter {

	private SpriteBatch batch;
	private TextureAtlas runAtlas;
	private Animation<TextureRegion> animation;
	private float timePassed = 0;


	@Override
	public void create () {
		batch = new SpriteBatch();
		runAtlas = new TextureAtlas(Gdx.files.internal("run.atlas"));
		animation = new Animation(1/15f,runAtlas.getRegions());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1,1,1,1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		batch.begin();
		timePassed += Gdx.graphics.getDeltaTime();
		batch.draw(animation.getKeyFrame(timePassed,true),300,300);
		batch.end();

	}

	@Override
	public void dispose() {
		batch.dispose();
		runAtlas.dispose();
	}
}

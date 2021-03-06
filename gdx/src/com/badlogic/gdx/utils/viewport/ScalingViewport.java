/*******************************************************************************
 * Copyright 2011 See AUTHORS file.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/

package com.badlogic.gdx.utils.viewport;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.Scaling;

/** A viewport that scales the world using {@link Scaling}.
 * <p>
 * {@link Scaling#fit} keeps the aspect ratio by scaling the world up to fit the screen, adding black bars (letterboxing) for the
 * remaining space.
 * <p>
 * {@link Scaling#fill} keeps the aspect ratio by scaling the world up to take the whole screen (some of the world may be off
 * screen).
 * <p>
 * {@link Scaling#stretch} does not keep the aspect ratio, the world is scaled to take the whole screen.
 * <p>
 * {@link Scaling#none} keeps the aspect ratio by using a fixed size world (the world may not fill the screen or some of the world
 * may be off screen).
 * @author Daniel Holderbaum
 * @author Nathan Sweet */
public class ScalingViewport extends Viewport {
	private Scaling scaling;

	/** Creates a new viewport using a new {@link OrthographicCamera}. */
	public ScalingViewport (Scaling scaling, float worldWidth, float worldHeight) {
		this(scaling, worldWidth, worldHeight, new OrthographicCamera());
	}

	public ScalingViewport (Scaling scaling, float worldWidth, float worldHeight, Camera camera) {
		this.scaling = scaling;
		this.worldWidth = worldWidth;
		this.worldHeight = worldHeight;
		this.camera = camera;
	}

	@Override
	public void update (int screenWidth, int screenHeight, boolean centerCamera) {
		Vector2 scaled = scaling.apply(worldWidth, worldHeight, screenWidth, screenHeight);
		viewportWidth = Math.round(scaled.x);
		viewportHeight = Math.round(scaled.y);
		// center the viewport in the middle of the screen
		viewportX = (screenWidth - viewportWidth) / 2;
		viewportY = (screenHeight - viewportHeight) / 2;
		super.update(screenWidth, screenHeight, centerCamera);
	}

	public Scaling getScaling () {
		return scaling;
	}

	public void setScaling (Scaling scaling) {
		this.scaling = scaling;
	}

	/** Returns the left gutter width in screen coordinates. */
	public int getLeftGutterWidth () {
		return viewportX;
	}

	/** Returns the right gutter x in screen coordinates. */
	public int getRightGutterX () {
		return viewportX + viewportWidth;
	}

	/** Returns the right gutter width in screen coordinates. */
	public int getRightGutterWidth () {
		return Gdx.graphics.getWidth() - (viewportX + viewportWidth);
	}

	/** Returns the bottom gutter height in screen coordinates. */
	public int getBottomGutterHeight () {
		return viewportY;
	}

	/** Returns the top gutter y in screen coordinates. */
	public int getTopGutterY () {
		return viewportY + viewportHeight;
	}

	/** Returns the top gutter height in screen coordinates. */
	public int getTopGutterHeight () {
		return Gdx.graphics.getHeight() - (viewportY + viewportHeight);
	}

	public String toString () {
		return getClass().getSimpleName() + ": " + scaling;
	}
}

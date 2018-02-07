package EngineTester;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class SolverCanvas extends Canvas {
	private static final long serialVersionUID = -6828443604112305057L;

	public SolverCanvas() {
		this.setBackground(Color.GRAY);
	}

	int[][][] cubeData = null;

	public void draw() {
		BufferedImage image;
		Graphics g;
		image = new BufferedImage(this.getWidth(), this.getHeight(), BufferedImage.TYPE_INT_ARGB);
		g = this.getGraphics();
		int[][] coords = { { 500, 0 }, { 800, 300 }, { 500, 300 }, { 200, 300 }, { 1100, 300 }, { 500, 600 } };
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 4; j++) {
				for (int k = 0; k < 4; k++) {
					switch (cubeData[i][j][k]) {
					case 1:
						g.setColor(Color.YELLOW);
						break;
					case 2:
						g.setColor(Color.RED);
						break;
					case 3:
						g.setColor(Color.BLUE);
						break;
					case 4:
						g.setColor(Color.decode("#FF6F00"));
						break;
					case 5:
						g.setColor(Color.GREEN);
						break;
					case 6:
						g.setColor(Color.WHITE);
						break;
					}
					g.fillRect(k * 70 + coords[i][0], j * 70 + coords[i][1], 65, 65);
				}
			}
		}
	}

	public void addEventQueue(SolverEventQueue queue) {

		this.addKeyListener(queue);
		this.addMouseListener(queue);
		this.addMouseMotionListener(queue);

		return;
	}

	public void updateCubeData(int[][][] cubeData) {
		this.cubeData = cubeData;
	}
	/*
	 * ╭━━━━╮ ╰┃ ┣▇━▇ ┃ ┃ ╰━▅╮ ╰┳╯ ╰━━┳╯ ╰╮ ┳━━╯ ▕▔▋ ╰╮╭━╮ ╱▔╲▋╰━┻┻╮╲╱▔▔▔╲ ▏ ▔▔▔▔▔▔▔
	 * O O┃ ╲╱▔╲▂▂▂▂╱▔╲▂▂▂╱ ▏╳▕▇▇▕ ▏╳▕▇▇▕ ╲▂╱╲▂╱ ╲▂╱╲﻿
	 */
}

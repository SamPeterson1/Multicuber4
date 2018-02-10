package EngineTester;

import GUI.SolverCanvas;
import GUI.SolverEvent;
import GUI.SolverEventQueue;
import GUI.SolverFrame;
import Lib.Algorithm;
import Lib.Cube;
import Lib.FaceUtils;
import Lib.Map;
import Solvers.CenterSolver;
import Utils.Commutator;

public class Main {
	
	
	public static void main(String args[]) {
		SolverEventQueue queue = new SolverEventQueue();
		SolverEvent event = null;
		SolverFrame frame = new SolverFrame();
		SolverCanvas canvas = new SolverCanvas();
		frame.addCanvas(canvas);
		canvas.addEventQueue(queue);
		int layer = 1;
		Map m = new Map();
		Cube cube = new Cube();
		CenterSolver c = new CenterSolver(); 
		while(true) {
			canvas.updateCubeData(cube.getCube());	
			if(queue.isEventToProcess()) {
				event = queue.getEvent();
				
				if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseLeftButton()) {
						int x = event.getMouseX();
						int y = event.getMouseY();
						if(inBounds(x,y, 500, 0, 300, 300)) {
							m.applyMap(cube, true, Map.TOPFACE, layer);
						}
						if(inBounds(x,y, 800, 300, 300, 300)) {
							m.applyMap(cube, true, Map.RIGHTFACE, layer);
						}
						if(inBounds(x,y, 500, 300, 300, 300)) {
							m.applyMap(cube, true, Map.FRONTFACE, layer);
							System.out.println("HIIC");
						}
						if(inBounds(x,y, 200, 300, 300, 300)) {
							m.applyMap(cube, true, Map.LEFTFACE, layer);
						}
						if(inBounds(x,y, 1100, 300, 300, 300)) {
							m.applyMap(cube, true, Map.BACKFACE, layer);
						}
						if(inBounds(x,y, 500, 600, 300, 300)) {
							m.applyMap(cube, true, Map.BOTTOMFACE, layer);
						}
					} else if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseRightButton()) {
						int x = event.getMouseX();
						int y = event.getMouseY();
						if(inBounds(x,y, 500, 0, 300, 300)) {
							m.applyMap(cube, false, Map.TOPFACE, layer);
						}
						if(inBounds(x,y, 800, 300, 300, 300)) {
							m.applyMap(cube, false, Map.RIGHTFACE, layer);
						}
						if(inBounds(x,y, 500, 300, 300, 300)) {
							System.out.println("HIICC");
							m.applyMap(cube, false, Map.FRONTFACE, layer);
						}
						if(inBounds(x,y, 200, 300, 300, 300)) {
							m.applyMap(cube, false, Map.LEFTFACE, layer);
						}
						if(inBounds(x,y, 1100, 300, 300, 300)) {
							m.applyMap(cube, false, Map.BACKFACE, layer);
						}
						if(inBounds(x,y, 500, 600, 300, 300)) {
							m.applyMap(cube, false, Map.BOTTOMFACE, layer);
						}
					} else if(event.getType() == SolverEvent.EVENT_MOUSE_BUTTON_PRESS & event.isMouseMiddleButton()) {
						int x = event.getMouseX();
						int y = event.getMouseY();
						if(inBounds(x,y, 500, 0, 300, 300)) {
							m.applyMap(cube, false, Map.TOPFACE, layer);
							m.applyMap(cube, false, Map.TOPFACE, layer);
						}
						if(inBounds(x,y, 800, 300, 300, 300)) {
							m.applyMap(cube, false, Map.RIGHTFACE, layer);
							m.applyMap(cube, false, Map.RIGHTFACE, layer);
						}
						if(inBounds(x,y, 500, 300, 300, 300)) {
							m.applyMap(cube, false, Map.FRONTFACE, layer);
							m.applyMap(cube, false, Map.FRONTFACE, layer);
						}
						if(inBounds(x,y, 200, 300, 300, 300)) {
							m.applyMap(cube, false, Map.LEFTFACE, layer);
							m.applyMap(cube, false, Map.LEFTFACE, layer);
						}
						if(inBounds(x,y, 1100, 300, 300, 300)) {
							m.applyMap(cube, false, Map.BACKFACE, layer);
							m.applyMap(cube, false, Map.BACKFACE, layer);
						}
						if(inBounds(x,y, 500, 600, 300, 300)) {
							m.applyMap(cube, false, Map.BOTTOMFACE, layer);
							m.applyMap(cube, false, Map.BOTTOMFACE, layer);
						}
					}
				if(event.getType() == SolverEvent.EVENT_KEY_PRESS & event.getKeyChar() == 'c') {
					layer = cycle(layer, 3);
					System.out.println(layer);
					new FaceUtils(cube, Map.BACKFACE);
					c.solveCenter(0, cube);
				}
			}
			canvas.draw();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	public static boolean inBounds(int x1, int y1, int x2, int y2, int width, int height) {
		if(x1 >= x2 & x1 <= x2 + width & y1 >= y2 & y1 <= y2 + height) {
			return true;
		}			
		return false;
	}
		
	public static int cycle(int i, int lim) {
		i ++;
		if(i > lim) {
			i = 0;
		}
		return i;
	}
}


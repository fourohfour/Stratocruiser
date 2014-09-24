package io.github.fourohfour.stratocruiser;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;
import org.lwjgl.opengl.GL11;

public class StratocruiserEditor {
	private Map<Integer, DrawingFrame> frames;
	private Integer selected;
	
	public StratocruiserEditor(int width, int height){
		try{
		    Display.setDisplayMode(new DisplayMode(width, height));
		    Display.create();
		    
			GL11.glMatrixMode(GL11.GL_PROJECTION);
			GL11.glLoadIdentity();
			GL11.glOrtho(0, width, 0, height, 1, -1);
			GL11.glMatrixMode(GL11.GL_MODELVIEW);
			
			frames = new HashMap<>();
			frames.put(0, new EditorWindow(201, 2, 597, 500));
			frames.put(1, new NavDrawer(2, 2, 197, 550));
			selected = 0;
			
			this.mainLoop();
		}
		catch (LWJGLException e){
			Stratocruiser.debug("Creation of StratocruiserEditor instance failed.")                                   ;
			Stratocruiser.debug(e.getMessage());
			Stratocruiser.debug("Aborting initialisation.");
			return;
		}
	}

	private void mainLoop() {
		while(!Display.isCloseRequested()){
			Display.sync(20);
			for(DrawingFrame f : frames.values()){
				f.draw();
			}
			
			while(Keyboard.next()){
				if(Keyboard.getEventKeyState()){
					DrawingFrame sFrame = frames.get(selected);
					sFrame.onKeypressEvent(Keyboard.getEventKey());
				}
			}
			
			while(Mouse.next()){
				if(Mouse.getEventButtonState()){
					DrawingFrame sFrame = frames.get(selected);
					int x = Mouse.getEventX();
					int y = Mouse.getEventY();
					if(sFrame.isWithinBounds(x, y)){
						sFrame.onMouseClickEvent(sFrame.withFrameX(x), sFrame.withFrameY(y));
					}
					else{
						for(Integer i : frames.keySet()){
							DrawingFrame frame = frames.get(i);
							if(frame.isWithinBounds(x, y)){
								selected = i;
							}
						}
					}
				}
			}
			Display.update();
		}
		Display.destroy();
	}
}


package io.github.fourohfour.stratocruiser;

import io.github.fourohfour.displayutils.text.BasicFont;
import io.github.fourohfour.displayutils.text.TextWriter;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

public class EditorWindow extends DrawingFrame{

	private List<String> content;
	private int ctop = 0;
	
	private int size = 2;
	
	private int topmargin = 10;
	
	public EditorWindow(int x, int y, int xsize, int ysize) {
		super(x, y, xsize, ysize);

		this.content = new ArrayList<>();
		this.content.add("First Line");
		this.content.add("Second Line");
	}
	
	public void setContent(List<String> c){
		this.content = c;
	}

	@Override
	public void draw() {
		TextWriter tw = new TextWriter();
		tw.font = new BasicFont();
		tw.scale = size;
		
		GL11.glColor3d(1.0, 1.0, 1.0);
		
	    GL11.glBegin(GL11.GL_QUADS);
	    
	    GL11.glVertex2f(withFrameX(800), withFrameY(550));
	    
	    GL11.glVertex2f(withFrameX(0), withFrameY(550));
	    
	    GL11.glVertex2f(withFrameX(0), withFrameY(0));

	    GL11.glVertex2f(withFrameX(800), withFrameY(0));
	    
	    GL11.glEnd();
	    
		GL11.glColor3d(0, 0, 0);
		
		int c = 1;
		for(String s : content){
			int writey = this.getYSize() - topmargin - (tw.font.res*tw.scale*c) - (tw.font.space*tw.scale*c);
		    tw.write(withFrameX(10), withFrameY(writey), s);
		    c++;
		}
	}
	
	@Override
	public void onKeypressEvent(int key){
		this.content.add(Keyboard.getKeyName(key));
	}
	
	@Override
	public void onMouseClickEvent(int x, int y){
		this.content.add(String.valueOf(x) + " " + String.valueOf(y));
	}
	
	
}

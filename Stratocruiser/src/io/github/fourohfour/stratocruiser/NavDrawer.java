package io.github.fourohfour.stratocruiser;

import org.lwjgl.opengl.GL11;

public class NavDrawer extends DrawingFrame{

	public NavDrawer(int x, int y, int xsize, int ysize) {
		super(x, y, xsize, ysize);
	}

	@Override
	public void draw() {
		GL11.glColor3d(1.0, 0.95, 0.65);
		
	    GL11.glBegin(GL11.GL_QUADS);
	    
	    GL11.glVertex2f(withFrameX(195), withFrameY(573));
	    
	    GL11.glVertex2f(withFrameX(0), withFrameY(573));
	    
	    GL11.glVertex2f(withFrameX(0), withFrameY(0));

	    GL11.glVertex2f(withFrameX(195), withFrameY(0));
	    
	    GL11.glEnd();
	    
		GL11.glColor3d(0, 0, 0);
	}

}

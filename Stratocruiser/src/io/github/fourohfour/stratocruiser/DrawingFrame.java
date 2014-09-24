package io.github.fourohfour.stratocruiser;

public abstract class DrawingFrame {
	private int x;
	private int y;
	private int xsize;
	private int ysize;

	public DrawingFrame(int x, int y, int xsize, int ysize){
		this.x = x;
		this.y = y;
		this.xsize = xsize;
		this.ysize = ysize;	
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getXSize(){
		return xsize;
	}
	
	public int getYSize(){
		return ysize;
	}
	
	public int withFrameX(int x){
		if(x < 0){
			x = 0;
		}
		else if (x > this.xsize){
			x = this.xsize;
		}
		return this.x + x;
	}
	
	public int withFrameY(int y){
		if(y < 0){
			y = 0;
		}
		else if (y > this.ysize){
			y = this.ysize;
		}
		return this.y + y;
	}
	
	public boolean isWithinBounds(int x, int y){
		if((x > this.x) && (x < this.x + xsize)){
			if((y > this.y) && (y < this.y + ysize)){
				return true;
			}
		}
		return false;
	}
	
	public abstract void draw();
	
	public void onKeypressEvent(int key){ }
	
	public void onMouseClickEvent(int x, int y){ }
	
	public void onSelectEvent(){ }
	
	public void onDeselectEvent(){ }
}



import processing.core.*;

public class FiltroImpressionismo extends PApplet 
{
	public static void main(String[] args) 
	{
		System.out.println("Helloooooooo");
		PApplet.main("FiltroImpressionismo");	
	}
	
	public void settings()
	{
		size(1200, 800);
	}
	
	public void setup()
	{		
		 background(255);
		 
	}
	
	PImage foto;
	int ind_img = 1,
		tam_pincelada = 10,
		orient = 30,
		peso_max = 30;
	
	float escala = 1;
	
	public void draw()
	{
		
		pintar();
	}
	
	float diagonal( float x, float y )
	{
		return (float)Math.sqrt( pow( x, 2) + pow( y, 2) );
	}
	
	public void pintar()
	{
		 String imgs[]= { "thamara.jpg","thamara2.jpeg"};
			 foto = loadImage(imgs[ind_img]);
			 foto.loadPixels();
			 //escala =  (float)( (float)diagonal(foto.width, foto.height)/diagonal(width, height));
			 //if ( foto.width > width || foto.height > height escala > 1 ) escala = 1 - escala;
			 scale( (float)0.8 );
			 
			for( int x=0; x < foto.width; x++ )
			  {
				  for(int y = 0; y < foto.height; y+=10 )
				  {
					  int c = x + y*foto.width;
					  stroke(color(red(foto.pixels[c]), green(foto.pixels[c]),blue(foto.pixels[c])));
					  strokeWeight(random(2,peso_max));
					  line(x,y,x + random(0, orient),y+tam_pincelada);
				  }
			  }
			noLoop();
	//		save("pintura.png");
			
			if ( key == 's') save("pintura.png");
			
			/*if ( keyPressed  )
			{
				if ( i < 7) i++;
				else i = 0;
				background(255);
			}*/
	}
	
	
}

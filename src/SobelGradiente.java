import processing.core.*;

public class SobelGradiente
{
	PImage mapaGradiente;
	float Gx[];
	float Gy[];
	
	public SobelGradiente(PImage img ) {
		this.mapaGradiente = new PImage(img.width, img.height );
		this.Gx = new float[img.width*img.height];
		this.Gy = new float[img.width*img.height];
	}
	
	public PImage processar( PImage img )
	{
		int Sx[][] = {{-1,0,1},{-2,0,2},{-1,0,1}},
		    Sy[][] = {{1,2,1},{0,0,0},{-1,-2,-1}},
		    k, 
		    px,
		    py;
		
		img.loadPixels();	
			for ( int x = 1; x < img.width - 2; x++ )
			{
				for ( int y = 1; y < img.height - 2; y++ )
				{
					k = indice(x,y);
					this.Gx[k]= px = multiplicar(Sx, img, x, y);
					this.Gy[k]= py = multiplicar(Sy, img, x, y);
//					this.mapaGradiente.pixels[ indice(x,y) ] = (int)Math.sqrt( Math.pow( px, 2) + Math.pow( py, 2) );
					this.mapaGradiente.pixels[ k ] = px + py;
				}
			}
		return this.mapaGradiente;
	}
	
	public int multiplicar( int S[][], PImage img, int x, int y )
	{
		 int resultado = S[0][0]*img.pixels[ indice(x-1,y-1) ] +
						 S[0][1]*img.pixels[ indice(x,y-1) ] +
						 S[0][2]*img.pixels[ indice(x+1,y-1) ] +
						 
						 S[1][0]*img.pixels[ indice(x-1,y) ] +
						 S[1][1]*img.pixels[ indice(x,y) ] +
						 S[1][2]*img.pixels[ indice(x+1,y) ] +
						 
						 S[2][0]*img.pixels[ indice(x-1,y+1) ] +
						 S[2][1]*img.pixels[ indice(x,y+1) ] +
						 S[2][2]*img.pixels[ indice(x+1,y+1) ];
		 
		 return resultado;
	}
	
	public int indice( int x, int y)
	{
		return x + y*this.mapaGradiente.width;
	}
	
	
}

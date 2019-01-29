package pixLab.classes;

import pixLab.classes.*;
import java.awt.*;
import java.awt.font.*;
import java.awt.geom.*;
import java.awt.image.BufferedImage;
import java.text.*;
import java.util.*;
import java.util.List; // resolves problem with java.awt.List and java.util.List
import java.util.Random;
import javax.swing.*;;

public class MathClass
{
	public static Picture toMath;
	
	public MathClass()
	{
		
	}
	
	public MathClass(Picture image)
	{
		System.out.println("math class initialized");
		toMath = image;
		greenUnder30Glitch(toMath);
		image.explore();
	}
	

	
//////////////////////////////////// T H I N G S /////////////////////////////////////
	

	public Pixel[][] greenUnder30Glitch(Picture image)
	{
		Pixel[][] grid = image.getPixels2D();
		Pixel[][] newGrid = image.getPixels2D();
		Pixel sample;
		Pixel replace;
		
		int maxRow = grid.length;
		int maxCol = grid[0].length;
		
		int repeats = 0;
		
		while(repeats < 30)
		{
			for(int row = 0; row < maxRow; row++)
			{
				for(int col = 0; col < maxCol; col++)
				{
					sample = grid[row][col];
					
					if(sample.getGreen() < 30)
					{
						for(int gU30 = 0; gU30 < maxCol; gU30 = (int) ((Math.sqrt((double) row) / (col + row + getHypotenuse(row, col)))))
						{
							replace = sample;
							replace.setRed(sample.getGreen());
							replace.setBlue(gU30);
							replace.setGreen((int) sample.getGreen() + (col / 255));
							
							newGrid[row][col] = replace;
						}
						
					}
				}
			}
		}
		
		for(int row = 0, col = 0; row < maxRow && col < maxCol; row++, col++)
		{
			grid[row][col].setColor(newGrid[row][col].getColor());
		}
		return grid;
	}
	
	public int getHypotenuse(int a, int b)
	{
		double hypotenuse;
		
		hypotenuse = Math.sqrt((a * a) + (b * b));
		
		return (int) hypotenuse;
	}
	
	
	public static void main(String[] args)
	{
		MathClass mathClass = new MathClass();
	}

}

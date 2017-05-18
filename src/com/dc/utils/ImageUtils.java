package com.dc.utils;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.util.Random;

import javax.servlet.http.HttpSession;

public class ImageUtils
{
	public static BufferedImage getVerifyImage(HttpSession session)
	{
		int width=60,height=30,imageType=BufferedImage.TYPE_INT_RGB;
		BufferedImage image=new BufferedImage(width, height, imageType);
		Graphics g=image.getGraphics();
		g.setColor(new Color(200, 200, 200));
		g.fillRect(0, 0, width, height);
		String str[]= {"2","3","4","5","6","7","8","9","z","x","c","v","b","n","m","a","s","d",
				"f","g","h","j","k","q","w","e","r","t","y","u","i","p"};
		Random random=new Random();
		int i1=random.nextInt(32);
		int i2=random.nextInt(32);
		int i3=random.nextInt(32);
		int i4=random.nextInt(32);
		String VerificationCode=str[i1]+str[i2]+str[i3]+str[i4];
		session.setAttribute("Verification", VerificationCode);
		g.setColor(Color.red);
		g.setFont(new Font("",Font.PLAIN,20));
		g.drawString(VerificationCode, 15, 22);
		return image;
	}
}

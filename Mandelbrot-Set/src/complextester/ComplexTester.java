/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package complextester;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.swing.JFrame;

/**
 *
 * @author huank4253
 */
public class ComplexTester extends JFrame{
    
    int width = 1500;
    int height = 1500;
    double maxA = 1;
    double minA = -3;
    double maxB = 2;
    double minB = -2;

    public void paint(Graphics g){
        Image img = createImage();
        g.drawImage(img,8,30,this);
    }
    
    public Image createImage(){
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        Graphics g = bufferedImage.getGraphics();
        
        
        for (double i = minA; i < maxA; i+= (maxA-minA)/width){
            for (double j = minB; j < maxB ; j+= (maxB-minB)/height){
                
                ComplexNumber c = new ComplexNumber(i,j);
                boolean set = c.inSet();
                if (set == true){
                    g.setColor(Color.white);
                }
                else{
                    
                    Color col = new Color(c.n,c.n,c.n);
                    g.setColor(col);
                }
                g.fillRect(getScreenX(i),getScreenY(j),2,2);
            }
        }
        return bufferedImage;
        
    }
    
    public void initializeWindow(){
        setTitle("Mandelbrot set");
        setSize(height, width);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBackground(Color.black);
        setVisible(true);          
    }
    
    public int getScreenX(double a){
        double pixPerUnitX = width/(maxA-minA);
        //System.out.println(pixPerUnitX);
        double x = pixPerUnitX*Math.abs(a-minA);
        return (int)x;
    }
    
    public int getScreenY(double b){
        double pixPerUnitY = height/(maxB-minB);
        //System.out.println(pixPerUnitY);
        double y = pixPerUnitY*Math.abs(b-maxB);
        return (int)y;
    }
    
    
    public static void main(String[] args) {
        
        ComplexTester ct = new ComplexTester();
        ct.initializeWindow();
        /*
        ComplexNumber z = new ComplexNumber(-2,-6);
        ComplexNumber w = new ComplexNumber(1, -2);
        ComplexNumber a = new ComplexNumber(2,0);
        ComplexNumber b = new ComplexNumber(3, -4);
        z.multiply(z).add(w).absoluteValue().display();
        
        z.add(w).display();
        a.multiply(b).display();
        z.division(b).display();
        b.division(a).display();
        
        int x = ct.getScreenX(0);
        int y = ct.getScreenY(0);
        System.out.println(x);
        System.out.println(y);
        */
    }
}

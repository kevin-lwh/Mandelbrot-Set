/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package complextester;

/**
 *
 * @author huank4253
 */
public class ComplexNumber {
    double a;
    double b;
    int n;
    
    //CONSTRUCTORS
    public ComplexNumber(double a, double b){
        this.a = a;
        this.b = b;
    }
    
    
    //METHODS
    public void display(){
        if (a == 0 && b == 0){
          System.out.println(0);  
        }
        else if (b == 0){
            System.out.println(a);
        }
        else if (a == 0){
            System.out.println(b + "i");
        }
        else if (b < 0){
            System.out.println(a + "-" + b*-1 + "i");
        }
        else if (b > 0){
            System.out.println(a + "+" + b + "i");
        }
    }
    
    public ComplexNumber add(ComplexNumber other){
        double a,b;
        a = this.a + other.a;
        b = this.b + other.b;
        return new ComplexNumber(a,b);
    }
    
    public ComplexNumber multiply(ComplexNumber other){
        double a,b;
        double a1,b1,b2,c;
        a1 = this.a * other.a;
        b1 = this.a * other.b;
        b2 = this.b * other.a;
        b = b1 + b2;
        c = this.b * other.b;
        a = a1 + c*-1;
        return new ComplexNumber(a,b);
    }
    
    public ComplexNumber absoluteValue (){
        double a;
        a = Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2));
        return new ComplexNumber(a,0);
    }
    
    public ComplexNumber conjugate(){
        return new ComplexNumber(a,b*-1);
    }
    
    public ComplexNumber division(ComplexNumber other){
        double a,b;
        ComplexNumber c = this.multiply(other.conjugate());
        a = c.a/Math.pow(other.absoluteValue().a,2);
        b = c.b/Math.pow(other.absoluteValue().a,2);
        return new ComplexNumber(a,b);
    }
    
    public boolean inSet(){
        ComplexNumber z = new ComplexNumber(this.a,this.b);
        n = 1;
        while (z.absoluteValue().a<2 && n <200){
            z = z.multiply(z).add(this);
            n ++;
        }
        if (n<200){
            return false;
        }
        else{
            return true;
        }
    }
    
}

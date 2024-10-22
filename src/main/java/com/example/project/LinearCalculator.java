package com.example.project;
public class LinearCalculator{
    //INSTANCE VARIABLES 
    //4 INTEGER variables (name them: x1,x2,y1,y2) 
    private int x1;
    private int x2;
    private int y1;
    private int y2;



    //CONSTRUCTOR
    //1 constructor with 2 String parameters. Each parameter represents a coordinate. 
    //For example, "(1,2)" and "(3,4)" would be two parameter values 
    //You will have to parse the string into 4 integers, representing the 2 points.
    public LinearCalculator(String cord1, String cord2){ // <--add 2 string parameters to this constructor
        x1 = Integer.parseInt(cord1.substring(cord1.indexOf("(") + 1, cord1.indexOf(",")));
        x2 = Integer.parseInt(cord2.substring(cord2.indexOf("(") + 1, cord2.indexOf(",")));
        y1 = Integer.parseInt(cord1.substring(cord1.indexOf(",") + 1, cord1.indexOf(")")));
        y2 = Integer.parseInt(cord2.substring(cord2.indexOf(",") + 1, cord2.indexOf(")")));
    }



    //METHODS
    //getters and setters for the 4 instance variables (8 methods total) 
    public int getX1(){
        return x1;
    }
    public int getY1(){
        return y1;
    }
    public int getX2(){
        return x2;
    }
    public int getY2(){
        return y2;
    }
    public void setX1(int xvalue1){
        x1 = xvalue1;
    }
    public void setY1(int yvalue1){
        y1 = yvalue1;
    }
    public void setX2(int xvalue2){
        x2 = xvalue2;
    }
    public void setY2(int yvalue2){
        y2 = yvalue2;
    }


    //distance() -> returns a double. 
    //calculates the distance between the two points to the nearest HUNDREDTH and returns the value.
    public double distance(){
        double distance = Math.sqrt(Math.pow((y2 - y1), 2) + (Math.pow((x2 - x1), 2)));
        distance = (Math.round(distance * 100)) / 100.0;
        return distance;
    }
    //yInt() -> returns a double.
    //calculates the y intercept of the equation and returns the value to the nearest HUNDREDTH
    //if y-int if undefined, should return -999.99
    public double yInt(){
        double slope = (double) (y2 - y1) / (x2 - x1);
        slope = Math.round(slope * 100.0);
        slope /= 100.0;
        if (slope == 1.0/0.0){
            slope = -999.99;
            return -999.99;
            
        }
        if (slope() == -999.99 && (double) Math.round(((double) y1 - (x1 * slope)) * 100) / 100.0 == 0){
            return -999.99;
        }
        return (double) Math.round(((double) y1 - (x1 * slope)) * 100) / 100.0;
    }

    //slope() -> returns a double. 
    //calculates the slope of the equations and returns the value to the nearest HUNDREDTH
    //if slope is undefined, should return -999.99
    public double slope(){
        double slope = (double) (y2 - y1) / (x2 - x1);
        if (slope == 1.0/0.0){
            return -999.99;
        }
        slope = Math.round(slope * 100.0);
        slope /= 100.0;
        return slope;
    }

    //equations() -> returns a String.
    //calculates the final equation in y=mx+b form and returns the string
    //if the equation has no slope, the equation should return -> "undefined"
    //HINT: You may need other custom methods to decrease the amount of code in the equations() method
    public String equation(){
        if (slope() == -999.99){
            return "undefined";
        }
        if (yInt() == 0.0){
            return "y=" + slope() + "x";
        }
        if (slope() == 0.0){
            return "y=" + yInt();
        }
        if (yInt() < 0){
            return "y=" + slope() + "x" + yInt() ;
        }
        return "y=" + slope() + "x+" + yInt() ;
    }


    //roundedToHundredth(double x)-> returns double
    //calculates the input to the nearest hundredth and returns that value
    public double roundedToHundredth(double x){
        x *= 100;
        x = Math.round(x);
        x /= 100;
        return x;
    }

    //printInfo() -> returns a string of information
    //this method is tested but you can also call it in your main method if gradle tests are 
    //not working. 
    public String printInfo(){
        String str = "The two points are: (" + x1 + "," + y1 + ")";
        str += " and " + "(" + x2 + "," + y2 + ")";
        str += "\nThe equation of the line between these points is: " + equation();
        str += "\nThe slope of this line is: " + slope();
        str += "\nThe y-intercept of the line is: " + yInt();
        str += "\nThe distance between the two points is: " + distance();
 
        return str;
    }



}
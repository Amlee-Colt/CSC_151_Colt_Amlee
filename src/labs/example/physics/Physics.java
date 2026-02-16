/*
@author: Colt Amlee
@date: 11 Feb 2026
@purpose: Week 5 lab
*/

package src.labs.example.physics;

public class Physics {

    final static double GRAVITY = 9.81; //m/s²

    public static double getDistance(double v, double t){
        double x = v*t; //velocity * time
        return x; //miles
    };

    public static double getVelocity(double x, double t){
        double v = x/t; //distance / time
        return v; //mph
    };

    public static double getMomentum(double m, double v){
        double p = m*v; //mass * velocity
        return p; //kg m/s
    };

    public static double getForce(double m, double a){
        double f = m*a; //mass * acceleration
        return f; //kg m/s²
    };

    public static double getWork(double f, double d){
        double w = f*d; //force * distance
        return w; //NM or Joules
    };

    public static double getKineticEnergy(double m, double v){
        double ke = 0.5*m*v*v; //.5 mass * velocity²
        return ke; //NM or Joules
    };

    public static double getPotentialEnergy(double m, double h){
        double pe = m*GRAVITY*h; //mass * gravity * height
        return pe; //NM or Joules
    };

    public static double trig(double y, double x){
        return Math.round(Math.atan2(y, x) * 180/Math.PI * 100.0) / 100.0; //returns the angle in degrees, rounded to two decimal places (Is there a better solution?)
    }

    public static void logInvalidAngleInfo(double angle){
        System.out.println("Logging the angle " + angle + " degrees. This is not a right angle.");
    }

    public static void logValidAngleInfo(double angle){
        System.out.println("Logging the angle " + angle + " degrees. This is a valid 3-4-5 triangle.");
    }

    public static double getKnownDistanceToEarth(){
        return 92947266.72; //miles
    }

    public static double getLightSpeedInMPH(){
        return 186282 * 3600; // miles/sec * 60 seconds * 60 minutes
    }

    public static double getTimeFromSunToEarthInHours(){
        double time = getKnownDistanceToEarth() / getLightSpeedInMPH();
        return time;
    }

    public static void logEarthToSunInvalidDistance(){
        System.out.println("This value is not equal to " + getKnownDistanceToEarth());
    }
}

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
}

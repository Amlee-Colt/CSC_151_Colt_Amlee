package src.labs.example.physics;

public class Physics {

    final static double GRAVITY = 9.81; //m/s²

    public static double getDistance(double v, double t){
        double x = v*t;
        return x; //miles
    };

    public static double getVelocity(double x, double t){
        double v = x/t;
        return v; //mph
    };

    public static double getMomentum(double m, double v){
        double p = m*v;
        return p; //kg m/s
    };

    public static double getForce(double m, double a){
        double f = m*a;
        return f; //kg m/s²
    };

    public static double getWork(double f, double d){
        double w = f*d;
        return w; //NM or Joules
    };

    public static double getKineticEnergy(double m, double v){
        double ke = 0.5*m*v*v;
        return ke; //NM or Joules
    };

    public static double getPotentialEnergy(double m, double g, double h){
        double pe = m*g*h;
        return pe; //NM or Joules
    };
}

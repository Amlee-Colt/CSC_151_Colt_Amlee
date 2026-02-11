/*
@author: Colt Amlee
@date: 11 Feb 2026
@purpose: Week 5 lab
*/

package src.labs.example.physics;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println("If you travel at a velocity of 50 miles per hour for 2 hours, you will travel a distance of " + Physics.getDistance(50,2) + " miles.");
        System.out.println("If you have travelled a distance of 100 miles in 2 hours, your average velocity was " + Physics.getVelocity(100,2) + " miles per hour.");
        System.out.println("If an object with a mass of 10 kg has a velocity of 5 meters per second, the momentum is " + Physics.getMomentum(10, 5) + " kg m/s.");
        System.out.println("An object with a mass of 15 kg has an acceleration of 5 meters per second squared. Its force would be " + Physics.getForce(15, 5) + " kg m/s^2");
        System.out.println("If you exert a force of 5 Newtons over a distance of 3 meters, the work will be " + Physics.getWork(5, 3) + " Joules (also known as Newton-Meters)");
        System.out.println("A 20 kg object with a velocity of 4 meters per second has a kinetic energy of " + Physics.getKineticEnergy(20, 4) + " Joules.");
        System.out.println("A ball with a mass of 1 kg at a height of 20 meters has a potential energy of " + Physics.getPotentialEnergy(1, 20) + " Joules.");

    }
}
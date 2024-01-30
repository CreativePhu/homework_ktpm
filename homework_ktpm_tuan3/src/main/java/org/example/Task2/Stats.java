package org.example.Task2;

public class Stats {
    private float totalClasses;
    private float concreteClasses;
    private float abstractClasses;
    private float ca;
    private float ce;
    private float a;
    private float i;
    private float d;
    private float v;

    public Stats(float totalClasses, float concreteClasses, float abstractClasses, float ca, float ce, float a, float i, float d, float v) {
        this.totalClasses = totalClasses;
        this.concreteClasses = concreteClasses;
        this.abstractClasses = abstractClasses;
        this.ca = ca;
        this.ce = ce;
        this.a = a;
        this.i = i;
        this.d = d;
        this.v = v;
    }

    public Stats() {
    }

    public float getTotalClasses() {
        return totalClasses;
    }

    public void setTotalClasses(float totalClasses) {
        this.totalClasses = totalClasses;
    }

    public float getConcreteClasses() {
        return concreteClasses;
    }

    public void setConcreteClasses(float concreteClasses) {
        this.concreteClasses = concreteClasses;
    }

    public float getAbstractClasses() {
        return abstractClasses;
    }

    public void setAbstractClasses(float abstractClasses) {
        this.abstractClasses = abstractClasses;
    }

    public float getCa() {
        return ca;
    }

    public void setCa(float ca) {
        this.ca = ca;
    }

    public float getCe() {
        return ce;
    }

    public void setCe(float ce) {
        this.ce = ce;
    }

    public float getA() {
        return a;
    }

    public void setA(float a) {
        this.a = a;
    }

    public float getI() {
        return i;
    }

    public void setI(float i) {
        this.i = i;
    }

    public float getD() {
        return d;
    }

    public void setD(float d) {
        this.d = d;
    }

    public float getV() {
        return v;
    }

    public void setV(float v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "Stats{" +
                "totalClasses=" + totalClasses +
                ", concreteClasses=" + concreteClasses +
                ", abstractClasses=" + abstractClasses +
                ", ca=" + ca +
                ", ce=" + ce +
                ", a=" + a +
                ", i=" + i +
                ", d=" + d +
                ", v=" + v +
                '}';
    }
}

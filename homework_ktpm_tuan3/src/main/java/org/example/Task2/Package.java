package org.example.Task2;

import java.util.List;

public class Package {
    private String name;
    private Stats stats;
    private List<String> abstractClasses;
    private List<String> concreteClasses;
    private List<String> dependsUpon;
    private List<String> usedBy;

    public Package() {
    }

    public Package(String name, Stats stats, List<String> abstractClasses, List<String> concreteClasses, List<String> dependsUpon, List<String> usedBy) {
        this.name = name;
        this.stats = stats;
        this.abstractClasses = abstractClasses;
        this.concreteClasses = concreteClasses;
        this.dependsUpon = dependsUpon;
        this.usedBy = usedBy;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Stats getStats() {
        return stats;
    }

    public void setStats(Stats stats) {
        this.stats = stats;
    }

    public List<String> getAbstractClasses() {
        return abstractClasses;
    }

    public void setAbstractClasses(List<String> abstractClasses) {
        this.abstractClasses = abstractClasses;
    }

    public List<String> getConcreteClasses() {
        return concreteClasses;
    }

    public void setConcreteClasses(List<String> concreteClasses) {
        this.concreteClasses = concreteClasses;
    }

    public List<String> getDependsUpon() {
        return dependsUpon;
    }

    public void setDependsUpon(List<String> dependsUpon) {
        this.dependsUpon = dependsUpon;
    }

    public List<String> getUsedBy() {
        return usedBy;
    }

    public void setUsedBy(List<String> usedBy) {
        this.usedBy = usedBy;
    }

    public void addAbstractClasses(String name){
        this.abstractClasses.add(name);
    }

    public void addConcreteClasses(String name){
        this.concreteClasses.add(name);
    }

    public void addDependsUpon(String name){
        this.dependsUpon.add(name);
    }

    public void addUsedBy(String name){
        this.usedBy.add(name);
    }

    @Override
    public String toString() {
        return "Package{" +
                "name='" + name + '\'' +
                ", stats=" + stats +
                ", abstractClasses=" + abstractClasses +
                ", concreteClasses=" + concreteClasses +
                ", dependsUpon=" + dependsUpon +
                ", usedBy=" + usedBy +
                '}';
    }

    public String checkPackageOk(){
        if(this.stats != null){
            boolean check = true;
            if(this.stats.getCe() >= 0 && this.stats.getCe() > 20){
                check = false;
            }
            if(this.stats.getCa() >= 0 && this.stats.getCa() > 500){
                check = false;
            }
            if(this.stats.getI() >= 0.75 && this.stats.getI() <= 1){
                check = false;
            }
            if(check){
                return "package " + this.getName() +  " is ok!";
            }
            return "package " + this.getName() +  " is not ok: " + "\n" + this.stats.toString() + "\n";
        }
        return "";
    }
}

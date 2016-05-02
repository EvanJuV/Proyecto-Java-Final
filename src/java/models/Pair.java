package models;


import models.Maestro;

public class Pair {
    private Object obj;
    private float num;

    public Pair(Object obj, float num) {
        this.obj = obj;
        this.num = num;
    }
    
    public Pair() {
        
    }

    public Object getObj()   { return obj; }
    public float getNum() { return num; }
    public void setNum(float num) { this.num = num; }
    public void setObject(Object obj) { this.obj = obj; }
}
package com.rommelmalked.qa.automation.mobile_automation.mobile_automation_poc.framework.actions.helpers;

public class Points {
    private Integer x;
    private Integer y;
    private Integer startPoint;
    private Integer endPoint;

    public Points(){}

    public Points(Integer x, Integer y, Integer startPoint, Integer endPoint){
        this.x = x;
        this.y = y;
        this.startPoint = startPoint;
        this.endPoint = endPoint;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        if(this.x == null){
            this.x = x;
        }
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        if(this.y == null){
            this.y = y;
        }
    }

    public int getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(int startPoint) {
        if(this.startPoint == null){
            this.startPoint = startPoint;
        }
    }

    public int getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(int endPoint) {
        if(this.endPoint == null){
            this.endPoint = endPoint;
        }
    }
}

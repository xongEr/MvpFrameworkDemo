package com.yilvs.myapplication.entity;

public class ResultParent<T> {


    /**
     * total : 161
     * end : false
     * sid : ef7424e1b6500eb415df975fd4d39e7a
     * ran : 0
     * ras : 0
     * kn : 16
     * cn : 0
     * gn : 0
     * ps : 33
     * pc : 33
     * adstar : 0
     * lastindex : 34
     * ceg : false
     * list : [{}]
     */

    private int total;
    private boolean end;
    private String sid;
    private int ran;
    private int ras;
    private int kn;
    private int cn;
    private int gn;
    private int ps;
    private int pc;
    private int adstar;
    private int lastindex;
    private boolean ceg;
    private T list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public boolean isEnd() {
        return end;
    }

    public void setEnd(boolean end) {
        this.end = end;
    }

    public String getSid() {
        return sid;
    }

    public void setSid(String sid) {
        this.sid = sid;
    }

    public int getRan() {
        return ran;
    }

    public void setRan(int ran) {
        this.ran = ran;
    }

    public int getRas() {
        return ras;
    }

    public void setRas(int ras) {
        this.ras = ras;
    }

    public int getKn() {
        return kn;
    }

    public void setKn(int kn) {
        this.kn = kn;
    }

    public int getCn() {
        return cn;
    }

    public void setCn(int cn) {
        this.cn = cn;
    }

    public int getGn() {
        return gn;
    }

    public void setGn(int gn) {
        this.gn = gn;
    }

    public int getPs() {
        return ps;
    }

    public void setPs(int ps) {
        this.ps = ps;
    }

    public int getPc() {
        return pc;
    }

    public void setPc(int pc) {
        this.pc = pc;
    }

    public int getAdstar() {
        return adstar;
    }

    public void setAdstar(int adstar) {
        this.adstar = adstar;
    }

    public int getLastindex() {
        return lastindex;
    }

    public void setLastindex(int lastindex) {
        this.lastindex = lastindex;
    }

    public boolean isCeg() {
        return ceg;
    }

    public void setCeg(boolean ceg) {
        this.ceg = ceg;
    }

    public T getList() {
        return list;
    }

    public void setList(T list) {
        this.list = list;
    }

    public static class ListBean {
    }
}

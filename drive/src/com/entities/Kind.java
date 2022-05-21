package com.entities;

public class Kind {
    private int Kno;//类编号
    private String Kind;//类名
    public Kind(){};
    public Kind(int Kno,String Kind){
        this.Kno=Kno;
        this.Kind=Kind;
    }

    public int getKno() {
        return Kno;
    }

    public void setKno(int kno) {
        Kno = kno;
    }

    public String getKind() {
        return Kind;
    }

    public void setKind(String kind) {
        Kind = kind;
    }
}

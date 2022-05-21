package com.entities;

public class Problem {
    private int Num;
    private String Problem;
    private String OptionA;
    private String OptionB;
    private String OptionC;
    private String OptionD;
    private String Answer;
    private String Note;
    private int Rank;
    private int Kno;
    private int Subj;

    public Problem() {
    }
    public Problem(int Num,String Problem,String OptionA,String OptionB,String OptionC,String OptionD,String Answer,String Note,int Rank,int Kno,int Subj) {
        this.Num=Num;
        this.Problem=Problem;
        this.OptionA=OptionA;
        this.OptionB=OptionB;
        this.OptionC=OptionC;
        this.OptionD=OptionD;
        this.Answer=Answer;
        this.Note=Note;
        this.Rank=Rank;
        this.Kno=Kno;
        this.Subj=Subj;
    }

    public int getNum() {
        return Num;
    }

    public void setNum(int num) {
        Num = num;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String problem) {
        Problem = problem;
    }

    public String getOptionA() {
        return OptionA;
    }

    public void setOptionA(String optionA) {
        OptionA = optionA;
    }

    public String getOptionB() {
        return OptionB;
    }

    public void setOptionB(String optionB) {
        OptionB = optionB;
    }

    public String getOptionC() {
        return OptionC;
    }

    public void setOptionC(String optionC) {
        OptionC = optionC;
    }

    public String getOptionD() {
        return OptionD;
    }

    public void setOptionD(String optionD) {
        OptionD = optionD;
    }

    public String getAnswer() {
        return Answer;
    }

    public void setAnswer(String answer) {
        Answer = answer;
    }

    public String getNote() {
        return Note;
    }

    public void setNote(String note) {
        Note = note;
    }

    public int getRank() {
        return Rank;
    }

    public void setRank(int rank) {
        Rank = rank;
    }

    public int getKno() {
        return Kno;
    }

    public void setKno(int kno) {
        Kno = kno;
    }

    public int getSubj() {
        return Subj;
    }

    public void setSubj(int subj) {
        Subj = subj;
    }
}

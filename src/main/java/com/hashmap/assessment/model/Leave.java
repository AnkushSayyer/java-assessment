package com.hashmap.assessment.model;

public class Leave {
    private int sickLeave;
    private int casualLeave;
    private int privilegeLeave;

    public Leave(int sickLeave, int casualLeave, int privilegeLeave) {
        this.sickLeave = sickLeave;
        this.casualLeave = casualLeave;
        this.privilegeLeave = privilegeLeave;
    }

    public int getSickLeave() {
        return sickLeave;
    }

    public void setSickLeave(int sickLeave) {
        this.sickLeave = sickLeave;
    }

    public int getCasualLeave() {
        return casualLeave;
    }

    public void setCasualLeave(int casualLeave) {
        this.casualLeave = casualLeave;
    }

    public int getPrivilegeLeave() {
        return privilegeLeave;
    }

    public void setPrivilegeLeave(int privilegeLeave) {
        this.privilegeLeave = privilegeLeave;
    }

    public int getTotalLeaves(){
        return sickLeave + casualLeave + privilegeLeave;
    }
}

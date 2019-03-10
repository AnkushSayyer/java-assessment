package com.hashmap.assessment.model.enums;

public enum LeaveType {
    SL(5), CL(5), PL(15);

    private int leaves;
    LeaveType(int leaves) {
        this.leaves = leaves;
    }

    public int getLeaves() {
        return leaves;
    }
}

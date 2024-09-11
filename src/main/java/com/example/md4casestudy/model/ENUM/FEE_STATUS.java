package com.example.md4casestudy.model.ENUM;

public enum FEE_STATUS {
    NOT_SUBMITTED("tuition debt"),
    SUBMITTED("submitted");


    private final String feeStatus;

    FEE_STATUS(String feeStatus) {
        this.feeStatus = feeStatus;
    }

    public String getRoleName() {
        return feeStatus;
    }
    }

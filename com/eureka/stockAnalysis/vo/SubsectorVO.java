package com.eureka.stockAnalysis.vo;

import java.util.Objects;

public class SubsectorVO {
    private int subsectorID;
    private String subsectorName;
    private int sectorID;

    @Override
    public String toString() {
        return "SubsectorVO{" +
                "subsectorID=" + subsectorID +
                ", subsectorName='" + subsectorName + '\'' +
                ", sectorID=" + sectorID +
                "}\n";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof SubsectorVO that)) return false;
        return getSubsectorID() == that.getSubsectorID() && getSectorID() == that.getSectorID() && getSubsectorName().equals(that.getSubsectorName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSubsectorID(), getSubsectorName(), getSectorID());
    }

    public int getSubsectorID() {
        return subsectorID;
    }

    public void setSubsectorID(int subsectorID) {
        this.subsectorID = subsectorID;
    }

    public String getSubsectorName() {
        return subsectorName;
    }

    public void setSubsectorName(String subsectorName) {
        this.subsectorName = subsectorName;
    }

    public int getSectorID() {
        return sectorID;
    }

    public void setSectorID(int sectorID) {
        this.sectorID = sectorID;
    }
}

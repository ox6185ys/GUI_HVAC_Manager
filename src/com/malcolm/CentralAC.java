package com.malcolm;

import java.util.Date;

/**
 * Represents a service call to fix a central AC until
 */
public class CentralAC extends ServiceCall{

    private String model;


    public CentralAC(String serviceAddress, String problemDescription, Date date, String model) {
        super(serviceAddress, problemDescription, date);
        this.model = model;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }


    @Override
    public String toString() {

       String resolvedDateString = ( resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = ( this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);


        return "Central AC Unit Service Call "  +
                " | Service Address= " + serviceAddress +
                " | Problem Description = " + problemDescription   +
                " | Reported Date = " + reportedDate +
                " | Resolved Date = " + resolvedDateString  +
                " | Resolution = " + resolutionString  +
                " | Fee = " + feeString ;

    }
}

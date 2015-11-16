package com.malcolm;

import java.util.Date;

/**
 * Created by Malcolm on 10/14/2015.
 */
public class WaterHeater extends ServiceCall{
    protected String ageOfheater;
    protected static int cityHeaterCharge=20;
public WaterHeater(String serviceAddress, String problemDescription, Date date,String ageOfheater) {
    super(serviceAddress, problemDescription, date);
    this.ageOfheater=ageOfheater;
}
    public String toString() {

        String ageString = ageOfheater;
        String resolvedDateString = (resolvedDate == null) ? "Unresolved" : this.resolvedDate.toString();
        String resolutionString = (this.resolution == null) ? "Unresolved" : this.resolution;
        String feeString = (fee == UNRESOLVED) ? "Unresolved" : "$" + Double.toString(fee);
        return "Water Heater Service Call "  +
                " | Service Address= " + serviceAddress  +
                " | Problem Description = " + problemDescription  +
                " | Heater Age = " + ageString  +
                " | Reported Date = " + reportedDate  +
                " | Resolved Date = " + resolvedDateString +
                " | Resolution = " + resolutionString  +
                " | Fee = " + feeString + " and the city mandatory fee: $"+cityHeaterCharge;
    }

}

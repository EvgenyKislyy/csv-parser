import com.opencsv.bean.CsvBindByName;

public class Input {


    @CsvBindByName(column = "Pincode")
    public String pincode;

    @CsvBindByName(column = "From")
    public String from;

    @CsvBindByName(column = "Apex Zone")
    public String airRegion;

    @CsvBindByName(column = "SFC Zone")
    public String surfaceRegion;

    @CsvBindByName(column = "Apex Min Rate")
    public String apexMinRate;

    @CsvBindByName(column = "Apex Per Kg Rate")
    public String apexPerKgRate;

    @CsvBindByName(column = "SFC Min Rate")
    public String sfcMinRate;

    @CsvBindByName(column = "SFC Per Kg Rate")
    public String sfcPerKgRate;

    @Override
    public String toString() {
        return "Intermidiate{" + "pincode='" + pincode + '\'' + ", from='" + from + '\'' + ", airRegion='" + airRegion
                + '\'' + ", surfaceRegion='" + surfaceRegion + '\'' + ", apexMinRate='" + apexMinRate + '\''
                + ", apexPerKgRate='" + apexPerKgRate + '\'' + ", sfcMinRate='" + sfcMinRate + '\'' + ", sfcPerKgRate='"
                + sfcPerKgRate + '\'' + '}';
    }
}

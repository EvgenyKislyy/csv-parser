import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class Result {

    @CsvBindByName(column = "PRICING_MODEL_NAME", required = true)
    @CsvBindByPosition(position = 0)
    public String pricingModelName;

    @CsvBindByName(column = "VENDOR_SCAC")
    @CsvBindByPosition(position = 1)
    public String vendorScac;

    @CsvBindByName(column = "SVC_CODE")
    @CsvBindByPosition(position = 2)
    public String svcCode;

    @CsvBindByName(column = "VENDOR_SVC_CODE")
    @CsvBindByPosition(position = 3)
    public String vendorSvcCode;

    @CsvBindByName(column = "FROM_COUNTRY")
    @CsvBindByPosition(position = 4)
    public String fromCountry;

    @CsvBindByName(column = "FROM_STATE")
    @CsvBindByPosition(position = 5)
    public String fromState;

    @CsvBindByName(column = "FROM_CITY")
    @CsvBindByPosition(position = 6)
    public String fromCity;

    @CsvBindByName(column = "FROM_ZIP")
    @CsvBindByPosition(position = 7)
    public String fromZip;

    @CsvBindByName(column = "FROM_ZONE")
    @CsvBindByPosition(position = 8)
    public String fromZone;

    @CsvBindByName(column = "TO_COUNTRY")
    @CsvBindByPosition(position = 9)
    public String toCountry;

    @CsvBindByName(column = "TO_STATE")
    @CsvBindByPosition(position = 10)
    public String toState;

    @CsvBindByName(column = "TO_CITY")
    @CsvBindByPosition(position = 11)
    public String toCity;

    @CsvBindByName(column = "TO_ZIP")
    @CsvBindByPosition(position = 12)
    public String toZip;

    @CsvBindByName(column = "TO_ZONE")
    @CsvBindByPosition(position = 13)
    public String toZone;

    @CsvBindByName(column = "MIN_AMOUNT_VAL")
    @CsvBindByPosition(position = 14)
    public String minAmountVal;

    @CsvBindByName(column = "FROM_WEIGHT")
    @CsvBindByPosition(position = 15)
    public String fromWeight;

    @CsvBindByName(column = "TO_WEIGHT")
    @CsvBindByPosition(position = 16)
    public String toWeight;

    @CsvBindByName(column = "FROM_MILE")
    @CsvBindByPosition(position = 17)
    public String fromMile;

    @CsvBindByName(column = "TO_MILE")
    @CsvBindByPosition(position = 18)
    public String toMile;

    @CsvBindByName(column = "AMOUNT_VAL")
    @CsvBindByPosition(position = 19)
    public String amountVal;

    @CsvBindByName(column = "AMOUNT_CODE")
    @CsvBindByPosition(position = 20)
    public String amountCode;

    @CsvBindByName(column = "TARIFF")
    @CsvBindByPosition(position = 21)
    public String tariff;

    @CsvBindByName(column = "TARIFF_EFFECTIVE_DATE")
    @CsvBindByPosition(position = 22)
    public String tariffEffectiveDate;

    @CsvBindByName(column = "CURRENCY_CODE")
    @CsvBindByPosition(position = 23)
    public String currencyCode;

    @CsvBindByName(column = "WT_UOM_CODE")
    @CsvBindByPosition(position = 24)
    public String wtUOMCode;

    @CsvBindByName(column = "MIN_FAK")
    @CsvBindByPosition(position = 25)
    public String minFAK;

    @CsvBindByName(column = "MAX_FAK")
    @CsvBindByPosition(position = 26)
    public String maxFAK;

    @CsvBindByName(column = "FAK_VALUE")
    @CsvBindByPosition(position = 27)
    public String fakValue;

    @CsvBindByName(column = "EFFECTIVE_DATE")
    @CsvBindByPosition(position = 28)
    public String effectiveDate;

    @CsvBindByName(column = "EXPIRATION_DATE")
    @CsvBindByPosition(position = 29)
    public String expirationDate;

    @CsvBindByName(column = "ACTIVE")
    @CsvBindByPosition(position = 30)
    public String active;

    @CsvBindByName(column = "BASE_VALUE")
    @CsvBindByPosition(position = 31)
    public String baseValue;

    @CsvBindByName(column = "BASE_AMOUNT_VAL")
    @CsvBindByPosition(position = 32)
    public String baseAmountVal;

    @CsvBindByName(column = "BASE_VALUE_CODE")
    @CsvBindByPosition(position = 33)
    public String baseValueCode;

}

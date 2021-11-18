import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;

public class CustomMappingStrategy2<T> extends ColumnPositionMappingStrategy<T> {
    private static final String[] HEADER = new String[] {
            "PRICING_MODEL_NAME", "VENDOR_SCAC", "SVC_CODE", "VENDOR_SVC_CODE", "FROM_COUNTRY", "FROM_STATE",
            "FROM_CITY", "FROM_ZIP", "FROM_ZONE", "TO_COUNTRY", "TO_STATE", "TO_CITY", "TO_ZIP", "TO_ZONE",
            "MIN_AMOUNT_VAL", "FROM_WEIGHT", "TO_WEIGHT", "FROM_MILE", "TO_MILE", "AMOUNT_VAL", "AMOUNT_CODE", "TARIFF",
            "TARIFF_EFFECTIVE_DATE", "CURRENCY_CODE", "WT_UOM_CODE", "MIN_FAK", "MAX_FAK", "FAK_VALUE",
            "EFFECTIVE_DATE", "EXPIRATION_DATE", "ACTIVE", "BASE_VALUE", "BASE_AMOUNT_VAL", "BASE_VALUE_CODE"};

    @Override
    public String[] generateHeader(T bean) throws CsvRequiredFieldEmptyException {
        super.generateHeader(bean); // without this the file contains ONLY headers
        return HEADER;
    }
}

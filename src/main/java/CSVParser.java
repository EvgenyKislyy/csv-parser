import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.apache.commons.lang3.StringUtils;

public class CSVParser {

    public static final String IN_FILE
            = "/Users/eugenekislyy/Documents/BLUE DART NEW PIN CODE LIST - SEP 2021 (1)/Combined-Table 1.csv";
    public static final String OUT_FILE = "/Users/eugenekislyy/Documents/rates.csv";
    public static final String VENDOR_SCAC = "BDRT";
    public static final String PRICING_MODEL_NAME = "NUTANIX_BT_TEST_1";
    public static int zipZoneCounter = 0;

    private static List<String> zipZonesSouth;

    public static void main(String[] args) throws Exception {
        CsvToBean<Input> csvToBean = getBeanReader();

        List<Input> inputRows = new ArrayList<>();
        csvToBean.forEach(inputRows::add);

        System.out.println("Input size: " + inputRows.size());
        zipZonesSouth = inputRows.stream()
                .filter(i -> (i.airRegion.equals("ST") || i.surfaceRegion.equals("S2"))).map(i -> i.pincode)
                .collect(Collectors.toList());
        System.out.println("South zones size: " + zipZonesSouth.size());
        List<Result> results = new ArrayList<>();

        Map<Object, List<String>> zip = zipZonesSouth.stream() //Stream<String>
                .collect(Collectors.groupingBy(r -> r.toString()));

        for (Map.Entry<Object, List<String>>  entry: zip.entrySet()) {
            System.out.println(entry.getKey() + " :2 " + entry.getValue().size());
        }

        fillGroundServices(inputRows, results);
        System.out.println("Ground services size: " + results.size());
        fillApexServices(inputRows, results);
        System.out.println("Full serices size: " + results.size());

        writeResults(results.stream().filter(r -> StringUtils.isNotBlank(r.minAmountVal)).collect(Collectors.toList()));

        Map<Object, List<Result>> charFrequency = results.stream() //Stream<String>
                .collect(Collectors.groupingBy(r -> r.fromZone));

        for (Map.Entry<Object, List<Result>>  entry: charFrequency.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }

        System.out.println("Done: " + results.size());
    }

    private static void writeResults(List<Result> results)
            throws IOException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        CSVWriter writer = new CSVWriter(new FileWriter(OUT_FILE));

        StatefulBeanToCsvBuilder<Result> builder = new StatefulBeanToCsvBuilder<>(writer);
        CustomMappingStrategy2<Result> mappingStrategy = new CustomMappingStrategy2<>();
        mappingStrategy.setType(Result.class);

        var beanToCsv = builder.withMappingStrategy(mappingStrategy).build();

        beanToCsv.write(results);
        writer.close();
    }

    private static CsvToBean<Input> getBeanReader() throws FileNotFoundException {
        CSVReader reader = new CSVReader(new FileReader(IN_FILE));

        return new CsvToBeanBuilder<Input>(reader).withType(Input.class).withIgnoreLeadingWhiteSpace(true).build();
    }

    private static void fillGroundServices(List<Input> inputs, List<Result> results) {
        for (Input input : inputs) {
            Result result = new Result();
            result.pricingModelName = PRICING_MODEL_NAME;
            result.vendorScac = VENDOR_SCAC;
            result.svcCode = "LTL";
            result.vendorSvcCode = "E";

            result.fromCountry = "IN";
            result.fromState = null;
            result.fromCity = null;
            result.fromZip = getNextSouthZipCode();
            result.fromZone = "ES";

            result.toCountry = "IN";
            result.toState = null;
            result.toCity = null;
            result.toZip = input.pincode;
            if (StringUtils.isBlank(input.surfaceRegion)) {
                continue;
            }
            result.toZone = input.surfaceRegion;

            result.minAmountVal = input.sfcMinRate;

            result.fromWeight = "0.5";
            result.toWeight = "50";

            result.fromMile = null;
            result.toMile = null;

            result.amountVal = input.sfcPerKgRate;
            result.amountCode = "WGHT";

            result.tariff = null;
            result.tariffEffectiveDate = null;

            result.currencyCode = "INR";
            result.wtUOMCode = "KGS";

            result.minFAK = null;
            result.maxFAK = null;
            result.fakValue = null;

            result.effectiveDate = null;
            result.expirationDate = null;

            result.active = "TRUE";

            result.baseValue = null;
            result.baseAmountVal = null;

            result.baseValueCode = "WGHT";

            results.add(result);
        }
    }

    private static void fillApexServices(List<Input> inputs, List<Result> results) {
        for (Input input : inputs) {
            Result result = new Result();
            result.pricingModelName = PRICING_MODEL_NAME;
            result.vendorScac = VENDOR_SCAC;
            result.svcCode = "AIR";
            result.vendorSvcCode = "A";

            result.fromCountry = "IN";
            result.fromState = null;
            result.fromCity = null;
            result.fromZip = getNextSouthZipCode();
            result.fromZone = "S2";

            result.toCountry = "IN";
            result.toState = null;
            result.toCity = null;
            result.toZip = input.pincode;
            if (StringUtils.isBlank(input.airRegion)) {
                continue;
            }
            result.toZone = input.airRegion;


            result.minAmountVal = input.apexMinRate;

            result.fromWeight = "10";
            result.toWeight = "999999";

            result.fromMile = null;
            result.toMile = null;

            result.amountVal = input.apexPerKgRate;
            result.amountCode = "WGHT";

            result.tariff = null;
            result.tariffEffectiveDate = null;

            result.currencyCode = "INR";
            result.wtUOMCode = "KGS";

            result.minFAK = null;
            result.maxFAK = null;
            result.fakValue = null;

            result.effectiveDate = null;
            result.expirationDate = null;

            result.active = "TRUE";

            result.baseValue = null;
            result.baseAmountVal = null;

            result.baseValueCode = "WGHT";

            results.add(result);
        }
    }

    private static String getNextSouthZipCode() {
        if (zipZonesSouth.size() <= zipZoneCounter + 1) {
            zipZoneCounter = 0;
        }
        return zipZonesSouth.get(zipZoneCounter++);
    }
}

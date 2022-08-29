package utilities;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvException;
import org.testng.annotations.DataProvider;

import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class ManageDDT extends CommonOps {


    @DataProvider(name = "Search-product-price")
    public static Object[][] getProductNaMae() throws IOException, CsvException {
        return readCsv(getData("DDTfile")+"product.csv");

    }
    @DataProvider(name = "Search-keyword")
    public static Object[][] getKeyWord() throws IOException, CsvException {
        return readCsv(getData("DDTfile")+"keyWord.csv");

    }

    public static Object[][] readCsv(String path) throws IOException, CsvException {
        CSVReader csvReaderer = new CSVReader(new FileReader(System.getProperty("user.dir") + path));
        List<String[]> csvData = csvReaderer.readAll();
        Object[][] csvDataObject = new Object[csvData.size()][2];
        for (int i = 0; i < csvData.size(); i++) {
            csvDataObject[i] = csvData.get(i);
        }
        return csvDataObject;
    }


}

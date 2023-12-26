package util;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class Utility {
    //function to select random number depend on the maximum value sent to it
    //this function used in select date and month of birth
        public static int generateRandomInt(int max){
            Random random = new Random();
            return random.nextInt(max)+1;
        }


        //this function to select random year used to select year of birth
        public static String generateRandomYear(){
            int minYear = 1913;
            int maxYear = 2023;
            Random random = new Random();
            int randomYear = random.nextInt(maxYear - minYear + 1) + minYear;
            return String.valueOf(randomYear);
        }

        //this function to select random number from certain list
        // used to select category from menu
    public static int generateRandomNumberFromList(){
        int[] numbers = {11, 15, 19, 23, 24, 25};
           // int[] numbers = {6, 10, 14, 18, 19, 20};
        Random random = new Random();
        int randomIndex = random.nextInt(numbers.length);
        int randomNumber = numbers[randomIndex];
        return  randomNumber;
    }

    public static int generateRandomNumberFromComputersCategoryList(){
        int[] numbers = {12, 13, 14};
        Random random = new Random();
        int randomIndex = random.nextInt(numbers.length);
        int randomNumber = numbers[randomIndex];
        return  randomNumber;
    }


    public static int generateRandomNumberFromColorList(){
        int[] numbers = {14, 15, 16};
        Random random = new Random();
        int randomIndex = random.nextInt(numbers.length);
        int randomNumber = numbers[randomIndex];
        return  randomNumber;
    }

    // Generate random product index (1-6)
    public static List<Integer> generateRandomNumbers(int numberOfNumbers) {
        List<Integer> randomNumbers = new ArrayList<>();
        Random random = new Random();

        for (int i = 0; i < numberOfNumbers; i++) {
            int randomNumber = random.nextInt(1000); // Adjust the range as needed
            randomNumbers.add(randomNumber);
        }

        return randomNumbers;
    }
    public static void main(String[] args) {
        System.out.println(generateRandomNumbers(6));
    }

    public static void captureScreenshot(WebDriver driver, String screenshotName) {
        TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
        Date currntDate=new Date();
        screenshotName=screenshotName+" "+currntDate.toString().replace(" ","-").replace(":","-");
        try {
            FileHandler.copy(takesScreenshot.getScreenshotAs(OutputType.FILE), new File(System.getProperty("user.dir")
                    + "/src/test/resources/Screenshots/"+ screenshotName + ".png"));
        } catch (WebDriverException | IOException e) {
            e.printStackTrace();
        }
    }

    //Jison file
    public static String getSingleJsonData(String jsonFilePath,String jsonField) throws IOException, ParseException {
        JSONParser jsonParser = new JSONParser();

        FileReader fileReader = new FileReader(jsonFilePath);
        Object obj = jsonParser.parse(fileReader);

        JSONObject jsonObject = (JSONObject) obj;
        return jsonObject.get(jsonField).toString();
    }
//excel
public static String getExcelData(int RowNum, int ColNum, String SheetName) {
    XSSFWorkbook workBook;
    XSSFSheet sheet;
    String projectPath = System.getProperty("user.dir");
    String cellData = null;
    try {
        workBook = new XSSFWorkbook(projectPath + "/src/test/resources/data_driven/data.xlsx");
        sheet = workBook.getSheet(SheetName);
        cellData = sheet.getRow(RowNum).getCell(ColNum).getStringCellValue();

    } catch (IOException e) {
        System.out.println(e.getMessage());
        System.out.println(e.getCause());
        e.printStackTrace();
    }
    return cellData;
}

//read multible json
public static String[] readJson(String jsonFilePath,String jsonFieldArray,String field) throws IOException, ParseException {

    JSONParser jsonParser = new JSONParser();

    FileReader fileReader = new FileReader(jsonFilePath);
    Object obj = jsonParser.parse(fileReader);

    JSONObject jsonObject = (JSONObject) obj;
    JSONArray array = (JSONArray) jsonObject.get(jsonFieldArray);

    String arr[] = new String[array.size()];
    for (int i = 0; i < array.size(); i++) {
        JSONObject users = (JSONObject) array.get(i);
        String fieldData = (String) users.get(field);

        arr[i] = fieldData;
    }
    return arr;
}
    }


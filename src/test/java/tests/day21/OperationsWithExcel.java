package tests.day21;

public class OperationsWithExcel {
    /*
    12/13/2019

    Review:
        Operations with excel files:

        To connect java code with excel file, we use Apache POI library. Means that it's free.
        Since we can not open excel file without special decoding, we have to use library that can do it for us.

        To open excel file, we need to do few things:

        First of all, open file through FileInputStream

        FileInputStream instream = new FileInputStream("path/to/the/file.xlsx");

        # then, we have to use workbook, to create object of excel file.

        * Creates the appropriate HSSFWorkbook / XSSFWorkbook from the given InputStream.

        We use WorkbookFactory, because it can open both type of excel files .xls ( old) and .xlsx (new).

        # Next step is to open spread sheet, because excel file can have multiple spreadsheets. It's like book can have many pages.

        Sheet workSheet = workbook.getSheet("name_of_sheet");

        # Then, since excel file is a table, and table consists of rows and cells, we need open Row first.

        Row row = workSheet.getRow(0);

        # Every row consists of cells, to get data from row, we need to use Cell

        Cell cell = row.getCell(1);

        Workbook ==> SpreadSheet ==> row ==> cell

        In test automation, excel files are very popular for storing test data. If we combine excel file with data
         provider we can do data driven testing. To do so , we have open some file, and return info as 2D array.

         We use DataProvider only to execute same test many times with different data sets.

         DataProvider is not required to use along with apache POI. it was our tests case, that requires to login many
         times different


     */
}

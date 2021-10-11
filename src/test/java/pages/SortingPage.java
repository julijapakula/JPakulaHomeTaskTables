package pages;

import core.BaseFunc;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.By;

public class SortingPage {
    private final By TOP_HEADER = By.xpath(".//h1[@class='None']");
    private final By FRAME_NAME = By.id("demoFrame");
    private final By FIRST_COLUMN_HEADER = By.id("dx-col-1");
    private final By SORTING_BTTN = By.xpath(".//span[@class = 'dx-menu-item-text'][contains(text(),'Clear Sorting')]");
    private final By SECOND_COLUMN_HEADER = By.id("dx-col-2");
    private final By FIRST_COLUMN_FIRST_POSITION = By.xpath(".//div[@class = 'dx-treelist-text-content']");
    private final By EXPANDER = By.xpath(".//div[@class = 'dx-treelist-icon-container']");

    public BaseFunc baseFunc;
    String url = "https://js.devexpress.com/Demos/WidgetsGallery/Demo/TreeList/MultipleSorting/";
    String pageNameExpected = "Sorting";
    String pageNameActual;
    String linePositionActual;
    String firstLinePositionExpected = "Automation Server";
    String lastLinePositionExpected = "TV Recall";

    public SortingPage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        baseFunc.goToUrl(url);
        pageNameActual = baseFunc.findElement(TOP_HEADER).getText();
        Assertions.assertEquals(pageNameExpected, pageNameActual, "Not an expected page");
    }

    public void goToTable() {
        baseFunc.switchToTable(FRAME_NAME);
    }

    public void sortingColumnClickAscending() {
        baseFunc.waitClick(FIRST_COLUMN_HEADER);
        baseFunc.clickOnElementById(0, EXPANDER);
        linePositionActual = baseFunc.findElement(FIRST_COLUMN_FIRST_POSITION).getText();
        Assertions.assertEquals(firstLinePositionExpected, linePositionActual, "Wrong sorting Ascending");
    }

    public void sortingColumnClickDescending() {
        baseFunc.waitClick(FIRST_COLUMN_HEADER);
        linePositionActual = baseFunc.findElement(FIRST_COLUMN_FIRST_POSITION).getText();
        Assertions.assertEquals(lastLinePositionExpected, linePositionActual, "Wrong sorting Descending");
    }

    public void clearFirstColumnSorting() {
        baseFunc.rightClick(FIRST_COLUMN_HEADER);
        baseFunc.waitClick(SORTING_BTTN);
        
    }

    public void multiSortingFirstSecondColumn() {
        baseFunc.waitClick(FIRST_COLUMN_HEADER);
        baseFunc.clickWithShift(SECOND_COLUMN_HEADER);
    }

    public void finishJob() {
        baseFunc.leaveTable();
        baseFunc.leaveBrowser();
    }
}

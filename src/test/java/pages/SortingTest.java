package pages;

import core.BaseFunc;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.Test;

public class SortingTest {
    private static final Logger LOGGER = LogManager.getLogger(SortingTest.class);
    public BaseFunc baseFunc = new BaseFunc();

    @Test
    public void checkTaskStatus() {
        LOGGER.info("Opening Sorting Page");
        SortingPage sortingPage = new SortingPage(baseFunc);
        LOGGER.info("Going to table");
        sortingPage.goToTable();
        LOGGER.info("First column sorting ascending by first click");
        sortingPage.sortingColumnClickAscending();
        LOGGER.info("First column sorting descending by second click");
        sortingPage.sortingColumnClickDescending();
        LOGGER.info("Clear first column sorting");
        sortingPage.clearFirstColumnSorting();
        LOGGER.info("Multiple sorting");
        sortingPage.multiSortingFirstSecondColumn();
        LOGGER.info("Finish job");
        //sortingPage.finishJob();
    }

}

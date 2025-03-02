package dropdown;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class DropdownTests extends BaseTests {
    @Test
    public void testSelectOption(){
        //we have access to the home page so we will click dropdown, will taje us to dropDownPage
       var dropDownPage =  homePage.clickDropDown();
       String option = "Option 1";
        dropDownPage.selectFromDropDown(option);
        // make sure that that's the option i selected , return a list
        var selectedOptions = dropDownPage.getSelectedOptions();
        // assert make sure that the number of selected options equals to 1
        assertEquals(selectedOptions.size(), 1, "Incorrect  number of selections");
        assertTrue(selectedOptions.contains(option) , "Option not selected");
    }
}

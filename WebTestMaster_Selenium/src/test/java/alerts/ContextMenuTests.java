package alerts;

import base.BaseTests;
import org.testng.annotations.Test;
import pages.HomePage;

import static org.testng.Assert.assertEquals;

public class ContextMenuTests extends BaseTests {
    @Test
    public void testContextMenuPage(){
        var contextMenu = homePage.clickContextMenu();
        contextMenu.rightClickOnBox();
        String text = contextMenu.getAlertText();
        assertEquals(text , "You selected a context menu", "text is wrong");
        contextMenu.clickOK();
    }
}

package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class NestedFramesTests extends BaseTests {
    @Test
    public void testNestedFramePage(){
        var nestedFramePage = homePage.clickFrames().clickNestedFrames();
        assertEquals(nestedFramePage.getLeftFrameText(), "LEFT", "Left Frame text is incorrect");
        assertEquals(nestedFramePage.getBottomFrameText(), "BOTTOM", "Bottom Frame text is incorrect");
    }
}

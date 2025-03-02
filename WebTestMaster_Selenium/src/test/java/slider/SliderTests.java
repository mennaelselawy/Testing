package slider;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class SliderTests extends BaseTests {
    @Test
    public void testSlideToValue(){
        var sliderPage = homePage.clickHorizontalSlider();
        sliderPage.setSliderValue("4");
        assertEquals(sliderPage.getValue() ,"4" , "value not equal expected");
    }
}

package hover;

import base.BaseTests;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.HoversPage;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class HoverTests extends BaseTests {


    @Test//(priority = 1)
    public void testHoverUsers(){
        var hoversPage = homePage.clickHovers();
        var caption = hoversPage.hoverOverFigure(1);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle() , "name: user1" , "caption title incorrect" );
        assertEquals(caption.getLinkText(),"View profile" , "caption link text incorrect" );
        assertTrue(caption.getTheLink().endsWith("/users/1"), "caption link is incorrect");


        caption = hoversPage.hoverOverFigure(2);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle() , "name: user2" , "caption title incorrect" );
        assertEquals(caption.getLinkText(),"View profile" , "caption link text incorrect" );
        assertTrue(caption.getTheLink().endsWith("/users/2"), "caption link is incorrect");


        caption = hoversPage.hoverOverFigure(3);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle() , "name: user3" , "caption title incorrect" );
        assertEquals(caption.getLinkText(),"View profile" , "caption link text incorrect" );
        assertTrue(caption.getTheLink().endsWith("/users/3"), "caption link is incorrect");


    }
}

 /*
 TRIAL FOR EACH TEST TO BE ALONE AND DEPENDENT ON EACH OTHER
 public HoversPage hoversPage;
    @BeforeMethod
    public void setUp(){
        hoversPage = homePage.clickHovers();
    }

     @Test(priority = 2)
    public void testHoverUser2(){
        //HoversPage cursor;
        var caption = hoversPage.hoverOverFigure(2);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle() , "name: user2" , "caption title incorrect" );
        assertEquals(caption.getLinkText(),"View profile" , "caption link text incorrect" );
        assertTrue(caption.getTheLink().endsWith("/users/2"), "caption link is incorrect");
    }
    @Test(priority = 3)
    public void testHoverUser3(){
        //HoversPage cursor;
        var caption = hoversPage.hoverOverFigure(3);
        assertTrue(caption.isCaptionDisplayed(), "Caption not displayed");
        assertEquals(caption.getTitle() , "name: user3" , "caption title incorrect" );
        assertEquals(caption.getLinkText(),"View profile" , "caption link text incorrect" );
        assertTrue(caption.getTheLink().endsWith("/users/3"), "caption link is incorrect");
    }
    */

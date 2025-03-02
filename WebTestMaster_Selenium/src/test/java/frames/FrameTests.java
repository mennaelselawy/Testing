package frames;

import base.BaseTests;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class FrameTests extends BaseTests {
    /**
     * it will fail because we do not have access to the editor to write but if we have it will PASS
     */
    @Test
    public void testWysiwyg(){
        var editorPage = homePage.clickWysiwygEditor();
        editorPage.clearTextArea();
        String text1 = "hello ";
        String text2 = "world";
        editorPage.writeTextArea(text1);
        editorPage.decreaseIndention();
        editorPage.writeTextArea(text2);
        assertEquals(editorPage.getTextFromEditor(), text1+text2, "Text from the editor is incorrect");
    }
}

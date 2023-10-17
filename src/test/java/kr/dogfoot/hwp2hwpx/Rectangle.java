package kr.dogfoot.hwp2hwpx;

import kr.dogfoot.hwp2hwpx.util.Util;
import kr.dogfoot.hwplib.object.HWPFile;
import kr.dogfoot.hwplib.reader.HWPReader;
import kr.dogfoot.hwpxlib.object.HWPXFile;
import kr.dogfoot.hwpxlib.writer.HWPXWriter;
import org.junit.Assert;
import org.junit.Test;

import java.nio.charset.StandardCharsets;

public class Rectangle {
    @Test
    public void test() throws Exception {
        String testPath = "test/rectangle";

        HWPFile fromFile = HWPReader.fromFile(testPath + "/from.hwp");
        HWPXFile toFile = Hwp2Hwpx.toHWPX(fromFile);
        HWPXWriter.toFilepath(toFile, testPath + "/to.zip");

        {
            String resultXML = Util.loadXMLString(testPath + "/result/header.xml", StandardCharsets.UTF_8);
            String toXML = Util.zipFileString(testPath + "/to.zip", "Contents/header.xml", StandardCharsets.UTF_8);
            Assert.assertEquals(resultXML, toXML);
        }

        {
            String resultXML = Util.loadXMLString(testPath + "/result/section0.xml", StandardCharsets.UTF_8);
            String toXML = Util.zipFileString(testPath + "/to.zip", "Contents/section0.xml", StandardCharsets.UTF_8);
            Assert.assertEquals(resultXML, toXML);
        }
    }
}

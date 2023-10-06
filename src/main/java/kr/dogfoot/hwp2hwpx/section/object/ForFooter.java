package kr.dogfoot.hwp2hwpx.section.object;

import kr.dogfoot.hwp2hwpx.Converter;
import kr.dogfoot.hwp2hwpx.Parameter;
import kr.dogfoot.hwp2hwpx.section.ForSubList;
import kr.dogfoot.hwp2hwpx.util.ValueConvertor;
import kr.dogfoot.hwplib.object.bodytext.control.ControlFooter;
import kr.dogfoot.hwplib.object.bodytext.control.ControlHeader;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Footer;
import kr.dogfoot.hwpxlib.object.content.section_xml.paragraph.ctrl.Header;

public class ForFooter extends Converter {
    public ForFooter(Parameter parameter) {
        super(parameter);
    }

    public void convert(Footer footer, ControlFooter hwpFooter) {
        footer
                .idAnd(String.valueOf(hwpFooter.getHeader().getCreateIndex()))
                .applyPageType(ValueConvertor.toApplyPageType(hwpFooter.getHeader().getApplyPage()));

        new ForSubList(parameter).convertForFooter(footer, hwpFooter);
    }
}

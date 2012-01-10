/* $Id:SAXErrorHandler.java 2824 2008-08-01 15:46:17Z davemckain $
 *
 * Copyright (c) 2011, The University of Edinburgh.
 * All Rights Reserved
 */
package dave;

import uk.ac.ed.ph.jqtiplus.JqtiExtensionManager;
import uk.ac.ed.ph.jqtiplus.internal.util.DumpMode;
import uk.ac.ed.ph.jqtiplus.internal.util.ObjectDumper;
import uk.ac.ed.ph.jqtiplus.reading.QtiXmlObjectReader;
import uk.ac.ed.ph.jqtiplus.resolution.AssessmentObjectManager;
import uk.ac.ed.ph.jqtiplus.validation.TestValidationResult;
import uk.ac.ed.ph.jqtiplus.xmlutils.ClassPathResourceLocator;

import java.net.URI;

public class TestTest {
    
    public static void main(String[] args) throws Exception {
        URI inputUri = URI.create("classpath:/WebDeveloperTest1/template_test1.xml");
        
        System.out.println("Reading and validating");
        JqtiExtensionManager jqtiExtensionManager = new JqtiExtensionManager();
        QtiXmlObjectReader objectReader = new QtiXmlObjectReader(jqtiExtensionManager, new ClassPathResourceLocator());
        
        AssessmentObjectManager objectManager = new AssessmentObjectManager(objectReader);

        TestValidationResult result = objectManager.validateTest(inputUri);
        System.out.println("Validation result: " + ObjectDumper.dumpObject(result, DumpMode.DEEP));
    }
}

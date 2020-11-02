package com.cyberup.schedule;

/***************************************************************************************************
 * $Id: HandleResponseStandard.java, v 1.0 2003/10/23 revision : 2003/11/15 Copyright (C) 2003
 * TriGem Infonet, Inc. All rights reserved.
 **************************************************************************************************/

import java.io.File;
import java.io.StringReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Hashtable;

import net.dcollection.flow.common.Configure;
import net.dcollection.flow.common.Model;
import net.dcollection.flow.common.OAISchema;
import net.dcollection.flow.common.OAIValidator;

import org.apache.log4j.xml.DOMConfigurator;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.xpath.XPath;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;

@Component
public class ResponseHandlerImpl implements ResponseHandler {
	@Autowired
	private ConstructorImpl constructorImpl;
	@Autowired
	private SynchronizerImpl synchronizerImpl;
	@Autowired
	private DemolisherImpl demolisherImpl;

    public void constructDB(Document document, DataProvider dataProvider, Schedule schedule)
        throws Exception {
    	
    	constructorImpl.constructItem(document, dataProvider, schedule);
    }

    public void synchronizeDB(Document document, DataProvider dataProvider, Schedule schedule)
        throws Exception {

        synchronizerImpl.synchronizeItem(document, dataProvider, schedule);
    }

	public void demolishDB(Document document, DataProvider dataProvider, Schedule schedule)
		throws Exception {
		
		demolisherImpl.demolishItem(document, dataProvider, schedule);
	}

	public String getJavaEncoding() {
		return "8859_1";
	}
}
package com.cyberup.schedule;

import org.jdom.Document;

import com.cyberup.model.course.DataProvider;
import com.cyberup.model.course.Schedule;

/***************************************************************************************************
 * $Id: HandleResponse.java, v 1.0 2003/10/21 Copyright (C) 2003 TriGem Infonet, Inc. All rights
 * reserved.
 **************************************************************************************************/

// Harvester에서 호출하는 클래스가 구현해야 할 인터페이스
public interface ResponseHandler {

    // 통합 DB 구축
    public void constructDB(Document document, DataProvider dataProvider, Schedule schedule)
        throws Exception;

    // 동기화
    public void synchronizeDB(Document document, DataProvider dataProvider, Schedule schedule)
        throws Exception;
    
    public void demolishDB(Document document, DataProvider dataProvider, Schedule schedule)
    	throws Exception;
    
    public String getJavaEncoding();
}
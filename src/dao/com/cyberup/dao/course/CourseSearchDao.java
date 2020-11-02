package com.cyberup.dao.course;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.dom4j.Element;
import org.omg.CORBA.portable.ResponseHandler;
import org.springframework.stereotype.Repository;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.NodeList;

import com.cyberup.dao.common.DeadLinkCheckDao;
import com.cyberup.framework.dao.BaseDAO;
import com.cyberup.model.course.Course;
import com.cyberup.model.course.CourseSearch;
import com.cyberup.model.home.CombineSearch;

@Repository
public class CourseSearchDao extends BaseDAO {

	public List univDeptList(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.univDeptList",courseSearch);
		
	}
	
	public List univDeptListForPublic(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.univDeptListForPublic",courseSearch);
		
	}
	
	public List rollUpList(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.rollUpList",courseSearch);
		
	}
	
	public List rollUpListForPublic(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.rollUpListForPublic",courseSearch);
		
	}

	public List searchOpenCourse_thumnail(CourseSearch courseSearch)
	{
		//return queryForList("CourseSearchDao.searchOpenCourse_thumnail",courseSearch);
		return queryForList("CourseSearchDao.searchPublicOpenCourse",courseSearch);
		
	}
	
	public List searchOpenCourse(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.searchOpenCourse",courseSearch);
		
	}
	
	public List searchOpenCourse2(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.searchOpenCourse2",courseSearch);
		
	}
	
	public List searchOpenCourseForCertificate(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.searchOpenCourseForCertificate",courseSearch);
		
	}
	
	
	
	//상세검색시 검색엔진에서 검색어를 분리한것을 확인하여 쿼리에 넣는다.
	public List searchOpenCourseDetail(CourseSearch courseSearch)
	{
		List list = null;
		List list2 = new ArrayList();
		
		//단어가 분리된것을 배열로만들어 배열만큼 변수에 담는다.
		String select1 	= courseSearch.getSelect1();
		String select2 	= courseSearch.getSelect2();
		String select3 	= courseSearch.getSelect3();
		String text1 	= courseSearch.getText1();
		String text2 	= courseSearch.getText2();
		String text3 	= courseSearch.getText3();

		/*
		System.out.println("select1 = " + select1);
		System.out.println("select2 = " + select2);
		System.out.println("select3 = " + select3);
		System.out.println("text1 = " + text1);
		System.out.println("text2 = " + text2);
		System.out.println("text3 = " + text3);
		 * */
		
		String highlight1 = "";
		String highlight2 = "";
		String highlight3 = "";
		
		if(!"".equals(text1))
		{
			if("title".equals(select1) || "description".equals(select1) || "keyword".equals(select1) || "department".equals(select1))
			{
				TreeSet tSet = new TreeSet();
				String[] arr = getWords(text1);
		        for( int i = 0; i < arr.length; i++ ) {
		        	if(!arr[i].equals(""))
		        		tSet.add(arr[i]);
		        }
		        Iterator it = tSet.iterator();
		        Iterator it1 = tSet.iterator();
		        int i = 0;
		        
		        while (it1.hasNext()){
		        	highlight1 += "," + it1.next();
		        }
		        while (it.hasNext()){
					if(i==0)
						courseSearch.setText01(text1);
					else if(i==1)
						courseSearch.setText02(it.next().toString());
					else if(i==2)
						courseSearch.setText03(it.next().toString());
					else if(i==3)
						courseSearch.setText04(it.next().toString());
					else if(i==4)
						courseSearch.setText05(it.next().toString());
					else if(i==5)
						courseSearch.setText06(it.next().toString());
					else if(i==6)
						courseSearch.setText07(it.next().toString());
					else if(i==7)
						courseSearch.setText08(it.next().toString());
					else if(i==8)
						courseSearch.setText09(it.next().toString());
					else if(i==9)
						courseSearch.setText10(it.next().toString());

		        	i++;
		        }
			}
			else
			{
				highlight1 += ","+text1;
				courseSearch.setText01(text1);	
			}
		}
		
		if(!"".equals(text2))
		{
			if("title".equals(select2) || "description".equals(select2) || "keyword".equals(select2) || "department".equals(select2))
			{
				TreeSet tSet = new TreeSet();
				String[] arr = getWords(text2);
				for( int i = 0; i < arr.length; i++ ) {
					if(!arr[i].equals(""))
						tSet.add(arr[i]);
				}
				Iterator it = tSet.iterator();
				Iterator it1 = tSet.iterator();
				int i = 0;
				while (it1.hasNext()){
		        	highlight2 += "," + it1.next();
		        }
				while (it.hasNext()){
					if(i==0)
						courseSearch.setText11(text2);
					else if(i==1)
						courseSearch.setText12(it.next().toString());
					else if(i==2)
						courseSearch.setText13(it.next().toString());
					else if(i==3)
						courseSearch.setText14(it.next().toString());
					else if(i==4)
						courseSearch.setText15(it.next().toString());
					else if(i==5)
						courseSearch.setText16(it.next().toString());
					else if(i==6)
						courseSearch.setText17(it.next().toString());
					else if(i==7)
						courseSearch.setText18(it.next().toString());
					else if(i==8)
						courseSearch.setText19(it.next().toString());
					else if(i==9)
						courseSearch.setText20(it.next().toString());
					
					i++;
				}
			}
			else
			{
				highlight2 += ","+text2;
				courseSearch.setText11(text2);
			}
		}
		
		if(!"".equals(text3))
		{
			if("title".equals(select3) || "description".equals(select3) || "keyword".equals(select3) || "department".equals(select3))
			{
				TreeSet tSet = new TreeSet();
				String[] arr = getWords(text3);
				for( int i = 0; i < arr.length; i++ ) {
					if(!arr[i].equals(""))
						tSet.add(arr[i]);
				}
				Iterator it = tSet.iterator();
				Iterator it1 = tSet.iterator();
				int i = 0;
				while (it1.hasNext()){
		        	highlight3 += "," + it1.next();
		        }
				while (it.hasNext()){
					if(i==0)
						courseSearch.setText21(text3);
					else if(i==1)
						courseSearch.setText22(it.next().toString());
					else if(i==2)
						courseSearch.setText23(it.next().toString());
					else if(i==3)
						courseSearch.setText24(it.next().toString());
					else if(i==4)
						courseSearch.setText25(it.next().toString());
					else if(i==5)
						courseSearch.setText26(it.next().toString());
					else if(i==6)
						courseSearch.setText27(it.next().toString());
					else if(i==7)
						courseSearch.setText28(it.next().toString());
					else if(i==8)
						courseSearch.setText29(it.next().toString());
					else if(i==9)
						courseSearch.setText30(it.next().toString());
					
					i++;
				}
			}
			else
			{
				courseSearch.setText21(text3);
				highlight3 += ","+text3;
			}
		}
		
		//xml 결과 값이 없을경우
		if(!text1.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
			return new ArrayList();
		if(!text2.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
			return new ArrayList();
		if(!text3.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
			return new ArrayList();
		
		list = queryForList("CourseSearchDao.searchOpenCourse",courseSearch);
		
		//검색어에 해당하는 단어는 하이라이팅
		
		String[] harr1 = highlight1.split(",");
		String[] harr2 = highlight2.split(",");
		String[] harr3 = highlight3.split(",");
		
		String title = "";
		String description = "";
		String keyword = "";
		String manager = "";
		String univname = "";
		String department = "";
		
		
		//상세검색 하이라이팅
		//검색된 내용에서 검색위치와 검색어를 확인하여 replace 한후 새로운 list 에 넣어서 return
		for (int i = 0; i < list.size(); i++) {
			System.out.println("checkI = " + i);
			
			CourseSearch cs = null;
			cs = (CourseSearch)list.get(i);
			
			for (int j = 0; j < harr1.length; j++) {
				
				if(!harr1[j].equals(""))
				{
					if(!"".equals(text1))
					{
						if("title".equals(select1))
						{
							title 		= cs.getTitle();
							if(!"".equals(title))
							title 		= title.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setTitle(title);
						}
						else if("description".equals(select1))
						{
							description = cs.getDescription();
							if(!"".equals(description))
							description = description.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setDescription(description);
						}
						else if("keyword".equals(select1))
						{
							keyword 	= cs.getKeyword();
							if(!"".equals(keyword))
							keyword 	= keyword.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setKeyword(keyword);
						}
						else if("manager".equals(select1))
						{
							manager 	= cs.getManager();
							if(!"".equals(manager))
								manager 	= manager.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setManager(manager);
						}
						else if("univName".equals(select1))
						{
							univname 	= cs.getUnivName();
							if(!"".equals(univname))
							univname 	= univname.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setUnivName(univname);
						}
						else if("department".equals(select1))
						{
							department 	= cs.getDepartment();
							if(!"".equals(department))
								department 	= department.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
							cs.setDepartment(department);
						}
					}
				}
			}
			for (int j = 0; j < harr2.length; j++) {
				if(!harr2[j].equals(""))
				{
					if(!"".equals(text2))
					{
						if("title".equals(select2))
						{
							title 		= cs.getTitle();
							if(!"".equals(title))
								title 		= title.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setTitle(title);
						}
						else if("description".equals(select2))
						{
							description = cs.getDescription();
							if(!"".equals(description))
								description = description.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setDescription(description);
						}
						else if("keyword".equals(select2))
						{
							keyword 	= cs.getKeyword();
							if(!"".equals(keyword))
								keyword 	= keyword.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setKeyword(keyword);
						}
						else if("manager".equals(select2))
						{
							manager 	= cs.getManager();
							if(!"".equals(manager))
								manager 	= manager.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setManager(manager);
						}
						else if("univName".equals(select2))
						{
							univname 	= cs.getUnivName();
							if(!"".equals(univname))
								univname 	= univname.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setUnivName(univname);
						}
						else if("department".equals(select2))
						{
							department 	= cs.getDepartment();
							if(!"".equals(department))
								department 	= department.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
							cs.setDepartment(department);
						}
					}
				}
			}
			for (int j = 0; j < harr3.length; j++) {
				if(!harr3[j].equals(""))
				{
					if(!"".equals(text3))
					{
						if("title".equals(select3))
						{
							title 		= cs.getTitle();
							if(!"".equals(title))
								title 		= title.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setTitle(title);
						}
						else if("description".equals(select3))
						{
							description = cs.getDescription();
							if(!"".equals(description))
								description = description.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setDescription(description);
						}
						else if("keyword".equals(select3))
						{
							keyword 	= cs.getKeyword();
							if(!"".equals(keyword))
								keyword 	= keyword.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setKeyword(keyword);
						}
						else if("manager".equals(select3))
						{
							manager 	= cs.getManager();
							if(!"".equals(manager))
								manager 	= manager.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setManager(manager);
						}
						else if("univName".equals(select3))
						{
							univname 	= cs.getUnivName();
							if(!"".equals(univname))
								univname 	= univname.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setUnivName(univname);
						}
						else if("department".equals(select3))
						{
							department 	= cs.getDepartment();
							if(!"".equals(department))
								department 	= department.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
							cs.setDepartment(department);
						}
					}
				}
			}
			list2.add(cs);
		}
		
		//System.out.println("list2.size() = " + list2.size());
		
		return list2;
		
	}
	
	//상세검색시 검색엔진에서 검색어를 분리한것을 확인하여 쿼리에 넣는다.
		public List searchOpenCourseDetail2(CourseSearch courseSearch)
		{
			List list = null;
			List list2 = new ArrayList();
			
			//단어가 분리된것을 배열로만들어 배열만큼 변수에 담는다.
			String select1 	= courseSearch.getSelect1();
			String select2 	= courseSearch.getSelect2();
			String select3 	= courseSearch.getSelect3();
			String text1 	= courseSearch.getText1();
			String text2 	= courseSearch.getText2();
			String text3 	= courseSearch.getText3();

			/*
			System.out.println("select1 = " + select1);
			System.out.println("select2 = " + select2);
			System.out.println("select3 = " + select3);
			System.out.println("text1 = " + text1);
			System.out.println("text2 = " + text2);
			System.out.println("text3 = " + text3);
			 * */
			
			String highlight1 = "";
			String highlight2 = "";
			String highlight3 = "";
			
			if(!"".equals(text1))
			{
				if("title".equals(select1) || "description".equals(select1) || "keyword".equals(select1) || "department".equals(select1))
				{
					TreeSet tSet = new TreeSet();
					String[] arr = getWords(text1);
			        for( int i = 0; i < arr.length; i++ ) {
			        	if(!arr[i].equals(""))
			        		tSet.add(arr[i]);
			        }
			        Iterator it = tSet.iterator();
			        Iterator it1 = tSet.iterator();
			        int i = 0;
			        
			        while (it1.hasNext()){
			        	highlight1 += "," + it1.next();
			        }
			        while (it.hasNext()){
						if(i==0)
							courseSearch.setText01(text1);
						else if(i==1)
							courseSearch.setText02(it.next().toString());
						else if(i==2)
							courseSearch.setText03(it.next().toString());
						else if(i==3)
							courseSearch.setText04(it.next().toString());
						else if(i==4)
							courseSearch.setText05(it.next().toString());
						else if(i==5)
							courseSearch.setText06(it.next().toString());
						else if(i==6)
							courseSearch.setText07(it.next().toString());
						else if(i==7)
							courseSearch.setText08(it.next().toString());
						else if(i==8)
							courseSearch.setText09(it.next().toString());
						else if(i==9)
							courseSearch.setText10(it.next().toString());

			        	i++;
			        }
				}
				else
				{
					highlight1 += ","+text1;
					courseSearch.setText01(text1);	
				}
			}
			
			if(!"".equals(text2))
			{
				if("title".equals(select2) || "description".equals(select2) || "keyword".equals(select2) || "department".equals(select2))
				{
					TreeSet tSet = new TreeSet();
					String[] arr = getWords(text2);
					for( int i = 0; i < arr.length; i++ ) {
						if(!arr[i].equals(""))
							tSet.add(arr[i]);
					}
					Iterator it = tSet.iterator();
					Iterator it1 = tSet.iterator();
					int i = 0;
					while (it1.hasNext()){
			        	highlight2 += "," + it1.next();
			        }
					while (it.hasNext()){
						if(i==0)
							courseSearch.setText11(text2);
						else if(i==1)
							courseSearch.setText12(it.next().toString());
						else if(i==2)
							courseSearch.setText13(it.next().toString());
						else if(i==3)
							courseSearch.setText14(it.next().toString());
						else if(i==4)
							courseSearch.setText15(it.next().toString());
						else if(i==5)
							courseSearch.setText16(it.next().toString());
						else if(i==6)
							courseSearch.setText17(it.next().toString());
						else if(i==7)
							courseSearch.setText18(it.next().toString());
						else if(i==8)
							courseSearch.setText19(it.next().toString());
						else if(i==9)
							courseSearch.setText20(it.next().toString());
						
						i++;
					}
				}
				else
				{
					highlight2 += ","+text2;
					courseSearch.setText11(text2);
				}
			}
			
			if(!"".equals(text3))
			{
				if("title".equals(select3) || "description".equals(select3) || "keyword".equals(select3) || "department".equals(select3))
				{
					TreeSet tSet = new TreeSet();
					String[] arr = getWords(text3);
					for( int i = 0; i < arr.length; i++ ) {
						if(!arr[i].equals(""))
							tSet.add(arr[i]);
					}
					Iterator it = tSet.iterator();
					Iterator it1 = tSet.iterator();
					int i = 0;
					while (it1.hasNext()){
			        	highlight3 += "," + it1.next();
			        }
					while (it.hasNext()){
						if(i==0)
							courseSearch.setText21(text3);
						else if(i==1)
							courseSearch.setText22(it.next().toString());
						else if(i==2)
							courseSearch.setText23(it.next().toString());
						else if(i==3)
							courseSearch.setText24(it.next().toString());
						else if(i==4)
							courseSearch.setText25(it.next().toString());
						else if(i==5)
							courseSearch.setText26(it.next().toString());
						else if(i==6)
							courseSearch.setText27(it.next().toString());
						else if(i==7)
							courseSearch.setText28(it.next().toString());
						else if(i==8)
							courseSearch.setText29(it.next().toString());
						else if(i==9)
							courseSearch.setText30(it.next().toString());
						
						i++;
					}
				}
				else
				{
					courseSearch.setText21(text3);
					highlight3 += ","+text3;
				}
			}
			
			//xml 결과 값이 없을경우
			if(!text1.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
				return new ArrayList();
			if(!text2.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
				return new ArrayList();
			if(!text3.equals("") && courseSearch.getText01().equals("") && courseSearch.getText11().equals("") && courseSearch.getText21().equals(""))
				return new ArrayList();
			
			list = queryForList("CourseSearchDao.searchOpenCourse2",courseSearch);
			
			//검색어에 해당하는 단어는 하이라이팅
			
			String[] harr1 = highlight1.split(",");
			String[] harr2 = highlight2.split(",");
			String[] harr3 = highlight3.split(",");
			
			String title = "";
			String description = "";
			String keyword = "";
			String manager = "";
			String univname = "";
			String department = "";
			
			
			//상세검색 하이라이팅
			//검색된 내용에서 검색위치와 검색어를 확인하여 replace 한후 새로운 list 에 넣어서 return
			for (int i = 0; i < list.size(); i++) {
				System.out.println("checkI = " + i);
				
				CourseSearch cs = null;
				cs = (CourseSearch)list.get(i);
				
				for (int j = 0; j < harr1.length; j++) {
					
					if(!harr1[j].equals(""))
					{
						if(!"".equals(text1))
						{
							if("title".equals(select1))
							{
								title 		= cs.getTitle();
								if(!"".equals(title))
								title 		= title.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setTitle(title);
							}
							else if("description".equals(select1))
							{
								description = cs.getDescription();
								if(!"".equals(description))
								description = description.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setDescription(description);
							}
							else if("keyword".equals(select1))
							{
								keyword 	= cs.getKeyword();
								if(!"".equals(keyword))
								keyword 	= keyword.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setKeyword(keyword);
							}
							else if("manager".equals(select1))
							{
								manager 	= cs.getManager();
								if(!"".equals(manager))
									manager 	= manager.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setManager(manager);
							}
							else if("univName".equals(select1))
							{
								univname 	= cs.getUnivName();
								if(!"".equals(univname))
								univname 	= univname.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setUnivName(univname);
							}
							else if("department".equals(select1))
							{
								department 	= cs.getDepartment();
								if(!"".equals(department))
									department 	= department.replaceAll(harr1[j], "<b style='color:red;'>" +  harr1[j] + "</b>");
								cs.setDepartment(department);
							}
						}
					}
				}
				for (int j = 0; j < harr2.length; j++) {
					if(!harr2[j].equals(""))
					{
						if(!"".equals(text2))
						{
							if("title".equals(select2))
							{
								title 		= cs.getTitle();
								if(!"".equals(title))
									title 		= title.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setTitle(title);
							}
							else if("description".equals(select2))
							{
								description = cs.getDescription();
								if(!"".equals(description))
									description = description.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setDescription(description);
							}
							else if("keyword".equals(select2))
							{
								keyword 	= cs.getKeyword();
								if(!"".equals(keyword))
									keyword 	= keyword.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setKeyword(keyword);
							}
							else if("manager".equals(select2))
							{
								manager 	= cs.getManager();
								if(!"".equals(manager))
									manager 	= manager.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setManager(manager);
							}
							else if("univName".equals(select2))
							{
								univname 	= cs.getUnivName();
								if(!"".equals(univname))
									univname 	= univname.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setUnivName(univname);
							}
							else if("department".equals(select2))
							{
								department 	= cs.getDepartment();
								if(!"".equals(department))
									department 	= department.replaceAll(harr2[j], "<b style='color:red;'>" +  harr2[j] + "</b>");
								cs.setDepartment(department);
							}
						}
					}
				}
				for (int j = 0; j < harr3.length; j++) {
					if(!harr3[j].equals(""))
					{
						if(!"".equals(text3))
						{
							if("title".equals(select3))
							{
								title 		= cs.getTitle();
								if(!"".equals(title))
									title 		= title.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setTitle(title);
							}
							else if("description".equals(select3))
							{
								description = cs.getDescription();
								if(!"".equals(description))
									description = description.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setDescription(description);
							}
							else if("keyword".equals(select3))
							{
								keyword 	= cs.getKeyword();
								if(!"".equals(keyword))
									keyword 	= keyword.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setKeyword(keyword);
							}
							else if("manager".equals(select3))
							{
								manager 	= cs.getManager();
								if(!"".equals(manager))
									manager 	= manager.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setManager(manager);
							}
							else if("univName".equals(select3))
							{
								univname 	= cs.getUnivName();
								if(!"".equals(univname))
									univname 	= univname.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setUnivName(univname);
							}
							else if("department".equals(select3))
							{
								department 	= cs.getDepartment();
								if(!"".equals(department))
									department 	= department.replaceAll(harr3[j], "<b style='color:red;'>" +  harr3[j] + "</b>");
								cs.setDepartment(department);
							}
						}
					}
				}
				list2.add(cs);
			}
			
			//System.out.println("list2.size() = " + list2.size());
			
			return list2;
			
		}
	
	
	public String[] getWords(String text)
	{
		String url = "";
		String text2 = text;
		//real
		String address			= "http://www.cuinfo.net/search1";
		
		url = address + "/search_xml.jsp?collection=univ_lecture&startCount=0&listCount=10&sfield=description";
		
		try {
			text = URLEncoder.encode(URLEncoder.encode(text,"UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("e1 Error"); e1.printStackTrace();
		} catch (Exception e2){
			System.out.println("e2 Error"); e2.printStackTrace();
		}
		
		//검색시작번호(페이징처리)
		
		//강의검색은 넘어오는 파라미터들에 따라 호출하는 xml 내용이 틀려지므로
		//기본 url 에 파라미터를 추가하는 형식으로 한다.
		
		//검색어
		if(!"".equals(text))
			url += "&query="+text;
		
		System.out.println("!!! url = "+url+"\n");
		
		String textarr = "";
		try {
			//1단계:xml 파싱
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder   		= factory.newDocumentBuilder();
			Document document     			= builder.parse(url);

			//2단계:콜렉션 명에 따라 해당하는 모델 맵핑
			NodeList result = document.getElementsByTagName("Result");
			
			NodeList rows = result.item(0).getChildNodes();
			
			String tmpStr = "";
			for (int i = 0; i < rows.getLength(); i++) {
				
				if(rows.item(i).getNodeType() == 1){
					CourseSearch cs = new CourseSearch();
					NodeList row = rows.item(i).getChildNodes();
					
					for (int j = 0; j < row.getLength(); j++) {
						if(row.item(j).getNodeType() == 1 && "description".equals(row.item(j).getNodeName())){// 
//							System.out.println(row.item(j).getNodeName()+":"+row.item(j).getTextContent());
							
							tmpStr = row.item(j).getTextContent().trim();
							
//							System.out.println(tmpStr);
							for (int k = 0; k < tmpStr.length(); k++) {
								if(tmpStr.charAt(k) == '\'' && tmpStr.charAt(k+1) == '>'){
									while(true){
										k++;
										textarr += tmpStr.charAt(k+1);
										
										if(tmpStr.charAt(k+2) == '<' && tmpStr.charAt(k+3) == '/'){
											textarr += ",";
											break;
										}
									}
								}
							}
						}
					}//end for
					
				}//end if
			}//end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("textarr = " + textarr);
		
		
		if(textarr.replaceAll(",", "").replaceAll(text2, "").trim().equals(""))
			return textarr.split(",");
		else
			return textarr.replaceAll(text2, "").split(",");
	}
	
	
	public CourseSearch selectCourseInfo(CourseSearch courseSearch)
	{
		return (CourseSearch)queryForObject("CourseSearchDao.selectCourseInfo", courseSearch);
	}
	
	public CourseSearch selectCourseInfo2(CourseSearch courseSearch)
	{
		return (CourseSearch)queryForObject("CourseSearchDao.selectCourseInfo2", courseSearch);
	}
	
	public CourseSearch selectCourseInfo3(String foundId)
	{
		return (CourseSearch)queryForObject("CourseSearchDao.selectCourseInfo3", foundId);
	}
	
	public List selectLectureList(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.selectLectureList", courseSearch);
	}
	
	public List selectLectureList3(String foundId)
	{
		return queryForList("CourseSearchDao.selectLectureList3", foundId);
	}
	
	
	public List selectUnivList(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.univList",courseSearch);
		
	}
	
	public List selectUnivListForPublic(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.univListForPublic",courseSearch);
		
	}
	
	public List selectYearListForPublic(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.yearListForPublic",courseSearch);
		
	}
	
	
	public List selectUnivList2(CourseSearch courseSearch)
	{
		return queryForList("CourseSearchDao.univList2",courseSearch);
		
	}
	
	public List kocwApiSearch(String gubn, String text){
		
		List list = new ArrayList();
		try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            // parse() 메소드에 들어갈 수 있는 인자 : xml , url
            
            if("".equals(text))
            	text = "사이버대학";
            
            //공개강의 = K, 학위논문 = A
            String url = "http://www.riss.kr/openApi?key=70aaa00tte60abr00aaa00ro00ja234a&version=1.0&type="+gubn+"&keyword="+URLEncoder.encode(text, "utf-8")+"&sort=Y&asc=D";
            
            Document doc = builder.parse(url);
            NodeList metadata = doc.getElementsByTagName("metadata");
            
            NodeList items = null;

            for (int i = 0; i < metadata.getLength(); i++) {
				items = metadata.item(i).getChildNodes();
				
				CourseSearch cs = new CourseSearch();
				for (int j = 0; j < items.getLength(); j++) {
					
					if("riss.title".equals(items.item(j).getNodeName()))
					{
						String str = items.item(j).getTextContent();
						cs.setTitle(str);
						
						if(str.length()>15)
							cs.setText(str.substring(0,13)+"..");
						else
							cs.setText(str);
						
					}
					
					if("url".equals(items.item(j).getNodeName())){
						
						String link=items.item(j).getTextContent();
						
						Integer index=link.indexOf("?")+1;
						String qri=link.substring(index);
						
						cs.setSip("www.riss.kr");
						cs.setUri("/link");
						cs.setQri(qri);
						cs.setSp("riss");
						
						cs.setUrl(items.item(j).getTextContent());
					}
					
				}
				
				list.add(cs);
				cs = null;

				if(i==4)
					break;
			}
            
		}catch(Exception e) {
            System.out.println("Exception : " + e.toString());
        }
		return list;
	}
	
	public List kocwApiSearch_univ(String gubn, String univname){
		
		List list = new ArrayList();
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			
			// parse() 메소드에 들어갈 수 있는 인자 : xml , url
			
			if("".equals(univname))
				univname = "사이버대학";
			
			//공개강의 = K, 학위논문 = A
			String url = "http://www.riss.kr/openApi?key=70aaa00tte60abr00aaa00ro00ja234a&version=1.0&type="+gubn+"&keyword="+URLEncoder.encode(univname, "utf-8")+"&publisher="+URLEncoder.encode(univname, "utf-8")+"&sort=Y&asc=D";
			
			Document doc = builder.parse(url);
			NodeList metadata = doc.getElementsByTagName("metadata");
			
			NodeList items = null;
			
			for (int i = 0; i < metadata.getLength(); i++) {
				items = metadata.item(i).getChildNodes();
				
				CourseSearch cs = new CourseSearch();
				for (int j = 0; j < items.getLength(); j++) {
					
					if("riss.title".equals(items.item(j).getNodeName()))
					{
						String str = items.item(j).getTextContent();
						cs.setTitle(str);
						
						if(str.length()>15)
							cs.setText(str.substring(0,13)+"..");
						else
							cs.setText(str);
						
					}
					
					if("url".equals(items.item(j).getNodeName()))
						cs.setUrl(items.item(j).getTextContent());
					
				}
				
				list.add(cs);
				cs = null;
				
				if(i==4)
					break;
			}
			
		}catch(Exception e) {
			System.out.println("Exception : " + e.toString());
		}
		return list;
	}
	
	public List getYearList()
	{
		List list = new ArrayList();
		
		Calendar cd = Calendar.getInstance();
		
		//검색조건으로 사용하는 연도는 2011 년도부터 시작하여 해당 년도 까지.
		String sYear 	= "2011";
		String eYear	= cd.get(Calendar.YEAR)+"";
		
		list.add(sYear);

		if(!sYear.equals(eYear))
		{
			int size = Integer.parseInt(eYear) - Integer.parseInt(sYear);
			
			for (int i = 1; i <= size; i++) {
				list.add(Integer.parseInt(sYear)+i);
			}
		}
		
		return list;
	}
	
	
	
	
	
	/*와이즈넛 통합검색 강의검색*/
	public List courseSearch(CourseSearch courseSearch){
List<CourseSearch> list = new ArrayList<CourseSearch>();
		
		Integer startCount		= 0;
		Integer universityId 	= 0;
		Integer currPage 		= 0;
		Integer showCnt 		= 10;
		Integer checkbox3		= 0;
		Integer publicYN		= 0;
		Integer select			= 0;
		
		String url = "";
		String collection		= "";
		String deptId 			= "";
		String text 			= "";
		String odbykey			= "";
		String odby				= "";
		String sfield			= "";
		String address			= "";
		
		
		
		//test wisenut
		//address			= "http://61.82.137.49:7900/xml/jsp";
		address			= "http://www.cuinfo.net/search_new";
		
		//test keris search server 65
		//address			= "http://210.102.99.65:9401/xml/jsp";
		
		//real
		//address			= "http://www.cuinfo.net/search1";
		
		select			= courseSearch.getSelect();
		currPage		= courseSearch.getCurrPage();
		checkbox3 		= courseSearch.getCheckbox3();
		text 			= courseSearch.getText();
		deptId 			= courseSearch.getDeptId();
		universityId 	= courseSearch.getUniversityId();
		showCnt 		= courseSearch.getShowCnt();
		odbykey 		= courseSearch.getOdbykey();
		odby 			= courseSearch.getOdby();
		publicYN		= courseSearch.getCheckbox1();
		
		
		//기존의 정렬기준을 확인하여 변경된 값으로 바꾼다.
		sfield 	= select == 1 ? "TITLE" : select == 2 ? "MANAGER" : select == 3 ? "UNIVERSITYNAME" : select == 4 ? "DESCRIPTION" : select == 5 ? "KEYWORD" : select == 6 ? "DEPARTMENT" : "TITLE";
		odbykey = "regdate".equals(odbykey)?"REGDATE":"univname".equals(odbykey)?"UNIVERSITYNAME":"deptname".equals(odbykey)?"DEPARTMENT":"clicksCnt".equals(odbykey)?"CLICKSCNT":"REGDATE";
		odby 	= "asc".equals(odby)?"ASC":"desc".equals(odby)?"DESC":"ASC";
		
		
		//임시로 고정값을 셋팅한다.
//		sfield 	 = "TITLE";
//		odbykey  = "REGDATE";
//		odby 	 = "DESC";
		
		
		//와이즈넛에서 컬렉션명 반대로 적용한듯..
		switch (checkbox3) {
//		switch (2) {
		case 2://최근1년검색
			collection = "univ_lecture_year";
			break;
		case 3://전체검색
			collection = "univ_lecture";
			break;
		default :
			collection = "univ_lecture_year";
		}
		
		startCount = (currPage - 1) * showCnt;
		
		if(startCount < 0)
			startCount = 0;
		
		System.out.println("#########################################");
		System.out.println("Select = " + courseSearch.getSelect());
		System.out.println("Select1 = " + courseSearch.getSelect1());
		System.out.println("sfield = " + sfield);
		System.out.println("currPage = " + currPage);
		System.out.println("collection = " + collection);
		System.out.println("startCount = " + startCount);
		System.out.println("odbykey = " + odbykey);
		System.out.println("odby = " + odby);
		System.out.println("#########################################");
		
		url = address + "/search_xml.jsp?collection="+collection+"&startCount="+startCount+"&listCount="+showCnt+"&sort="+odbykey+"/"+odby;
		
		try {
			text = URLEncoder.encode(text,"UTF-8");
			//text = URLEncoder.encode(URLEncoder.encode(text,"UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("e1 Error"); e1.printStackTrace();
		} catch (Exception e2){
			System.out.println("e2 Error"); e2.printStackTrace();
		}
		
		//검색시작번호(페이징처리)
		
		//강의검색은 넘어오는 파라미터들에 따라 호출하는 xml 내용이 틀려지므로
		//기본 url 에 파라미터를 추가하는 형식으로 한다.
		
		//검색어
		if(!"".equals(text))
			url += "&query="+text;
		//검색필터
		if(!"".equals(sfield))
			url += "&sfield="+sfield;
		//학과분야별검색시
		if(!"".equals(deptId))
			url += "&departmentid="+deptId;
		//학교별검색시
		if(universityId != 0)
			url += "&universityid="+universityId;
		//공개강의여부
		if(publicYN != 0)
			url += "&publicyn=Y";
		
		System.out.println("!!! url = \n\n"+url+"\n");
		
		try {
			//1단계:xml 파싱
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder   		= factory.newDocumentBuilder();
			Document document     			= builder.parse(url);

			System.out.println("\nDocumentSet ============================================================================================\n");
			
			String resultName 	= "";
			String resultValue 	= "";
			int totalCnt 		= 0;
			String collName 	= "";
			
			NodeList DocumentSet = document.getElementsByTagName("DocumentSet");
			NodeList temp1 = null;

			
			for (int i = 0; i < DocumentSet.getLength(); i++) {
				temp1 = DocumentSet.item(i).getChildNodes();
				for (int j = 0; j < temp1.getLength(); j++) {
					if(temp1.item(j).getNodeName().equals("TotalCount")){
						totalCnt += Integer.parseInt(temp1.item(j).getTextContent().trim());
					}
				}
			}
			System.out.println("totalCnt ===> " + totalCnt);
			
			//3단계:콜렉션 명에 따라 해당하는 모델 맵핑
			
			//Document 집합을 구한다.
			NodeList Documents = document.getElementsByTagName("Document");
			
			//Document 크기만큼 루프.
			for (int i = 0; i < Documents.getLength(); i++) {
				
				//Document 의 내용을 담는다.
				NodeList Document = Documents.item(i).getChildNodes();
				
				
				//Document 의 내용만큼 루프.
				for (int k = 0; k < Document.getLength(); k++) {
					
					//Document 의 내용중 Field 를 CourseSearch 객체에 맵핑한다.
					if(Document.item(k).getNodeName().equals("Field") && Document.item(k).getNodeType() == 1){
						CourseSearch cs = new CourseSearch();
						NodeList row = Document.item(k).getChildNodes();
						Integer clicksCnt = 0;
						Integer courseId = 0;
						
						for (int j = 0; j < row.getLength(); j++) {
							if(row.item(j).getNodeType() == 1 ){
								
								System.out.println(i + " => " + row.item(j).getNodeName()+":"+row.item(j).getTextContent());
	
								if(row.item(j).getNodeName().equals("DOCID"))
									cs.setCourseId(Integer.parseInt(row.item(j).getTextContent().trim()));
								else if(row.item(j).getNodeName().equals("COURSEIDENTIFIER"))
									cs.setCourseIdentifier(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("UNIVNAME"))
									cs.setUniversityName (row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));//<em class="red"></em>
								else if(row.item(j).getNodeName().equals("CLICKSCNT")){
									courseId = cs.getCourseId();
									clicksCnt = (Integer)queryForObject("CourseSearchDao.clicksCnt",courseId);
									cs.setClicksCnt(clicksCnt);
								}
								else if(row.item(j).getNodeName().equals("DEPARTMENT"))
									cs.setDepartment(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("CREDIT"))
									cs.setCredit(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("TERMSEMESTER"))
									cs.setTermSemester(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("MANAGER"))
									cs.setManager(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("DESCRIPTION"))
									cs.setDescription(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("TITLE")){
									cs.setMainTitle(row.item(j).getTextContent().trim().replace("<!HS>", "").replace("<!HE>", ""));
									cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								}
								else if(row.item(j).getNodeName().equals("PUBLICYN"))
									cs.setPublicYn(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("DEPARTMENTID"))
									cs.setDepartmentId(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("UNIVERSITYID"))
									cs.setUniversityId(Integer.parseInt(row.item(j).getTextContent().trim()));
								else if(row.item(j).getNodeName().equals("KEYWORD"))
									cs.setKeyword(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("REGDATE"))
								{
									SimpleDateFormat sdfmt = new SimpleDateFormat( "yyyymmdd" );
									String date = row.item(j).getTextContent().substring(0, 8);
									Date regdate = sdfmt.parse( date.trim() );
									cs.setRegDate(regdate);
								}
								else if(row.item(j).getNodeName().equals("SIP"))
									cs.setSip(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("URI"))
									cs.setUri(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("QUI"))
									cs.setQri(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("SP"))
									cs.setSp(row.item(j).getTextContent().trim());
								cs.setTotalCnt(totalCnt);
								cs.setStartCount(startCount);
							}
						}//end for j
						list.add(cs);
						System.out.println();
					}//end if
				
				}//end for k
				
			}//end for i
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	
	
	
	//test
	public static void main(String[] ar){
		
		try {
			
			URLEncoder.encode("","UTF-8");
			
			URLDecoder.decode("","UTF-8");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		/*
		
		 String[] arrStr = {"A", "B", "C", "A", "G", "D", "C", "F", "H", "G"};

	        TreeSet    tSet    = new TreeSet();
	        for( int i = 0; i < arrStr.length; i++ ) {
	            tSet.add( arrStr[i] );
	        }       
	       Iterator    it    = tSet.iterator();
	        while ( it.hasNext() ) {
	            System.out.println(" Str = " + it.next().toString() );
	        }
	        
	        if(true)
	        	return;
		
		
		
		
		System.out.println("main test");
		
		String url = "";
		String text 			= "사회복지";
		
		//real
		String address			= "http://www.cuinfo.net/search1";
		
		url = address + "/search_xml.jsp?collection=univ_lecture&startCount=0&listCount=10&sfield=description";
		
		try {
			text = URLEncoder.encode(URLEncoder.encode(text,"UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("e1 Error"); e1.printStackTrace();
		} catch (Exception e2){
			System.out.println("e2 Error"); e2.printStackTrace();
		}
		
		
		//검색어
		if(!"".equals(text))
			url += "&query="+text;
		
		System.out.println("!!! url = "+url+"\n");
		
		String textarr = "";
		try {
			//1단계:xml 파싱
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder   		= factory.newDocumentBuilder();
			Document document     			= builder.parse(url);

			//2단계:콜렉션 명에 따라 해당하는 모델 맵핑
			NodeList result = document.getElementsByTagName("Result");
			
			NodeList rows = result.item(0).getChildNodes();
			
			String tmpStr = "";
			for (int i = 0; i < rows.getLength(); i++) {
				
				if(rows.item(i).getNodeType() == 1){
					CourseSearch cs = new CourseSearch();
					NodeList row = rows.item(i).getChildNodes();
					
					for (int j = 0; j < row.getLength(); j++) {
						if(row.item(j).getNodeType() == 1 && "description".equals(row.item(j).getNodeName())){// 
							tmpStr = row.item(j).getTextContent().trim();
							for (int k = 0; k < tmpStr.length(); k++) {
								if(tmpStr.charAt(k) == '\'' && tmpStr.charAt(k+1) == '>'){
									while(true){
										k++;
										textarr += tmpStr.charAt(k+1);
										
										if(tmpStr.charAt(k+2) == '<' && tmpStr.charAt(k+3) == '/'){
											textarr += ",";
											break;
										}
									}
								}
							}
						}
					}//end for
					
				}//end if
			}//end for
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("textarr = " + textarr);
		
		*/
		
		
		
		
List<CourseSearch> list = new ArrayList<CourseSearch>();
		
		Integer startCount		= 0;
		Integer universityId 	= 0;
		Integer currPage 		= 0;
		Integer showCnt 		= 10;
		Integer checkbox3		= 0;
		Integer publicYN		= 0;
		Integer select			= 0;
		
		String url = "";
		String collection		= "";
		String deptId 			= "";
		String text 			= "";
		String odbykey			= "";
		String odby				= "";
		String sfield			= "";
		String address			= "";
		
		//test
		address			= "http://61.82.137.49:7900/xml/jsp";
		text = "스크린";
		
		//real
		//address			= "http://www.cuinfo.net/search1";
		select			= 1;
		currPage		= 1;
		/*
		checkbox3 		= courseSearch.getCheckbox3();
		text 			= courseSearch.getText();
		deptId 			= courseSearch.getDeptId();
		universityId 	= courseSearch.getUniversityId();
		showCnt 		= courseSearch.getShowCnt();
		odbykey 		= courseSearch.getOdbykey();
		odby 			= courseSearch.getOdby();
		publicYN		= courseSearch.getCheckbox1();
		*/
		
		System.out.println("check1 sfield = " + sfield);
		System.out.println("check2 odbykey = " + odbykey);
		System.out.println("check3 odby = " + odby);
		
		//기존의 정렬기준을 확인하여 변경된 값으로 바꾼다.
		sfield 	= select == 1 ? "title" : select == 2 ? "contName" : select == 3 ? "univName" : select == 4 ? "description" : select == 5 ? "keyword" : "title";
		//sfield 	= "maintitle".equals(sfield)?"title":"contname".equals(sfield)?"contName":"univName".equals(sfield)?"univName":"description".equals(sfield)?"description":"keyword".equals(sfield)?"keyword":"title";
		odbykey = "regdate".equals(odbykey)?"regDate":"univname".equals(odbykey)?"univName":"deptname".equals(odbykey)?"deptName":"clicksCnt".equals(odbykey)?"clicksCnt":"regDate";
		odby 	= "asc".equals(odby)?"0":"desc".equals(odby)?"1":"1";
		
		
		//와이즈넛에서 컬렉션명 반대로 적용한듯..
//		switch (checkbox3) {
		switch (2) {
		case 2://최근1년검색
			collection = "univ_lecture_year";
			break;
		case 3://전체검색
			collection = "univ_lecture";
			break;
		}
		
		startCount = (currPage - 1) * showCnt;
		
		if(startCount < 0)
			startCount = 0;
		/*
		System.out.println("#########################################");
		System.out.println("Select1 = " + courseSearch.getSelect1());
		System.out.println("sfield = " + sfield);
		System.out.println("currPage = " + currPage);
		System.out.println("collection = " + collection);
		System.out.println("startCount = " + startCount);
		System.out.println("#########################################");
		*/
		url = address + "/search_xml.jsp?collection="+collection+"&startCount="+startCount+"&listCount="+showCnt+"&sort="+odbykey+"&order="+odby;
		
		try {
			text = URLEncoder.encode(URLEncoder.encode(text,"UTF-8"),"UTF-8");
		} catch (UnsupportedEncodingException e1) {
			System.out.println("e1 Error"); e1.printStackTrace();
		} catch (Exception e2){
			System.out.println("e2 Error"); e2.printStackTrace();
		}
		
		//검색시작번호(페이징처리)
		
		//강의검색은 넘어오는 파라미터들에 따라 호출하는 xml 내용이 틀려지므로
		//기본 url 에 파라미터를 추가하는 형식으로 한다.
		
		//검색어
		/*
		if(!"".equals(text))
			url += "&query="+text;
		//검색필터
		if(!"".equals(sfield))
			url += "&sfield="+sfield;
		//학교별검색시
		if(!"".equals(deptId))
			url += "&departmentId="+deptId;
		//학과분야별검색시
		if(universityId != 0)
			url += "&universityId="+universityId;
		//공개강의여부
		if(publicYN != 0)
			url += "&publicYn=Y";
		*/
		
		System.out.println("!!! url = "+url+"\n");
		
		try {
			//1단계:xml 파싱
			DocumentBuilderFactory factory  = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder   		= factory.newDocumentBuilder();
			Document document     			= builder.parse(url);

			System.out.println("\nDocumentSet ============================================================================================\n");
			
			String resultName 	= "";
			String resultValue 	= "";
			int totalCnt 		= 0;
			String collName 	= "";
			
			NodeList DocumentSet = document.getElementsByTagName("DocumentSet");
			NodeList temp1 = null;

			
			for (int i = 0; i < DocumentSet.getLength(); i++) {
				temp1 = DocumentSet.item(i).getChildNodes();
				for (int j = 0; j < temp1.getLength(); j++) {
					if(temp1.item(j).getNodeName().equals("TotalCount")){
						totalCnt += Integer.parseInt(temp1.item(j).getTextContent().trim());
					}
				}
			}
			System.out.println("totalCnt ===> " + totalCnt);
			
			//3단계:콜렉션 명에 따라 해당하는 모델 맵핑
			
			//Document 집합을 구한다.
			NodeList Documents = document.getElementsByTagName("Document");
			
			//Document 크기만큼 루프.
			for (int i = 0; i < Documents.getLength(); i++) {
				
				//Document 의 내용을 담는다.
				NodeList Document = Documents.item(i).getChildNodes();
				
				
				//Document 의 내용만큼 루프.
				for (int k = 0; k < Document.getLength(); k++) {
					
					//Document 의 내용중 Field 를 CourseSearch 객체에 맵핑한다.
					if(Document.item(k).getNodeName().equals("Field") && Document.item(k).getNodeType() == 1){
						CourseSearch cs = new CourseSearch();
						NodeList row = Document.item(k).getChildNodes();
						Integer clicksCnt = 0;
						Integer courseId = 0;
						
						for (int j = 0; j < row.getLength(); j++) {
							if(row.item(j).getNodeType() == 1 ){
								
								System.out.println(i + " => " + row.item(j).getNodeName()+":"+row.item(j).getTextContent());
	
								if(row.item(j).getNodeName().equals("DOCID"))
									cs.setCourseId(Integer.parseInt(row.item(j).getTextContent().trim()));
								else if(row.item(j).getNodeName().equals("COURSEIDENTIFIER"))
									cs.setCourseIdentifier(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("UNIVNAME"))
									cs.setUniversityName (row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));//<em class="red"></em>
								else if(row.item(j).getNodeName().equals("CLICKSCNT")){
									courseId = cs.getCourseId();
									//clicksCnt = (Integer)queryForObject("CourseSearchDao.clicksCnt",courseId);
									cs.setClicksCnt(clicksCnt);
								}
								else if(row.item(j).getNodeName().equals("DEPARTMENT"))
									cs.setDepartment(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("CREDIT"))
									cs.setCredit(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("TERMSEMESTER"))
									cs.setTermSemester(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("MANAGER"))
									cs.setManager(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("DESCRIPTION"))
									cs.setDescription(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("TITLE")){
									cs.setMainTitle(row.item(j).getTextContent().trim().replace("<!HS>", "").replace("<!HE>", ""));
									cs.setTitle(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								}
								else if(row.item(j).getNodeName().equals("PUBLICYN"))
									cs.setPublicYn(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("DEPARTMENTID"))
									cs.setDepartmentId(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("UNIVERSITYID"))
									cs.setUniversityId(Integer.parseInt(row.item(j).getTextContent().trim()));
								else if(row.item(j).getNodeName().equals("KEYWORD"))
									cs.setKeyword(row.item(j).getTextContent().trim().replace("<!HS>", "<b style='color:red;'>").replace("<!HE>", "</b>"));
								else if(row.item(j).getNodeName().equals("REGDATE"))
								{
									SimpleDateFormat sdfmt = new SimpleDateFormat( "YYYYMMDD" );
									String date = row.item(j).getTextContent().substring(0, 8);
									Date regdate = sdfmt.parse( date.trim() );
									cs.setRegDate(regdate);
								}
								else if(row.item(j).getNodeName().equals("SIP"))
									cs.setSip(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("URI"))
									cs.setUri(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("QUI"))
									cs.setQri(row.item(j).getTextContent().trim());
								else if(row.item(j).getNodeName().equals("SP"))
									cs.setSp(row.item(j).getTextContent().trim());
								cs.setTotalCnt(totalCnt);
								cs.setStartCount(startCount);
							}
						}//end for j
						list.add(cs);
						System.out.println();
					}//end if
				
				}//end for k
				
			}//end for i
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
	}
	
	public List selectPublicCourseList(CourseSearch courseSearch){
		return queryForList("CourseSearchDao.selectPublicCourseList",courseSearch);
	}
	
	public String selectCourseId(CourseSearch courseSearch){
		return (String)queryForObject("CourseSearchDao.selectCourseId",courseSearch);
	}
	
}

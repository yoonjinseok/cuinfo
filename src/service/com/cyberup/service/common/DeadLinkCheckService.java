package com.cyberup.service.common;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.common.DeadLinkCheckDao;
import com.cyberup.dao.univ.AcademyinfoLinkDao;
import com.cyberup.dao.univ.UnivDao;
import com.cyberup.model.common.DeadLinkCheckModel;
import com.cyberup.model.univ.AcademyinfoLink;
import com.cyberup.model.univ.Univ;
import com.ibm.icu.text.SimpleDateFormat;

@Service
@Transactional
public class DeadLinkCheckService {
	
	@Autowired
	private DeadLinkCheckDao deadLinkCheckDao;
	@Autowired
	private AcademyinfoLinkDao academyinfoLinkDao;
	@Autowired
	private UnivDao univDao;
	
	public void AcademyDeadLinkCheck(Integer infoId){
		
		List<AcademyinfoLink> list;
		List<Univ> univList = univDao.selectUnivList(1);
		
		list = academyinfoLinkDao.selectViewList();
		
		int linkId 			= 0;
		int errCode 		= 0;
		String checkLink 	= "";
		
		for (int i = 0; i < list.size(); i++) {

			/*
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("## Thread Error !!!");
			}
			*/
			//link 수만큼 for 문을 수행하며 코드 이상을 확인하여 업데이트
			
			AcademyinfoLink dlcm = (AcademyinfoLink)list.get(i);
			
			linkId 		= dlcm.getInfoId();
			checkLink 	= dlcm.getInfoUrlpattern();
			SimpleDateFormat sdt = new SimpleDateFormat("yyyy", Locale.KOREA);
			Date dTime = new Date();
			
			System.out.println("\n\n [YYYY]:" + Integer.toString(Integer.parseInt(sdt.format(dTime))-1));
			checkLink = checkLink.replace("[YYYY]", Integer.toString(Integer.parseInt(sdt.format(dTime))-1));
			checkLink = checkLink.replace("[SCHCODE]", univList.get(0).getAcademy_id());
			
			errCode		= deadLinkCheckDao.isValid(checkLink, "75000");
			
			System.out.println("\n\nlinkId = "+linkId + ", checkLink = " + checkLink + ", errCode check =>> " + errCode + "\n\n");
			
			//0 또는 200 이면 정상, 그외에는 오류
			if(errCode == 0 || errCode == 200)
				errCode = 0;
				
			academyinfoLinkDao.updateDeadlink(linkId,errCode);
			
		}
	}
	
	public void deadLinkCheck(Integer university_id){
		
		List<DeadLinkCheckModel> list;
		
		//ibatis 에서 동적쿼리가 에러 발생하여 service 단에서 분기함..
		if(university_id != 0)
			list = deadLinkCheckDao.deadLinkCheckListForUser(university_id);
		else
			list = deadLinkCheckDao.deadLinkCheckList();
		
		
		int linkId 			= 0;
		int errCode 		= 0;
		String checkLink 	= "";
		
		for (int i = 0; i < list.size(); i++) {
			
			/*
			try {
				Thread.sleep(2000);
			} catch (Exception e) {
				System.out.println("## Thread Error !!!");
			}
			*/
			//link 수만큼 for 문을 수행하며 코드 이상을 확인하여 업데이트
			
			DeadLinkCheckModel dlcm = (DeadLinkCheckModel)list.get(i);
			
			linkId 		= dlcm.getLink_id();
			checkLink 	= dlcm.getLink_url();
			errCode		= deadLinkCheckDao.isValid(checkLink, "75000");
			
			System.out.println("\n\nlinkId = "+linkId + ", checkLink = " + checkLink + ", errCode check =>> " + errCode + "\n\n");
			
			//0 또는 200 이면 정상, 그외에는 오류
			if(errCode == 0 || errCode == 200)
				errCode = 0;
				
			deadLinkCheckDao.updateUnivLinkInfo(linkId,errCode);
			
		}
		
	}
	
}

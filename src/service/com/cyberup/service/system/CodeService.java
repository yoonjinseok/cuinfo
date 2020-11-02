package com.cyberup.service.system;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cyberup.dao.admin.AdminDao;
import com.cyberup.dao.course.DataProviderDao;
import com.cyberup.dao.system.CodeDao;
import com.cyberup.dao.system.UnivCodeDao;
import com.cyberup.model.admin.Admin;
import com.cyberup.model.course.DataProvider;
import com.cyberup.model.system.Code;
import com.cyberup.model.system.UnivCode;


@Service
@Transactional
public class CodeService {
	@Autowired
	private CodeDao codeDao;

	public int deleteInfo(Integer codeId) {
		return this.codeDao.deleteInfo(codeId);
	}
	public List<Code> selectViewList(Integer showCnt, Integer currPage, Integer codeId, String codeName, String codeGroup, String codeGroupName, String useYn) {
		return this.codeDao.selectViewList(showCnt, currPage, codeId, codeName, codeGroup, codeGroupName, useYn);
	}
	public List<Code> selectList(Integer codeGroup, String useYn) {
		return this.codeDao.selectList(codeGroup, useYn);
	}
	public List<Code> selectGroupList(String useYn) {
		return this.codeDao.selectGroupList(useYn);
	}
	public int updateInfo(Code code) {
		return this.codeDao.updateInfo(code);
	}
	public Code selectInfo(Integer codeId) {
		return this.codeDao.selectInfo(codeId);
	}
	public Integer insertInfo(Code code) {
		return this.codeDao.insertInfo(code);
	}
	
	/**row 데이터 추출 기능
	 * 20140918 김재현
	 * @param model
	 * @param query
	 * @return
	 */
	
	public List selectTableData(String query){
		return this.codeDao.selectTableData(query);
	}
	
	public String insertTableData(String insertquery){
		return this.codeDao.insertTableData(insertquery);
	}
	
	public int updateTableData(String updatequery){
		return this.codeDao.updateTableData(updatequery);
	}
	
	public int deleteTableData(String deletequery){
		return this.codeDao.deleteTableData(deletequery);
	}
	
	public String createTableData(String query){
		List list = this.codeDao.selectTableData(query);
		return this.codeDao.makeFileTableData(list);
	}
}

//라이선스 팝업창 호출 스크립트
function openCCPreview(form) {
    //popup('DcSuNsLicensePreview.jsp','CCPreview',650,600,1);
    //popup('http://creativecommons.org/licenses/by-nc-nd/2.0/kr/','CCPreview',650,600,1);

    if (!form) form = document.form;
		if(!checkLic()){
			return;
		}
    form.openLegalCodeYN.value = "N";
    popup('','CCPreview',650,600,'No');
    form.target = "CCPreview";
    form.method = "post";
	form.action = "/mgr/license/DcCcLicenseView.jsp";
	form.submit();
}

//legalCOde 팝업창 호출 스크립트
function openLegalCode(form) {
    //popup('DcSuNsLegalCode.jsp','LegalCode',650,600,1);
    //popup('http://creativecommons.org/licenses/by-nc-nd/2.0/kr/legalcode','LegalCode',650,600,1);

    if (!form) form = document.form;

    form.openLegalCodeYN.value = "Y";
    popup('', 'LegalCode', 650, 600, 1);
    form.target = "LegalCode";
    form.method = "post";
	form.action = "/mgr/license/DcCcLicenseView.jsp";
	form.submit();
}

//라이선스 수정 클릭시 호출되는 팝업 스크립트
function openCCLicenseMod() {
	showWin('/mgr/license/DcCcLicenseInput.jsp','CCLicenseMod',500,400);
}

//해당 라이선스 이미지 클릭 시 해당 라이선스에 대한 상세정보를 보여주는 팝업창을 호출하는 스크립트
function openLicenseHelp(elementId) {
	showWin('/mgr/license/DcCcLicenseHelp.jsp?elementId='+elementId,'LicenseHelp',675,600);
}

// Creative Commons License 안내페이지
function openCCLicense() {
    //window.open('http://www.creativecommons.or.kr/info/about','CCLicense');
	window.open('http://www.creativecommons.or.kr/xe/?mid=ccl','CCLicense');
}





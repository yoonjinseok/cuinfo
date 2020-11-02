<%@ page contentType="text/html;charset=UTF-8"%>

<html>
<head>
<title>라이선스 정보</title>
<script language="javascript">
<!--
// Creative Commons License 안내페이지 
function openCCLicense() {
    window.open('http://www.creativecommons.or.kr/info/about','CCLicense');
}

// 라이선스 도움말 새창 
function openLicenseHelp(elementId) {
    popup('DcSuNsLicenseHelp.jsp?elementId='+elementId,'LicenseHelp','375','300');
}

// 페이지 로딩 시 Form 초기화 
function setInitLic()
{
	if ( window.opener.document.form.elementId[1].value == "002" )
	{
		if ( window.opener.document.form.defaultValue[1].value == "Y" )
			document.licenseForm.nc[1].checked = true;
		else
			document.licenseForm.nc[0].checked = true;
	}
	
	document.licenseForm.sand[0].checked = true;
	if ( window.opener.document.form.elementId[3].value == "004" )
	{
		if ( window.opener.document.form.defaultValue[3].value == "Y" )
			document.licenseForm.sand[1].checked = true;
		
	}
	if ( window.opener.document.form.elementId[2].value == "003" )
	{
		if ( window.opener.document.form.defaultValue[2].value == "Y" )
			document.licenseForm.sand[2].checked = true;
		
	}
}

// 수정 버튼 클릭 시 오프너에게 값 전달 
function modLic()
{
	if ( document.licenseForm.nc[1].checked )
		window.opener.document.form.defaultValue[1].value = "Y";
	else
		window.opener.document.form.defaultValue[1].value = "N";
		
	if ( document.licenseForm.sand[0].checked )
	{
		window.opener.document.form.defaultValue[2].value = "N";
		window.opener.document.form.defaultValue[3].value = "N";
	}
	else if ( document.licenseForm.sand[1].checked )
	{
		window.opener.document.form.defaultValue[2].value = "N";
		window.opener.document.form.defaultValue[3].value = "Y";
	}
	else if ( document.licenseForm.sand[2].checked )
	{
		window.opener.document.form.defaultValue[2].value = "Y";
		window.opener.document.form.defaultValue[3].value = "N";
	}
	
	window.opener.showHideLICTable(0);
	window.close();
}
//-->

</script>
</head>

<body leftmargin="0" topmargin="0" marginheight="0">
<form name="licenseForm">
<table width="500" height="100%" border="0" cellpadding="0" cellspacing="0" class="tatble2_box_w_1">
  <tr> 
    <td height="65" valign="top"><img src="/pop_40.gif" width="500" height="65"></td>
  </tr>
  <tr>
  	<td height=10></td>
  </tr>
  <tr>
  	<td align=center>
  		<table width="460" border="0" cellpadding="0" cellspacing="0">
  			<tr>
  				<td>
  					<strong>▶ 귀하의 저작물 이용시 저작자를 표시해야 합니까?</strong>(<a href="javascript:openLicenseHelp('001');"><font color="#a000000">상세</font><img src="/popup.gif" border=0></a>)
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type=radio checked readonly disabled> 예
  					<br/>
  					<input type=radio readonly disabled> 아니오	
  				</td>
  			</tr>			
  			<tr>
				<td height=10></td>
			</tr>
  			<tr>
  				<td>
  					<strong>▶ 귀하는 저작물의 영리목적 이용을 허락합니까?</strong>(<a href="javascript:openLicenseHelp('002');"><font color="#a000000">상세</font><img src="/popup.gif" border=0></a>)
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type=radio name=nc value=1> 예
  					<br/>
  					<input type=radio name=nc value=0> 아니오	
  				</td>
  			</tr>		
  			<tr>
				<td height=10></td>
			</tr>
  			<tr>
  				<td>
  					<strong>▶ 귀하는 저작물의 변경을 허락합니까?</strong>(<a href="javascript:openLicenseHelp('003');"><font color="#a000000">상세</font><img src="/popup.gif" border=0></a>)
  				</td>
  			</tr>
  			<tr>
  				<td>
  					<input type=radio name=sand value=1> 예
  					<br/>
  					<input type=radio name=sand value=2> 네, 단 동일한 이용허락조건을 적용하는 경우에만(<a href="javascript:openLicenseHelp('004');"><font color="#a000000">상세</font><img src="/popup.gif" border=0></a>)			
  					<br/>
  					<input type=radio name=sand value=0> 아니오		
  				</td>
  			</tr>	
  			<tr>
				<td height=20></td>
			</tr>
			<tr>
				<td>
					<table cellpadding="0" cellspacing="0" width="100%">
						<tr bgcolor="#eeeeee">
							<td width=10 height=40><img src="/point_17_2.gif" border=0 ></td>
							<td>
								&nbsp;&nbsp;dCollection은 <a href="javascript:openCCLicense();"><font color="#ff6600"><b><u>Creative Commons License</u></b></font></a>를 준수합니다.<br/>
								&nbsp;&nbsp;라이선스(이용허락) 범위는수정할 수 있습니다.
							</td>
						</tr>
					</table>
				</td>
			</tr>
  		</table>
  	</td>
  </tr>
  <tr height="100%" valign="bottom" > 
    <td align="center" valign="bottom">
    	<a href="javascript:modLic();"><img src="/table_unB_19.gif"  border="0"></a>
    	&nbsp;&nbsp;
    	<a href="javascript:window.close();"><img src="/table_unB_38.gif" border="0"></a>
    </td>
  </tr>
</table>
</form>
<script language=javascript>
	setInitLic();
</script>
</body>
</html>

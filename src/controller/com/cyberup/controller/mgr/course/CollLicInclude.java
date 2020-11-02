/***********************************************************
 * 프로그램 이름 : 라이선스 > 라이선스 미리보기               
 * 프로그램 fileName : CollLicInclude.java            
 * 작성일자 : 2005.10.28.(금)
 * 작성자  : Song, kook-jong
 * 소   속 : 퓨쳐인포넷
 ***********************************************************/

package com.cyberup.controller.mgr.course;

import java.util.ArrayList;
import java.util.List;
  
public class CollLicInclude {
    String imgBY = "";
    String imgNC = "";
    String imgND = "";
    String imgSA = "";
    
    String CCDeedName = "";
    
    /**
     * CollLicense를 파라미터로 받아 라이선스 미리보기 내용을 생성하는 함수 
     * 
     * @param object
     *            CollLicense 
      * @return 라이선스 미리보기 내용 
     */
    public String getCollLic(Object object)
    {
        List lKeys = (List)object;
        String ccDeed = CommonConstants.LIC_ATTRIBUTION;
        
        //System.out.println("lKeys.size() = "+Integer.toString(lKeys.size()));
        
        CollLicense article[] = new CollLicense[lKeys.size()];
        lKeys.toArray(article);

        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("002") && (article[i].getADefaultValue()).equals("Y") )
            { 
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NONCOMMERCIAL;
                break;
            }
        }
        
        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("003") && (article[i].getADefaultValue()).equals("Y") )
            {    
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NO_DERIVATIVE;
                break;
            }
            else if ( (article[i].getElementId()).equals("004") && (article[i].getADefaultValue()).equals("Y") )
            {
                ccDeed = ccDeed + "-"+CommonConstants.LIC_SHARE_ALIKE;
                break;
            }
        }
        
        //Logger.debug("ccDeed = "+ccDeed);
        return getCCDeed(ccDeed);
    }
    
    /**
     * CollLicense를 파라미터로 받아 CommmonsDeed명을 생성하는 함수 
     * 
     * @param object
     *            CollLicense 
      * @return CommmonsDeed명(예: by, by-nc 등)
     */
    public String getCCDeedName(Object object)
    {
        List lKeys = (List)object;
        String ccDeed = CommonConstants.LIC_ATTRIBUTION;
        
        CollLicense article[] = new CollLicense[lKeys.size()];
        lKeys.toArray(article);
        
        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("002") && (article[i].getADefaultValue()).equals("Y") )
            { 
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NONCOMMERCIAL;
                break;
            }
        }
        
        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("003") && (article[i].getADefaultValue()).equals("Y") )
            {    
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NO_DERIVATIVE;
                break;
            }
            else if ( (article[i].getElementId()).equals("004") && (article[i].getADefaultValue()).equals("Y") )
            {
                ccDeed = ccDeed + "-"+CommonConstants.LIC_SHARE_ALIKE;
                break;
            }
        }
        
        //Logger.debug("ccDeed = "+ccDeed);
        return ccDeed;
    }
    
    /**
     * CollLicense를 파라미터로 받아 CommmonsDeed명을 전역변수에 저장하는 함수 
     * 
     * @param object
     *            CollLicense 
     */
    public void setCCDeed(Object object)
    {
        List lKeys = (List)object;
        String ccDeed = CommonConstants.LIC_ATTRIBUTION;
        
        CollLicense article[] = new CollLicense[lKeys.size()];
        lKeys.toArray(article);
        
        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("002") && (article[i].getADefaultValue()).equals("Y") )
            { 
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NONCOMMERCIAL;
                break;
            }
        }
        
        for(int i=0;i<article.length;i++)
        {
            if ( (article[i].getElementId()).equals("003") && (article[i].getADefaultValue()).equals("Y") )
            {    
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NO_DERIVATIVE;
                break;
            }
            else if ( (article[i].getElementId()).equals("004") && (article[i].getADefaultValue()).equals("Y") )
            {
                ccDeed = ccDeed + "-"+CommonConstants.LIC_SHARE_ALIKE;
                break;
            }
        }
        
        //Logger.debug("ccDeed = "+ccDeed);
        CCDeedName = ccDeed;
    }
    
    public String getCCDeed()
    {
    	return this.CCDeedName;
    }
    
    /**
     * 라이선스 항목을 배열로 받아 CommmonsDeed명을 생성하는 함수 
     * 
     * @param elementIds
     *            라이선스 요소 아이디 배열
     * @param default_Values
     *            라이선스 값 배열            
      * @return CommmonsDeed명(예: by, by-nc 등)
     */
    public static String getCCDeedName(String[] elementIds, String[] default_Values)
    {
        String ccDeed = CommonConstants.LIC_ATTRIBUTION;
        
        for(int i=0;i<elementIds.length;i++)
        {
            if ( elementIds[i].equals("002") && default_Values[i].equals("Y") )
            { 
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NONCOMMERCIAL;
                break;
            }
        }
        
        for(int i=0;i<elementIds.length;i++)
        {
            if ( elementIds[i].equals("003") && default_Values[i].equals("Y") )
            {    
                ccDeed = ccDeed + "-" + CommonConstants.LIC_NO_DERIVATIVE;
                break;
            }
            else if ( elementIds[i].equals("004") && default_Values[i].equals("Y") )
            {
                ccDeed = ccDeed + "-"+CommonConstants.LIC_SHARE_ALIKE;
                break;
            }
        }
        
        //Logger.debug("ccDeed = "+ccDeed);
        return ccDeed;
    }
    
    /**
     * CommmonsDeed명을 받아 라이선스미리보기 내용을 생성하는 함수 
     * 
     * @param ccDeed
     *            CommmonsDeed명      
      * @return 라이선스 미리보기 내용 
     */
    public String getCCDeed(String ccDeed)
    {
        setSymbols();
        
        if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION) )
            return getBY();
        else if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NONCOMMERCIAL) )
            return getBY_NC();
        else if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NO_DERIVATIVE) )
            return getBY_ND();
        else if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_SHARE_ALIKE) )
            return getBY_SA();
        else if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NONCOMMERCIAL+"-"+CommonConstants.LIC_NO_DERIVATIVE) )
            return getBY_NC_ND();
        else if ( ccDeed.equals(CommonConstants.LIC_ATTRIBUTION+"-"+CommonConstants.LIC_NONCOMMERCIAL+"-"+CommonConstants.LIC_SHARE_ALIKE) )
            return getBY_NC_SA();
        else
            return null;
    }
    
    /**
     * 라이선스 아이콘 파일명을 전역변수에 저장하는 함수 
     * 
     */
    private void setSymbols()
    {
        imgBY = "by.gif";
        imgNC = "nc.gif";
        imgND = "nd.gif";
        imgSA = "sa.gif";
    }
    
    /**
     * CommonsDeed의 By 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY()
    {
        StringBuffer sb = new StringBuffer("");
        
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\"/mgr/license/resource/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\"/mgr/license/resource/logo_deed.gif\" width=280 vspace=14 border=0> \n");
        sb.append("\n");
        sb.append("<P><B>저작자표시 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. \n");
          sb.append("<LI>이차적 저작물을 작성할 수 있습니다.\n");
          sb.append("<LI>이 저작물을 영리 목적으로 이용할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 src=\"/mgr/license/resource/by.gif\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 \n");
          sb.append("합니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\"/mgr/license/resource/popup.gif\" width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\"/mgr/license/resource/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");
        
        return sb.toString();
    }
    
    /**
     * CommonsDeed의 By-Nc 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY_NC()
    {
        StringBuffer sb = new StringBuffer("");
        
        String imgPath  = "/mgr/license/resource";
        
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\""+imgPath+"/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\""+imgPath+"/logo_deed.gif\" width=280 vspace=14 \n");
        sb.append("border=0> \n");
        sb.append("<P><B>저작자표시-비영리 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. \n");
          sb.append("<LI>이차적 저작물을 작성할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 src=\""+imgPath+"/"+imgBY+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 합니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=nc hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgNC+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>비영리</STRONG>. 귀하는 이 저작물을 영리 목적으로 이용할 수 \n");
            sb.append("없습니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\""+imgPath+"/popup.gif\" \n");
        sb.append("width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\""+imgPath+"/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");

        return sb.toString();
    }
    
    /**
     * CommonsDeed의 By-Nd 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY_ND()
    {
        StringBuffer sb = new StringBuffer("");
        
        String imgPath  = "/mgr/license/resource";
        
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\""+imgPath+"/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\""+imgPath+"/logo_deed.gif\" width=280 vspace=14 \n");
        sb.append("border=0> \n");
        sb.append("<P><B>저작자표시-변경금지 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. \n");
          sb.append("<LI>이 저작물을 영리 목적으로 이용할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 src=\""+imgPath+"/"+imgBY+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 합니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=nd hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgND+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>변경금지</STRONG>. 귀하는 이 저작물을 개작, 변형 또는 가공할 수 \n");
              sb.append("없습니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nd/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nd/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nd/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nd/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nd/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\""+imgPath+"/popup.gif\" \n");
        sb.append("width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\""+imgPath+"/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");
        
        return sb.toString();
    }
    
    /**
     * CommonsDeed의 By-Sa 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY_SA()
    {
        StringBuffer sb = new StringBuffer("");
        
        String imgPath  = "/mgr/license/resource";
        
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\""+imgPath+"/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\""+imgPath+"/logo_deed.gif\" width=280 vspace=14 \n");
        sb.append("border=0> \n");
        sb.append("<P><B>저작자표시-동일조건변경허락 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. \n");
          sb.append("<LI>이차적 저작물을 작성할 수 있습니다.\n");
          sb.append("<LI>이 저작물을 영리 목적으로 이용할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 src=\""+imgPath+"/"+imgBY+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 합니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=sa hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgSA+"\" \n");
              sb.append(" align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>동일조건변경허락</STRONG>. 귀하가 이 저작물을 개작, 변형 또는 가공했을 경우에는, \n");
              sb.append("이 저작물과 동일한 이용허락조건하에서만 배포할 수 있습니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-sa/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-sa/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-sa/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-sa/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-sa/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\""+imgPath+"/popup.gif\" \n");
        sb.append("width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\""+imgPath+"/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");
        
        return sb.toString();
    }
    
    /**
     * CommonsDeed의 By-Nc-Nd 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY_NC_ND()
    {
        StringBuffer sb = new StringBuffer("");
        
        String imgPath  = "/mgr/license/resource";
        
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\""+imgPath+"/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\""+imgPath+"/logo_deed.gif\" width=280 vspace=14 \n");
        sb.append("border=0> \n");
        sb.append("<P><B>저작자표시-비영리-변경금지 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgBY+"\" align=left \n");
        sb.append("border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 합니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=nc hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgNC+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>비영리</STRONG>. 귀하는 이 저작물을 영리 목적으로 이용할 수 \n");
            sb.append("없습니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=nd hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgND+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>변경금지</STRONG>. 귀하는 이 저작물을 개작, 변형 또는 가공할 수 \n");
              sb.append("없습니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-nd/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc-nd/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-nd/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc-nd/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-nd/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\""+imgPath+"/popup.gif\" \n");
        sb.append("width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\""+imgPath+"/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");
        
        return sb.toString();
    }
    
    /**
     * CommonsDeed의 By-Nc-Sa 항목에 해당하는 내용을 리턴하는 함수 
     * 
     */
    private String getBY_NC_SA()
    {
        StringBuffer sb = new StringBuffer("");
        
        String imgPath  = "/mgr/license/resource";
     
        sb.append("<HTML><HEAD><TITLE>Creative Commons Deed</TITLE>\n");
        sb.append("<LINK \n");
        sb.append("href=\""+imgPath+"/deeds.css\" type=text/css \n");
        sb.append("rel=stylesheet><LINK href=\"rdf\" type=application/rdf+xml rel=alternate>\n");
        sb.append("</HEAD>\n");
        sb.append("<BODY>\n");
        sb.append("<DIV id=deed>\n");
        sb.append("<DIV align=center><IMG height=79 alt=\"Creative Commons Deed\" \n");
        sb.append("src=\""+imgPath+"/logo_deed.gif\" width=280 vspace=14 \n");
        sb.append("border=0> \n");
        sb.append("<P><B>저작자표시-비영리-동일조건변경허락 2.0 대한민국</B></P>\n");
        sb.append("<DIV class=text>\n");
        sb.append("<P><STRONG>이용자는 아래의 조건을 따르는 경우에 한하여 자유롭게</STRONG></P>\n");
        sb.append("<UL>\n");
          sb.append("<LI>이 저작물을 복제, 배포, 전송, 전시, 공연 및 방송할 수 있습니다. \n");
          sb.append("<LI>이차적 저작물을 작성할 수 있습니다. </LI></UL>\n");
        sb.append("<P><STRONG>다음과 같은 조건을 따라야 합니다:</STRONG></P>\n");
        sb.append("<DIV align=center>\n");
        sb.append("<TABLE class=draft cellSpacing=0 cellPadding=4 width=500 border=0>\n");
          sb.append("<TBODY>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=by hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgBY+"\" align=left \n");
        sb.append("border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>저작자표시</STRONG>. 귀하는 원저작자를 표시하여야 합니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=nc hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgNC+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>비영리</STRONG>. 귀하는 이 저작물을 영리 목적으로 이용할 수 \n");
            sb.append("없습니다.</DIV></TD></TR>\n");
          sb.append("<TR>\n");
            sb.append("<TD>\n");
            sb.append("<IMG alt=sa hspace=4 \n");
              sb.append("src=\""+imgPath+"/"+imgSA+"\" \n");
              sb.append("align=left border=0 width=\"64\" height=\"64\"></TD>\n");
            sb.append("<TD align=left>\n");
              sb.append("<DIV class=tiny><STRONG>동일조건변경허락</STRONG>. 귀하가 이 저작물을 개작, 변형 또는 가공했을 경우에는, \n");
              sb.append("이 저작물과 동일한 이용허락조건하에서만 배포할 수 있습니다.</DIV></TD></TR></TBODY></TABLE></DIV>\n");
        sb.append("<UL>\n");
          sb.append("<LI>귀하는, 이 저작물의 재이용이나 배포의 경우, 이 저작물에 적용된 이용허락조건을 명확하게 나타내어야 합니다. \n");
          sb.append("<LI>저작권자로부터 별도의 허가를 받으면 이러한 조건들은 적용되지 않습니다. </LI></UL>\n");
        sb.append("<P style=\"MARGIN-TOP: 40px\" align=center><STRONG>저작권법에 따른 이용자의 권리는 위의 내용에 의하여 \n");
        sb.append("영향을 받지 않습니다.</STRONG></P>\n");
        sb.append("<P align=center>이것은 <A class=fulltext \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-sa/2.0/kr/legalcode\">이용허락규약(Legal \n");
        sb.append("Code)</A>을 이해하기 쉽게 요약한 것입니다. </P>\n");
        sb.append("<DIV align=center><A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc-sa/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-sa/2.0/kr\">Disclaimer</A> \n");
        sb.append("<A \n");
        sb.append("onclick=\"window.open('http://creativecommons.org/licenses/by-nc-sa/2.0/kr', 'characteristic_help', 'width=375,height=300,scrollbars=yes,resizable=yes,toolbar=no,directories=no,location=yes,menubar=no,status=yes');return false;\" \n");
        sb.append("href=\"http://creativecommons.org/licenses/by-nc-sa/2.0/kr\"><IMG \n");
        sb.append("height=13 alt=disclaimer src=\""+imgPath+"/popup.gif\" \n");
        sb.append("width=15 border=0></A></DIV>");
		sb.append("<DIV align=center>   ");
		sb.append("  <br>               ");
		sb.append("&nbsp;</DIV>         ");
		sb.append("  </DIV></DIV></DIV> ");
		sb.append("<p>                  ");
		sb.append("<img border=0 src=\""+imgPath+"/dcollection_logo.gif\" width=144 height=43></p><P></P>");
		sb.append("</BODY></HTML>");
        
        return sb.toString();
    }
}

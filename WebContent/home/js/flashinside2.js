function Flash2(id,url,w,h,bg,t,sc){
	document.writeln("<object classid='clsid:d27cdb6e-ae6d-11cf-96b8-444553540000' codebase='http://fpdownload.macromedia.com/pub/shockwave/cabs/flash/swflash.cab#version=8,0,0,0' width="+w+" height="+h+" id="+id+">");
	document.writeln("<param name='movie' value="+url+" />");
	document.writeln("<param name='wmode' value="+t+" />");
	document.writeln("<param name='bgcolor' value="+bg+" />");
	document.writeln("<param name='allowScriptAccess' value='always' />");
	document.writeln("<param name='quality' value='high' />");
	document.writeln("<param name='scale' value="+sc+" />");
	document.writeln("<param name='menu' value='false' />");
	document.writeln("<embed src="+url+" wmode="+t+" scale="+sc+" width="+w+" height="+h+" name="+id+" bgcolor="+bg+" allowScriptAccess='always' quality='high' type='application/x-shockwave-flash' pluginspage='http://www.macromedia.com/go/getflashplayer' />");
	document.writeln("</object>");
}

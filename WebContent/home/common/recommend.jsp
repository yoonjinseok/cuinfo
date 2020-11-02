<script type="text/javascript">
	jQuery.post('/home/recommendLink.ajax.action',
						{menuId:<%=gnb%>},
						function(data){
							$("#link_recomm").html(data);
	});

</script>
<div class="link_box" id="link_box">
<div class="link_recomm" id="link_recomm"></div>
</div>
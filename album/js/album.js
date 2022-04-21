var triggerFlag = false;

$(window).on('scroll load', function loadNext() {
	var contextPath = $("#contextPath").val();
	var documentHeight = $(document).height();
	var scrollBottomPosition = $(window).height() + $(window).scrollTop();
	var triggerPoint = documentHeight - scrollBottomPosition;
	
	if (!triggerFlag && triggerPoint <= 0) {
		triggerFlag = true;
		$.ajax({
			type : "GET",
			scriptCharset : "UTF-8",
			url : contextPath + "/album",
			dataType : "json",
			data : {offset : $("#offset").val()}
		}).done(function (result) {
			var count = $("#offset").val();
			var album = result.album;
			$.each(album, function(i) {
				$(".album").append("<a href=\"/album/detail?imageid=" + album[i].imageid + "\"><img src=\"" + album[i].imagepath + "\"></a>");
				count++;
			});
			$("#offset").val(count);
		}).fail(function () {
			alert("failed");
		}).always(function (result) {
			console.log("aaa");
		});
	}
	if (triggerPoint > 0) {
		triggerFlag = false;
	}
});
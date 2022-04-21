$("#image").on("change", function(event) {
	var reader = new FileReader();
	reader.onload = function(event) {
		$("#preview").attr("src", event.target.result);
	}
	reader.readAsDataURL(event.target.files[0]);
});

$("#preview").on("dragover", function(event) {
	event.preventDefault();
	event.stopPropagation();
});
$("#preview").on("drop", function(event) {
	event.preventDefault();
	event.stopPropagation();
	var reader = new FileReader();
	reader.onload = function(event) {
		$("#preview").attr("src", event.target.result);
	}
	reader.readAsDataURL(event.originalEvent.dataTransfer.files[0]);
	$("#image")[0].files = event.originalEvent.dataTransfer.files;
});

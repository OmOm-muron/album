var deleteButton = document.getElementById("delete-confirm");
var cancelButton = document.getElementById("cancel-button");
var dialog = document.getElementById("dialog");

deleteButton.addEventListener('click', function() {
	dialog.showModal();
});
cancelButton.addEventListener('click', function() {
	dialog.close();
});

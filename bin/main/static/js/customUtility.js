function fileProcess(input) {
	// 파일 확장자 검사
	const allowExt = ["png", "jpg", "jpeg", "svg"];
	let fileLength = input.value.length;
	let fileDot = input.value.lastIndexOf(".");
	let fileType = input.value.substring(fileDot+1, fileLength).toLowerCase();
	if(!allowExt.includes(fileType)) {
		alert("허용되지 않는 확장자입니다.");
		$("#file").val('');
		document.getElementById('preview').src = "/space/default.png";
		return false;
	}
	
	// 파일 사이즈 5MB 제한
	let maxSize = 5 * 1024 * 1024;
	let fileSize = input.files[0].size;
	if(fileSize > maxSize) {
		alert("업로드 용량제한 : 5MB");
		input.val('');
		return false;
	}

	// preview 이미지 띄우기
	if(input.files && input.files[0]) {
		let reader = new FileReader();
		reader.onload = function(e) {
			document.getElementById('preview').src = e.target.result;
		};
		reader.readAsDataURL(input.files[0]);
	} else {
		document.getElementById('preview').src = "/space/default.png";
	}
}
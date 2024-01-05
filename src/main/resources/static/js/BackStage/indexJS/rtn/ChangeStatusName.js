function changeStatusName(keyValue){
	
	switch (keyValue){
		case "0":
			keyValue = "待確認";
			return keyValue;
			break;
		case "1":
			keyValue = "待退款";
			return keyValue;
			break;
		case "2":
			keyValue = "完成";
			return keyValue;
			break;	
	}
}

window.addEventListener("DOMContentLoaded" , function(){
	const StatusValueList = document.querySelectorAll(".RtnStatus");
	
	for(let i = 0 ; i < StatusValueList.length ; i++ ){
		StatusValueList[i].innerText = changeStatusName(StatusValueList[i].innerText);
	}
	
	
	
})


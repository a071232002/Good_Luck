function changeStatusName(keyValue){
	switch (keyValue){
		case 0:
			keyValue = "待確認";
			return keyValue;
			break;
		case 1:
			keyValue = "待退款";
			return keyValue;
			break;
		case 2:
			keyValue = "完成";
			return keyValue;
			break;	
	}
}

changeStatusName(keyValue);
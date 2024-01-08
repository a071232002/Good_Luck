function QueryButtonEven() {

	let selectedReason = document.getElementById("Query-btn").value;

	let xhr = new XMLHttpRequest();
	xhr.open("GET", "/Rtns?rtnCateGory=" + selectedReason, true);

	xhr.onreadystatechange = function() {
		if (xhr.readyState == 4 && xhr.status == 200) {

			let responseData = JSON.parse(xhr.responseText);
			updateTable(responseData);

			console.log(responseData);
		}
	};

	xhr.send();
}


function updateTable(data) {
	let tbody = document.querySelector("tbody");


	tbody.innerHTML = "";
	

	data.forEach(function(rtn) {
		let newRow = tbody.insertRow();

	const countTotal = 8;
	let count = 0;
	
		for (let key in rtn) {
			let cell = newRow.insertCell();
			cell.className = "Rtn-Table-td";
			let keyValue = rtn[key];
			
			
//			待order model
			if (count == 2){
//				let cell2 = newRow.insertCell();
//				cell.className = "Rtn-Table-td";
//				cell.innerText = "order model";
				count++;
				
				let cell2 = newRow.insertCell();
				cell2.className = "Rtn-Table-td";
				
				cell2.innerText = keyValue;
				continue;
			}
			
			switch (key) {
				case "rtnNo":
				case "rtnDate":
				case "rtnWhy":
				case "refundAmount":
				
					
					cell.innerText = keyValue;
					
					count++;
					
					break;
				case "empNo":
					cell.innerText = keyValue.empNo;
					
					count++;
					
					break;
				case "orderNo":
					cell.innerText = keyValue.ordNo;
//					cell.innerText = "order model";

					count++;
					
					break;
				case "rtnStatus":	
					cell.innerText = keyValue;
					cell.innerText = changeStatusName(keyValue);
					break;
				case null:
					cell.innerText = "沒有資料";
					break;
			}
		}

		let modifyCell = newRow.insertCell();
		modifyCell.innerHTML = '<button onclick="redirectToModifyPage('
			+ rtn.rtnNo + ')" class="modify-btn">修改</button>';
	});
}

function ChangeStatusName(keyValue){
	
	keyValue = Number(keyValue);
	
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


function CanelButton() {
	window.location.href = '/Rtn';
}

//ChangeStatusName(keyValue);
//CanelButton();
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


		for (let key in rtn) {
			let cell = newRow.insertCell();
			cell.className = "Rtn-Table-td";
			let keyValue = rtn[key];

			switch (key) {
				case "rtnNo":
				case "rtnDate":
				case "rtnWhy":
				case "refundAmount":
				case "rtnStatus":
					cell.innerText = keyValue;
					break;
				case "empNo":
					cell.innerText = keyValue.empNo;
					break;
				case "orderNo":
//					cell.innerText = keyValue.ordNo;
					cell.innerText = "order model";
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
function CanelButton() {
	window.location.href = '/Rtn';
}
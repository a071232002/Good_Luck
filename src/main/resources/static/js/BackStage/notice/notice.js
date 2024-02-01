const database = [
    { "noticeNo": "0001", "empNo": "001", "noticeTime": "2023-01-01 00:00", "noticeContent": "activity", "noticeStatus": 1 },
    { "noticeNo": "0002", "empNo": "001", "noticeTime": "2024-01-01 00:00", "noticeContent": "activity", "noticeStatus": 1 },
    { "noticeNo": "0003", "empNo": "002", "noticeTime": "2023-11-11 00:00:00", "noticeContent": "activity", "noticeStatus": 1 }
];
const jsonData = JSON.stringify(database, null, 2);
console.log(jsonData);

const noticecontent_box = document.querySelector('#noticecontent_box');
const noticestatus_box = document.querySelector('#noticestatus_box');
const noticeNo_box = document.querySelector('#noticeNo_box'); 
const empNo_box = document.querySelector('#empNo_box'); 
const output = document.querySelector('#output');

database.forEach(data => {
    noticecontent_box.innerHTML += `<option value="${data.noticeNo}">${data.noticeContent}</option>`;
    noticeNo_box.innerHTML += `<option value="${data.noticeNo}">${data.noticeNo}</option>`;
    empNo_box.innerHTML += `<option value="${data.empNo}">${data.empNo}</option>`;
});

noticestatus_box.addEventListener('change', () => {
    const selected_status = noticestatus_box.options[noticestatus_box.selectedIndex].value;
    console.log(`Latest notice status: ${selected_status}`);
});

noticeNo_box.addEventListener('change', (event) => {
    const selected_noticeNo = event.target.value;
    const selectedData = database.find(data => data.noticeNo === selected_noticeNo);

    if (selectedData) {
        output.innerHTML = `Notice No: ${selectedData.noticeNo}<br>
                            Employee No: ${selectedData.empNo}<br>
                            Notice Time: ${selectedData.noticeTime}<br>
                            Notice Content: ${selectedData.noticeContent}<br>
                            Notice Status: ${selectedData.noticeStatus}`;
    } else {
        output.innerHTML = 'No information found';
    }
});

empNo_box.addEventListener('change', (event) => {
    const selected_empNo = event.target.value;
    const selectedData = database.filter(data => data.empNo === selected_empNo);

    if (selectedData.length > 0) {
        output.innerHTML = selectedData.map(data => `Notice No: ${data.noticeNo}<br>
                                                   Employee No: ${data.empNo}<br>
                                                   Notice Time: ${data.noticeTime}<br>
                                                   Notice Content: ${data.noticeContent}<br>
                                                   Notice Status: ${data.noticeStatus}`)
                                      .join('<br><br>');
    } else {
        output.innerHTML = 'No information found';
    }
});
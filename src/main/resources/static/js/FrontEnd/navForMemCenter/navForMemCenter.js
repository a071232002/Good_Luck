window.onload = function() {
	connect();
	
	var existingMsgBox = document.querySelector('.messagePopup');
	message.addEventListener("click", function(event) {
		if (existingMsgBox.style.display === 'none') {
			existingMsgBox.style.display = 'block';
		} else {
			existingMsgBox.style.display = 'none';
		}
		event.stopPropagation();
	});

      
    document.addEventListener("click", function() {
        existingMsgBox.style.display = 'none';
    });
	
};


//window.onunload = function() {
//    disconnect();
//};



$(document).ready(function() {
	$('#memBlock').click(function() {
		$('.memBlock').not(this).toggle();
	});
});

$(document).ready(function() {
	$('#lddBlock').click(function() {
		$('.lddBlock').not(this).toggle();
	});
});

var message = document.getElementById("message");
let user = document.getElementById("userId").value;

let MyPoint = `/MsgWS/${user}`;
let host = window.location.host;
let path = window.location.pathname;
let webCtx = path.substring(0, path.indexOf('/', 1));
let endPointURL = "ws://" + window.location.host + MyPoint;
let webSocket;
let messageQueue = [];


let storageSupported = typeof(Storage) !== "undefined";

function connect() {
    if (!user) return;

    webSocket = new WebSocket(endPointURL);

    webSocket.onmessage = async function(event) {

        let msgDTO = JSON.parse(event.data);
        console.log(msgDTO);
        message.style.opacity = 1;

        if (messageQueue.length >= 3) {
            messageQueue.pop();
        }

        messageQueue.unshift(msgDTO);

        updateMessageDisplay();

      	//local儲存
        if (storageSupported) {
            localStorage.setItem('messageQueue', JSON.stringify(messageQueue));
        }
    };

    //local讀取
    if (storageSupported) {
        let storedQueue = localStorage.getItem('messageQueue');
        if (storedQueue) {
            messageQueue = JSON.parse(storedQueue);
            updateMessageDisplay();
        }
    }

    function updateMessageDisplay() {
        var existingMsgBox = document.querySelector('.messagePopup');

        if (!existingMsgBox) {
            existingMsgBox = document.createElement('ul');
            existingMsgBox.className = 'messagePopup';
            existingMsgBox.style.display = 'none';
            existingMsgBox.style.position = 'absolute';
            existingMsgBox.style.top = '100%';
            message.parentNode.appendChild(existingMsgBox);
        }

        existingMsgBox.innerHTML = '';

        messageQueue.forEach(function(msgDTO) {
            let listItem = document.createElement('li');
            let link = document.createElement('a');

            let messageDate = new Date();
            let messageTime = messageDate.toLocaleString();
            
			link.href = msgDTO.link;
			link.textContent= msgDTO.msg + ' ' + messageTime;
			
//            switch (apo.apoStatus) {
//                case 0:
//                    link.href = "/apo/reviewApo";
//                    link.textContent = `物件No:${apo.rent.rentNo}, 有新的預約。 ${messageTime}`;
//                    break;
//                case 9:
//                    link.href = "/apo/reviewApo";
//                    link.textContent = `預約No:${apo.apoNo}, 預約時間變更, 請確認。 ${messageTime}`;
//                    break;
//                case 1:
//                    link.href = "/apo/listAllApo";
//                    link.textContent = `預約No:${apo.apoNo}, 預約已被婉拒。 ${messageTime}`;
//                    break;
//                case 2:
//                    link.href = "/apo/listAllApo";
//                    link.textContent = `預約No:${apo.apoNo}, 通過審核, 請準時赴約。 ${messageTime}`;
//                    break;
//                case 3:
//                    link.href = "/apo/listAllApo";
//                    link.textContent = `預約No:${apo.apoNo}, 看屋完成, 請確認是否要租屋。 ${messageTime}`;
//                    break;
//                default:
//                    break;
//            }

            listItem.appendChild(link);
            existingMsgBox.appendChild(listItem);
        });

//        // 添加点击事件监听器
//        message.addEventListener("click", function(event) {
//            if (existingMsgBox.style.display === 'none') {
//                existingMsgBox.style.display = 'block';
//            } else {
//                existingMsgBox.style.display = 'none';
//            }
//            event.stopPropagation();
//        });
//
//        // 点击页面其他位置时隐藏菜单
//        document.addEventListener("click", function() {
//            existingMsgBox.style.display = 'none';
//        });

    }
}

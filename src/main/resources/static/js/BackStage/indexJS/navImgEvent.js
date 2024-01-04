	document.addEventListener('DOMContentLoaded', function () {
			// 初始化圖片
			updateImageBasedOnActiveNav();

			// 為每個導航項目添加點擊事件監聽器
			document.querySelectorAll('.navbar-nav .nav-item').forEach(item => {
				item.addEventListener('click', function (event) {
					updateImageBasedOnActiveNav();
				});
			});

			// 監聽滾動事件
			window.addEventListener('scroll', function () {
				updateImageBasedOnActiveNav();
			});
		});

		// 更新圖片的函數
		function updateImageBasedOnActiveNav() {
			let img = document.getElementById('nav-img');
			let activeNavItem = document.querySelector('.active');


			switch (activeNavItem.text) {
				case '會員管理':
					img.src = '/icon/BackStage/indexJS/person-solid.svg';
					break;
				case '物件管理':
					img.src = '/icon/BackStage/indexJS/file-pen-solid.svg';
					break;
				case '購物管理':
					img.src = '/icon/BackStage/indexJS/shop-solid.svg';
					break;
				case '公告管理':
					img.src = '/icon/BackStage/indexJS/bell-regular.svg';
					break;
				case '投訴管理':
					img.src = '/icon/BackStage/indexJS/person-harassing-solid.svg';
					break;
				case '後台管理':
					img.src = '/icon/BackStage/indexJS/chalkboard-user-solid.svg';
					break;

				default:
					img.src = '/icon/BackStage/indexJS/person-harassing-solid.svg';
					break;
			}
		}
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
			let path = img.getAttribute('data-active-nav-item-id');

			switch (activeNavItem.text) {
				case '會員管理':
					img.src = path + '/person-solid.svg';
					break;
				case '物件管理':
					img.src = path + '/file-pen-solid.svg';
					break;
				case '購物管理':
					img.src = path + '/shop-solid.svg';
					break;
				case '公告管理':
					img.src = path + '/bell-regular.svg';
					break;
				case '投訴管理':
					img.src = path + '/person-harassing-solid.svg';
					break;
				case '後台管理':
					img.src = path + '/chalkboard-user-solid.svg';
					break;

				default:
					img.src =  path + '/person-harassing-solid.svg';
					break;
			}
		}
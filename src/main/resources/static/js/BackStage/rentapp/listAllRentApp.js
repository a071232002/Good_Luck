/**
 * 
 */
// 獲取圖片元素和放大顯示容器元素
    var images = document.querySelectorAll('.myImage');
    var lightbox = document.getElementById('lightbox');
    var lightboxImg = document.getElementById('lightbox-img');

    // 點擊圖片時顯示放大顯示的容器和圖片
     images.forEach(function (img) {
        // 點擊圖片時顯示放大顯示的容器和圖片
        img.onclick = function () {
            lightbox.style.display = 'flex'; // 使容器可見
            lightboxImg.src = this.src; // 設置放大顯示的圖片
        };
    });

    // 點擊放大顯示的容器時隱藏容器
    lightbox.onclick = function () {
        lightbox.style.display = 'none'; // 隱藏容器
    };
    
    // 阻止點擊放大顯示的圖片時隱藏容器
	lightboxImg.onclick = function (event) {
	    event.stopPropagation(); // 阻止事件冒泡
	};
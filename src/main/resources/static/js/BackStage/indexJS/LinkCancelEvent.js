document.addEventListener('DOMContentLoaded', function() {
	let links = document.querySelectorAll('.subA');

	// 為每個<a>元素添加事件監聽器
	links.forEach(function(link) {
		link.addEventListener('click', function(event) {
			// 如果這個<a>元素沒有'class="linkOk"'，則取消預設行為
			if (!this.classList.contains('linkOk')) {
				event.preventDefault();
			}
			// 如果有'class="linkOk"'，則不阻止預設行為，什麼也不做
		});
	});
});
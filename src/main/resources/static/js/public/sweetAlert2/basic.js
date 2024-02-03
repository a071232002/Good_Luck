function showConfirmation(element) {
    Swal.fire({
        title: '確定送出？',
        icon: 'warning',
        showCancelButton: true,
        confirmButtonText: '确定',
        cancelButtonText: '取消'
    }).then((result) => {
        if (result.isConfirmed) {
            Swal.fire('送出', '', 'success');
            setTimeout(() => {
                // 使用 element.form 來獲取包含當前按鈕的表單元素
                element.submit();
            }, 300);
        }
    });

    return false;
}
function showConfirmation() {

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
            document.forms[0].submit();
            }, 1000);
        }
    });
    

    return false;
}
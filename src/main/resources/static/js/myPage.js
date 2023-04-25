document.addEventListener('DOMContentLoaded', function() {
    const box = document.querySelector('#delete');

    box.addEventListener("click", function(e){
        if(!confirm('정말로 아이디를 삭제하시겠습니까?(삭제된 아이디는 복구하기 힘듭니다)')){
            e.preventDefault();
            alert("취소 되었습니다");
        }
        else{
            alert("삭제 되었습니다.");
        }

    });
});

document.addEventListener('DOMContentLoaded', function(){
    const fileInput = document.getElementById('Profile_image');
    fileInput.addEventListener('change', handleFileSelect, false);

    function handleFileSelect(e) {
        const file = e.target.files[0];
        const formData = new FormData();
        formData.append('file', file);

        const xhr = new XMLHttpRequest();
        xhr.open('POST', '/uploadProfileImg');
        xhr.send(formData);
        xhr.onload = function() {
            if (xhr.status === 200) {
                const previewUrl = xhr.responseText;
                const previewImg = document.getElementById('file_img');
                previewImg.src = previewUrl;
            } else {
                alert('서버 에러가 발생했습니다.');
            }
        };
    }
});




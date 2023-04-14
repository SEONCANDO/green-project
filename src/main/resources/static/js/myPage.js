document.addEventListener('DOMContentLoaded', function() {
    const box = document.querySelector('#delete');

    box.addEventListener("click", function(e){
        if(!confirm('정말로 아이디를 삭제하시겠습니까?(삭제된 아이디는 복구하기 힘듭니다)')){
            e.defaultPrevented;
            alert("취소 되었습니다");
            history.back();
        }
        else{
            alert("삭제 되었습니다.");
        }

    });
});
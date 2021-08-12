$('.success').hide();
$('.flase').hide();
$('.pw2-in').keyup(function () {
     var pwd = $("#pw").val();
     var pwd2 =$("#pw2").val();
     if(pwd != "" || pwd2 != ""){
          if(pwd==pwd2){
               $(".success").show();
               $(".flase").hide();
               $("#submit").attr("disabled", false);

          }
          else{
               $(".success").hide();
               $(".flase").show();
               $("#submit").attr("disabled", true);

          }
     }

});

$(".int").keypress(function (e) {
     if(e.which && (e.which <=47 || e.which >=58) && e.which != 8){
          e.preventDefault();
     }

});

//회원가입시, ajax를 통한 put 요청 테스트

let index = {
  init: function(){
    $("#submit").on("click", ()=>{
      this.save();
    });
  },
  save: function(){

    let data = {
      username: $("#id").val(),
      password: $("#pw").val(),
      name: $("#name").val(),
      birth: $("#yy").val()+$("#mm").val()+$("#dd").val(),
      email: $("#email").val()
    };

    //console.log(data);
    
    
    //ajax호출시 default가 비동기 호출
    $.ajax({
		type: "POST",
		url: "/auth/joinProc",
		data: JSON.stringify(data), // http body데이터
		contentType: "application/json; charset = utf-8", // body데이터 타입(MIME)
		dataType: "json" // 응답이 왔을 때 기본적으로 모든것이 string (생긴게 json이라면 => js오브젝트로 변경해 줌)		
	}).done(function(resp){
		alert("회원가입이 완료되었습니다.");
		location.href = "/";
	}).fail(function(error){
		alert(JSON.stringify(error));
	}); //ajax 통신을 이용해서 5개의 데이터를 json으로 변경하여 insert 요청
  }
}

index.init();

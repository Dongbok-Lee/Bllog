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
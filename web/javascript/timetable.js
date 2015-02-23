$(function(){
  $("table").click(function(){
    
    $("jsp").toggleClass( $(this).attr("class") );
    window.location.href='table.jsp';
    
  });
});


window.addEventListener("load",function(){
    var section = this.document.querySelector("#category");
    var dl = section.querySelector("dl")
    var add = section.querySelector("input[type=submit]");
    var name = section.querySelector("input[type=text]");

    add.onclick=function(){
        alert(" 왜?");
        var name1 = name.Value;

        var request = new XMLHttpRequest();
        request.open("GET","/view/admin/category-ajax",false);
        request.send();

        var json = JSON.parse(request.responseText);
        var tempate = section.querySelector(".list-template");

        dl.innerHTML="";
        var key = Object.keys(json[0]);
      
        for(var i = 0; i<json.lenth;i++){
            var 
        }

    };



});
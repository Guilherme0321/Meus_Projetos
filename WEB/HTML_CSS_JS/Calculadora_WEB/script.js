function math(){
    const n1 = document.querySelector("#P1");
    const n2 = document.querySelector("#P2");
    const v1 = n1.value;
    const v2 = n2.value;
    if(document.querySelector("#mais").checked==true){
        document.querySelector("body > label:nth-child(2)").innerHTML = "Digite um número";
        document.querySelector("body > label:nth-child(4)").innerHTML = "Digite outro número";
        var s = Number(v1) + Number(v2);
        document.querySelector("#text").innerHTML = `A soma de ${v1} + ${v2} = ${s}`;
    } else if(document.querySelector("#menos").checked==true){
        document.querySelector("body > label:nth-child(2)").innerHTML = "Digite um número";
        document.querySelector("body > label:nth-child(4)").innerHTML = "Digite outro número";
        var s = Number(v1) - Number(v2);
        document.querySelector("#text").innerHTML = `A subtração de ${v1} - ${v2} = ${s}`;
    } else if(document.querySelector("#mult").checked==true){
        document.querySelector("body > label:nth-child(2)").innerHTML = "Digite um número";
        document.querySelector("body > label:nth-child(4)").innerHTML = "Digite outro número";
        var s = Number(v1) * Number(v2);
        document.querySelector("#text").innerHTML = `A multiplicação de ${v1} x ${v2} = ${s}`;
    } else if(document.querySelector("#divid").checked==true){
        document.querySelector("body > label:nth-child(2)").innerHTML = "Digite um número";
        document.querySelector("body > label:nth-child(4)").innerHTML = "Digite outro número";
        var s = Number(v1) / Number(v2);
        document.querySelector("#text").innerHTML = `A divisão de ${v1} ÷ ${v2} = ${s}`;
    } else if(document.querySelector("#per100").checked==true){
        document.querySelector("body > label:nth-child(2)").innerHTML = '\0';
        document.querySelector("body > label:nth-child(4)").innerHTML = "% de";
        var s = (Number(v1) * Number(v2))/100;
        document.querySelector("#text").innerHTML = `${v1}% de ${v2} = ${s}`;
    } else{
        document.querySelector("#text").innerHTML = "Você não selecionou o operador";
    }
  }
  
let i = 0;
document.querySelectorAll("nav > ul > li > a").forEach(x => {
    x.setAttribute('onclick',`focar(${i})`);
    i++;
})
function focar(x) {
    let a = document.querySelectorAll("nav > ul > li > a").length; 
    document.querySelectorAll("nav > ul > li > a")[x].classList.add('a');;
    for(let j = 0; j < a; j++){
        if(j != x){
            if(document.querySelectorAll("nav > ul > li > a")[j].classList.contains('a')){
                document.querySelectorAll("nav > ul > li > a")[j].classList.remove('a');
            }
        
        }
    }
}
async function postar(Cadastro){
    const response = await fetch('http://localhost:5000/logins', {
        method:'POST',
        headers:{
            'content-Type': 'application/json'
        },
        body: JSON.stringify(Cadastro)
    });
    const resposta = await response.json();
    console.log(resposta);
}
document.querySelector("#form").addEventListener('submit', () => {
    let nome = document.querySelector("#input-name").value;
    let email = document.querySelector("#input-email").value;
    let senha = document.querySelector("#input-senha").value;
    let data = document.querySelector("#input-date").value;
    var Cadastro = {
        nome: nome,
        email: email,
        senha: senha,
        data: data
    }
    postar(Cadastro);
});

document.querySelector("#submit-login").addEventListener('click',async (e) => {
    e.preventDefault()
    let Email = document.querySelector("#login-email").value;
    let password = document.querySelector("#login-senha").value;

    const response = await fetch('http://localhost:5000/logins');
    const resposta = await response.json();
    let existe = false;
    resposta.forEach(e => {
        if(e.email === Email && e.senha === password){
            existe = true;
        }
    });
    if(existe){
        localStorage.setItem('acesso','liberado');
        console.log('liberado');
    }else{
        localStorage.setItem('acesso','negado');
        console.log('negado');
    }
});

document.querySelector("#cad").addEventListener('click', () =>{
    const cad = document.querySelector("#fundo-cadastro");
    const log = document.querySelector("#fundo-do-login");
    if(!cad.classList.contains('fundo-cadastro' && !log.classList.contains('fundo-do-login'))){
        if(cad.classList.contains('fundo-do-login') && log.classList.contains('fundo-cadastro')){
            cad.classList.remove('fundo-do-login');
            log.classList.remove('fundo-cadastro');
        }
        cad.classList.add('fundo-cadastro');
        log.classList.add('fundo-do-login');
        log.classList.remove('ativada')
    }
});

document.querySelector("#log").addEventListener('click', () =>{
    const cad = document.querySelector("#fundo-cadastro");
    const log = document.querySelector("#fundo-do-login");
    if(!cad.classList.contains('fundo-cadastro' && !log.classList.contains('fundo-do-login'))){
       if(!log.classList.contains('ativada')){
        log.classList.remove('fundo-do-login');
        cad.classList.remove('fundo-cadastro');
        log.classList.add('fundo-cadastro');
        cad.classList.add('fundo-do-login');
    }
    }
})
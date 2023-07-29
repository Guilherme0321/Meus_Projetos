import './App.css';
import React,{useState,useEffect} from 'react';
import Nav from './components/nav.js';
import Title from './components/title.js'
import Scene from './components/Projetos.js'
function App() {
  const [Tela,setTela] = useState(0);
   
  useEffect(
    () => {
      const url = window.location.href;
      let res = [];
      if(url.includes('?')){
        res = url.split('?')[1];
      }else{
        res = ['',''];
      }
      setTela(res)
      console.log();
    }
  )

  if(Tela == "Projetos"){
    return(
      <>
        <Scene />
      </>
    )
  }else{
    return (
      <header className="Home">
        <Nav />
        <section className="section">
          <Title />
        </section>
      </header>
    );
  }
}

export default App;

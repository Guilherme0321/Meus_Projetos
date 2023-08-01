import Nav from './nav';
import Data from './Projetos.json';
import ProjectStructure from './projectsName';
import './Projeto.css';
import { useEffect, useState } from 'react';

function Projetos() {
  const [projeto, setProjeto] = useState('');
  const [projects, setProjects] = useState([]);

  useEffect(() => {
    const url = window.location.href;
    const res = url.includes('&') ? url.split('&')[1] : '';
    setProjeto(res);
    const array = Object.keys(Data.projetos);
    setProjects(array);
  }, []);

  const openWindow = (nome) => {
    window.open(`http://localhost:3000?Projetos&${nome}`, "_self");
  };

  if (projeto === 'web') {
    return (
      <>
        <Nav />
        <section className='projects'>
          {Object.keys(Data.projetos[projeto].info).map((key) => (
            <div className='Project'>
              <div className='items'>
                <div className='imagemProjeto'>
                  <img className='imgProjetos' src={Data.projetos[projeto].info[key].image} alt='img'/>
                </div>
                <div className='infoProjeto'>
                  <h1 className='nomeProjeto'>{key.toUpperCase()}</h1>
                </div>
              </div>
            </div>
          ))}
        </section>
      </>
    );
  }
  else if(projects.includes(projeto)){
    return (
      <>
          <ProjectStructure chave={projeto}/>
      </>
    )
  }
  
  else{
    return (
      <>
        <Nav />
        <section className='projects'>
          {Object.keys(Data.projetos).map((chave) => (
            <div className='Project' onClick={() => { openWindow(chave) }}>
              <div className='items'>
                <div className='imagemProjeto'>
                  <img className='imgProjetos' src={Data.projetos[chave].image} alt={chave} />
                </div>
                <div className='infoProjeto'>
                  <h1 className='nomeProjeto'>{chave.toLocaleUpperCase()}</h1>
                </div>
              </div>
            </div>
          ))}
        </section>
      </>
    );
  }
}

export default Projetos;

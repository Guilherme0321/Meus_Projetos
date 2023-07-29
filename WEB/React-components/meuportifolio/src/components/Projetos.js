import Nav from './nav';
import Data from './Projetos.json';
import './Projeto.css'
function Projetos(){
    
    return(
        <>
            <Nav />
            <section className='projects'>
                {Object.keys(Data.projetos).map((chave) => (
                    <div className='Project'>
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
    )
}
export default Projetos;
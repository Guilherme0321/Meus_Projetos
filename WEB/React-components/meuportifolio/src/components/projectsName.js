import Nav from "./nav"
import Data from './Projetos.json'
function ProjectStructure(props){
    return(
        <>
            <Nav />
            <section className='projects'>
                {Object.values(Data.projetos[props.chave].info).map((key) => (
                <div className='Project'>
                    <div className='items'>
                    <div className='imagemProjeto'>
                        <img className='imgProjetos' src={key.image} alt='img'/>
                    </div>
                    <div className='infoProjeto'>
                        <h1 className='nomeProjeto'>{key.nome}</h1>
                        <a href={key.repositorio} className='rep'>Repositorio</a>
                    </div>
                    </div>
                </div>
                ))}
            </section>
        </>
    )
}

export default ProjectStructure;
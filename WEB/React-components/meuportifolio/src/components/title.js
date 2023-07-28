import Whats from './Images/logo-whatsappCyan.svg'
import WhatsBlack from './Images/logo-whatsapp.svg'
import Linkedin from './Images/logo-linkedinCyan.svg'
import LinkdBlack from './Images/logo-linkedin.svg'
import Github from './Images/logo-githubCyan.svg'
import GitBlack from './Images/logo-github.svg'
function title(){
    return(
        <header className="titleDIV">
            <div className="firstPart">
                <div className="introduce">
                    <h3 className="titulo inicio">Olá, eu sou</h3>
                    <h1 className="titulo nome">Guilherme Oliveira</h1>
                    <h3 className="titulo aboutMe">E sou um <a href="#" className="area"> Estudante de ciências da computação</a></h3>
                </div>
                <div className="paragrafo">
                    <p className="texto">Sou estudante de ciências da computação, e essa é minha primeira tentativa de fazer um portifolio com React.js</p>
                </div>
                <div className="icons">
                    <div className="icon">
                        <a className="cyan" href="#" target="_blank" rel="noopener noreferrer">
                            <img className="cyan" width="30px" src={Whats} alt="Whats" />
                        </a>
                        <a className="black" href="#" target="_blank" rel="noopener noreferrer">
                            <img className="black" width="30px" src={WhatsBlack} alt="Whats_black" />
                        </a>
                    </div>
                    <div className="icon">
                        <a className="cyan" href="https://www.linkedin.com/in/guilherme-oliveira-b79171275/" target="_blank" rel="noopener noreferrer">
                            <img className="cyan" width="30px" src={Linkedin} alt="Linkedin" />
                        </a>
                        <a className="black" href="https://www.linkedin.com/in/guilherme-oliveira-b79171275/" target="_blank" rel="noopener noreferrer">
                            <img className="black" width="30px" src={LinkdBlack} alt="Linkedin Black" />
                        </a>
                    </div>
                    <div className="icon">
                        <a className="cyan" href="https://github.com/Guilherme0321" target="_blank" rel="noopener noreferrer">
                            <img className="cyan" width="30px" src={Github} alt="GitHub" />
                        </a>
                        <a className="black" href="https://github.com/Guilherme0321" target="_blank" rel="noopener noreferrer">
                            <img className="black" width="30px" src={GitBlack} alt="Git Black" />
                        </a>
                    </div>
                </div>  
            </div>
            <div className="imagePart">
                <div className="background-image">
                </div>
            </div>
        </header>
    );
}
export default title;
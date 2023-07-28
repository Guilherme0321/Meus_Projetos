import Menu from './Images/menu.svg'
import Close from './Images/close.svg'
function nav(){

    const mudar = () => {
        let menuRes = document.querySelector('.HideListM');
        if(menuRes.classList.contains('height')){
            menuRes.classList.remove('height');
        }else{
            menuRes.classList.add('height');
        }
    };

    return(
        <nav className="nav-bar">
            <ul CLass="lista">
                <li className="listItem"><a href="#" className="textPrincipal">Portifolio</a></li>
                <input onChange={mudar} type="checkbox" className="checkbox" id="checkbox" />
                <label htmlFor="checkbox" className="checkboxIcon">
                    <img src={Menu} width="40px" className="menu" alt="Menu" />
                    <img src={Close} width="40px" className="close" alt="Menu" />
                </label>
            </ul>
            <div className="HideListM" >
                <ul className="listaN">
                    <li className="listItem"><a href="#" className="text">Sobre</a></li>
                    <li className="listItem"><a href="#" className="text">Home</a></li>
                    <li className="listItem"><a href="#" className="text">Skills</a></li>
                </ul>
            </div>
            <ul className="listaM">
                <li className="listItem"><a href="#" className="text">Sobre</a></li>
                <li className="listItem"><a href="#" className="text">Home</a></li>
                <li className="listItem"><a href="#" className="text">Skills</a></li>
            </ul>
        </nav>
    )
}
export default nav;
import './App.css';
import Nav from './components/nav.js';
import Title from './components/title.js'
function App() {
  return (
    <header className="Home">
      <Nav />
      <section className="section">
        <Title />
      </section>
    </header>
  );
}

export default App;

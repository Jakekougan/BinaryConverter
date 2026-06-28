import logo from './logo.svg';
import './App.css';

function App() {
  return (
    <div className="BinaryConvert">
      <header className="Binary-Converter">
        <img src={logo} className="App-logo" alt="logo" />
      </header>
      <body>
        <div>
          <input type="text"></input>
        </div>
        <div>
          <button>Submit</button>
        </div>
      </body>
    </div>
  );
}

export default App;

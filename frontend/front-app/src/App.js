import logo from './logo.svg';
import './App.css';
import UserList from "./components/user-list/UserList";
import Increment from "./components/incr-test/Increment"

function App() {
  return (
    <div className="App">
        <Increment/>
      <UserList/>
      { /*<header className="App-header">
        <img src={logo} className="App-logo" alt="logo" />
        <p>
          Edit <code>src/App.js</code> and save to reload.
        </p>
        <a
          className="App-link"
          href="https://reactjs.org"
          target="_blank"
          rel="noopener noreferrer"
        >
          Learn React
        </a>
      </header>*/}
    </div>
  );
}

export default App;

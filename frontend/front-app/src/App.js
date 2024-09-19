import UserList from "./components/user/user-list/UserList";
import ProductList from "./components/product/product-list/ProductList";
import ProductSave from "./components/product/product-save/ProductSave";
import Login from "./components/login/Login";
import {BrowserRouter, Routes, Route, Navigate} from "react-router-dom";
import Catalog from "./components/catalog/Catalog";

function App() {
    return (
        <div className="App">
            <BrowserRouter>
                <Routes>
                    <Route path="/" element={<Login/>}/>
                    <Route path="/users" element={<UserList/>}/>
                    <Route path="/productSave" element={<ProductSave/>}/>
                    <Route path="/catalog" element={<ProductList/>}/>
                    <Route path="/prod-catalog" element={<Catalog/>}/>
                </Routes>
            </BrowserRouter>


            {

                /*<header className="App-header">
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
      </header>*/
            }
        </div>
    );
}

export default App;

import "./ProductList.css";
import ProductItem from "../product-item/ProductItem"
import {useState, useEffect} from 'react';
import {HttpService} from '../../../services/HttpService';

export default function ProductList() {

    const [products, setProducts] = useState([]);
    const [errorMessage, setErrorMessage] = useState('');
    const httpService = new HttpService();

    function getProducts() {
        httpService.doGet("product/all"
            , data => setProducts(data)
            , data => setErrorMessage(data)
            , false)
    }

    useEffect(() => getProducts(),
        [])

    return (
        <div id="prod-container">
            {products.map(elem =>
                <ProductItem product={elem}/>)}
            <p>{errorMessage}</p>
        </div>
    );
}

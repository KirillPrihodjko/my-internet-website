import "./ProductList.css";
import ProductItem from "../product-item/ProductItem"
import {useState, useEffect} from 'react';
import {HttpService} from '../../../services/HttpService';

export default function ProductList(props) {

    const {products} = props;
    const [errorMessage, setErrorMessage] = useState('');
    const httpService = new HttpService();

    return (
        <div id="prod-container">
            {products.map(elem =>
                <ProductItem product={elem}/>)}
            <p>{errorMessage}</p>
        </div>
    );
}

import "./Catalog.css"
import CategoryList from "../category/category-list/CategoryList";
import ProductFilterList from "../product/product-list/ProductFilterList";
import {useEffect, useState} from 'react';
import {HttpService} from "../../services/HttpService";

export default function Catalog() {

    const [chooseCategory, setChooseCategory] = useState(null);
    const [products, setProducts] = useState([]);
    const [allCategories, setAllCategories] = useState([]);
    const httpService = new HttpService();

    function getProducts() {
        let url = chooseCategory ? "getByCategory/" + chooseCategory : "all";

        httpService.doGet("product/" + url
            , data => setProducts(data)
            , data => console.log(data)
            , false)
    }

    function getCategories() {
        httpService.doGet("product/allCategories"
            , data => setAllCategories(data)
            , data => console.log(data)
            , false)
    }

    useEffect(() => getCategories(),
        [])

    useEffect(() => getProducts(),
        [chooseCategory])

    return (
        <div id="catalog">
            <CategoryList categories={allCategories} clickHandler={setChooseCategory}/>
            <ProductFilterList products={products}/>
        </div>
    )
}

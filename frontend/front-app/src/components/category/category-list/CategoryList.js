import CategoryItem from "../category-item/CategoryItem"
import {useState, useEffect} from 'react';
import {HttpService} from '../../../services/HttpService';

export default function CategoryList(props) {

    const [errorMessage, setErrorMessage] = useState('');
    const httpService = new HttpService();
    // function which call after click on category
    const {categories, clickHandler} = props;

    return (
        <ul id="category-container">
            {categories.map(elem =>
                <CategoryItem category={elem} clickHandler={clickHandler}/>)}
            <p>{errorMessage}</p>
        </ul>
    );
}

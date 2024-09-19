import "./CategoryItem.css"

export default function ProductItem(props) {
    const {category, clickHandler} = props;


    return (
        <li className="category" onClick={() => clickHandler(category.id)}>
            {category.categoryName}
        </li>
    );
}

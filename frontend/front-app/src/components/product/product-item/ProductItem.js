import "./ProductItem.css"

export default function ProductItem(props) {
    const {product} = props;
    const formatter = new Intl.NumberFormat('en-US', {
        style: 'currency',
        currency: 'EUR',
    });

    return (
        <div className="card">
            <p>{product.id}</p>
            <h3>{product.name}</h3>
            <img src={"data:image/png;base64," + product.images[0].byteContent}/>
            <p>{formatter.format(product.price)}</p>
        </div>
    );
}

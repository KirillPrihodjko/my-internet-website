import {HttpService} from '../../../services/HttpService';
import {useState, useEffect} from 'react';

const ProductSave = () => {
    const [name, setName] = useState('');
    const [price, setPrice] = useState('');
    const [chooseCategory, setChooseCategory] = useState('');
    const [allCategories, setAllCategories] = useState([]);
    const [file, setFile] = useState(null);

    const httpService = new HttpService();

    const save = (event) => {
        event.preventDefault();


        let requestBody = {
            name: name
            , price: price
            , productCategory: {id: Number(chooseCategory)}
            , images: [file]
        };

        console.log(requestBody);

        httpService.doPost('/product/create',
            requestBody
            , data => {
                //localStorage.setItem("token", "Bearer " + data);
                //navigate('/users');//redirect
                console.log(data)
            }
            , data => console.log(data),
            false
            , "text");
    }

    function getCategories() {
        httpService.doGet("product/allCategories"
            , data => setAllCategories(data)
            , data => console.log(data)
            , false)
    }

    function base64ToArrayBuffer(base64) {

        const binaryString = atob(decodeURIComponent(base64));
        const bytes = [];

        for (let i = 0; i < binaryString.length; i++) {
            bytes[i] = binaryString.charCodeAt(i);
        }
        return bytes;
    }

    useEffect(() => getCategories(), []);

    const handleFileChange = (event) => {
        const uploadedFile = event.target.files[0]; // Получаем выбранный файл

        if (uploadedFile) {
            const reader = new FileReader();
            reader.readAsDataURL(uploadedFile);

            reader.onload = () => {
                //console.log(reader.result.toString());
                let encoded = reader.result.toString().replace(/^data:(.*,)?/, '');

                if ((encoded.length % 4) > 0) {
                    encoded += '='.repeat(4 - (encoded.length % 4));
                }
                // Создаем объект файла с именем, типом и содержимым в формате BigInt64Array
                const fileObj = {
                    name: uploadedFile.name,
                    type: uploadedFile.type,
                    byteContent: base64ToArrayBuffer(encoded),
                };
                setFile(fileObj); // Сохраняем объект файла в состояние
            };
            // reader.readAsArrayBuffer(uploadedFile); // Читаем файл как ArrayBuffer
        }
    };

    return (
        <div>
            <form>
                <label>Name</label><input type="text" onChange={(event => setName(event.target.value))}/>
                <label>Price</label><input type="number" onChange={(event => setPrice(event.target.value))}/>
                <label>Category</label><select onChange={(event => setChooseCategory(event.target.value))}>
                {allCategories.map(category => <option value={category.id}>{category.categoryName}</option>)}

            </select>
                <input type="file" onChange={handleFileChange}/>
                {file && (
                    <div>
                        <p>Файл загружен, размер: {file.byteContent.length} байт</p>
                    </div>
                )}

                <input type="submit" onClick={(e) => save(e)}/>
            </form>
        </div>
    )

}
export default ProductSave;

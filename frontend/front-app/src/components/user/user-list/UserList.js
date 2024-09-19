import UserItem from "../user-item/UserItem"
import {useState, useEffect} from 'react';
import {HttpService} from '../../../services/HttpService';

export default function UserList() {

    const [users, setUsers] = useState([]);
    const [errorMessage, setErrorMessage] = useState('');
    const httpServise = new HttpService();

    function getUsers() {
        httpServise.doGet("users/all"
            , data => setUsers(data)
            , data => setErrorMessage(data)
            , true)
        /*fetch('http://localhost:8080/users/all')
            .then(response=>response.json())
            .then(data=>setUsers(data));*/
    }

    useEffect(() => getUsers(),
        [])/*elements which call useEffect
        при пустом массиве вызовется 1 раз при загрузке страницы/)//do after render


   // const users=[{name:"Vasya",age:18},{name:"Vanya",age:23}];
    //<tr><td>Vasya</td><td>18</td></tr>
   /* return (<table>
        {users.map(user=>
            <tr>
                <td>{user.name}</td>
                <td>{user.age}</td>
            </tr>)}
    </table>);*/
    return (
        <div>
            <table>
                {users.map(elem =>
                    <UserItem user={elem}/>)}
            </table>
            <p>{errorMessage}</p>
        </div>
    );
}

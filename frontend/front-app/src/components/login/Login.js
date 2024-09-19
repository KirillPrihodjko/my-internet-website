import {useState} from 'react';
import {useNavigate} from 'react-router-dom';
import {HttpService} from '../../services/HttpService';

//export default function Login() {
const Login = () => {

    const [login, setLogin] = useState('');
    const [password, setPassword] = useState('');
    const [errorMessage, setErrorMessage] = useState('');
    const httpService = new HttpService();
    const navigate = useNavigate();

    const doLogin = (event) => {
        event.preventDefault();
        let requestBody = {email: login, password: password};
        httpService.doPost('/users/login',
            requestBody
            , data => {
                localStorage.setItem("token", "Bearer " + data);
                navigate('/users');//redirect
            }
            , data => setErrorMessage(data),
            false
            , "text");
    }

    return (
        <div>
            <form>
                <label>Email</label><input type="text" onChange={(event => setLogin(event.target.value))}/>
                <label>Password</label><input type="password" onChange={(event => setPassword(event.target.value))}/>
                <input type="submit" onClick={(e) => doLogin(e)}/>
            </form>
            <p>{errorMessage}</p>
        </div>
    )
}

export default Login;

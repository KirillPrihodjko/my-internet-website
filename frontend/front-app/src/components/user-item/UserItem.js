export default function UserItem(props){
    const {user} = props;
    //const user = props.user

    /*
    let user = {name:"Vasya",age:18}
    let name = user.name;
    let age = user.age;
    const {name, age} = user;




     */

    return (
            <tr>
                <td>{user.id}</td>
                <td>{user.firstName}</td>
                <td>{user.lastName}</td>
            </tr>
    );



}
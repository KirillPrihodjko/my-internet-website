import {useState} from 'react';

export default function Increment() {

    const [number, setMyNumber] = useState(0);
    //console.log(setMyNumber)
    const incr = () => {
        setMyNumber(number + 1);
        console.log(number)
    }
    return (
        <div>
            <p>{number}</p>
            <button onClick={incr}>Test</button>
        </div>
    )
}
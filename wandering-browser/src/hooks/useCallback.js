import React, { useState } from 'react'

export default function App() {

    const [count,setCount] = useState(0)

    var mycount = 0

  return (
    <div>
        <button onClick={()=>{
            setCount(count+1)
        }}>add</button>
        {count}-{mycount}
    </div>
  )
}

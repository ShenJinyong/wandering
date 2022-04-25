import React, { useState } from 'react'

export default function App() {

    const [name,setName] = useState("沈金勇");
    return (
      <div>
          <button onClick={()=>{
              setName("李兴")
          }}>click</button>
          App-{name}
      </div>
    )
}

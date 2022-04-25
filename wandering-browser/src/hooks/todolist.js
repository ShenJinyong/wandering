import React, { useState } from 'react'

export default function App(){

    const [text,setText] = useState("")
    const [list,setList] = useState(["aa","bb","cc"])

    const handleDel = (index)=>{
        console.log(index)
        var newList = [...list]
        newList.splice(index,1)
        setList(newList)
    }
    return (
      <div>
          <input onChange={(evt)=>{
              setText(evt.target.value)
          }} value={text}></input>
          <button onClick={()=>{
              console.log(text)
              setList([...list,text])
              setText("")
          }}>add</button>
        <ul>
            {
                list.map((item,index)=><li key={item}>
                    {item}
                    <button onClick={()=>handleDel(index)}>del</button>
                    </li>)
            }
        </ul>
        {!list.length && <div>暂无待办事项</div>}
      </div>
    )
}

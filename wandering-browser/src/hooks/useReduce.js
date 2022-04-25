import React, { useReducer } from 'react'

// 外部的对象
const intialState = {
    count: 0
}

// 处理函数
const reducer = (prevState,action)=>{
    let newState = [...prevState]
    console.log(111)
    switch(action.type){
        case 'minus':
            newState.count--
            return newState
        case 'add':
            newState.count++
            return newState
        default:
            return prevState
    }
}
    

export default function App() {

  const [state,dispatch] = useReducer(reducer,intialState);

  return (
    <div>
        <button onClick={()=>{
            dispatch({
            type:'minus'
            })
        }}>-</button>
        {state.count}
        <button onClick={()=>
            dispatch({
                type:'add'
            })
        }>+</button>
    </div>
  )
}

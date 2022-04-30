# React Hooks

## 使用hooks理由

1. 高阶组件为了服用，导致代码层级复杂
2. 生命周期的复杂
3. 写成function组件，无状态组件，因为需要状态，又改成了class，成本高

**useState（保存组件状态）**



```JS
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
```

**useEffect**

```js
import React ,{useEffect, useState} from 'react'

export default function App() {
     const [name,setName] = useState("shenjinyong")

     useEffect(()=>{
        setName(name.substring(0,1).toUpperCase()+name.substring(1))
     },[name])
     // 第一次执行一次，之后name（依赖）更新也会执行
  return (
    <div>
        App-{name}
        <button onClick={
            ()=>setName("xiaoming")
        }>click</button>
    </div>
  )
}

```

**useCallback记忆函数**

```js
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

```

**useMemo记忆组件**

计算属性

**useRef保存引用值**

```js
const mytext = useRef() //React.createRef()
```

**useReducer和useContext**

减少组件层级！！！

```js
const GlobalContext = React.createContext()
```


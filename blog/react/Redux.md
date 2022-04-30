# Redux

## Flux架构思想

## Redux工作流

React Components==>action==>store==>React Components

store< ==>reducers

## Redux实战

安装

```js
npm i redux
```

store.js

```js
import {createStore} from'redux'

const reducer = (prevState={
 	show:true   
},action)=>{
    return prevState
}
const store = createStore(reducer)

export default store
```

store.subsribe 订阅

```js
componentDidMount(){
    store.subscribe(()=>{
       console.log("app中订阅",store.getStore().show)
    })
}
```

sotre.dispatch 通知

```js
useEffect(()=>{
    store.disparch({
        type:"显示"
    })
    return ()=>{
        store.disparch({
        type:"隐藏"
    })
    }
},[])
```

## Redux原理

```js
function createStore(){
    var list = []
    var state = reducer()
    function subcribe(callback){
        list.push(callback)
    }
    function dispatch(){
        state = reducer(state,action)
        for(var i in list){
            list[i] && list[i]()
        }
    }
    function getState(){
        return state
    }
    return {
        subcribe,
        dispatch,
        getState
    }
}
```

reducx**介绍及设计和使用的三大原则**

- state以单一对象存储在store对象中
- state只读(每次都返回一个新的对象)
- 使用纯函数reducer执行state更新

**纯函数**

1. 对外界没有副作用
2. 同样的输入得到同样的输出

## Redux-reducer合并

```js
import {combineReducers,createStore} from 'redux'

const reducer = combineReducers({
    Reducer1,
    Reducer2
})

const store = createStore(reducer)
```

**中间件Redux-thunk**

dispatch 返回值对象变成函数

安装

```js
npm i redux-thunk
```

引入

```js
import reduxThunk from 'redux-thunk'

const store = createStore(reducer,applyMiddleware(reduxThunk))
```

**中间件Redux-promise**

安装

```js
npm i redux-promise
```

引入

```js
import reduxPromise from 'redux-promise'

const store = createStore(reducer,applyMiddleware(reduxPromise))
```

**React-redux**

安装

```js
npm i react-redux
```

引入

index.js

```js
import {Provider} from 'react-redux

<Provider>
    <App/>
</Provider>
```

App.js

```js
import {connect} from 'react-redux'

export default connect((state)=>{
    return{
        a:1,
        b:2,
        isShow:state.TabbarReducer.show
    }
})(App)
```

Components.js

```js
import {connect} from 'react-redux'

// connect(将来给孩子传的属性，将来给孩子的回调函数)
export default connect(null,{
	show,
    hide
})(Detail)
```


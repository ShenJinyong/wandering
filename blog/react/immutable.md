# immutable

安装

```
npm i immutable
```

引入

```js
import {Map} from 'immutable'

var obj = {
    name:"沈金勇",
    age:24
}

var oldImmutableObj = Map(obj)

var newImmutableObj = oldImmutableObj.set("name","李兴")

console.log(oldImmutableObj.get("name"),newImmutableObj.get("name"))

console.log(oleImmutable.toJS(),newImmutableObj.toJS())
```

FromJS

```
setIn(['一级','二级'])
```

## Immuable-reudx

 
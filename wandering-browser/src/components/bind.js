import React, { Component } from 'react'

export default class App extends Component {
  a = 10
  render() {
    return (
      <div>
          <input/>
          <button onClick={
            ()=>{
              console.log("click1","如果处理逻辑过多，不推荐这种写法",this.a)
            }
          }>add1</button>
          <button onClick={this.handleClick2.bind(this)}>add2</button>
          <button onClick={this.handleClick3}>add3</button>
          <button onClick={
            ()=>{
              this.handleClick4() // 比较推荐
            }
          }>add4</button>
      </div>
    )
  }
  handleClick2(){
    console.log("click2",this.a)
  }

  handleClick3 = ()=>{
    console.log("click3",this.a)
  }

  handleClick4(){
    console.log("click4",this.a)
  }

}

var obj1 = {
  name:"obj1",
  getName(){
    console.log(this.name)
  }
}

var obj2 = {
  name:"obj2",
  getName(){
    console.log(this.name)
  }
}

obj1.getName.call(obj2)

obj2.getName()

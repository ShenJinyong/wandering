import React, { Component } from 'react'

export default class App extends Component {
  myusername = React.createRef()
  render() {
    return (
      <div>
          <h1>登录页</h1>
          <input type="text" ref={this.myusername} defaultValue="沈金勇"></input>
          <button onClick={()=>{
              console.log(this.myusername.current.value)
          }}>登录</button>
          <button onClick={()=>{
              console.log(this.myusername.current.value = "")
          }}>重置</button>
      </div>
    )
  }
}

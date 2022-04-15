import React, { Component } from 'react'
import '../css/index.css'

export default class App extends Component {
  render() {
      var myname = "小沈要努力呀"
      var obj = {
          backgroundColor:"red",
          fontSize:"20px"
      }
    return (
      <div> 
        {10+20}-{myname}<br/>
        {10>20?myname:"小沈"}
        <div style={{background:"yellow"}}>111111111</div>
        <div style={obj}>222222222</div>
        <div className='active'>222222222</div>
        <label htmlFor="username">用户名：</label>
        <input type="text" id='username'></input>
      </div>
    )
  }
}

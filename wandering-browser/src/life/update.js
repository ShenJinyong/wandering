import React, { Component } from 'react'

export default class App extends Component {
    state = {
        myname:"沈金勇"
    }
  render() {
      console.log("render")
    return (
      <div>
          <button onClick={()=>{
              this.setState({
                  myname:"李儿子"
              })
          }}>click</button>
          <span id='myname'>{this.state.myname}</span>
      </div>
    )
  }

  shouldComponentUpdate(){
      return true
  }
  UNSAFE_componentWillUpdate(){
    console.log("componentWillUpdate",document.getElementById("myname").innerHTML)
  }
  componentDidUpdate(){
    console.log("componentDidUpdate")
  }
}

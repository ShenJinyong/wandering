import React, { Component } from 'react'

export default class App extends Component {
  render() {
    return (
      <div>
          <input/>
          <button onClick={this.handleClick}>add</button>
      </div>
    )
  }
  handleClick(){
      console.log("click")
  }
}

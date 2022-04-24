import React, { Component } from 'react'

export default class App extends Component {

    state = {
        myname:"沈金勇",
        myage:23
    }
    static getDerivedStateFromProps(){
        console.log("getDerivedStateFromProps")
        return {
            myname:"李兴"
        }
    }
  render() {
    return (
      <div>
          {this.state.myname}-{this.state.myage}
      </div>
    )
  }
}

import React, { Component } from 'react'

class Child extends Component{
    render(){
        return <div>Child</div>
    }
    UNSAFE_componentWillReceiveProps(){
        console.log("componentWillReceiveProps")
    }
}

export default class App extends Component {
    state = {
        text: 11
    }
  render() {
    return (
      <div>
        {
            this.state.text
        }
        <button onClick={()=>{
            this.setState({
                text:222
            })
        }}>click</button>
          <Child></Child>
      </div>
    )
  }
}

import React, { Component } from 'react'

class Child extends Component{
    render(){
        return <div>Child</div>
    }

    componentDidMount(){
        window.onresize = ()=>{
            console.log("resize")
        } 
    }
    componentWillUnmount(){
        console.log("componentWillUnmount")

        window.onresize = null

    }
}

export default class App extends Component {

    state = {
        isCreated:true
    }
    render() {
    return (
      <div>
          <button onClick={()=>{
              this.setState({
                  isCreated:false
              })
          }}>click</button>
          {this.state.isCreated?<Child></Child>:""}
      </div>
    )
  }
}

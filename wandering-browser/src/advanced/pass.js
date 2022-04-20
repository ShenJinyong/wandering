import React, { Component } from 'react'

class Navbar extends Component{
    render(){
        return <div style={{background:"red"}}>
            <button onClick={()=>{
                this.props.event()
            }}>click</button>
            <span>navbar</span>
        </div>
    }
}

class Sidebar extends Component{
    render(){
        return <div style={{background:"yellow",width:"200px"}}>
            <ul>
                <li>11111111</li>
                <li>11111111</li>
                <li>11111111</li>
                <li>11111111</li>
                <li>11111111</li>
            </ul>
        </div>
    }
}

export default class App extends Component {
    state = {
        isShow:false
    }
  render() {
    return (
      <div>
          <Navbar event={()=>
              this.setState(
                {
                    isShow:!this.state.isShow
                }
              )
          }></Navbar>
          { this.state.isShow && <Sidebar></Sidebar>}
      </div>
    )
  }
}

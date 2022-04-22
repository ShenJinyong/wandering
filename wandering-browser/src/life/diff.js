import React, { Component } from 'react'

class Box extends Component{
    render(){
        return <div style={{width:"100px",height:"100px",border:"1px solid gray",margin:"10px",float:"left"}}>
        </div>
    }
}

export default class App extends Component {
    state = {
        list:["00","01","02","03","04","05","06","07","08","09","10"],
        current:0
    }
  render() {
    return (
      <div>
          <input type="number"></input>
            <div style={{overflow:"hidden"}}>
                {
                    this.state.list.map((item,index)=><Box key={item} current={this.state.current} index={index}></Box>)
                }
            </div>
      </div>
    )
  }
}

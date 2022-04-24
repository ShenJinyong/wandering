import React, { Component } from 'react'

export default class App extends Component {
    state = {
        list:[1,2,3,4,5,6,7,8,9,10,11,12,13,14,15]
    }

    myref = React.createRef()

    getSnapshotBeforeUpdate(){
        // 获取容器的高度
        console.log(this.myref.current.scrollHeight)
        return this.myref.current.scrollHeight
    }

    componentDidUpdate(preProps,preState,value){
        console.log(this.myref.current.scrollHeight)

        this.myref.current.scrollTop += this.myref.current.scrollHeight-value
    }
  render() {
    return (
      <div>
          <button onClick={()=>{
              this.setState({
                  list:[...[16,17,18,19,20],...this.state.list]
              })
          }}>来邮件</button>
          <h1>邮箱应用</h1>
          <ul style={{height:"200px",overflow:"auto"}} ref={this.myref}>
              {this.state.list.map(item=><li key={item} style={{height:"100px",background:"yellow"}}>{item}</li>)}
          </ul>
      </div>
    )
  }
}

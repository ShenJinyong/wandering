import React, { Component } from 'react'

export default class App extends Component {

  state = {
    myShow: true
  }
  
  render() {
    return (
      <div>
        <h1>欢迎来到react开发</h1>
        <button onClick={
            ()=>{
                this.setState({
                    myShow: !this.state.myShow
                })
                if(this.state.myShow){
                    console.log("收藏的逻辑")
                }else{
                    console.log("取消收藏的逻辑")
                }
            }
        }>{this.state.myShow?'收藏':'取消收藏'}</button>
      </div>
    )
  }
}

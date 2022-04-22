import React, { Component } from 'react'

export default class App extends Component {

    UNSAFE_componentWillMount(){
        console.log("render之前")
        // 初始化数据的作用
    }
    componentDidMount(){
        console.log("render之后")
        // 数据请求axios、订阅和发布、setInterval、基于创建玩的dom进行初始化
    }

  render() {
      console.log("render")
    return (
      <div>App</div>
    )
  }
}

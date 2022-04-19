import React, { Component } from 'react'
import Navbar from './Navbar'

export default class App extends Component {
  render() {
    // 上面父组件传来的一个对象
    var obj = {
      title:"测试",
      leftshow:false
    }
    return (
      <div>
          <div>
              <h2>首页</h2>
              <Navbar title="首页" leftshow={false}></Navbar>
          </div>
          <div>
              <h2>列表</h2>
              <Navbar title="列表" leftshow={true}></Navbar>
          </div>
          <div>
              <h2>购物车</h2>
              <Navbar title="购物车" leftshow={true}></Navbar>
          </div>

          <Navbar title={obj.title} leftshow={obj.leftshow}></Navbar>

          <Navbar {...obj}></Navbar>
      </div>
    )
  }
}

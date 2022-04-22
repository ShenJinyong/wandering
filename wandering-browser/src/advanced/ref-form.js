import React, { Component } from 'react'

class Field extends Component{
    state = {
        value:""
    }

    clear(){
        this.setState({
            value:""
        })
    }
    render(){
        return <div style={{background:"yellow"}}>
            <label>{this.props.label}</label>
            <input type={this.props.type} onChange={(evt)=>{
                this.setState({
                    value:evt.target.value
                })
            }} value={this.state.value}></input>
        </div>
    }
}

export default class App extends Component {

    username = React.createRef()
    password = React.createRef()
  render() {
    return (
      <div>
          <h1>登录页面</h1>
          <Field label="用户名" type="text" ref={this.username}/>
          <Field label="密码" type="password" ref={this.password}/>
          <button onClick={()=>{
              console.log(this.username.current.state.value)
          }}>登录</button>
          <button onClick={()=>{
              this.username.current.clear()
          }}>取消</button>
      </div>
    )
  }
}

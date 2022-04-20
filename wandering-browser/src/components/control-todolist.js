import React, { Component } from 'react'

export default class App extends Component {
  state = {
      list:["aa","bb","cc"],
      mytext: ""
  }
  render() {
    return (
      <div>
          <input value={this.state.mytext} onChange={
              (evt)=>{
                  this.setState({
                      mytext: evt.target.value
                  })
              }
          }/>
          <button onClick={this.handleClick}>add</button>
          <ul>
              {this.state.list.map((item,index)=>
              <li key={item}>
                  <input type="checkbox"></input>
                <span dangerouslySetInnerHTML={
                  {
                    __html:item
                  }
                }></span>
                <button onClick={this.handleDelClick.bind(this,index)}>delete</button>
              </li>)}
          </ul>
          {this.state.list.length===0?<div>暂无待办事项</div>:null}
      </div>
    )
  }

  handleClick = ()=>{
    let newList = [...this.state.list]
    newList.push(this.state.mytext)
    this.setState({
        list:newList
    })

    this.setState({
        mytext:""
    })

  }

  handleDelClick(index){
    console.log("del-clock",index)
    let newList = this.state.list.slice()
    newList.splice(index,1)
    this.setState({
        list:newList
    })
  }
  

}

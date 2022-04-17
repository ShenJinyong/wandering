import React, { Component } from 'react'

export default class App extends Component {
  myRef = React.createRef()
  state = {
      list:["aa","bb","cc"]
  }
  render() {
    return (
      <div>
          <input ref={this.myRef}/>
          <button onClick={this.handleClick}>add</button>
          <ul>
              {this.state.list.map((item,index)=>
              <li key={item}>
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
    console.log("click1",this.myRef.current.value)
    let newList = [...this.state.list]
    newList.push(this.myRef.current.value)
    this.setState({
        list:newList
    })

    this.myRef.current.value = ""

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

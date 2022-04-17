import React, { Component } from 'react'
import '../css/select.css'
import Film from './movie/Film'
import Cinema from './movie/Cinema'
import Center from './movie/Center'


export default class App extends Component {
    
  state = {
      list:[
          {
              id:1,
              text:"电影"
          },
          {
              id:2,
              text:"影院"
          },
          {
              id:3,
              text:"我的"
          }
      ],
      current: 0
  }



  render() {
    return (
      <div>
         
        {this.state.current === 0 && <Film></Film>}
          {this.state.current === 1 && <Cinema></Cinema>}
          {this.state.current === 2 &&  <Center></Center>}

          <ul>
              {
                this.state.list.map((item,index)=>
                <li key={item.id} className={this.state.current === index? "active":""} onClick={()=>this.handleClick(index)}>{item.text}</li>)
              }
          </ul>
      </div>
    )
  }
  handleClick(index){
      console.log(index)
      this.setState(
          {
              current:index
          }
      )
  }

}

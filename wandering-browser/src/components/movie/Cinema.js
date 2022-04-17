import React, { Component } from 'react'
import axios from 'axios'
import BetterScroll from 'better-scroll'

export default class Cinema extends Component {


  constructor(){
    super()

    this.state = {
      cinemaList:[],
      bakcinemaList:[]
    }

    // axios 第三方的库，专门用于请求数据
    // axios.get("https://m.maizuo.com/gateway?cityId=440100&ticketFlag=1&k=433021").then(res=>{}).catch(err=>{console.log(err)})
    
    axios({
      url:"https://m.maizuo.com/gateway?cityId=440100&ticketFlag=1&k=433021",
      headers:{
        'X-Client-Info': '{"a":"3000","ch":"1002","v":"5.2.0","e":"1650104829100880191848449","bc":"440100"}',
        'X-Host': 'mall.film-ticket.cinema.list'
      }
    }).then(res=>{
      console.log(res.data.data.cinemas)
      this.setState({
        cinemaList:res.data.data.cinemas,
        bakcinemaList:res.data.data.cinemas
      },()=>{
        new BetterScroll(".wrapper")
      })
    })
    .catch(err=>{console.log(err)})
  }
  render() {

    return (
      <div>
        <input onInput={this.handleInput}></input>
        <div className='wrapper' style={{height:'200px',background:'yellow',overflow:'hidden'}}>
        {
            this.state.cinemaList.map(item=>
              <dl key={item.cinemaId}>
                <dt>{item.name}</dt>
                <dd>{item.address}</dd>
              </dl>)
          }
        </div>
      </div>
    )
  }

  handleInput = (event)=>{
    console.log("input",event.target.value)
    var newList = this.state.bakcinemaList.filter(item=>item.name.toUpperCase().includes(event.target.value.toUpperCase()) || item.address.toUpperCase().includes(event.target.value.toUpperCase()))
    console.log(newList)
    this.setState({
      cinemaList:newList
    })
  }


}

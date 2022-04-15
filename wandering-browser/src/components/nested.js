import React, { Component } from 'react'

class Navbar extends Component{
    render(){
        return <div>Navbar</div>
    }
}

class Swiper extends Component{
    render(){
        return <div>Swiper</div>
    }
}

class Tabbar extends Component{
    render(){
        return <div>Tabbar</div>
    }
}

export default class App extends Component {
  render() {
    return (
      <div>
          <Navbar></Navbar>
          <Swiper></Swiper>
          <Tabbar></Tabbar>
      </div>
    )
  }
}

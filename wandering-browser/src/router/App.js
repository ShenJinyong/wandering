import React, { Component } from 'react'
import IndexRouter from './router/router.js'
import Tabbar from './components/Tabbar.js'

export default class App extends Component {
  render() {
    return (
      <div>
        <IndexRouter>
        <Tabbar></Tabbar>
        </IndexRouter>
        
      </div>
    )
  }
}

import React, { Component } from 'react'
import { Route,Redirect,Switch } from 'react-router-dom'

import NowPlaying from './films/NowPlaying.js'
import Comingsoon from './films/Comingsoon.js'

export default class Films extends Component {
  render() {
    return (
      <div>
        <div style={{height:"200px",background:"yellow"}}>大轮播</div>
        <div>导航栏</div>
        <Switch>
            <Route path="/films/nowplaying" component={NowPlaying}/>
            <Route path="/films/comingsoon" component={Comingsoon}/>

            <Redirect from='/films' to='/films/nowplaying'/>
          </Switch>
        </div>

    )
  }
}

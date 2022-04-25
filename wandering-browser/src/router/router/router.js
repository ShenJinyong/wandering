import React, { Component } from 'react'

import { HashRouter,Route,Redirect,Switch } from 'react-router-dom'

import Films from '../views/Films'
import Cinemas from '../views/Cinemas'
import Center from '../views/Center'
import NotFound from '../views/NotFound'

export default class IndexRouter extends Component {
  render() {
    return (
        <HashRouter>
                <Switch>
                    <Route path="/films" component={Films} />

                    {/* <Route path="/films/nowplaying" component={Nowplaying}/> */}

                    <Route path="/cinemas" component={Cinemas} />
                    <Route path="/center" component={Center} />
                    {/* 模糊匹配 */}
                    <Redirect from="/" to="/films" exact/>

                    {/* 精确匹配  exact */}
                    <Route component={NotFound}/>
                </Switch>
                {this.props.children}
        </HashRouter>
    )
  }
}

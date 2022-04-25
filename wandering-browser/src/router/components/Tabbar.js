import React, { Component } from 'react'
import { NavLink } from 'react-router-dom'

export default class Tabbar extends Component {
  render() {
    return (
      <div>
          <ul>
              <li>
                  <a href='#/films'>电影</a>
                  <NavLink to="/films">电影</NavLink>
              </li>
              <li>
                  <a href='#/cinemas'>影院</a>
                  <NavLink to="/cinemas">影院</NavLink>
              </li>
              <li>
                  <a href='#/center'>我的</a>
                  <NavLink to="/center">我的</NavLink>
              </li>
          </ul>
      </div>
    )
  }
}

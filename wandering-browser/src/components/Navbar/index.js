import React, { Component } from 'react'
import ReactPropTypes from 'prop-types'

export default class Navbar extends Component {
  render() {

    let {title,leftshow} = this.props
    return (
      <div>
          {leftshow && <button>返回</button>}
          {title}
          <button>home</button>
      </div>
    )
  }
}

// 默认值
Navbar.defaultProps = {
  leftshow:true
}

//类属性
Navbar.propTypes = {
  title: ReactPropTypes.string,
  leftshow: ReactPropTypes.bool
}



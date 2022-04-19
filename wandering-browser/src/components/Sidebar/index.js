import React from 'react'

export default function Sidebar(props) {
  console.log(props)
  let {bg} = props
  return (
    <div style={{background:bg,width:"200px"}}>
      <ul>
        <li>111</li>
        <li>111</li>
        <li>111</li>
        <li>111</li>
        <li>111</li>
      </ul>
    </div>
  )
}


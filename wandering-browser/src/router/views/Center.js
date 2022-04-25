import React from 'react'

export default function Center(props) {
  return (
    <div>
      <h1>Center</h1>
      <div onClick={()=>{
        console.log(props)
          // props.hisstory.push(`/filmsorder`)
      }}>电影订单</div>
    </div>
  )
}

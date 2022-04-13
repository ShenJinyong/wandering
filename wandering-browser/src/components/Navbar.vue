<template>
  <div class="blog-navbar">

    <router-link style="text-decoration-line: none;color: white">
      <h3 class="ui header item m-blue" style="display: inline;padding:20px 20px 20px 60px">流浪所</h3>
    </router-link>

    <router-link class="item" style="text-decoration-line: none;color: white;padding:20px;">
      首页
    </router-link>

    <router-link class="item" style="text-decoration-line: none;color: white;padding:20px">
      归档
    </router-link>

    <router-link class="item" style="text-decoration-line: none;color: white;padding:20px">
      友链
    </router-link>

    <router-link class="item" style="text-decoration-line: none;color: white;padding: 20px">
      关于我
    </router-link>

  </div>

</template>

<script>
export default {
  name: "Navbar"
}
</script>

<style scoped>
.el-popper .popper__arrow::after {
  content: none !important;
}

.popper__arrow {
  display: none !important;
}

.el-dropdown-link {
  outline-style: none !important;
  outline-color: unset !important;
  height: 100%;
  cursor: pointer;
}

.el-dropdown-menu {
  margin: 20px 0 0 0 !important;
  padding: 0 !important;
  border: 0 !important;
  background: #1b1c1d !important;
}


.el-dropdown-menu__item {
  padding: 0px 15px 0px 15px !important;

}

.el-dropdown-menu__item:hover {
   background-color: #399BDD!important;
}


.el-menu-demo {
  border-bottom-color: #ffffff !important;
}

.blog-navbar {


  height: 50px;
  padding-top:  20px;
  background-color: #333333;



  margin-left: auto !important;
  margin-right: auto !important;


}

.m-search {
  min-width: 220px;
  padding: 0 !important;
  margin-top: -5px;
}

.m-search input {
  color: rgba(255, 255, 255, .9);;
  border: 0px !important;
  background-color: inherit;



}

.m-search i {
  color: rgba(255, 255, 255, .9) !important;
}

.m-search-item {

  min-width: 350px !important;

}


.m-search-item li {
  line-height: normal !important;
  padding: 8px 10px !important;
  width: 1000px;


}

.m-search-item li .title {
  text-overflow: ellipsis;
  overflow: hidden;
  color: rgba(0, 0, 0, 0.87);
}

.m-search-item li .content {
  text-overflow: ellipsis;
  font-size: 12px;
  color: rgba(0, 0, 0, .70);
}

.m-mobile-hide {
  display: none !important;

}

.m-mobile-show {
  padding: 0px 1px 0px 1px;
  margin: 20px 1px 0px 1px;

}
.el-autocomplete {
  position: absolute;
  right: 100px;
}

</style>


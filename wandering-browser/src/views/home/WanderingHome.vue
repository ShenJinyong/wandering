<template>
<el-container>
  <el-header>
    <el-row :gutter="20">
      <el-col :span="3" class="wandering-name">
          流浪所
      </el-col>
      <el-col :span="15" class="wandering-home">
        <el-link type="info">首页</el-link>
        <el-link type="primary">新闻</el-link>
        <el-link type="success">博问</el-link>
        <el-link type="warning">专区</el-link>
        <el-link type="danger">闪存</el-link>
        <el-link type="info">班级</el-link>
        <el-link type="info" href="https://github.com/ShenJinyong/wandering" target="_blank">友链</el-link>
      </el-col>
      <el-col :span="4" class="wandering-search">
        <el-input v-model="input" placeholder="代码改变世界"></el-input>
      </el-col>
      <el-col :span="2" class="wandering-login">
        <el-link type="primary">注册</el-link>
        <el-link type="success">登录</el-link>
      </el-col>
    </el-row>
  </el-header>

  <el-container>
    <el-aside width="200px">
      <ul>
        <li>
          <span>分类</span>
        </li>
        <li>
          <span>精华</span>
        </li>
        <li>
          <span>候选</span>
        </li>
        <li>
          <el-divider></el-divider>
        </li>
        <li>
          <span>订阅</span>
        </li>
        <li>
          <span>关注</span>
        </li>
        <li>
          <span>我赞</span>
        </li>
        <li>
          <span>更多</span>
        </li>
        <li>
          <el-divider></el-divider>
        </li>
        <li>
          <span>反馈</span>
        </li>
      </ul>
    </el-aside>
    <el-main>
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
              <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪</span>
        </div>
        <div>
          <span>面试官您好，我叫沈金勇，萍乡学院软件工程专业。目前有两段经历，在校经历和实习经历。大一的时候开始就加入启创工作室，跟着学长学姐一起做Java开发相关的工作，接着从大二开始就已经带领团队开发项目了。然后从去年十二月份开始到现在，有小半年的工作经验，在浩云科技的物联交付科担任Java开发工程师的职位，主要的职责是开发结果工时系统和广西社矫系统。Java项目开发经验比较符合贵公司的要求，然后我看贵公司是拥有低代码平台的，刚好我参与的两个项目都是基于浩云科技的低代码平台2.x版本的开发的，二者拥有一定的共通性的，其中结果工时系统是企业内部的教育管理类系统，广西社交系统也是党政机关项目，与贵公司的要求比较稳合的。然后我本人也是从第三的购买了两年华为云服务器来用来部署项目，在这边的工作期间不仅有用过公司的服务器linux系统的运用，还有堡垒机上系统的操作，实践经验也是有的，符合贵公司的招聘要求。最后的话就是，所参与的项目基本上都是使用Spring那一套的解决方案，对于Springboot、mybatis、mybatisplus等主流框架也是熟练运用，版本管理的话使用git去管理代码、svn管理文档、maven管理依赖，在线接口文档使用的是swagger，数据库方面的话mysql和redis。</span>
        </div>
        <div>
          <span>萍院云的博客</span>
          <span>2020-03-17 20:32</span>
          <el-badge :value="12" class="item">
          <el-button size="small">评论</el-button>
          </el-badge>
          <el-badge :value="3" class="item">
            <el-button size="small">回复</el-button>
          </el-badge>
          <el-badge :value="1" class="item" type="primary">
            <el-button size="small">评论</el-button>
          </el-badge>
        </div>
      </el-card>
      </el-card>
    </el-main>
    <el-aside width="300px">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>卡片名称</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{o +'列表内容 ' }}
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>卡片名称</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{o +'列表内容 ' }}
        </div>
      </el-card>
            <el-card class="box-card">
        <div slot="header" class="clearfix">
          <span>卡片名称</span>
        </div>
        <div v-for="o in 4" :key="o" class="text item">
          {{o +'列表内容 ' }}
        </div>
      </el-card>
    </el-aside>
  </el-container>
  <el-footer>
    <span>启创工作室出品，必属精品！！！</span>
  </el-footer>
</el-container>
</template>

<script>
export default {
  name: 'WanderingHome',
  data() {
    return {
      input: ''
    }
  }
}

</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
  /* 导航栏样式 */
  .el-header {
    height: 52px;
  } 

  /* 页脚样式 */
  .el-footer {
    background-color: #d3dce6;
    height: 52px;
  }
  
  /* 主题样式 */
  .el-main {
    background-color: #E9EEF3;
  }
  
  /* 导航栏 */
  .el-row {
    height: 52px;
    border-radius: 4px;
  }

  /* 流浪所文字 */
  .wandering-name {
    text-align: center;
    line-height: 52px;
  }

  /* 首页链接 */
  .wandering-home {
    text-align: left;
    line-height: 52px;
  }
  .wandering-home .el-link{
    margin-left: 40px;  
  }

  /* 搜索框 */
  .wandering-search .el-input {
    margin-top: 15px;
    background: #d3dce6;
  }

  /* 注册登录 */
  .wandering-login {
    text-align: left;
    line-height: 52px; 
  }
  .wandering-login .el-link{
    margin-left: 20px;  
  }

  /* 无序列表去掉点 */
  .el-container .el-aside ul li{
    list-style: none;
    line-height: 36px; 
    text-align: center;
  }

  /* 主题内容 */
  .item {
    margin-top: 10px;
    margin-right: 40px;
    margin-bottom: 18px;
  }

  /* 页脚 */
  .el-footer {
    text-align: center;
    color: red;
  }

</style>
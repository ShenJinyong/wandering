<template>
  <div class="app-container">
    <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪。</span>
    <el-table
      v-loading="listLoading"
      :data="BlogList"
      element-loading-text="Loading"
      border
      fit
      highlight-current-row
    >
      <el-table-column align="center" label="序号" width="95">
        <template slot-scope="scope">
          {{ scope.$index + 1 }}
        </template>
      </el-table-column>
      <el-table-column label="ID">
        <template slot-scope="scope">
          {{ scope.row.id }}
        </template>
      </el-table-column>
      <el-table-column label="标题">
        <template slot-scope="scope">
          {{ scope.row.title }}
        </template>
      </el-table-column>
      <el-table-column label="首图">
        <template slot-scope="scope">
          {{ scope.row.firstPicture }}
        </template>
      </el-table-column>
      <el-table-column label="内容">
        <template slot-scope="scope">
          {{ scope.row.content }}
        </template>
      </el-table-column>
      <el-table-column label="类型">
        <template slot-scope="scope">
          {{ scope.row.typeId }}
        </template>
      </el-table-column>
      <el-table-column label="标签">
        <template slot-scope="scope">
          {{ scope.row.tagId }}
        </template>
      </el-table-column>
      <el-table-column label="是否可见">
        <template slot-scope="scope">
          {{ scope.row.status }}
        </template>
      </el-table-column>
      <el-table-column label="浏览量">
        <template slot-scope="scope">
          {{ scope.row.views }}
        </template>
      </el-table-column>
      <el-table-column label="创建时间">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          {{ scope.row.createTime }}
        </template>
      </el-table-column>
      <el-table-column label="修改时间">
        <template slot-scope="scope">
          <i class="el-icon-time" />
          {{ scope.row.updateTime }}
        </template>
      </el-table-column>
      <el-table-column label="操作类型">
        <el-button type="primary" icon="el-icon-edit" size="small" plain>编辑</el-button>
        <el-button type="danger" icon="el-icon-delete" size="small" plain>删除</el-button>
      </el-table-column>
    </el-table>
  </div>
</template>

<script>
import { selectAllBlog } from '@/api/blog/index'
import { selectAllBlogType } from '@/api/blog/type'
import { selectAllBlogTag } from '@/api/blog/tag'

export default {
  data() {
    return {
      BlogList: null,
      BlogTypeList: null,
      BlogTagList: null,
      listLoading: true
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      this.listLoading = true
      selectAllBlogType().then(response => {
        this.BlogTypeList = response.data.data
      })
      selectAllBlogTag().then(response => {
        this.BlogTagList = response.data.data
      })
      selectAllBlog().then(response => {
        this.BlogList = response.data.data
      })
      this.listLoading = false
    }
  }
}

</script>

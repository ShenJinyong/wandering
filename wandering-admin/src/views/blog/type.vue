<template>
  <div class="app-container">
    <span>青春是一个短暂的美梦, 当你醒来时, 它早已消失无踪。如果博客类型不满足您的需求，想要添加新的博客类型，请点击</span>
    <i class="el-icon-right" />
    <el-button type="success" icon="el-icon-check" circle size="mini" />
    <el-table
      v-loading="listLoading"
      :data="list"
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
      <el-table-column label="博客类型">
        <template slot-scope="scope">
          {{ scope.row.typeName }}
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
import { selectAllBlogType } from '@/api/blog/type'

export default {
  data() {
    return {
      list: null,
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
        this.list = response.data.data
        this.listLoading = false
      })
    }
  }
}

</script>

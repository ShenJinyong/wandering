<template>
  <div class="app-container">
    <mavon-editor v-model="blogForm.content" placeholder="# 请开始编写您的博客" />
    <el-row>
      <el-button type="success" plain @click="handleCreate">立即创建</el-button>
      <el-dialog :visible.sync="dialogFormVisible">
        <el-form
          ref="blogForm"
          :model="blogForm"
          label-position="left"
          label-width="90px"
          style="width: 400px; margin-left:50px;"
        >
          <el-form-item label="博客标题">
            <el-input v-model="blogForm.title" />
          </el-form-item>
          <el-form-item label="博客首图">
            <el-input v-model="blogForm.firstPicture" />
          </el-form-item>
          <el-form-item label="博客摘要">
            <el-input v-model="blogForm.description" />
          </el-form-item>
          <el-form-item label="博客类型">
            <el-select v-model="blogForm.typeId" placeholder="请选择博客类型">
              <el-option v-for="(item,index) in BlogTypeList" :key="index" :label="item.typeName" :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="博客标签">
            <el-select v-model="blogForm.tagId" placeholder="请选择博客标签">
              <el-option v-for="(item,index) in BlogTagList" :key="index" :label="item.tagName" :value="item.id" />
            </el-select>
          </el-form-item>
          <el-form-item label="是否显示" prop="delivery">
            <el-switch v-model="blogForm.status" active-value="0" inactive-value="1" />
          </el-form-item>
        </el-form>
        <div slot="footer" class="dialog-footer">
          <el-button @click="dialogFormVisible = false">取消</el-button>
          <el-button type="primary" @click=" createData() ">确定</el-button>
        </div>
      </el-dialog>
    </el-row>
  </div>
</template>

<script>
import { selectAllBlogType } from '@/api/blog/type'
import { selectAllBlogTag } from '@/api/blog/tag'
import { createBlog } from '@/api/blog/editor'

export default {
  data() {
    return {
      dialogFormVisible: false,
      BlogTypeList: null,
      BlogTagList: null,
      blogForm: {
        title: '',
        typeId: '',
        tagId: '',
        content: '',
        firstPicture: '',
        description: '',
        status: ''
      }
    }
  },
  created() {
    this.fetchData()
  },
  methods: {
    fetchData() {
      selectAllBlogType().then(response => {
        this.BlogTypeList = response.data.data
      })
      selectAllBlogTag().then(response => {
        this.BlogTagList = response.data.data
      })
    },
    handleCreate() {
      this.dialogFormVisible = true
    },
    createData() {
      createBlog(this.blogForm)
      this.dialogFormVisible = false
      this.$notify({
        title: '成功',
        message: '发表博客成功',
        type: 'success'
      })
    }
  }

}
</script>

<style scoped>
.v-note-wrapper{
  min-height: 600px;
}
</style>

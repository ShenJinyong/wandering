<template>
  <!--顶部导航栏-->
  <Navbar />
  <router-view/>
</template>

<script>
import Navbar from "../../components/Navbar.vue";
export default {
  name: 'WanderingIndex',
  components: { Navbar },
  data() {
    return {
    }
  }
}

</script>
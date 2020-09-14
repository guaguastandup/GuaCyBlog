<template>
  <div>
    <h1>Welcome!{{msg}}</h1>
  </div>
</template>
<script>
export default {
  data() {
    return {
      msg: this.$route.query.data
    };
  },
}
</script>
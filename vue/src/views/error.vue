<template>
  <div>
    <h1>��¼����{{msg}}</h1>
  </div>
</template>
<script>
export default {
  // data() {
  //   return {
  //     msg: this.$route.query.data
  //   };
  // }, //ʹ�����ַ�ʽҲ������ʾ msg
  data() {
    return {
      msg: null
    };
  },
  created() {
    this.msg = this.$route.query.message;
  }
};
</script>
<template>
  <div>
    �û���:<input type="text" v-model="loginForm.username" placeholder="�������û���"/>
    <br><br>
    ���룺 <input type="password" v-model="loginForm.password" placeholder="����������"/>
    <br><br>
    <button v-on:click="login">��¼</button>
  </div>
</template>

<script>

export default {
  name: 'Login',
  data () {
    return {
      loginForm: {
        username: '',
        password: ''
      },
      responseResult: []
    }
  },
  methods: {
    login () {
      this.$axios
          .post('/login', {
            username: this.loginForm.username,
            password: this.loginForm.password
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              this.$router.replace({path: '/index'})
            }
          })
          .catch(failResponse => {
          })
    }
  }
}
</script>


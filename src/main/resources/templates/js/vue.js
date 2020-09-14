new Vue({
    el: '#app',
    data: function() {
        return { visible: false }
    }
}),
    new Vue({
        el: '#app2',
        data: {
            message: 'Hi',
            message2: '页面加载于 ' + new Date().toLocaleString(),
            todos:[
                {text:"课设"},
                {text:"算法训练"},
                {text:"科研训练"}
            ],
            seen: true
        },
        methods:{
            reverseMessage: function () {
                this.message = this.message.split('').reverse().join('')
            }
        }
    })
const base = {
    get() {
        return {
            url : "http://localhost:8080/springboot01u2zqkf/",
            name: "springboot01u2zqkf",
            // 退出到首页链接
            indexUrl: 'http://localhost:8080/springboot01u2zqkf/front/dist/index.html'
        };
    },
    getProjectName(){
        return {
            projectName: "预制菜订购平台开发"
        } 
    }
}
export default base

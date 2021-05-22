<template>
    <div class="about">
        <h1>{{aaa}}</h1>
       <el-button @click="downDoc">下载doc</el-button>
    </div>
</template>

<script>
    var baseUrl=`/api`;
    export default {
        data() {
            return {
                aaa: '中欧阿尔法混合',
            }
        },
        mounted(){
                this.getBackDatas();
        },
        methods: {
            getBackDatas(){
                this.$axios.get('api/order/getBackDatas').then(res =>{
                    this.aaa= res.data.msg
                    console.log(res);
                })
            },
          downDoc(){



            window.location.href = "api/test/downLoadFile_doc";
            // this.$axios.get('api/test/downLoadFile_doc').then(res =>{
            //   const blob = new Blob([res.data]);
            //   const fileName = 'a.doc';
            //   const link = document.createElement('a');
            //   link.download = fileName;
            //   link.style.display = 'none';
            //   link.href = URL.createObjectURL(blob);
            //   document.body.appendChild(link)
            //   link.click();
            //   URL.revokeObjectURL(link.href);
            //   document.body.removeChild(link);
            // })
          }


        },

    }

</script>

function delFruit(fid){
    if(confirm('是否确认删除？')){
        // href 就相当于给地址栏赋值del.do 而且将fid 给它
        window.location.href='del.do?fid='+fid;
    }
}
function delFruit(fid){
    if(confirm('是否确认删除？')){
        // href 就相当于给地址栏赋值del.do 而且将fid 给它
        //40.2更改删除方法
        window.location.href='fruit.do?fid='+fid+'&operate=del';
    }
}

function page(pageNo){
    //40.2
    window.location.href="fruit.do?pageNo="+pageNo;
}
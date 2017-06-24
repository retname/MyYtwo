<%--
  Created by IntelliJ IDEA.
  User: zhangyu
  Date: 2017/6/16
  Time: 14:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script type="text/javascript">


    var person={
        name:"zy",
        age:"19",
        sex:"男",
        showYour:function () {
             alert(person.name);
        }
    }
    
    
    function  Person(name,age,sex) {
        this.name=name;
        this.age=age;
        this.sex=sex;
        this.showYour=myself;
    }
    function  myself() {
        alert(this.name);
    }

    //var per1 = new Person("zy",18,"男");
    //var per2 = new Person("ss",15,"女");

   function Person() {
        this.into=["b","f","p"];
        this.age=10000;
   }
    function  Student() {
        Person.call(this);   //call  一个对象替换为当前对象
    };
  Student.prototype=new Person();
    var stu = new Student();
    //stu.into.push();
    // alert(stu.into);
    
    
    function  Flower() {
        
    }
    Flower.prototype.name="曼陀罗花";
    Flower.prototype.showName=function () {
        alert(this.name);
    }
    var f1 =new Flower();
    var f2 = new Flower();
    alert(f1.showName()==f2.showName())

    
</script>


<html>
<head>
    <title>Title</title>
</head>
<body>

</body>
</html>

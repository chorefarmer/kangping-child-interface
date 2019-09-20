<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>营养监测分析报告(1-6M)</title>

    <link rel="stylesheet" href="http://localhost:8080/css/bodyComposition.css" />
    <link rel="stylesheet" href="http://localhost:8080/js/echarts.min.js" />

    <style>
        @page {
            size: 210mm 297mm; /*设置纸张大小:A4(210mm 297mm)、A3(297mm 420mm) 横向则反过来*/
            margin: 0.25in;
            padding: 1em;
            @bottom-center{
                content:"儿童个体营养监测分析报告";
                font-family: SimSun;
                font-size: 16px;
                color:deepskyblue;
            };
            @top-center { content: element(header) };
            @bottom-right{
                content:"第" counter(page) "页  共 " counter(pages) "页";
                font-family: SimSun;
                font-size: 14px;
                color:#000;
            };
        }
    </style>
</head>
<body style="font-family: SimSun">
<div class="container">
    <div style="margin: 0 0 15px 200px " class="hospital">
        <img style="width: 60px;height: 60px;margin: 0 0 -20px 0 " src="http://localhost:8080/img/hospital.jpg" />
        <span style="font-size: 35px">${hospital.hospitalName}</span>
    </div>

    <div style="text-align: center" class="header">
        <div class="bg-line"></div>
        <div class="header-title">
            <span>营养监测分析报告</span>
        </div>
    </div>

    <div class="main">
        <#--基本信息-->
        <div class="item-title-infor">
            <div class="title-left">
                <img width="35px" height="35px" src="http://localhost:8080/img/information.jpg" />
                基本信息
            </div>
            <div class="title-right">检测时间:${.now}</div>
        </div>

        <div class="table_wrap_infor">
            <table class="table" width="700" cellspacing="0" cellpadding="0">
                <thead class="table_head">
                <tr>
                    <th>ID</th>
                    <th>姓名</th>
                    <th>性别</th>
                    <th>身高</th>
                    <th>出生日期</th>
                    <th>年龄</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>${information.guardian_phone?c}</td>
                    <td>${information.name}</td>
                    <td>${sex}</td>
                    <td>${height}cm</td>
                    <td>${information.birth?string('yyyy-MM-dd')}</td>
                    <td>${ageActual}</td>
                </tr>

                </tbody>
            </table>
        </div>

        <#--身高体重曲线图-->
        <div class="item-title-height">
            <div class="title-left">
                <img width="35px" height="35px" src="http://localhost:8080/img/heightWeight.jpg" />
                身高体重曲线图
            </div>
            <div class="title-right"></div>
        </div>
        <div >
            <img style="margin-left: -300px;width:600px;height:350px"  src="http://localhost:8080/${information.guardian_phone?c}_Height.png" />

        </div>
        <div >
            <img style="margin-left: 50px;width:600px;height:350px"  src="http://localhost:8080/${information.guardian_phone?c}_Weight.png" />

        </div>
        <div >
            <img style="margin-left: 50px;width:600px;height:350px"  src="http://localhost:8080/${information.guardian_phone?c}_Bmi.png" />

        </div>


        <#--指导方案建议日摄入量-->
        <div class="item-title-dayintake">
            <div class="title-left">
                <img width="35px" height="35px" src="http://localhost:8080/img/milk_.jpg" />
                纯母乳/配方奶喂养建议量
            </div>
            <div class="title-right"></div>
        </div>

        <div class="table_wrap_dayintake">
            <table class="table" width="700" cellspacing="0" cellpadding="0">
                <thead class="table_head">
                <tr>
                    <th>纯母乳喂养</th>
                    <th>配方奶喂养</th>
                </tr>
                </thead>
                <tbody>
                <tr>
                    <td>初乳(出生后7天内{包括7天})毫升数:${(EER_/73)?string("0")}ml</td>
                    <td rowspan="3">婴儿配方奶毫升数:${(EER_/65)?string("0")}ml</td>
                </tr>
                <tr>
                    <td>过渡乳(出生后7天-14天内{包括14天})毫升数:${(EER_/70)?string("0")}ml</td>
                    <#--<td></td>-->
                </tr>
                <tr>
                    <td>成熟乳(出生后14天以上)毫升数:${(EER_/55)?string("0")}ml</td>
                    <#--<td></td>-->
                </tr>
                <tr>
                    <td>每日推荐摄入能量</td>
                    <td>${kcal_low?c}Kcal-${kcal_high?c}Kcal</td>
                </tr>

                </tbody>
            </table>
        </div>


        <#--辅食添加原则-->
            <div class="item-title-sport">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/fushiyz.jpg" />
                    辅食添加说明
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_sport">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>6个月之前不建议添加辅食，若已添加辅助食物，请阅读如下原则性说明。</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>1、食物要呈泥糊状、滑软、易咽，不要加任何调味剂(如盐、味精、鸡精、糖等)。</td>
                    </tr>

                    <tr>
                        <td>2、头两天以1～2勺开始，若宝宝消化、吸收得很好，再慢慢增加一些。</td>
                    </tr>
                    <tr>
                        <td>3、每添加一种新的食物，要在前一种食物食用3～5天，宝宝没有出现任何异常之后进行。</td>
                    </tr>

                    <tr>
                        <td>4、4～5个月，每天最多加一次辅食。</td>
                    </tr>


                    </tbody>
                </table>
            </div>


        <#--辅食可以食用的食物-->
            <div class="item-title-sport">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/keshiyong.jpg" />
                    辅食食物说明
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_sport">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>举例</th>
                        <th>说明</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>米粉：</td>
                        <td>有家族过敏史的，则6个月以后再添加蛋黄。建议先从单纯的米粉作为辅食。</td>
                    </tr>

                    <tr>
                        <td>水果：</td>
                        <td>如苹果、梨；橙子、猕猴桃等暂不食用。</td>
                    </tr>
                    <tr>
                        <td>蔬菜：</td>
                        <td>如胡萝卜、马铃薯、青豆、南瓜等。</td>
                    </tr>

                    <tr>
                        <td>食物性状：</td>
                        <td>泥糊状（能用小勺舀起不会很快滴落）。</td>
                    </tr>

                    <tr>
                        <td>餐次：</td>
                        <td>有辅食添加时5-6次奶（逐渐断夜间奶）。</td>
                    </tr>
                    <tr>
                        <td>辅食量：</td>
                        <td>由1～2勺开始，逐渐加至1餐（需要对量进行描述）。</td>
                    </tr>

                    </tbody>
                </table>
            </div>
        <#--医生建议-->
            <div class="item-title-doctorAdvice">
                <div class="title-left">
                    <#--<img width="35px" height="35px" src="http://localhost:8080/img/doctor.jpg" />-->
                    医生建议:
                </div>
                <div class="title-right"></div>
            </div>

            <div class="item-title-doctor">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/doctor.jpg" />
                    医生:
                </div>
                <div class="title-right"></div>
            </div>


        <#--&lt;#&ndash;运动指导&ndash;&gt;-->
        <#--<div class="item-title-sport">-->
            <#--<div class="title-left">-->
                <#--<img width="35px" height="35px" src="http://localhost:8080/img/sport.jpg" />-->
                <#--运动指导-->
            <#--</div>-->
            <#--<div class="title-right"></div>-->
        <#--</div>-->

        <#--<div class="table_wrap_sport">-->
            <#--<table class="table" width="700" cellspacing="0" cellpadding="0">-->
                <#--<thead class="table_head">-->
                <#--<tr>-->
                    <#--<th>运动类型</th>-->
                    <#--<th>活动标准</th>-->
                <#--</tr>-->
                <#--</thead>-->
                <#--<tbody>-->
                <#--<tr>-->
                    <#--<td>做游戏</td>-->
                    <#--<td>做游戏玩耍40分钟</td>-->
                <#--</tr>-->

                <#--<tr>-->
                    <#--<td>散步</td>-->
                    <#--<td>散步60分钟</td>-->
                <#--</tr>-->
                <#--<tr>-->
                    <#--<td>游泳</td>-->
                    <#--<td>游泳40分钟</td>-->
                <#--</tr>-->

                <#--<tr>-->
                    <#--<td>注意事项:</td>-->     <#--<td>可根据自己的具体情况调整运动时间，可多次完成</td>-->
                <#--</tr>-->


                <#--</tbody>-->
            <#--</table>-->
        <#--</div>-->
    </div>


    <div class="footer"></div>
</div>
</body>

</html>
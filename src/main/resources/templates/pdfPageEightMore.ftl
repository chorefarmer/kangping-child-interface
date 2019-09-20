<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>营养监测分析报告(8-12M)</title>

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
                喂养建议方案
            </div>
            <div class="title-right"></div>
        </div>

        <div class="table_wrap_dayintake">
            <table class="table" width="700" cellspacing="0" cellpadding="0">
                <thead class="table_head">
                <tr>
                    <th>乳量</th>
                    <th></th>
                    <th></th>
                    <th>辅食建议</th>
                    <th></th>
                    <th></th>

                </tr>
                </thead>
                <tbody>
                <tr>
                    <td rowspan="5">900ml</td>
                    <td></td>
                    <td>婴儿米粉或软饭量（g）</td>
                    <td>瘦肉（g）</td>
                    <td>蛋黄（g）</td>
                    <td>果蔬（g）</td>
                </tr>
                <tr>
                    <#--<td></td>-->
                    <td>方案一</td>
                    <td>${planA1}</td>
                    <td>${planA2}</td>
                    <td>${planA3}</td>
                    <td>${planA4}</td>
                </tr>
                <tr>
                    <#--<td></td>-->
                    <td>方案二</td>
                    <td>${planB1}</td>
                    <td>${planB2}</td>
                    <td>${planB3}</td>
                    <td>${planB4}</td>
                </tr>
                <tr>
                    <#--<td></td>-->
                    <td>方案三</td>
                    <td>${planC1}</td>
                    <td>${planC2}</td>
                    <td>${planC3}</td>
                    <td>${planC4}</td>
                </tr>
                <tr>
                    <#--<td></td>-->
                    <td>方案四</td>
                    <td>${planD1}</td>
                    <td>${planD2}</td>
                    <td>${planD3}</td>
                    <td>${planD4}</td>
                </tr>
                <tr>
                    <td style="background-color:#eaeaea">每日推荐摄入能量</td>
                    <td style="background-color:#eaeaea" ></td>
                    <td style="background-color:#eaeaea"></td>
                    <td style="background-color:#eaeaea">${kcal_low?c}Kcal-${kcal_high?c}Kcal</td>
                    <td style="background-color:#eaeaea"></td>
                    <td style="background-color:#eaeaea"></td>
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
                    <th>举例</th>
                    <th>说明</th>
                </tr>

                </thead>
                <tbody>
                <tr>
                    <td>辅食性状：</td>
                    <td>碎末状。</td>
                </tr>
                <tr>
                    <td>餐次：</td>
                    <td>4-5次奶，1-2次辅食。</td>
                </tr>

                <tr>
                    <td>辅食食物选择：</td>
                    <td></td>
                </tr>
                <tr>
                    <td>米粉：</td>
                    <td>有家族过敏史的，则6个月以后再添加蛋黄。建议先从单纯的米粉作为辅食。</td>
                </tr>

                <tr>
                    <td>水果：</td>
                    <td>推荐选择苹果、梨；不推荐橙子、猕猴桃等。</td>
                </tr>
                <tr>
                    <td>蔬菜：</td>
                    <td>如胡萝卜、马铃薯、青豆、南瓜等。</td>
                </tr><tr>
                    <td>辅食：</td>
                    <td>由1～2勺开始，逐渐加至1餐。</td>
                </tr>

                </tbody>
            </table>
        </div>


        <#--辅食可以食用的食物-->
            <div class="item-title-sport">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/keshiyong.jpg" />
                    添加注意事项
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_sport">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>

                        <th>注意事项</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>

                        <td>1、不要喂得过饱；奶和奶制品是宝宝的主要食品。</td>
                    </tr>
                    <tr>

                        <td>2、观察宝宝的大便。如出现腹泻，表明宝宝发生了消化不良，需要停止添加。如大便中带有未消化的食物，需要降低食物的摄入量或将食物做得更细小一些。</td>
                    </tr>

                    <tr>

                        <td>3、避免将食物混合。不要把多种食物混在一起，以免宝宝发生过敏后，不易找出致敏食物。少盐，不放糖。</td>
                    </tr>
                    <tr>

                        <td>4、按需喂养，可遵医嘱根据实际情况调整。</td>
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
        <#--<td>注意事项:</td>-->
        <#--<td>可根据自己的具体情况调整运动时间，可多次完成</td>-->
        <#--</tr>-->


        <#--</tbody>-->
        <#--</table>-->
        <#--</div>-->
    </div>


    <div class="footer"></div>
</div>
</body>

</html>
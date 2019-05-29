<!DOCTYPE html>
<html>
<head lang="en">
    <title>营养监测分析报告</title>

    <link rel="stylesheet" href="http://localhost:8082/css/bodyComposition.css" />
    <link rel="stylesheet" href="http://localhost:8082/js/echarts.min.js" />

    <style>
        @page {
            size: 210mm 297mm; /*设置纸张大小:A4(210mm 297mm)、A3(297mm 420mm) 横向则反过来*/
            margin: 0.25in;
            padding: 1em;
            @bottom-center{
                content:"康萍科技儿童个体营养监测分析报告";
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
        <img style="width: 60px;height: 60px;margin: 0 0 -20px 0 " src="http://localhost:8082/img/hospital.jpg" />
        <span style="font-size: 35px">XXX医院</span>
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
                    <img width="35px" height="35px" src="http://localhost:8082/img/information.jpg" />
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
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>${information.guardian_phone?c}</td>
                        <td>${information.name}</td>
                        <td>${sex}</td>
                        <td>${information.height}</td>
                        <td>${information.birth?string('yyyy-MM-dd')}</td>
                    </tr>


                    </tbody>
                </table>
            </div>

            <#--体成分检测-->
            <div class="item-title-tcf">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/bodyComposition.jpg" />
                    体成分检测结果
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_tcf">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>身体体成分</th>
                        <th>测量值</th>
                        <th>总体水</th>
                        <th>肌肉量</th>
                        <th>瘦体重</th>
                        <th>体重</th>

                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>细胞内液(kg)</td>
                        <td>19.4</td>
                        <td rowspan="2">34.5</td>
                        <td rowspan="3"></td>
                        <td rowspan="4"></td>
                        <td rowspan="5"></td>
                    </tr>
                    <tr>
                        <td>细胞外液(kg)</td>
                        <td>15.1</td>
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                    </tr>
                    <tr>
                        <td>蛋白质(kg)</td>
                        <td>9.4</td>
                        <td colspan="2">37.36</td>
                    </tr>
                    <tr>
                        <td>无机盐(kg)</td>
                        <td>3.6</td>
                        <td colspan="3">40.76</td>
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                    </tr>
                    <tr>
                        <td>脂肪(kg)</td>
                        <td>12.3</td>
                        <td colspan="4">59.00</td>
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                    </tr>

                    </tbody>
                </table>
            </div>

            <#--身高体重曲线图-->
            <div class="item-title-height">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/heightWeight.jpg" />
                    身高体重曲线图
                </div>
                <div class="title-right"></div>
            </div>
            <div >
                <img style="margin-left: -150px;width:300px;height:450px"  src="http://localhost:8082/img/ImgHeight.jpg" />

            </div>

            <#--膳食结构分析-->
            <div class="item-title-shanshi">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/dietary.jpg" />
                    膳食结构分析
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_shanshi">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>种类</th>
                        <#--<th>推荐摄入量</th>-->
                        <th>实际摄入偏差🔼 ⏬</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>谷类</td>
                        <#--<td>312.5g</td>-->
                        <td>
                            <#--<#if 0>-->

                            <#--<#else>-->
                                <#---->
                            <#--</#if>-->
                            <img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8082/img/downArrow.jpg" />
                        </td>
                    </tr>
                    <tr>
                        <td>蔬菜</td>
                        <#--<td>500g</td>-->
                        <td><img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8082/img/downArrow.jpg" /></td>
                    </tr>
                    <tr>
                        <td>水果</td>
                        <#--<td>300g</td>-->
                        <td><img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8082/img/downArrow.jpg" /></td>
                    </tr>
                    <tr>
                        <td>禽畜</td>
                        <#--<td>75g</td>-->
                        <td><img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8082/img/downArrow.jpg" /></td>
                    </tr>
                    <tr>
                        <td>海产品</td>
                        <#--<td>75g</td>-->
                        <td>正确</td>
                    </tr>
                    <tr>
                        <td>蛋及制品</td>
                        <#--<td>50g</td>-->
                        <td><img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8082/img/downArrow.jpg" /></td>
                    </tr>
                    <tr>
                        <td>奶</td>
                        <#--<td>320g</td>-->
                        <td>正确</td>
                    </tr>
                    <#--<tr>-->
                        <#--<td>豆及制品</td>-->
                        <#--<td>12.5g</td>-->
                        <#--<td>15g</td>-->
                    <#--</tr>-->

                    <tr>
                        <td>坚果</td>
                        <#--<td>15g</td>-->
                        <td>正确</td>
                    </tr>
                    <#--<tr>-->
                        <#--<td>油脂</td>-->
                        <#--<td>20g</td>-->
                        <#--<td>30g</td>-->
                    <#--</tr>-->


                    </tbody>
                </table>
            </div>


            <#--指导方案建议日摄入量-->
            <div class="item-title-dayintake">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/intakeAdvice.jpg" />
                    指导方案建议日摄入量
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_dayintake">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>分类</th>
                        <th>食物量</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>谷类</td>
                        <td>400g</td>
                    </tr>
                    <tr>
                        <td>蔬菜</td>
                        <td>750g</td>
                    </tr>
                    <tr>
                        <td>水果</td>
                        <td>400g</td>
                    </tr>
                    <tr>
                        <td>禽畜</td>
                        <td>75g</td>
                    </tr>
                    <tr>
                        <td>海产品</td>
                        <td>100g</td>
                    </tr>
                    <tr>
                        <td>蛋及制品</td>
                        <td>50g</td>
                    </tr>
                    <tr>
                        <td>奶</td>
                        <td>400g</td>
                    </tr>
                    <tr>
                        <td>豆及制品</td>
                        <td>25g</td>
                    </tr>
                    <tr>
                        <td>坚果</td>
                        <td>15g</td>
                    </tr>
                    <tr>
                        <td>油脂</td>
                        <td>25g</td>
                    </tr>
                    <tr>
                        <td>每日推荐摄入能量</td>
                        <td>2868Kcal</td>
                    </tr>


                    </tbody>
                </table>
            </div>

            <#--餐次举例-->
            <div class="item-title-intake">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/intakeCanci.jpg" />
                    餐次举例
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_intake">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>餐次</th>
                        <th>食物</th>
                        <th>食物量</th>
                        <th>参考举例</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td rowspan="5">早餐</td>
                        <td>谷类</td>
                        <td>90g</td>
                        <td>一个普通大小和一个稍小的馒头|三片较大的全麦吐司</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>蔬菜</td>
                        <td>70g</td>
                        <td>三分之二碗的油菜或菠菜等绿叶菜|半碗的芹菜茎</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>水果</td>
                        <td>80g</td>
                        <td>半个普通大小的去核苹果|5-8个樱桃番茄|5-6颗草莓|一根小型的香蕉</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>蛋类</td>
                        <td>50g</td>
                        <td>一个普通大小的鸡蛋</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>乳制品</td>
                        <td>300g</td>
                        <td>两杯半左右带包装酸奶或牛奶</td>
                    </tr>
                    <tr>
                        <td>加餐</td>
                        <td>水果</td>
                        <td>320g</td>
                        <td>两个普通大小的苹果|两根大香蕉和一根小香蕉或三根半小香蕉|23-24颗草莓|18颗樱桃番茄</td>
                    </tr>
                    <tr>
                        <td rowspan="4">午餐</td>
                        <td>谷类</td>
                        <td>160g</td>
                        <td>一碗+四分之三碗米饭</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>蔬菜</td>
                        <td>250g</td>
                        <td>一碗+三分之二碗绿叶菜</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>禽畜肉类</td>
                        <td>100g</td>
                        <td>超市买到的鸡胸肉的五分之四大小即可</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>烹调油</td>
                        <td>15g</td>
                        <td>一汤勺</td>
                    </tr>
                    <tr>
                        <td>加餐</td>
                        <td>坚果</td>
                        <td>10g</td>
                        <td>10粒去壳杏仁|2个核桃仁|5粒松子仁|3粒腰果|一碟南瓜子仁</td>
                    </tr>
                    <tr>
                        <td rowspan="5">晚餐</td>
                        <td>谷类</td>
                        <td>125g</td>
                        <td>四分之三碗蒸红薯|两个稍大些的馒头</td>
                    </tr>
                    <tr>
                        <#--<td>晚餐</td>-->
                        <td>蔬菜</td>
                        <td>180g</td>
                        <td>9颗手中指长度的小油菜|6片大白菜</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>水产类</td>
                        <td>100g</td>
                        <td>从指根到腕关节部分手掌大小的带鱼段和三个虾仁；八只河虾；十一只基围虾；十个虾仁</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>大豆</td>
                        <td>25g</td>
                        <td>对应豆浆500毫升左右；或豆腐脑10汤勺左右；扁平状的豆腐干一小块；北豆腐或南豆腐一小块</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>烹调油</td>
                        <td>10g</td>
                        <td>三分之二汤勺</td>
                    </tr>
                    <tr>
                        <td></td>
                        <td></td>
                        <td></td>
                        <td>参考工具~碗,直径11公分左右,高5.3公分左右|参考工具~盘子,直径22.7公分左右|参考工具~普通汤勺,15毫升</td>
                    </tr>
                    <tr>
                        <td style="background-color:#eaeaea"></td>
                        <td style="background-color:#eaeaea"></td>
                        <td style="background-color:#eaeaea"></td>
                        <td style="background-color:#eaeaea"></td>
                    </tr>
                    </tbody>
                </table>
            </div>

            <#--运动指导-->
            <div class="item-title-sport">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8082/img/sport.jpg" />
                    运动指导
                </div>
                <div class="title-right"></div>
            </div>

            <div class="table_wrap_sport">
                <table class="table" width="700" cellspacing="0" cellpadding="0">
                    <thead class="table_head">
                    <tr>
                        <th>运动类型</th>
                        <th>活动标准</th>
                    </tr>
                    </thead>
                    <tbody>
                    <tr>
                        <td>做游戏</td>
                        <td>做游戏玩耍40分钟</td>
                    </tr>
                    <tr>
                        <td>工间操+散步</td>
                        <td>工间操30分钟外加散步30分钟</td>
                    </tr>
                    <tr>
                        <td>散步</td>
                        <td>散步60分钟</td>
                    </tr>
                    <tr>
                        <td>游泳</td>
                        <td>游泳40分钟</td>
                    </tr>
                    <tr>
                        <td>瑜伽</td>
                        <td>瑜伽50分钟</td>
                    </tr>
                    <tr>
                        <td>注意事项:</td>
                        <td>可根据自己的具体情况调整运动时间，可多次完成</td>
                    </tr>


                    </tbody>
                </table>
            </div>
        </div>


    <div class="footer"></div>
</div>
</body>

</html>
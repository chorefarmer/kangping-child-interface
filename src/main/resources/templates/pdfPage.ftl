<!DOCTYPE html>
<html>
<head lang="en">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <title>营养监测分析报告(3-18Y)</title>

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

            <#--体成分检测-->
            <div class="item-title-tcf">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/bodyComposition.jpg" />
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
                        <td>${bodyCompositionTest.intracellularFluid}</td><#--细胞內液-->
                        <td rowspan="2">${bodyCompositionTest.totalWater}</td><#--总体水-->
                        <td rowspan="3"></td>
                        <td rowspan="4"></td>
                        <td rowspan="5"></td>
                    </tr>
                    <tr>
                        <td>细胞外液(kg)</td>
                        <td>${bodyCompositionTest.extracellularFluid}</td><#--细胞外液-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                    </tr>
                    <tr>
                        <td>蛋白质(kg)</td>
                        <td>${bodyCompositionTest.protein}</td><#--蛋白质-->
                        <td colspan="2">${bodyCompositionTest.muscle}</td><#--肌肉量-->
                    </tr>
                    <tr>
                        <td>无机盐(kg)</td>
                        <td>${bodyCompositionTest.sclerotin}</td><#--无机盐-->
                        <td colspan="3">${bodyCompositionTest.fatfreeBodyWeight}</td><#--瘦体重-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                        <#--<td></td>-->
                    </tr>
                    <tr>
                        <td>脂肪(kg)</td>
                        <td>${bodyCompositionTest.fat}</td><#--脂肪-->
                        <td colspan="4">${bodyCompositionTest.weight}</td><#--体重-->
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

            <#--膳食结构分析-->
            <div class="item-title-shanshi">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/dietary.jpg" />
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
                            ${StapleFoodIntake}
                            <#--<img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8080/img/downArrow.jpg" />-->
                        </td>
                    </tr>
                    <tr>
                        <td>蔬菜</td>
                        <#--<td>500g</td>-->
                        <td>
                            ${VegetablesIntake}
                            <#--<img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8080/img/downArrow.jpg" />--></td>
                    </tr>
                    <tr>
                        <td>水果</td>
                        <#--<td>300g</td>-->
                        <td>
                            ${FruitsIntake}
                            <#--<img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8080/img/downArrow.jpg" />--></td>
                    </tr>
                    <tr>
                        <td>禽畜</td>
                        <#--<td>75g</td>-->
                        <td>
                            ${livestockGIntake}
                            <#--<img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8080/img/downArrow.jpg" />--></td>
                    </tr>
                    <tr>
                        <td>海产品</td>
                        <#--<td>75g</td>-->
                        <td>${aquaticProductGIntake}</td>
                    </tr>
                    <tr>
                        <td>蛋及制品</td>
                        <td>
                            ${eggGIntake}
                            <#--<img style="line-height: 20px;margin-left: 5px" width="20px" height="20px" src="http://localhost:8080/img/downArrow.jpg" />--></td>
                    </tr>
                    <tr>
                        <td>奶</td>
                        <#--<td>320g</td>-->
                        <td>${milkGIntake}</td>
                    </tr>
                    <#--<tr>-->
                        <#--<td>豆及制品</td>-->
                        <#--<td>12.5g</td>-->
                        <#--<td>15g</td>-->
                    <#--</tr>-->

                    <tr>
                        <td>坚果</td>
                        <#--<td>15g</td>-->
                        <td>${nutGIntake}</td>
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
                    <img width="35px" height="35px" src="http://localhost:8080/img/intakeAdvice.jpg" />
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
                        <td>${dietaryGuide.stapleFoodG}g</td>
                    </tr>
                    <tr>
                        <td>蔬菜</td>
                        <td>${dietaryGuide.vegetablesG}g</td>
                    </tr>
                    <tr>
                        <td>水果</td>
                        <td>${dietaryGuide.fruitsG}g</td>
                    </tr>
                    <tr>
                        <td>禽畜</td>
                        <td>${dietaryGuide.livestockG}g</td>
                    </tr>
                    <tr>
                        <td>海产品</td>
                        <td>${dietaryGuide.aquaticProductG}g</td>
                    </tr>
                    <tr>
                        <td>蛋及制品</td>
                        <td>${dietaryGuide.eggG}g</td>
                    </tr>
                    <tr>
                        <td>奶</td>
                        <td>${dietaryGuide.milkG}g</td>
                    </tr>
                    <tr>
                        <td>豆及制品</td>
                        <td>${dietaryGuide.beanG}g</td>
                    </tr>
                    <tr>
                        <td>坚果</td>
                        <td>${dietaryGuide.nutG}g</td>
                    </tr>
                    <tr>
                        <td>油脂</td>
                        <td>${dietaryGuide.oilG}g</td>
                    </tr>
                    <tr>
                        <td>每日推荐摄入能量</td>
                        <td>${kcal_low?c}Kcal-${kcal_high?c}Kcal</td>
                    </tr>

                    </tbody>
                </table>
            </div>

            <#--餐次举例-->
            <div class="item-title-intake">
                <div class="title-left">
                    <img width="35px" height="35px" src="http://localhost:8080/img/intakeCanci.jpg" />
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
                        <td>${mealTimes.breakfastCerealQuantity}g</td>
                        <td>${mealTimes.examplesOfBreakfastCereals}</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>蔬菜</td>
                        <td>${mealTimes.breakfastVegetablesQuantity}g</td>
                        <td>${mealTimes.examplesOfBreakfastVegetables}</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>水果</td>
                        <td>${mealTimes.breakfastFruitsQuantity}g</td>
                        <td>${mealTimes.examplesOfBreakfastFruits}</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>蛋类</td>
                        <td>${mealTimes.breakfastEggsQuantity}g</td>
                        <td>${mealTimes.examplesOfBreakfastEggs}</td>
                    </tr>
                    <tr>
                        <#--<td>早餐</td>-->
                        <td>乳制品</td>
                        <td>${mealTimes.breakfastMilkQuantity}g</td>
                        <td>${mealTimes.examplesOfBreakfastMilk}</td>
                    </tr>
                    <tr>
                        <td>加餐</td>
                        <td>水果</td>
                        <td>${mealTimes.snacksFruitsQuantity}g</td>
                        <td>${mealTimes.examplesOfSnacksFruits}</td>
                    </tr>
                    <tr>
                        <td rowspan="4">午餐</td>
                        <td>谷类</td>
                        <td>${mealTimes.lunchCerealQuantity}g</td>
                        <td>${mealTimes.examplesOfLunchCereals}</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>蔬菜</td>
                        <td>${mealTimes.lunchVegetablesQuantity}g</td>
                        <td>${mealTimes.examplesOfLunchVegetables}</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>禽畜肉类</td>
                        <td>${mealTimes.lunchMeatQuantity}g</td>
                        <td>${mealTimes.examplesOfLunchMeat}</td>
                    </tr>
                    <tr>
                        <#--<td>午餐</td>-->
                        <td>烹调油</td>
                        <td>${mealTimes.lunchOilQuantity}g</td>
                        <td>${mealTimes.examplesOfLunchOil}</td>
                    </tr>
                    <tr>
                        <td>加餐</td>
                        <td>乳制品</td>
                        <td>${mealTimes.snacksMilkQuantity}g</td>
                        <td>${mealTimes.examplesOfSnacksMilk}</td>
                    </tr>
                    <tr>
                        <td>加餐</td>
                        <td>坚果</td>
                        <td>${mealTimes.snacksNutQuantity}g</td>
                        <td>${mealTimes.examplesOfSnacksNut}</td>
                    </tr>
                    <tr>
                        <td rowspan="5">晚餐</td>
                        <td>谷类</td>
                        <td>${mealTimes.dinnerCerealQuantity}g</td>
                        <td>${mealTimes.examplesOfDinnerCereals}</td>
                    </tr>
                    <tr>
                        <#--<td>晚餐</td>-->
                        <td>蔬菜</td>
                        <td>${mealTimes.dinnerVegetablesQuantity}g</td>
                        <td>${mealTimes.examplesOfDinnerVegetables}</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>水产类</td>
                        <td>${mealTimes.dinnerFisheriesQuantity}g</td>
                        <td>${mealTimes.examplesOfDinnerFisheries}</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>大豆</td>
                        <td>${mealTimes.dinnerSoybeanQuantity}g</td>
                        <td>${mealTimes.examplesOfDinnerSoybean}</td>
                    </tr><tr>
                        <#--<td>晚餐</td>-->
                        <td>烹调油</td>
                        <td>${mealTimes.dinnerOilQuantity}g</td>
                        <td>${mealTimes.examplesOfDinnerOil}</td>
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


        </div>


    <div class="footer"></div>
</div>
</body>

</html>
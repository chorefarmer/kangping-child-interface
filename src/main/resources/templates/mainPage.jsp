<%@page import="com.entity.User"%>
<%@page import="com.entity.Movie"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8" isELIgnored="false"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%
	User u = (User)session.getAttribute("user");
	if(u==null)
		response.sendRedirect("/MovieManager/index.jsp");
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
 	
 	<title>猫眼电影</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	 <base href="<%=basePath%>">
	 
    <link rel="icon" type="image/x-icon" href="img/title.ico"/>
  	<link rel="stylesheet" type="text/css" href="<%=path %>/css/style2.css">
  	<link rel="stylesheet" type="text/css" href="<%=path %>/css/header.css">
  	<link rel="stylesheet" type="text/css" href="<%=path %>/css/main.css">
 	<link rel="stylesheet" type="text/css" href="<%=path %>/css/footer.css">
 	<!--  样式 start-->
 	<link href="css/bootstrap.css" rel='stylesheet' type='text/css' />
	<link href="css/owl.carousel.css" rel='stylesheet' type='text/css' />
	<link href="css/style.css" rel='stylesheet' type='text/css' />
	<link rel="stylesheet" type="text/css" href="css/list.css"/>
	<link rel="stylesheet" type="text/css"  href="css/lanren.css">
	<!--  样式 end-->
	<style>
	  	*{
				margin: 0;
				padding: 0;
		}
		ul{
			list-style: none;
		}
		a{
			text-decoration: none;
		}
		a:active, a:hover {
	    	outline-width: 0;
		}
		img {
	    	border-style: none;
		}
	  	body{
	  	    font-family: Microsoft YaHei,Helvetica,Arial,sans-serif;
		    background-color: #fff;
		    -webkit-font-smoothing: subpixel-antialiased;
	  	}
		input{
			outline:none;
		}
		input[type=search]::-webkit-search-cancel-button{
	    	-webkit-appearance: none;  //此处去掉默认的小×
		}
 		
  </style>
 </head>
  
  <body>

    <div class="header">
    	<div class="header-top">
	  		<div class="header-inner">
	  			<h1>
	  				<a href="javascript:void(0)" class="logo"></a>
	  			</h1>
	  			<div class="nav">
	  				<ul>
	  					<li><a href="/MovieManager/MovieAction">首页</a></li>
	  					<li><a href="/MovieManager/SortMoviesAction?order=boxOffice*boxOfficeUnit">电影</a></li>
	  					<li><a href="javascript:void(0)">影院</a></li>
	  					<li><a href="javascript:void(0)">榜单</a></li>
	  					
	  					<c:if test="${sessionScope.user.role == 1}">
	  						<li><a href="/MovieManager/MovieAction?update=manager">管理</a></li>
	  					</c:if>
	  				</ul>
	  			</div>
	  			<div class="app-download">
	  				
	  			</div>
	  			<div class="user-info">
	  				<div class="user-avatar J-login">
		              <img src="${sessionScope.user.headImg}">
		              <span class="caret"></span>
		              <ul class="user-menu">
		                <li><a href="javascript:void 0">登录</a></li>
		              </ul>
	            	</div>
	  			</div>
	  			<form action="">
	  				<input name="searchMovie" class="search" type="search" maxlength="32" placeholder="找影视剧、影人、影院" autocomplete="off">
	            	<input class="submit" type="submit" value="">
	  			</form>
	  			
	  		</div>
		</div>
  		<div class="banner">
  			<div class="slider">
  				<div class="carousel-content">
					<ul class="carousel">
						<li><img src="./img/pic1.jpg"></li>
						<li><img src="./img/pic2.jpg"></li>
						<li><img src="./img/pic3.jpg"></li>
						<li><img src="./img/pic4.jpg"></li>
						<li><img src="./img/pic5.jpg"></li>
					</ul>
					<ul class="img-index"></ul>
					<div class="carousel-prev"><img src="./img/left1.png"></div>
					<div class="carousel-next"><img src="./img/right1.png"></div>

				</div>
  			</div>
  		</div>
  	</div>
  	<div class="main">
  		<div class="main-inner">
  			<div class="aside">
  				
  				<div class="left">
					<div class="kuang">
						<p>正在热映</p>
					</div>
					<div class="context">
						<p><a>路西法第三季</a></p>
						<p><a>这个警察有点烦第五季</a></p>
						<p><a>傲骨之战第二季</a></p>
						<p><a>辛普森一家第二十九季</a></p>
						<p><a>开心汉堡店第八季</a></p>
						<p><a>真我人生第一季</a></p>
						<p><a>路西法第三季</a></p>
						
					</div>
					<div class="kuang">
						<p>最近连载</p>
					</div>
					<div class="context">
						<p><a>路西法第三季</a></p>
						<p><a>这个警察有点烦第五季</a></p>
						<p><a>傲骨之战第二季</a></p>
						<p><a>辛普森一家第二十九季</a></p>
						<p><a>开心汉堡店第八季</a></p>
						<p><a>真我人生第一季</a></p>
						<p><a>路西法第三季</a></p>
						<p><a>这个警察有点烦第五季</a></p>
						<p><a>傲骨之战第二季</a></p>
						<p><a>小猪佩奇第五季</a></p>
						<p><a>小猪佩奇第五季</a></p>
						<p><a>小猪佩奇第五季</a></p>
						<p><a>小猪佩奇第五季</a></p>
						<p><a>小猪佩奇第五季</a></p>
						<p><a>这个警察有点烦第五季</a></p>
					</div>
				</div>
  				
  				
  			</div>
  			<div class="movie-grid">

  				<div class="panel-header">
				    <span class="panel-more">
				        <a href="/MovieManager/movieList.jsp" class="textcolor_red" data-act="all-playingMovie-click">
				        <span>全部</span>
				        </a>
				        <span class="panel-arrow panel-arrow-red"></span>
				    </span>
				    <span class="panel-title">
				        <span class="textcolor_red">正在热映（19部）</span>
				    </span>
				</div>
				<div class="panel-content">
					<ul class="movie-list">
							<c:forEach var="u" items="${sessionScope.movie}" varStatus="status">
								<c:if test="${status.index<8}">
								<li>
								    <div class="movie-item">
								    	
								    	
								      	<a href="javascript:void(0)" target="_blank" data-act="playingMovie-click" data-val="${u.id}">
								      		<div class="movie-poster">
										        <img src="${u.picture}">
										        <div class="movie-overlay movie-overlay-bg">
										          	<div class="movie-info">
											            <div class="movie-score"><i class="integer">${u.score}</i></div>
											            <div class="movie-title movie-title-padding" title="${u.name}">${u.name}</div>
										        	</div>
									        	</div>
								    		</div>
								      	</a>
										<div class="movie-detail movie-detail-strong movie-sale" style=“margin:0 0 0 80px”>
										  <a href="/MovieManager/FindMovieByIdAction?movieId=${u.id}" class="active" target="_blank" data-act="salePlayingMovie-click" data-val="{movieid:42964}">查看</a>
										</div>
								      	<c:if test="${u.id  == '1'|| u.id  == '2'}">
											<div class="movie-ver"><i class="imax3d"></i></div>
										</c:if>
								    </div>		  
								</li>
								</c:if>
							</c:forEach>
					</ul>
				</div>
				<div class="panel">
					<div class="panel-header">
						<span class="panel-more">
					        <a href="javascript:void(0)" class="textcolor_blue" data-act="all-upcomingMovie-click">
					          <span>全部</span>
					        </a>
				        	<span class="panel-arrow panel-arrow-blue"></span>
				      	</span>
				      	<span class="panel-title">
				        	<span class="textcolor_blue">即将上映（244部）</span>
				      	</span>
					</div>
					<div class="panel-content">
						<ul class="movie-list">
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie2.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									 
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie8.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									  
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie7.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									  
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie6.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									 
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie5.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									  
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie4.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									 
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie3.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
								
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
							<li>
							    <div class="movie-item">
							      	<a href="" target="_blank" data-act="playingMovie-click" data-val="{movieid:42964}">
							      		<div class="movie-poster">
									        <img src="img/movies/movie2.jpg">
									        <div class="movie-overlay movie-overlay-bg">
									          	<div class="movie-info">
										            <div class="movie-score"><i class="integer">7.7</i></div>
										            <div class="movie-title movie-title-padding" title="神奇动物：格林德沃之罪">神奇动物：格林德沃之罪</div>
									        	</div>
								        	</div>
							    		</div>
							      	</a>
							      	<div class="movie-detail movie-wish"><span class="stonefont">200</span>人想看</div>
									<div class="movie-detail movie-detail-strong movie-presale">
									
									</div>
							      	<!-- <div class="movie-ver"><i class="imax3d"></i></div> -->
							    </div>		  
							</li>
						</ul>
					</div>
				</div>
  			</div>
  			
  		</div>
  		
  	</div>
  	<div >
  	<div class="trunk"><div><div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div></div><div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div></div></div><div><div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div></div><div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div><div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div><div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div><div><div><div><div></div><div></div></div><div><div></div><div></div></div></div><div><div><div></div><div></div></div><div><div></div><div></div></div></div></div></div></div></div></div></div>
	
  	
  			</div>
  	<!--  添加动态效果-->
  	<!-- 代码部分begin -->
  	

<!-- 代码部分end -->
  	<!--  -->
  	<!-- footer end-->
  	<div class="footer">
						<div class="container">
							<div class="footer-grids">
								<div class="col-md-3">
									<div class="footer-grid">
										<h5>About musicz</h5>
										<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis lobortis, urna a aliquam rhoncus,</p>
										<p> Ut ultrices diam enim, eget consectetur elit iaculis eu</p>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid f-blog">
										<h5>Form the Blog</h5>
										<div class="f-blog-artical">
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											<span>March 20,2014</span>
										</div>
										<div class="f-blog-artical f-blog-artical1">
											<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											<span>March 20,2014</span>
										</div>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid site-map">
										<h5>导航栏</h5>
										<ul>
											<li><a href="/MovieManager/MovieAction"><span> </span>首页</a></li>
											<li><a href="/MovieManager/MovieAction"><span> </span>中国</a></li>
											<li><a href="/MovieManager/MovieAction"><span> </span>排行榜</a></li>
											<li><a href="/MovieManager/MovieAction"><span> </span>最近更新</a></li>
											<li><a href="/MovieManager/MovieAction"><span> </span>剧集频道</a></li>
										</ul>
									</div>
								</div>
								<div class="col-md-3">
									<div class="footer-grid f-gallery">
										<h5>Form the portfolio</h5>
										<div class="f-gallery-grids">
											<div class="f-gallery-grid">
												<ul>
													<li><a href="/MovieManager/MovieAction"><img src="images/qidao.jpg" title="name"></a></li>
													<li><a href="/MovieManager/MovieAction"><img src="images/qidao2.jpg" title="name"></a></li>
													<li><a href="/MovieManager/MovieAction"><img src="images/qidao3.jpg" title="name"></a></li>
													<li><a href="/MovieManager/MovieAction"><img src="images/rightpic4.jpg" title="name"></a></li>
													<li><a href="/MovieManager/MovieAction"><img src="images/rightpic2.jpg" title="name"></a></li>
													<li><a href="/MovieManager/MovieAction"><img src="images/rightpic3.jpg" title="name"></a></li>
													<div class="clearfix"> 
												</div></ul>
											</div>
										</div>
									</div>
								</div>
								<div class="clearfix"> </div>
							</div>
						</div>
					</div>
		<!-- footer -->
		<!-- copy-right -->
		<div class="copy-right">
			<div class="container">
			</div>
		</div>
  	<!-- footer end -->
  	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="./js/carousel.js"></script>
	<script type="text/javascript">
		$(function(){
			$(".carousel-content").carousel({
				carousel : ".carousel",//轮播图容器
				indexContainer : ".img-index",//下标容器
				prev : ".carousel-prev",//左按钮
				next : ".carousel-next",//右按钮
				timing : 2000,//自动播放间隔
				animateTime : 700,//动画时间
				autoPlay : true,//是否自动播放 true/false
				direction : "left",//滚动方向 right/left
			});

			$(".carousel-content").hover(function(){
				$(".carousel-prev,.carousel-next").fadeIn(300);
			},function(){
				$(".carousel-prev,.carousel-next").fadeOut(300);
			});

			$(".carousel-prev").hover(function(){
				$(this).find("img").attr("src","./img/left2.png");
			},function(){
				$(this).find("img").attr("src","./img/left1.png");
			});
			$(".carousel-next").hover(function(){
				$(this).find("img").attr("src","./img/right2.png");
			},function(){
				$(this).find("img").attr("src","./img/right1.png");
			});
		});
	</script>
  </body>
</html>

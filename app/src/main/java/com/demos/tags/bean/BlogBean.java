package com.demos.tags.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class BlogBean  extends BasePageBean<BlogBean.ResultBean.ItemsBean>{
    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"编辑部的故事","body":"很多开发者在看到自己感兴趣的项目时会使用 Star 功能，可以说 Star ...","commentCount":30,"href":"https://my.oschina.net/editorial-story/blog/1525158","id":1525158,"original":true,"pubDate":"2017-08-28 18:38:13","recommend":true,"title":"GitHub 上最火的开源项目 \u2014\u2014 Java 篇","type":3,"viewCount":16095},{"author":"编辑部的故事","body":"所以，如何写出一手好代码？ 良好的代码更易于阅读、理解、调试和修改，...","commentCount":51,"href":"https://my.oschina.net/editorial-story/blog/1525762","id":1525762,"original":true,"pubDate":"2017-08-29 19:37:40","recommend":true,"title":"30 多年的编码经验浓缩成的 10 条最佳实践","type":3,"viewCount":6699},{"author":"java思维导图","body":"关于缓存 缓存是实际工作中非常常用的一种提高性能的方法。而在java中，...","commentCount":10,"href":"https://my.oschina.net/u/3080373/blog/1524728","id":1524728,"original":true,"pubDate":"2017-08-28 09:02:53","recommend":true,"title":"Spring思维导图，让Spring不再难懂（cache篇）","type":3,"viewCount":5384},{"author":"编辑部的故事","body":"对于系统桌面，有人追求美观，有人追求简洁，有人追求实用，也有人就是喜...","commentCount":24,"href":"https://my.oschina.net/editorial-story/blog/1527138","id":1527138,"original":true,"pubDate":"2017-08-31 18:17:25","recommend":true,"title":"颜值即正义，超好用的 Linux 桌面个性化工具推荐","type":3,"viewCount":4943},{"author":"我是钟钟","body":"原文地址：https://vsavkin.com/writing-angular-2-in-typescript-1fa77...","commentCount":31,"href":"https://my.oschina.net/zhongzhong5/blog/1524807","id":1524807,"original":true,"pubDate":"2017-08-28 11:01:06","recommend":true,"title":"Angular为什么选择TypeScript？","type":3,"viewCount":3309},{"author":"冷冷gg","body":"限流的目的是通过对并发访问/请求进行限速或者一个时间窗口内的的请求进...","commentCount":7,"href":"https://my.oschina.net/giegie/blog/1525931","id":1525931,"original":true,"pubDate":"2017-08-30 09:45:23","recommend":true,"title":"基于Redis实现分布式应用限流","type":3,"viewCount":3533},{"author":"wangkang80","body":"spring boot / cloud (十五) 分布式调度中心进阶 在&lt;spring boot / clou...","commentCount":8,"href":"https://my.oschina.net/wangkang80/blog/1525908","id":1525908,"original":true,"pubDate":"2017-08-30 08:59:30","recommend":true,"title":"spring boot / cloud (十五) 分布式调度中心进阶","type":3,"viewCount":2959},{"author":"神奇Sam","body":"一、HTTPS 服务 为什么需要HTTPS?\n原因：HTTP不安全\n    1、传输数据被中...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1526748","id":1526748,"original":true,"pubDate":"2017-08-31 10:54:45","recommend":false,"title":"Nginx 手记（十四）https 服务","type":3,"viewCount":3875},{"author":"wier","body":"并发处理的广泛应用是使得amdahl定律代替摩尔定律成为计算机性能发展源动...","commentCount":5,"href":"https://my.oschina.net/u/1859679/blog/1517807","id":1517807,"original":true,"pubDate":"2017-08-21 10:08:39","recommend":true,"title":"java 多线程\u2014线程怎么来的?","type":3,"viewCount":3567},{"author":"开源中国码云","body":"码云项目推荐 1、项目名称：OA 平台 JFinalOA 项目简介： 项目主要提供办...","commentCount":3,"href":"https://my.oschina.net/gitosc/blog/1523633","id":1523633,"original":true,"pubDate":"2017-08-25 16:51:06","recommend":true,"title":"【码云周刊第 35 期】漫谈 6 款实用企业应用框架","type":3,"viewCount":2480},{"author":"YM-","body":"Java引用的种类 1.对象在内存中的状态 对于JVM的垃圾回收机制来说，是否...","commentCount":3,"href":"https://my.oschina.net/u/3644566/blog/1525503","id":1525503,"original":false,"pubDate":"2017-08-29 14:12:37","recommend":false,"title":"疯狂Java笔记之Java的内存与回收","type":3,"viewCount":2821},{"author":"王孟君","body":"HashMap也是我们使用非常多的Collection，它是基于哈希表的 Map 接口的实...","commentCount":9,"href":"https://my.oschina.net/wangmengjun/blog/1527300","id":1527300,"original":true,"pubDate":"2017-09-01 02:45:37","recommend":true,"title":"HashMap的实现原理浅析","type":3,"viewCount":2375},{"author":"xrzs","body":"0、背景 经常做后端服务开发的同学，或多或少都遇到过 CPU 负载特别高的...","commentCount":0,"href":"https://my.oschina.net/leejun2005/blog/1524687","id":1524687,"original":true,"pubDate":"2017-08-28 01:38:25","recommend":false,"title":"线上服务 CPU 100%？一键定位 so easy！","type":3,"viewCount":1595},{"author":"编辑部的故事","body":"都说分久必合，合久必分。哎呦，一不留神，Node.js 就被分叉出一个项目 ...","commentCount":8,"href":"https://my.oschina.net/editorial-story/blog/1524098","id":1524098,"original":true,"pubDate":"2017-08-26 08:15:03","recommend":true,"title":"【源资讯 第41期】前端项目一言不合就分叉；工程师一言不合就删库？？","type":3,"viewCount":2679},{"author":"wier","body":"并发处理的广泛应用是使得amdahl定律代替摩尔定律成为计算机性能发展源动...","commentCount":7,"href":"https://my.oschina.net/u/1859679/blog/1525343","id":1525343,"original":true,"pubDate":"2017-08-29 10:22:22","recommend":true,"title":"java多线程-内存模型","type":3,"viewCount":1404},{"author":"我是钟钟","body":"原文地址：https://medium.com/google-developer-experts/angular-advan...","commentCount":3,"href":"https://my.oschina.net/zhongzhong5/blog/1525297","id":1525297,"original":true,"pubDate":"2017-08-29 09:36:34","recommend":true,"title":"Angular高级样式指南（V4+）","type":3,"viewCount":1006},{"author":"神奇Sam","body":"Nginx的rewrite规则 实现url重写以及重定向 场景 URL访问跳转，支持开发...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1526746","id":1526746,"original":true,"pubDate":"2017-08-31 10:52:45","recommend":false,"title":"Nginx 手记（十三）rewrite规则","type":3,"viewCount":1438},{"author":"ksfzhaohui","body":"系列文章 Zookeeper实现参数的集中式管理 JMS实现参数的集中式管理 Redi...","commentCount":0,"href":"https://my.oschina.net/OutOfMemory/blog/1526063","id":1526063,"original":true,"pubDate":"2017-08-30 11:54:18","recommend":true,"title":"Redis实现参数的集中式管理","type":3,"viewCount":2509},{"author":"YM-","body":"关于缓存 缓存是实际工作中非常常用的一种提高性能的方法。而在java中，...","commentCount":0,"href":"https://my.oschina.net/u/3644566/blog/1525078","id":1525078,"original":false,"pubDate":"2017-08-28 16:46:57","recommend":false,"title":"Spring思维导图，让Spring不再难懂","type":3,"viewCount":1007},{"author":"随风溜达的向日葵","body":"什么叫前后端同构？ 为了解决某些问题（比如SEO、提升渲染速度等）react...","commentCount":2,"href":"https://my.oschina.net/chkui/blog/1523410","id":1523410,"original":true,"pubDate":"2017-08-25 11:58:48","recommend":true,"title":"React前后端同构防止重复渲染","type":3,"viewCount":1538}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":20}
     * time : 2017-09-06 23:16:04
     */

    private int code;
    private String message;
    private ResultBean result;
    private String time;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ResultBean getResult() {
        return result;
    }

    public void setResult(ResultBean result) {
        this.result = result;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    @Override
    public List<ResultBean.ItemsBean> getItemDatas() {
        return result.items;
    }

    public static class ResultBean {
        /**
         * items : [{"author":"编辑部的故事","body":"很多开发者在看到自己感兴趣的项目时会使用 Star 功能，可以说 Star ...","commentCount":30,"href":"https://my.oschina.net/editorial-story/blog/1525158","id":1525158,"original":true,"pubDate":"2017-08-28 18:38:13","recommend":true,"title":"GitHub 上最火的开源项目 \u2014\u2014 Java 篇","type":3,"viewCount":16095},{"author":"编辑部的故事","body":"所以，如何写出一手好代码？ 良好的代码更易于阅读、理解、调试和修改，...","commentCount":51,"href":"https://my.oschina.net/editorial-story/blog/1525762","id":1525762,"original":true,"pubDate":"2017-08-29 19:37:40","recommend":true,"title":"30 多年的编码经验浓缩成的 10 条最佳实践","type":3,"viewCount":6699},{"author":"java思维导图","body":"关于缓存 缓存是实际工作中非常常用的一种提高性能的方法。而在java中，...","commentCount":10,"href":"https://my.oschina.net/u/3080373/blog/1524728","id":1524728,"original":true,"pubDate":"2017-08-28 09:02:53","recommend":true,"title":"Spring思维导图，让Spring不再难懂（cache篇）","type":3,"viewCount":5384},{"author":"编辑部的故事","body":"对于系统桌面，有人追求美观，有人追求简洁，有人追求实用，也有人就是喜...","commentCount":24,"href":"https://my.oschina.net/editorial-story/blog/1527138","id":1527138,"original":true,"pubDate":"2017-08-31 18:17:25","recommend":true,"title":"颜值即正义，超好用的 Linux 桌面个性化工具推荐","type":3,"viewCount":4943},{"author":"我是钟钟","body":"原文地址：https://vsavkin.com/writing-angular-2-in-typescript-1fa77...","commentCount":31,"href":"https://my.oschina.net/zhongzhong5/blog/1524807","id":1524807,"original":true,"pubDate":"2017-08-28 11:01:06","recommend":true,"title":"Angular为什么选择TypeScript？","type":3,"viewCount":3309},{"author":"冷冷gg","body":"限流的目的是通过对并发访问/请求进行限速或者一个时间窗口内的的请求进...","commentCount":7,"href":"https://my.oschina.net/giegie/blog/1525931","id":1525931,"original":true,"pubDate":"2017-08-30 09:45:23","recommend":true,"title":"基于Redis实现分布式应用限流","type":3,"viewCount":3533},{"author":"wangkang80","body":"spring boot / cloud (十五) 分布式调度中心进阶 在&lt;spring boot / clou...","commentCount":8,"href":"https://my.oschina.net/wangkang80/blog/1525908","id":1525908,"original":true,"pubDate":"2017-08-30 08:59:30","recommend":true,"title":"spring boot / cloud (十五) 分布式调度中心进阶","type":3,"viewCount":2959},{"author":"神奇Sam","body":"一、HTTPS 服务 为什么需要HTTPS?\n原因：HTTP不安全\n    1、传输数据被中...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1526748","id":1526748,"original":true,"pubDate":"2017-08-31 10:54:45","recommend":false,"title":"Nginx 手记（十四）https 服务","type":3,"viewCount":3875},{"author":"wier","body":"并发处理的广泛应用是使得amdahl定律代替摩尔定律成为计算机性能发展源动...","commentCount":5,"href":"https://my.oschina.net/u/1859679/blog/1517807","id":1517807,"original":true,"pubDate":"2017-08-21 10:08:39","recommend":true,"title":"java 多线程\u2014线程怎么来的?","type":3,"viewCount":3567},{"author":"开源中国码云","body":"码云项目推荐 1、项目名称：OA 平台 JFinalOA 项目简介： 项目主要提供办...","commentCount":3,"href":"https://my.oschina.net/gitosc/blog/1523633","id":1523633,"original":true,"pubDate":"2017-08-25 16:51:06","recommend":true,"title":"【码云周刊第 35 期】漫谈 6 款实用企业应用框架","type":3,"viewCount":2480},{"author":"YM-","body":"Java引用的种类 1.对象在内存中的状态 对于JVM的垃圾回收机制来说，是否...","commentCount":3,"href":"https://my.oschina.net/u/3644566/blog/1525503","id":1525503,"original":false,"pubDate":"2017-08-29 14:12:37","recommend":false,"title":"疯狂Java笔记之Java的内存与回收","type":3,"viewCount":2821},{"author":"王孟君","body":"HashMap也是我们使用非常多的Collection，它是基于哈希表的 Map 接口的实...","commentCount":9,"href":"https://my.oschina.net/wangmengjun/blog/1527300","id":1527300,"original":true,"pubDate":"2017-09-01 02:45:37","recommend":true,"title":"HashMap的实现原理浅析","type":3,"viewCount":2375},{"author":"xrzs","body":"0、背景 经常做后端服务开发的同学，或多或少都遇到过 CPU 负载特别高的...","commentCount":0,"href":"https://my.oschina.net/leejun2005/blog/1524687","id":1524687,"original":true,"pubDate":"2017-08-28 01:38:25","recommend":false,"title":"线上服务 CPU 100%？一键定位 so easy！","type":3,"viewCount":1595},{"author":"编辑部的故事","body":"都说分久必合，合久必分。哎呦，一不留神，Node.js 就被分叉出一个项目 ...","commentCount":8,"href":"https://my.oschina.net/editorial-story/blog/1524098","id":1524098,"original":true,"pubDate":"2017-08-26 08:15:03","recommend":true,"title":"【源资讯 第41期】前端项目一言不合就分叉；工程师一言不合就删库？？","type":3,"viewCount":2679},{"author":"wier","body":"并发处理的广泛应用是使得amdahl定律代替摩尔定律成为计算机性能发展源动...","commentCount":7,"href":"https://my.oschina.net/u/1859679/blog/1525343","id":1525343,"original":true,"pubDate":"2017-08-29 10:22:22","recommend":true,"title":"java多线程-内存模型","type":3,"viewCount":1404},{"author":"我是钟钟","body":"原文地址：https://medium.com/google-developer-experts/angular-advan...","commentCount":3,"href":"https://my.oschina.net/zhongzhong5/blog/1525297","id":1525297,"original":true,"pubDate":"2017-08-29 09:36:34","recommend":true,"title":"Angular高级样式指南（V4+）","type":3,"viewCount":1006},{"author":"神奇Sam","body":"Nginx的rewrite规则 实现url重写以及重定向 场景 URL访问跳转，支持开发...","commentCount":0,"href":"https://my.oschina.net/magicalSam/blog/1526746","id":1526746,"original":true,"pubDate":"2017-08-31 10:52:45","recommend":false,"title":"Nginx 手记（十三）rewrite规则","type":3,"viewCount":1438},{"author":"ksfzhaohui","body":"系列文章 Zookeeper实现参数的集中式管理 JMS实现参数的集中式管理 Redi...","commentCount":0,"href":"https://my.oschina.net/OutOfMemory/blog/1526063","id":1526063,"original":true,"pubDate":"2017-08-30 11:54:18","recommend":true,"title":"Redis实现参数的集中式管理","type":3,"viewCount":2509},{"author":"YM-","body":"关于缓存 缓存是实际工作中非常常用的一种提高性能的方法。而在java中，...","commentCount":0,"href":"https://my.oschina.net/u/3644566/blog/1525078","id":1525078,"original":false,"pubDate":"2017-08-28 16:46:57","recommend":false,"title":"Spring思维导图，让Spring不再难懂","type":3,"viewCount":1007},{"author":"随风溜达的向日葵","body":"什么叫前后端同构？ 为了解决某些问题（比如SEO、提升渲染速度等）react...","commentCount":2,"href":"https://my.oschina.net/chkui/blog/1523410","id":1523410,"original":true,"pubDate":"2017-08-25 11:58:48","recommend":true,"title":"React前后端同构防止重复渲染","type":3,"viewCount":1538}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 20
         */

        private String nextPageToken;
        private String prevPageToken;
        private int requestCount;
        private int responseCount;
        private int totalResults;
        private List<ItemsBean> items;

        public String getNextPageToken() {
            return nextPageToken;
        }

        public void setNextPageToken(String nextPageToken) {
            this.nextPageToken = nextPageToken;
        }

        public String getPrevPageToken() {
            return prevPageToken;
        }

        public void setPrevPageToken(String prevPageToken) {
            this.prevPageToken = prevPageToken;
        }

        public int getRequestCount() {
            return requestCount;
        }

        public void setRequestCount(int requestCount) {
            this.requestCount = requestCount;
        }

        public int getResponseCount() {
            return responseCount;
        }

        public void setResponseCount(int responseCount) {
            this.responseCount = responseCount;
        }

        public int getTotalResults() {
            return totalResults;
        }

        public void setTotalResults(int totalResults) {
            this.totalResults = totalResults;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean {
            /**
             * author : 编辑部的故事
             * body : 很多开发者在看到自己感兴趣的项目时会使用 Star 功能，可以说 Star ...
             * commentCount : 30
             * href : https://my.oschina.net/editorial-story/blog/1525158
             * id : 1525158
             * original : true
             * pubDate : 2017-08-28 18:38:13
             * recommend : true
             * title : GitHub 上最火的开源项目 —— Java 篇
             * type : 3
             * viewCount : 16095
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
            private boolean original;
            private String pubDate;
            private boolean recommend;
            private String title;
            private int type;
            private int viewCount;

            public String getAuthor() {
                return author;
            }

            public void setAuthor(String author) {
                this.author = author;
            }

            public String getBody() {
                return body;
            }

            public void setBody(String body) {
                this.body = body;
            }

            public int getCommentCount() {
                return commentCount;
            }

            public void setCommentCount(int commentCount) {
                this.commentCount = commentCount;
            }

            public String getHref() {
                return href;
            }

            public void setHref(String href) {
                this.href = href;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public boolean isOriginal() {
                return original;
            }

            public void setOriginal(boolean original) {
                this.original = original;
            }

            public String getPubDate() {
                return pubDate;
            }

            public void setPubDate(String pubDate) {
                this.pubDate = pubDate;
            }

            public boolean isRecommend() {
                return recommend;
            }

            public void setRecommend(boolean recommend) {
                this.recommend = recommend;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getViewCount() {
                return viewCount;
            }

            public void setViewCount(int viewCount) {
                this.viewCount = viewCount;
            }
        }
    }
}

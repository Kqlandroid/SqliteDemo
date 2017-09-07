package com.demos.tags.bean;

import org.itheima.recycler.bean.BasePageBean;

import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */

public class NewsBean extends BasePageBean<NewsBean.ResultBean.ItemsBean>{
    /**
     * code : 1
     * message : success
     * result : {"items":[{"author":"八一菜刀","body":"swagger-bootstrap-ui 1.6 发布了。swagger-bootstrap-ui 是 Swagger 的前端 UI 实现，目的是替换 Swagger 默认的 UI 实现 Swagger-UI，使文档更友...","commentCount":12,"href":"https://www.oschina.net/news/88444/swagger-bootstrap-ui-1-6","id":88444,"pubDate":"2017-09-06 15:22:02","recommend":true,"title":"swagger-bootstrap-ui 1.6 发布，前端 UI 实现","type":6,"viewCount":903},{"author":"狮子的魂","body":"Jcseg是基于mmseg算法的一个轻量级中文分词器，同时集成了关键字提取，关键短语提取，关键句子提取和文章自动摘要等功能，并且提供了一个基于Jetty...","commentCount":9,"href":"https://www.oschina.net/news/88443/jcseg-2-2-0","id":88443,"pubDate":"2017-09-06 14:03:08","recommend":true,"title":"Jcseg 2.2.0 发布，Java 轻量级开源自然语言处理包","type":6,"viewCount":673},{"author":"javazj","body":"微信小程序商城更新最新版 v1.5.0，主要改进内容包括： 1、修复在安卓机型中，首页的商品分类导航和优惠券部分不能横向滚动bug【感谢 @binghx 贡献...","commentCount":3,"href":"https://www.oschina.net/news/88442/wechat-app-mall-1-5-0","id":88442,"pubDate":"2017-09-06 13:35:43","recommend":true,"title":"微信小程序商城更新最新版 v1.5.0","type":6,"viewCount":1073},{"author":"medz","body":"ThinkSNS+ 简介 ThinkSNS+ 是基于 Laravel 开发的一个用户生态基础框架系统，支持动态拓展应用的接入和UI规范设计。 新增功能： 问答拓展 签到拓展...","commentCount":13,"href":"https://www.oschina.net/news/88440/thinksns-plus-1-0-0-alpha6","id":88440,"pubDate":"2017-09-06 11:13:37","recommend":true,"title":"ThinkSNS Plus 1.0.0-alpha.6 发布，基于 Laravel","type":6,"viewCount":510},{"author":"JaveyZ","body":"Intact是一个充分利用继承思想开发前端页面的框架，秉承了数据驱动来简单高效地更新界面的同时，又充分利用组合和继承来实现代码的复用。 Intact将...","commentCount":3,"href":"https://www.oschina.net/news/88439/intact-2-0","id":88439,"pubDate":"2017-09-06 10:59:57","recommend":true,"title":"可继承的前端开发框架 Intact v2.0 发布","type":6,"viewCount":914},{"author":"三生石上","body":"FineUI（专业版）v3.7.0.0 已发，这已经是自 2014 年以来的第 26 个版本，3 年来精雕细琢，只为你来！ 更新记录： +问题修正\r\n\t-修正初始没有选项卡...","commentCount":1,"href":"https://www.oschina.net/news/88438/fineui-3-7-0","id":88438,"pubDate":"2017-09-06 10:46:27","recommend":false,"title":"FineUI（专业版）v3.7.0 发布，ASP.NET UI 控件库","type":6,"viewCount":121},{"author":"两味真火","body":"经历了\u201c996\u201d摇一摇，前四十位集齐\u201c开源已九\u201d四个字的幸运用户已经揭晓\u2026\u2026","commentCount":42,"href":"https://www.oschina.net/question/2894582_2265601","id":2265601,"pubDate":"2017-09-06 08:37:55","recommend":false,"title":"\u201c摇一摇\u201d获奖名单出炉，没上榜的你还有最后一个获奖机会","type":2,"viewCount":628},{"author":"王练","body":"OSCHINA 本期高手问答（2017 年 9 月 6 日 \u2014 9 月 12 日）我们请来了黄勇老师@hy1984427 和大家一起探讨 Web 开发中测试的种种问题。...","commentCount":18,"href":"https://www.oschina.net/question/2720166_2265590","id":2265590,"pubDate":"2017-09-06 08:35:37","recommend":false,"title":"高手问答第 169 期 \u2014\u2014 聊聊 Web 测试中的那些囧事","type":2,"viewCount":974},{"author":"王练","body":"转眼到了九月，伴随着赵雷\u201c在成都的街头走一走，走到玉林路的尽头，坐在小酒馆的门口\u201d的歌声，OSC 源创会又将和成都重庆的小伙伴们来一场重逢。","commentCount":0,"href":"https://www.oschina.net/news/88367/oschina-september-yuanchuanghui","id":88432,"pubDate":"2017-09-06 08:29:21","recommend":false,"title":"9 月成都重庆源创会，分析千人业务团队的微服务血泪史","type":0,"viewCount":52},{"author":"王练","body":"综艺届互怼可以说是家常便饭，为了曝光增什么样的奇招都不足怪！但是综艺界掐架能引起程序员技术宅的大量关注，那就有点意思了！故事还得从一档音乐...","commentCount":19,"href":"https://www.oschina.net/news/88431/ali-yunqi-ai","id":88431,"pubDate":"2017-09-06 08:27:18","recommend":false,"title":"薛之谦怒撕虚拟偶像，程序员的关注点可不在这里","type":6,"viewCount":2549},{"author":"王练","body":"现在学习 JavaScript 和 Web 开发的人很多，他们都希望能凭此获得一份工作。然而，自学常常会使学习者对 JavaScript 语言本身的理解存在知识盲点。...","commentCount":6,"href":"https://my.oschina.net/editorial-story/blog/1529543","id":1529543,"pubDate":"2017-09-06 08:25:33","recommend":false,"title":"不仅仅是面试，JavaScript 开发者都应该知道的十个概念","type":3,"viewCount":2197},{"author":"王练","body":"AvocadoDB是具有灵活的数据模型 原生支持restful-api 文档、图表和k/v多结构的开源数据库。 使用Aql构建高性能应用程序 方便的sql查询语言或JavaS...","commentCount":0,"href":"https://gitee.com/zhenruyan/avocadodb","id":88429,"pubDate":"2017-09-06 08:24:25","recommend":false,"title":"码云推荐 | 本地化多模型 NoSQL 数据库 AvocadoDB","type":0,"viewCount":15},{"author":"王练","body":"在Spring引入Java Config机制之后，我们会越来越多的使用@Configuration来注册Bean，并且Spring Boot更广泛地使用了这一机制，其提供的大量Auto Co...","commentCount":1,"href":"https://my.oschina.net/sqq/blog/1529030","id":1529030,"pubDate":"2017-09-06 08:23:04","recommend":false,"title":"每日一博 | Spring、Spring Boot 和 TestNG 测试指南","type":3,"viewCount":1367},{"author":"王练","body":"PySC2 是 DeepMind 开源的 \u201c星际争霸II学习环境\u201d（SC2LE）的 Python 组件，允许研究者较容易地使用暴雪的 feature-layer API 和自己的智能体。...","commentCount":2,"href":"https://www.oschina.net/p/pysc2","id":45905,"pubDate":"2017-09-06 08:20:48","recommend":false,"title":"PySC2 \u2014\u2014 星际争霸II学习环境 Python 组件","type":1,"viewCount":1599},{"author":"王练","body":"做了程序员我花了一年时间从一个143斤4块腹肌的瘦子成功转型到一个156斤憨实体型的虚胖，有没有比我还惨的？","commentCount":38,"href":"https://my.oschina.net/xxiaobian/blog/1529675","id":1529675,"pubDate":"2017-09-06 08:19:50","recommend":false,"title":"OSChina 周三乱弹 \u2014\u2014小萝卜变蘑菇大法","type":3,"viewCount":3090},{"author":"王练","body":"不管什么时候，都会有一些预测 Java 覆灭的帖子出现。但有趣的是，这些帖子从不写预言成真的日期。说实话，它们说的都算正确，因为这是每一种语言的...","commentCount":6,"href":"https://www.oschina.net/translate/the-rise-and-fall-of-jvm-languages","id":10003978,"pubDate":"2017-09-06 08:18:48","recommend":false,"title":"协作翻译 | JVM 语言的兴衰史","type":4,"viewCount":1031},{"author":"王练","body":"根据美国网络分析公司 Net Applications 最新数据显示，微软 Edge 和 Internet Explorer 浏览器市场份额继续走低。上个月，两个应用合计市场份额下...","commentCount":11,"href":"https://www.oschina.net/news/88424/edge-and-internetexplorer-trend","id":88424,"pubDate":"2017-09-06 08:17:41","recommend":false,"title":"微软 Edge 和 IE 浏览器面临窘境，市场份额持续走低","type":6,"viewCount":778},{"author":"王练","body":"由于近年来虚拟个人助理的迅猛发展和深度学习算法的运用所带来的字词识别准确率的飞跃，自动语音识别 (ASR) 已经得到广泛的采用。许多语音识别团队...","commentCount":3,"href":"https://www.oschina.net/news/88423/kaldi-tensorflow","id":88423,"pubDate":"2017-09-06 08:16:05","recommend":false,"title":"Kaldi 集成 TensorFlow，两个开源社区要一起玩耍了","type":6,"viewCount":623},{"author":"王练","body":"Opera 的联合创始人谭咏文（Jon Stephenson von Tetzchner）通过官方博客公开呼吁 Google 不要作恶。不作恶曾经是 Google 的信条，但最近改成了\u201c...","commentCount":11,"href":"https://www.oschina.net/news/88422/google-return-to-not-being-evil","id":88422,"pubDate":"2017-09-06 08:15:20","recommend":false,"title":"Opera 联合创始人谭咏文呼吁 Google 不要作恶","type":6,"viewCount":1276},{"author":"局长","body":"Nginx 1.13.5 已发布，该版本是 mainline 版，即通常说的开发版。本次更新主要是修复了 bug，以及添加了一个新特性，详细如下： 功能： $ssl_clien...","commentCount":9,"href":"https://www.oschina.net/news/88421/nginx-1-13-5","id":88421,"pubDate":"2017-09-06 08:10:05","recommend":false,"title":"Nginx 开发版 1.13.5 发布，Bug 修复版本","type":6,"viewCount":1484}],"nextPageToken":"DBA816934CD0AA59","prevPageToken":"0997C855C600E421","requestCount":20,"responseCount":20,"totalResults":81266}
     * time : 2017-09-06 21:27:23
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
    public List getItemDatas() {
        return result.items;
    }

    public static class ResultBean {
        /**
         * items : [{"author":"八一菜刀","body":"swagger-bootstrap-ui 1.6 发布了。swagger-bootstrap-ui 是 Swagger 的前端 UI 实现，目的是替换 Swagger 默认的 UI 实现 Swagger-UI，使文档更友...","commentCount":12,"href":"https://www.oschina.net/news/88444/swagger-bootstrap-ui-1-6","id":88444,"pubDate":"2017-09-06 15:22:02","recommend":true,"title":"swagger-bootstrap-ui 1.6 发布，前端 UI 实现","type":6,"viewCount":903},{"author":"狮子的魂","body":"Jcseg是基于mmseg算法的一个轻量级中文分词器，同时集成了关键字提取，关键短语提取，关键句子提取和文章自动摘要等功能，并且提供了一个基于Jetty...","commentCount":9,"href":"https://www.oschina.net/news/88443/jcseg-2-2-0","id":88443,"pubDate":"2017-09-06 14:03:08","recommend":true,"title":"Jcseg 2.2.0 发布，Java 轻量级开源自然语言处理包","type":6,"viewCount":673},{"author":"javazj","body":"微信小程序商城更新最新版 v1.5.0，主要改进内容包括： 1、修复在安卓机型中，首页的商品分类导航和优惠券部分不能横向滚动bug【感谢 @binghx 贡献...","commentCount":3,"href":"https://www.oschina.net/news/88442/wechat-app-mall-1-5-0","id":88442,"pubDate":"2017-09-06 13:35:43","recommend":true,"title":"微信小程序商城更新最新版 v1.5.0","type":6,"viewCount":1073},{"author":"medz","body":"ThinkSNS+ 简介 ThinkSNS+ 是基于 Laravel 开发的一个用户生态基础框架系统，支持动态拓展应用的接入和UI规范设计。 新增功能： 问答拓展 签到拓展...","commentCount":13,"href":"https://www.oschina.net/news/88440/thinksns-plus-1-0-0-alpha6","id":88440,"pubDate":"2017-09-06 11:13:37","recommend":true,"title":"ThinkSNS Plus 1.0.0-alpha.6 发布，基于 Laravel","type":6,"viewCount":510},{"author":"JaveyZ","body":"Intact是一个充分利用继承思想开发前端页面的框架，秉承了数据驱动来简单高效地更新界面的同时，又充分利用组合和继承来实现代码的复用。 Intact将...","commentCount":3,"href":"https://www.oschina.net/news/88439/intact-2-0","id":88439,"pubDate":"2017-09-06 10:59:57","recommend":true,"title":"可继承的前端开发框架 Intact v2.0 发布","type":6,"viewCount":914},{"author":"三生石上","body":"FineUI（专业版）v3.7.0.0 已发，这已经是自 2014 年以来的第 26 个版本，3 年来精雕细琢，只为你来！ 更新记录： +问题修正\r\n\t-修正初始没有选项卡...","commentCount":1,"href":"https://www.oschina.net/news/88438/fineui-3-7-0","id":88438,"pubDate":"2017-09-06 10:46:27","recommend":false,"title":"FineUI（专业版）v3.7.0 发布，ASP.NET UI 控件库","type":6,"viewCount":121},{"author":"两味真火","body":"经历了\u201c996\u201d摇一摇，前四十位集齐\u201c开源已九\u201d四个字的幸运用户已经揭晓\u2026\u2026","commentCount":42,"href":"https://www.oschina.net/question/2894582_2265601","id":2265601,"pubDate":"2017-09-06 08:37:55","recommend":false,"title":"\u201c摇一摇\u201d获奖名单出炉，没上榜的你还有最后一个获奖机会","type":2,"viewCount":628},{"author":"王练","body":"OSCHINA 本期高手问答（2017 年 9 月 6 日 \u2014 9 月 12 日）我们请来了黄勇老师@hy1984427 和大家一起探讨 Web 开发中测试的种种问题。...","commentCount":18,"href":"https://www.oschina.net/question/2720166_2265590","id":2265590,"pubDate":"2017-09-06 08:35:37","recommend":false,"title":"高手问答第 169 期 \u2014\u2014 聊聊 Web 测试中的那些囧事","type":2,"viewCount":974},{"author":"王练","body":"转眼到了九月，伴随着赵雷\u201c在成都的街头走一走，走到玉林路的尽头，坐在小酒馆的门口\u201d的歌声，OSC 源创会又将和成都重庆的小伙伴们来一场重逢。","commentCount":0,"href":"https://www.oschina.net/news/88367/oschina-september-yuanchuanghui","id":88432,"pubDate":"2017-09-06 08:29:21","recommend":false,"title":"9 月成都重庆源创会，分析千人业务团队的微服务血泪史","type":0,"viewCount":52},{"author":"王练","body":"综艺届互怼可以说是家常便饭，为了曝光增什么样的奇招都不足怪！但是综艺界掐架能引起程序员技术宅的大量关注，那就有点意思了！故事还得从一档音乐...","commentCount":19,"href":"https://www.oschina.net/news/88431/ali-yunqi-ai","id":88431,"pubDate":"2017-09-06 08:27:18","recommend":false,"title":"薛之谦怒撕虚拟偶像，程序员的关注点可不在这里","type":6,"viewCount":2549},{"author":"王练","body":"现在学习 JavaScript 和 Web 开发的人很多，他们都希望能凭此获得一份工作。然而，自学常常会使学习者对 JavaScript 语言本身的理解存在知识盲点。...","commentCount":6,"href":"https://my.oschina.net/editorial-story/blog/1529543","id":1529543,"pubDate":"2017-09-06 08:25:33","recommend":false,"title":"不仅仅是面试，JavaScript 开发者都应该知道的十个概念","type":3,"viewCount":2197},{"author":"王练","body":"AvocadoDB是具有灵活的数据模型 原生支持restful-api 文档、图表和k/v多结构的开源数据库。 使用Aql构建高性能应用程序 方便的sql查询语言或JavaS...","commentCount":0,"href":"https://gitee.com/zhenruyan/avocadodb","id":88429,"pubDate":"2017-09-06 08:24:25","recommend":false,"title":"码云推荐 | 本地化多模型 NoSQL 数据库 AvocadoDB","type":0,"viewCount":15},{"author":"王练","body":"在Spring引入Java Config机制之后，我们会越来越多的使用@Configuration来注册Bean，并且Spring Boot更广泛地使用了这一机制，其提供的大量Auto Co...","commentCount":1,"href":"https://my.oschina.net/sqq/blog/1529030","id":1529030,"pubDate":"2017-09-06 08:23:04","recommend":false,"title":"每日一博 | Spring、Spring Boot 和 TestNG 测试指南","type":3,"viewCount":1367},{"author":"王练","body":"PySC2 是 DeepMind 开源的 \u201c星际争霸II学习环境\u201d（SC2LE）的 Python 组件，允许研究者较容易地使用暴雪的 feature-layer API 和自己的智能体。...","commentCount":2,"href":"https://www.oschina.net/p/pysc2","id":45905,"pubDate":"2017-09-06 08:20:48","recommend":false,"title":"PySC2 \u2014\u2014 星际争霸II学习环境 Python 组件","type":1,"viewCount":1599},{"author":"王练","body":"做了程序员我花了一年时间从一个143斤4块腹肌的瘦子成功转型到一个156斤憨实体型的虚胖，有没有比我还惨的？","commentCount":38,"href":"https://my.oschina.net/xxiaobian/blog/1529675","id":1529675,"pubDate":"2017-09-06 08:19:50","recommend":false,"title":"OSChina 周三乱弹 \u2014\u2014小萝卜变蘑菇大法","type":3,"viewCount":3090},{"author":"王练","body":"不管什么时候，都会有一些预测 Java 覆灭的帖子出现。但有趣的是，这些帖子从不写预言成真的日期。说实话，它们说的都算正确，因为这是每一种语言的...","commentCount":6,"href":"https://www.oschina.net/translate/the-rise-and-fall-of-jvm-languages","id":10003978,"pubDate":"2017-09-06 08:18:48","recommend":false,"title":"协作翻译 | JVM 语言的兴衰史","type":4,"viewCount":1031},{"author":"王练","body":"根据美国网络分析公司 Net Applications 最新数据显示，微软 Edge 和 Internet Explorer 浏览器市场份额继续走低。上个月，两个应用合计市场份额下...","commentCount":11,"href":"https://www.oschina.net/news/88424/edge-and-internetexplorer-trend","id":88424,"pubDate":"2017-09-06 08:17:41","recommend":false,"title":"微软 Edge 和 IE 浏览器面临窘境，市场份额持续走低","type":6,"viewCount":778},{"author":"王练","body":"由于近年来虚拟个人助理的迅猛发展和深度学习算法的运用所带来的字词识别准确率的飞跃，自动语音识别 (ASR) 已经得到广泛的采用。许多语音识别团队...","commentCount":3,"href":"https://www.oschina.net/news/88423/kaldi-tensorflow","id":88423,"pubDate":"2017-09-06 08:16:05","recommend":false,"title":"Kaldi 集成 TensorFlow，两个开源社区要一起玩耍了","type":6,"viewCount":623},{"author":"王练","body":"Opera 的联合创始人谭咏文（Jon Stephenson von Tetzchner）通过官方博客公开呼吁 Google 不要作恶。不作恶曾经是 Google 的信条，但最近改成了\u201c...","commentCount":11,"href":"https://www.oschina.net/news/88422/google-return-to-not-being-evil","id":88422,"pubDate":"2017-09-06 08:15:20","recommend":false,"title":"Opera 联合创始人谭咏文呼吁 Google 不要作恶","type":6,"viewCount":1276},{"author":"局长","body":"Nginx 1.13.5 已发布，该版本是 mainline 版，即通常说的开发版。本次更新主要是修复了 bug，以及添加了一个新特性，详细如下： 功能： $ssl_clien...","commentCount":9,"href":"https://www.oschina.net/news/88421/nginx-1-13-5","id":88421,"pubDate":"2017-09-06 08:10:05","recommend":false,"title":"Nginx 开发版 1.13.5 发布，Bug 修复版本","type":6,"viewCount":1484}]
         * nextPageToken : DBA816934CD0AA59
         * prevPageToken : 0997C855C600E421
         * requestCount : 20
         * responseCount : 20
         * totalResults : 81266
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
             * author : 八一菜刀
             * body : swagger-bootstrap-ui 1.6 发布了。swagger-bootstrap-ui 是 Swagger 的前端 UI 实现，目的是替换 Swagger 默认的 UI 实现 Swagger-UI，使文档更友...
             * commentCount : 12
             * href : https://www.oschina.net/news/88444/swagger-bootstrap-ui-1-6
             * id : 88444
             * pubDate : 2017-09-06 15:22:02
             * recommend : true
             * title : swagger-bootstrap-ui 1.6 发布，前端 UI 实现
             * type : 6
             * viewCount : 903
             */

            private String author;
            private String body;
            private int commentCount;
            private String href;
            private int id;
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

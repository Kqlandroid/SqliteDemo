package com.demos.tags.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class User {
    //   <user>
//                                                                 <uid>861587</uid>
//                                                                 <location><![CDATA[北京 东城]]></location>
//                                                                 <name><![CDATA[九洲北研]]></name>
//                                                                 <followers>9</followers>
//                                                                 <fans>19</fans>
//                                                                 <score>12</score>
//
//<portrait>https://static.oschina.net/uploads/user/430/861587_10
//            0.jpg?t=1417777230000</portrait>
//                                                                 <favoritecount>35</favoritecount>
//                                                                 <gender>1</gender>
//                                                               </user>
    @XStreamAlias("uid")
    public String uid;
    @XStreamAlias("location")
    public String location;
    @XStreamAlias("name")
    public String name;
    @XStreamAlias("followers")
    public String followers;
    @XStreamAlias("fans")
    public String fans;
    @XStreamAlias("score")
    public String score;
    @XStreamAlias("favoritecount")
    public String favoritecount;
    @XStreamAlias("gender")
    public String gender;
}

package com.demos.tags.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2017/9/7 0007.
 */
@XStreamAlias("oschina")
public class MyInfo {
    @XStreamAlias("result")
    public Result result;
    @XStreamAlias("user")
    public User user;
    @XStreamAlias("notice")
    public Notice notice;
}

package com.demos.tags.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class Result {
    //    	<result>
//         <errorCode>1</errorCode>
//        <errorMessage><![CDATA[登录成功]]></c>
//        </result>
    @XStreamAlias("errorCode")
    public String errorCode;
    @XStreamAlias("errorMessage")
    private   String errorMessage;
}

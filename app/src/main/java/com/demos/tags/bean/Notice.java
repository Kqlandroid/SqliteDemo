package com.demos.tags.bean;

import com.thoughtworks.xstream.annotations.XStreamAlias;

/**
 * Created by Administrator on 2017/9/7 0007.
 */

public class Notice {
    //      <notice>
//                                                             	<atmeCount>0</atmeCount>
//                                                             	<msgCount>0</msgCount>
//                                                             	<reviewCount>0</reviewCount>
//                                                             	<newFansCount>0</newFansCount>
//                                                             	<newLikeCount>0</newLikeCount>
//                                                             </notice>
    @XStreamAlias("atmeCount")
    public String atmeCount;
    @XStreamAlias("msgCount")
    public String msgCount;
    @XStreamAlias("reviewCount")
    public String reviewCount;
    @XStreamAlias("newFansCount")
    public String newFansCount;
    public String newLikeCount;
}

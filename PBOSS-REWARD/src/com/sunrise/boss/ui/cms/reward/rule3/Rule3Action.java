/**
* auto-generated code
* Mon Feb 04 12:04:50 CST 2008
*/
package com.sunrise.boss.ui.cms.reward.rule3;

import com.sunrise.boss.ui.base.*;
import com.sunrise.boss.business.cms.reward.rule3.persistent.Rule3VO;

/**
 * <p>Title: Rule3Action</p>
 * <p>Description:  </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: Maywide Tech Ltd.</p>
 * @author 
 * @version 1.0
 */
public class Rule3Action extends BaseDelegateAction {
    public Rule3Action() {
           //以下几个方法是必须的 
           //指定VO类 
            setVoClass(Rule3VO.class);
            //指定主键数组，如果是复合主键，则需指定全部复合主键的字段名称 
           this.pkNameArray = new String[1]; 
           pkNameArray[0] = "ruleid"; 
    }
}

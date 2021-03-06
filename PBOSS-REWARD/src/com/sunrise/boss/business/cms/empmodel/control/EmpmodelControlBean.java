/**
* auto-generated code
* Thu Nov 19 11:08:41 CST 2009
*/
package com.sunrise.boss.business.cms.empmodel.control;

import java.io.Serializable;

import com.sunrise.boss.common.base.control.AbstractControlBean;
import com.sunrise.boss.common.base.db.DataPackage;
import com.sunrise.boss.common.base.db.DAOFactory;
import com.sunrise.boss.ui.commons.User;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelVO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelDAO;
import com.sunrise.boss.business.cms.empmodel.persistent.EmpmodelListVO;

/**
 * <p>Title: EmpmodelControlBean</p>
 * <p>Description: </p>
 * <p>Copyright: Copyright (c) 2006</p>
 * <p>Company: sunrise Tech Ltd.</p>
 * @author Linli
 * @version 1.0
 */
/**
 @ejb.bean
 local-jndi-name="com/sunrise/boss/business/cms/empmodel/control/EmpmodelControlBean"
 name="EmpmodelControl"
 view-type="local"
 type="Stateless"

 @ejb.interface pattern="{0}"
 @ejb.transaction type="Required"
*/
public class EmpmodelControlBean extends AbstractControlBean
    implements EmpmodelControl {

    public EmpmodelVO doCreate(EmpmodelVO vo, User user)
        throws Exception {
        try{
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
            // TODO  set the pk */
            return (EmpmodelVO) dao.create(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public void doRemove(EmpmodelVO vo, User user)
        throws Exception {
        try{
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
            dao.remove(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmpmodelVO doUpdate(EmpmodelVO vo, User user)
        throws Exception {
        try{
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
            return (EmpmodelVO) dao.update(vo);
        } catch(Exception ex){
            sessionContext.setRollbackOnly();
            throw ex;
        }
    }

    public EmpmodelVO doFindByPk(Serializable pk, User user)
        throws Exception {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
        return (EmpmodelVO) dao.findByPk(pk);
    }

    public DataPackage doQuery(EmpmodelListVO params, User user)
        throws Exception {
			EmpmodelDAO dao = (EmpmodelDAO) DAOFactory.build(EmpmodelDAO.class, user);
        return dao.query(params);
    }
}

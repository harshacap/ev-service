package ev.service;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ev.dao.GuestServiceDAO;
import ev.model.EvModel;


@Service
public class EvServiceImpl implements EvService{
	
	@Autowired
	GuestServiceDAO guestServiceDAO;
	
	@Override
	@Transactional("transactionManager")
	public String getXidBySwid(String swid) {
	
		try{
//			return guestServiceDAO.getXidBySwid(swid);
		}catch(Exception e){
			e.printStackTrace();
		}
		return "";
	}

	@Override
	@Transactional("transactionManager")
	public void storeEntitlement(String xid, String entIdType, String entIdValue) {
		try{
			EvModel evModel = new EvModel();
			evModel.setXid(xid);
			evModel.setEntIdType(entIdType);
			evModel.setEntIdValue(entIdValue);
			
			guestServiceDAO.storeEntitlement(evModel);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Override
	@Transactional("transactionManager")
	public Map getEvDetails(String xidvalue) {
		
		return guestServiceDAO.getEvDetails(xidvalue);	
	}

}

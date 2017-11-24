package com.sunrise.boss.ui.rightmanage.operrole.batchin;

import com.sunrise.boss.ui.commons.batch.upload.UploadFileForm;

public class BatchinOperroleForm extends UploadFileForm {
	

	private String createdate;

	private String statusdate;

	private Byte status;
	
	public BatchinOperroleForm() {
		this.setCheckFormat(new BatchinOperroleCheck());
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	public String getStatusdate() {
		return statusdate;
	}

	public void setStatusdate(String statusdate) {
		this.statusdate = statusdate;
	}
}
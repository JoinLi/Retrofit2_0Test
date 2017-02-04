package com.ethanco.retrofit2_0test;

import java.util.List;

public class CreditBean {

	/**
	 * rs_code : 0
	 * totalRecordCount : 5
	 * mydata : [{"user_cname":"北京冀玉明钢铁贸易有限公司","zongfen":"80.9100000000002","jibie":"B级"},{"user_cname":"石家庄冀秋商贸有限公司","zongfen":"18.4000000000001","jibie":"C级"},{"user_cname":"江西中志兴实业有限公司","zongfen":"9.50999999999998","jibie":"C级"},{"user_cname":"北京中鼎嘉华商贸有限公司","zongfen":"9.38999999999996","jibie":"C级"},{"user_cname":"石家庄市金邦钢铁有限公司","zongfen":"9.30999999999998","jibie":"C级"}]
	 */

	private String rs_code;
	private String totalRecordCount;
	/**
	 * user_cname : 北京冀玉明钢铁贸易有限公司
	 * zongfen : 80.9100000000002
	 * jibie : B级
	 */

	private List<MydataBean> mydata;

	public String getRs_code() {
		return rs_code;
	}

	public void setRs_code(String rs_code) {
		this.rs_code = rs_code;
	}

	public String getTotalRecordCount() {
		return totalRecordCount;
	}

	public void setTotalRecordCount(String totalRecordCount) {
		this.totalRecordCount = totalRecordCount;
	}

	public List<MydataBean> getMydata() {
		return mydata;
	}

	public void setMydata(List<MydataBean> mydata) {
		this.mydata = mydata;
	}

	public static class MydataBean {
		private String user_cname;
		private String zongfen;
		private String jibie;

		public String getUser_cname() {
			return user_cname;
		}

		public void setUser_cname(String user_cname) {
			this.user_cname = user_cname;
		}

		public String getZongfen() {
			return zongfen;
		}

		public void setZongfen(String zongfen) {
			this.zongfen = zongfen;
		}

		public String getJibie() {
			return jibie;
		}

		public void setJibie(String jibie) {
			this.jibie = jibie;
		}
	}
}

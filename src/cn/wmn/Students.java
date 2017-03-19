package cn.wmn;

import java.sql.Blob;
import java.util.Date;



public class Students {
	    private int sid;
        private String name;
        private String sex;
        private Date birth;
        private String address;
        private Blob picture;
		public Blob getPicture() {
			return picture;
		}

		public void setPicture(Blob picture) {
			this.picture = picture;
		}

		public Students() {
			
		}

		public Students(int sid, String name, String sex, Date birth, String address) {
			//super();
			this.sid = sid;
			this.name = name;
			this.sex = sex;
			this.birth = birth;
			this.address = address;
		}

		public int getSid() {
			return sid;
		}

		public void setSid(int sid) {
			this.sid = sid;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getSex() {
			return sex;
		}

		public void setSex(String sex) {
			this.sex = sex;
		}

		public Date getBirth() {
			return birth;
		}

		public void setBirth(Date birth) {
			this.birth = birth;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		@Override
		public String toString() {
			return "Students [sid=" + sid + ", name=" + name + ", sex=" + sex + ", birth=" + birth + ", address="
					+ address + "]";
		}
		
		
        
}

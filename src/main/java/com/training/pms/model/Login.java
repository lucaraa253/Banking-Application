package com.training.pms.model;

import java.util.Objects;

public class Login {
		private int loginId;
		private String username;
		private String password;
		
		public Login() {
			// TODO Auto-generated constructor stub
		}

		public Login(int loginId, String username, String password) {
			super();
			this.loginId = loginId;
			this.username = username;
			this.password = password;
		}

		public int getLoginId() {
			return loginId;
		}

		public void setLoginId(int loginId) {
			this.loginId = loginId;
		}

		public String getUsername() {
			return username;
		}

		public void setUsername(String username) {
			this.username = username;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		@Override
		public int hashCode() {
			return Objects.hash(loginId, password, username);
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Login other = (Login) obj;
			return loginId == other.loginId && Objects.equals(password, other.password)
					&& Objects.equals(username, other.username);
		}

		@Override
		public String toString() {
			return "Login [loginId=" + loginId + ", username=" + username + ", password=" + password + "]";
		}
		
}

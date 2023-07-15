package nagarro.exitassignment.productCatalogue.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
	public class Pincode {

		@Id
		private int pincode;
		private int distanceFromHub;
		public Pincode() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Pincode(int pincode, int distanceFromHub) {
			super();
			this.pincode = pincode;
			this.distanceFromHub = distanceFromHub;
		}
		public int getPincode() {
			return pincode;
		}
		public void setPincode(int pincode) {
			this.pincode = pincode;
		}
		public int getDistanceFromHub() {
			return distanceFromHub;
		}
		public void setDistanceFromHub(int distanceFromHub) {
			this.distanceFromHub = distanceFromHub;
		}
		
		
	}


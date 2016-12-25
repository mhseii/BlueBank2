package main.java.com.bluebank.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name = "TBL_ADDRESS")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ADDRESS_ID")
	private Long id;
	@Version
	private Long version;
	@NotNull
	private String address;
	@NotNull
	private String addressNumber;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private String zipCode;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = AccountHolder.class)
	@JoinColumn(name = "ACCOUNT_HOLDER_ID", referencedColumnName = "ACCOUNT_HOLDER_ID")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private AccountHolder holder;

	public Address() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressNumber() {
		return addressNumber;
	}

	public void setAddressNumber(String addressNumber) {
		this.addressNumber = addressNumber;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public Long getId() {
		return id;
	}

	public AccountHolder getHolder() {
		return holder;
	}

	public void setHolder(AccountHolder holder) {
		this.holder = holder;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", version=" + version + ", address=" + address + ", addressNumber="
				+ addressNumber + ", city=" + city + ", state=" + state + ", zipCode=" + zipCode + ", holder=" + holder
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((addressNumber == null) ? 0 : addressNumber.hashCode());
		result = prime * result + ((city == null) ? 0 : city.hashCode());
		result = prime * result + ((holder == null) ? 0 : holder.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((state == null) ? 0 : state.hashCode());
		result = prime * result + ((version == null) ? 0 : version.hashCode());
		result = prime * result + ((zipCode == null) ? 0 : zipCode.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (addressNumber == null) {
			if (other.addressNumber != null)
				return false;
		} else if (!addressNumber.equals(other.addressNumber))
			return false;
		if (city == null) {
			if (other.city != null)
				return false;
		} else if (!city.equals(other.city))
			return false;
		if (holder == null) {
			if (other.holder != null)
				return false;
		} else if (!holder.equals(other.holder))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (state == null) {
			if (other.state != null)
				return false;
		} else if (!state.equals(other.state))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		if (zipCode == null) {
			if (other.zipCode != null)
				return false;
		} else if (!zipCode.equals(other.zipCode))
			return false;
		return true;
	}

}

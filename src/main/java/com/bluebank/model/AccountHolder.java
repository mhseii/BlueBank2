package main.java.com.bluebank.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import main.java.com.bluebank.util.DocumentType;

@Entity
@Table(name = "TBL_ACCOUNT_HOLDER")
public class AccountHolder {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="ACCOUNT_HOLDER_ID")
	private Long id;
	@Version
	private Long version;
	private boolean isPrimary;
	@NotNull
	private String holdersName;
	@NotNull
	@Enumerated(EnumType.STRING)
	private DocumentType holdersDocType;
	@NotNull
	private String holdersDocId;
	@NotNull
	private String holdersPhone;
	@NotNull
	private String holdersMobile;
	@NotNull
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "address", targetEntity = Address.class)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private List<Address> holdersAddress;

	@ManyToOne(optional = false, fetch = FetchType.LAZY, targetEntity = Account.class)
	@JoinColumn(name = "ACCOUNT_ID", referencedColumnName = "ACCOUNT_ID")
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private Account account;

	public AccountHolder() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "AccountHolder [id=" + id + ", version=" + version + ", isPrimary=" + isPrimary + ", holdersName="
				+ holdersName + ", holdersDocType=" + holdersDocType + ", holdersDocId=" + holdersDocId
				+ ", holdersPhone=" + holdersPhone + ", holdersMobile=" + holdersMobile + ", holdersAddress="
				+ holdersAddress + ", account=" + account + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((account == null) ? 0 : account.hashCode());
		result = prime * result + ((holdersAddress == null) ? 0 : holdersAddress.hashCode());
		result = prime * result + ((holdersDocId == null) ? 0 : holdersDocId.hashCode());
		result = prime * result + ((holdersDocType == null) ? 0 : holdersDocType.hashCode());
		result = prime * result + ((holdersMobile == null) ? 0 : holdersMobile.hashCode());
		result = prime * result + ((holdersName == null) ? 0 : holdersName.hashCode());
		result = prime * result + ((holdersPhone == null) ? 0 : holdersPhone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isPrimary ? 1231 : 1237);
		result = prime * result + ((version == null) ? 0 : version.hashCode());
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
		AccountHolder other = (AccountHolder) obj;
		if (account == null) {
			if (other.account != null)
				return false;
		} else if (!account.equals(other.account))
			return false;
		if (holdersAddress == null) {
			if (other.holdersAddress != null)
				return false;
		} else if (!holdersAddress.equals(other.holdersAddress))
			return false;
		if (holdersDocId == null) {
			if (other.holdersDocId != null)
				return false;
		} else if (!holdersDocId.equals(other.holdersDocId))
			return false;
		if (holdersDocType != other.holdersDocType)
			return false;
		if (holdersMobile == null) {
			if (other.holdersMobile != null)
				return false;
		} else if (!holdersMobile.equals(other.holdersMobile))
			return false;
		if (holdersName == null) {
			if (other.holdersName != null)
				return false;
		} else if (!holdersName.equals(other.holdersName))
			return false;
		if (holdersPhone == null) {
			if (other.holdersPhone != null)
				return false;
		} else if (!holdersPhone.equals(other.holdersPhone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isPrimary != other.isPrimary)
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}

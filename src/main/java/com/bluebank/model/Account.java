package main.java.com.bluebank.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Version;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "TBL_ACCOUNT")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1114937644057109552L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ACCOUNT_ID")
	private Long id;
	@Version
	private Long version;
	@NotNull
	private String accountNumber;
	@NotNull
	private BigDecimal balance;
	@NotNull
	private BigDecimal creditLimit;
	@NotNull
	private boolean isActive;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar startDate;
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar endDate;
	@NotNull
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd-MM-yyyy")
	private Calendar lastUpdate;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", targetEntity = AccountTransaction.class)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private List<AccountTransaction> transactionsList;
	@NotNull
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "id", targetEntity = AccountHolder.class)
	@Cascade({ CascadeType.SAVE_UPDATE, CascadeType.DELETE })
	private List<AccountHolder> accountHolderList;

	public Account() {
		super();
	}

	public Long getVersion() {
		return version;
	}

	public void setVersion(Long version) {
		this.version = version;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public BigDecimal getBalance() {
		return balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

	public BigDecimal getCreditLimit() {
		return creditLimit;
	}

	public void setCreditLimit(BigDecimal creditLimit) {
		this.creditLimit = creditLimit;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isActive) {
		this.isActive = isActive;
	}

	public Calendar getStartDate() {
		return startDate;
	}

	public void setStartDate(Calendar startDate) {
		this.startDate = startDate;
	}

	public Calendar getEndDate() {
		return endDate;
	}

	public void setEndDate(Calendar endDate) {
		this.endDate = endDate;
	}

	public Calendar getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(Calendar lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public List<AccountTransaction> getTransactionsList() {
		return transactionsList;
	}

	public void setTransactionsList(List<AccountTransaction> transactionsList) {
		this.transactionsList = transactionsList;
	}

	public List<AccountHolder> getAccountHolderList() {
		return accountHolderList;
	}

	public void setAccountHolderList(List<AccountHolder> accountHolderList) {
		this.accountHolderList = accountHolderList;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public Long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Account [id=" + id + ", version=" + version + ", accountNumber=" + accountNumber + ", balance="
				+ balance + ", creditLimit=" + creditLimit + ", isActive=" + isActive + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", lastUpdate=" + lastUpdate + ", transactionsList=" + transactionsList
				+ ", accountHolderList=" + accountHolderList + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountHolderList == null) ? 0 : accountHolderList.hashCode());
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((balance == null) ? 0 : balance.hashCode());
		result = prime * result + ((creditLimit == null) ? 0 : creditLimit.hashCode());
		result = prime * result + ((endDate == null) ? 0 : endDate.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + (isActive ? 1231 : 1237);
		result = prime * result + ((lastUpdate == null) ? 0 : lastUpdate.hashCode());
		result = prime * result + ((startDate == null) ? 0 : startDate.hashCode());
		result = prime * result + ((transactionsList == null) ? 0 : transactionsList.hashCode());
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
		Account other = (Account) obj;
		if (accountHolderList == null) {
			if (other.accountHolderList != null)
				return false;
		} else if (!accountHolderList.equals(other.accountHolderList))
			return false;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (balance == null) {
			if (other.balance != null)
				return false;
		} else if (!balance.equals(other.balance))
			return false;
		if (creditLimit == null) {
			if (other.creditLimit != null)
				return false;
		} else if (!creditLimit.equals(other.creditLimit))
			return false;
		if (endDate == null) {
			if (other.endDate != null)
				return false;
		} else if (!endDate.equals(other.endDate))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (isActive != other.isActive)
			return false;
		if (lastUpdate == null) {
			if (other.lastUpdate != null)
				return false;
		} else if (!lastUpdate.equals(other.lastUpdate))
			return false;
		if (startDate == null) {
			if (other.startDate != null)
				return false;
		} else if (!startDate.equals(other.startDate))
			return false;
		if (transactionsList == null) {
			if (other.transactionsList != null)
				return false;
		} else if (!transactionsList.equals(other.transactionsList))
			return false;
		if (version == null) {
			if (other.version != null)
				return false;
		} else if (!version.equals(other.version))
			return false;
		return true;
	}

}

package fr.ensitech.carsprestige28.entity;

import java.util.Date;
import java.util.List;
import javax.persistence.*;


@Entity
@Table(name = "user", catalog = "carsprestige28")
@NamedQueries(
        {
                @NamedQuery(name = "User::findAll", query = "FROM User u"),
                @NamedQuery(name = "User::findByBirthdate", query = "FROM User u WHERE u.birthdate = :birthdate"),
                @NamedQuery(name = "User::findByEmail", query = "FROM User u WHERE u.email = :email")
        }
)

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

    @Column(name = "firstname",nullable = true, length = 40)
	private String firstname;

    @Column(name = "lastname", nullable = false, length = 40)
	private String lastname;

    @Column(name = "email",nullable = false, length = 64, unique = true)
	private String email;

    @Column(name = "pwd", nullable = false , length = 12)
	private String password;

    @Column(name = "birthdate",nullable = true)
    @Temporal(TemporalType.DATE)
	private Date birthdate;

    @Column(name = "active",nullable = false)
	private Boolean isActive;

    @OneToMany(mappedBy = "user",fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Address> addresses;
	
	public User() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

	public Boolean getIsActive() {
		return isActive;
	}

	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", birthdate=" + birthdate + ", isActive=" + isActive + "]";
	}
	
}

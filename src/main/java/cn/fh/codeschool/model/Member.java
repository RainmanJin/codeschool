package cn.fh.codeschool.model;
// Generated Apr 29, 2014 2:35:49 PM by Hibernate Tools 4.0.0

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


/**
 * Member generated by hbm2java
 */

@NamedQuery(
		name = "Member.findMember",
		query = "select m from Member m " +
				"where m.username=:username"
		)

@Entity
@Table(name = "member", schema = "public")
public class Member implements java.io.Serializable {

	private int id;
	private String username;
	private String nickName;
	private String password;
	private Date birthday;
	private Integer gender;
	private String qqNumber;
	private String emailAddress;
	private String phoneNumber;
	private String bio;
	private String occupation;
	private Integer coursesFinishedAmount;
	private Integer point;
	private Integer maxConsecution;
	private Long rank;
	
	private byte[] avatar;
	
	private Set<MemberRole> memberRoles = new HashSet<MemberRole>(0);
	private Set<MemberAcquiredBadges> memberAcquiredBadgeses = new HashSet<MemberAcquiredBadges>(0);
	
	/**
	 * 用户已经完成的小节
	 */
	private Set<CourseSection> finishedSections = new HashSet<CourseSection>(0);

	public Member() {
	}

	public Member(int id, String username) {
		this.id = id;
		this.username = username;
	}
	public Member(int id, String username, String nickName, String password,
			Date birthday, Integer gender, String qqNumber,
			String emailAddress, String phoneNumber, String bio,
			String occupation, Integer coursesFinishedAmount, Integer point,
			Integer maxConsecution, Long rank, Set<MemberRole> memberRoles,
			Set<MemberAcquiredBadges> memberAcquiredBadgeses) {
		this.id = id;
		this.username = username;
		this.nickName = nickName;
		this.password = password;
		this.birthday = birthday;
		this.gender = gender;
		this.qqNumber = qqNumber;
		this.emailAddress = emailAddress;
		this.phoneNumber = phoneNumber;
		this.bio = bio;
		this.occupation = occupation;
		this.coursesFinishedAmount = coursesFinishedAmount;
		this.point = point;
		this.maxConsecution = maxConsecution;
		this.rank = rank;
		this.memberRoles = memberRoles;
		this.memberAcquiredBadgeses = memberAcquiredBadgeses;
	}
	
	/**
	 * 增加1点分值
	 */
	@Transient
	public void increasePoint() {
		this.setPoint(this.getPoint() + 1);
	}

	@OneToMany(fetch = FetchType.EAGER)
	@JoinTable(name = "member_section",
		joinColumns = @JoinColumn(name = "member_id"),
		inverseJoinColumns = @JoinColumn(name = "section_id")
			)
	public Set<CourseSection> getFinishedSections() {
		return finishedSections;
	}

	public void setFinishedSections(Set<CourseSection> finishedSections) {
		this.finishedSections = finishedSections;
	}

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "username", nullable = false, length = 64)
	@NotNull
	@Size(max = 64)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "nick_name", length = 64)
	@Size(max = 64)
	public String getNickName() {
		return this.nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	@Column(name = "password", length = 64)
	@Size(max = 64)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "birthday", length = 13)
	public Date getBirthday() {
		return this.birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Column(name = "gender")
	public Integer getGender() {
		return this.gender;
	}

	public void setGender(Integer gender) {
		this.gender = gender;
	}

	@Column(name = "qq_number", length = 30)
	@Size(max = 30)
	public String getQqNumber() {
		return this.qqNumber;
	}

	public void setQqNumber(String qqNumber) {
		this.qqNumber = qqNumber;
	}

	@Column(name = "email_address", length = 32)
	@Size(max = 32)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "phone_number", length = 20)
	@Size(max = 20)
	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Column(name = "bio")
	public String getBio() {
		return this.bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	@Column(name = "occupation", length = 128)
	@Size(max = 128)
	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	@Column(name = "courses_finished_amount")
	public Integer getCoursesFinishedAmount() {
		return this.coursesFinishedAmount;
	}

	public void setCoursesFinishedAmount(Integer coursesFinishedAmount) {
		this.coursesFinishedAmount = coursesFinishedAmount;
	}

	@Column(name = "point")
	public Integer getPoint() {
		// 如果point为空则置为0
		this.point = this.point == null ? 0 : this.point;
		return this.point;
	}

	public void setPoint(Integer point) {
		this.point = point;
	}

	@Column(name = "max_consecution")
	public Integer getMaxConsecution() {
		return this.maxConsecution;
	}

	public void setMaxConsecution(Integer maxConsecution) {
		this.maxConsecution = maxConsecution;
	}

	@Column(name = "rank")
	public Long getRank() {
		return this.rank;
	}

	public void setRank(Long rank) {
		this.rank = rank;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<MemberRole> getMemberRoles() {
		return this.memberRoles;
	}

	public void setMemberRoles(Set<MemberRole> memberRoles) {
		this.memberRoles = memberRoles;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "member")
	public Set<MemberAcquiredBadges> getMemberAcquiredBadgeses() {
		return this.memberAcquiredBadgeses;
	}

	public void setMemberAcquiredBadgeses(
			Set<MemberAcquiredBadges> memberAcquiredBadgeses) {
		this.memberAcquiredBadgeses = memberAcquiredBadgeses;
	}

	@Column(name = "avatar_image")
	public byte[] getAvatar() {
		return avatar;
	}

	public void setAvatar(byte[] avatar) {
		this.avatar = avatar;
	}

}

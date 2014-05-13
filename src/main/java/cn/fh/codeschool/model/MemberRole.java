package cn.fh.codeschool.model;
// Generated Apr 29, 2014 2:35:49 PM by Hibernate Tools 4.0.0

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

/**
 * MemberRole generated by hbm2java
 */
@Entity
@Table(name = "member_role", schema = "public")
public class MemberRole implements java.io.Serializable {

	private MemberRoleId id;
	private Role role;
	private Member member;

	public MemberRole() {
	}

	public MemberRole(MemberRoleId id, Role role, Member member) {
		this.id = id;
		this.role = role;
		this.member = member;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "memberId", column = @Column(name = "member_id", unique = false, nullable = false)),
			@AttributeOverride(name = "roleId", column = @Column(name = "role_id", unique = false, nullable = false))})
	@NotNull
	public MemberRoleId getId() {
		return this.id;
	}

	public void setId(MemberRoleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "role_id", unique = false, nullable = false, insertable = false, updatable = false)
	@NotNull
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", unique = false, nullable = false, insertable = false, updatable = false)
	@NotNull
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

}

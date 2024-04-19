package com.vti.models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "groups")
@Getter @Setter @NoArgsConstructor
public class GroupModel {

	@Id
	@Column(name = "groupId")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long groupId;

	@Column(name = "groupName")
	private String groupName;
	
	@Column(name = "users")
	@ManyToMany(mappedBy = "groups", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	private Set<UserModel> users = new HashSet<UserModel>();
}

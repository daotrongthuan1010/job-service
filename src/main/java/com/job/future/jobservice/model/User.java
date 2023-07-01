package com.job.future.jobservice.model;

import lombok.*;

import javax.persistence.*;
import java.util.List;



@Getter
@Setter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "user")
public class User  {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "username")
	private String username;

	@Column(name = "email")
	private String email;

	@Column(name = "password")
	private String password;

	@ElementCollection(fetch = FetchType.EAGER)
	List<Role> roles;



}




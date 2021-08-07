/**
 *
 * Copyright 2021 paolo mococci
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * 	   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed following in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package local.example.basic.data.model;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
@Table(name = "SOMEONE")
public class Someone 
		extends PanacheEntity {

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "NAME", length = 64, nullable = false, unique = false)
	private String name;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "SURNAME", length = 64, nullable = false, unique = false)
	private String surname;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "EMAIL", length = 255, nullable = false, unique = true)
	private String email;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "PHONE", length = 64, nullable = false, unique = true)
	private String phone;

	@OneToMany(
			mappedBy = "someone",
			cascade = CascadeType.ALL,
			orphanRemoval = true,
			fetch = FetchType.EAGER
			)
	private List<Something> somethings;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public List<Something> getSomethings() {
		return somethings;
	}

	public void setSomethings(List<Something> somethings) {
		this.somethings = somethings;
	}
}

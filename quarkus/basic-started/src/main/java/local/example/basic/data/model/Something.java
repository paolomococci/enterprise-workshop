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

import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Lob;
import javax.persistence.Table;

//import com.fasterxml.jackson.annotation.JsonProperty;

import io.quarkus.hibernate.orm.panache.PanacheEntity;

@Entity
@Cacheable
@Table(name = "SOMETHING")
public class Something 
		extends PanacheEntity {

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "CODE", length = 16, nullable = false, unique = true)
	private String code;

	@Basic(fetch = FetchType.LAZY)
	@Column(name = "NAME", length = 255, nullable = false, unique = true)
	private String name;

	@Lob
	//@JsonProperty(value = "connoted")
	@Basic(fetch = FetchType.LAZY)
	@Column(columnDefinition = "text" ,name = "DESCRIPTION", nullable = true, unique = false)
	private String description;

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String descrition) {
		this.description = descrition;
	}
}

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

package local.example.basic.data.repository;

import javax.enterprise.context.ApplicationScoped;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

import local.example.basic.data.model.Something;

@ApplicationScoped
public class SomethingRepository 
		implements PanacheRepository<Something> {

	public Something findByCode(String code) {
		return this.find("code", code).firstResult();
	}

	public Something findByName(String name) {
		return this.find("name", name).firstResult();
	}

	public Long numberOfThings() {
		return Long.valueOf(this.count());
	}
}

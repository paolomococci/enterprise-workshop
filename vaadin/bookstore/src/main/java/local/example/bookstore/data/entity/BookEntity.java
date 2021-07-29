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

package local.example.bookstore.data.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@Entity(name = "books")
@Table(name = "BOOK", uniqueConstraints = @UniqueConstraint(columnNames = {"ISBN"}))
public class BookEntity
        extends AbstractEntity {

    @Column(name = "TITLE")
    private String title;

    @Column(name = "SUBTITLE")
    private String subtitle;

    @Column(name = "ISBN", unique = true)
    private String isbn;

    @Column(name = "PAGES")
    private Integer pages;

    @Column(name = "PUBLICATION")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate publication;

    @Lob
    @Column(name = "IMAGE")
    private String uriImage;

    @ManyToMany(
            targetEntity = AuthorEntity.class,
            mappedBy = "books",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY
    )
    private List<AuthorEntity> authors;
}

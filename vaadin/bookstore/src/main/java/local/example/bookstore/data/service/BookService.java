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

package local.example.bookstore.data.service;

import local.example.bookstore.data.entity.BookEntity;
import local.example.bookstore.data.repository.BookRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepository bookRepository;

    public List<BookEntity> readAll() {
        return (List<BookEntity>) bookRepository.findAll();
    }

    public List<BookEntity> readAll(PageRequest pageRequest) {
        return (List<BookEntity>) bookRepository.findAll();
    }

    public void create(BookEntity addressEntity) {
        bookRepository.save(addressEntity);
    }

    public Optional<BookEntity> read(Long id) {
        return bookRepository.findById(id);
    }

    public void update(BookEntity updatedBookEntity, Long id) {
        Optional.of(bookRepository.findById(id).map(
                storedBookEntity -> {
                    if (updatedBookEntity.getTitle() != null)
                        storedBookEntity.setTitle(updatedBookEntity.getTitle());
                    if (updatedBookEntity.getSubtitle() != null)
                        storedBookEntity.setSubtitle(updatedBookEntity.getSubtitle());
                    if (updatedBookEntity.getIsbn() != null)
                        storedBookEntity.setIsbn(updatedBookEntity.getIsbn());
                    if (updatedBookEntity.getPages() != null)
                        storedBookEntity.setPages(updatedBookEntity.getPages());
                    if (updatedBookEntity.getPublication() != null)
                        storedBookEntity.setPublication(updatedBookEntity.getPublication());
                    if (updatedBookEntity.getUriImage() != null)
                        storedBookEntity.setUriImage(updatedBookEntity.getUriImage());
                    return bookRepository.save(storedBookEntity);
                }).orElseGet(
                () -> {
                    return bookRepository.save(updatedBookEntity);
                }));
    }

    public void update(BookEntity updatedBookEntity) {
        this.update(updatedBookEntity, updatedBookEntity.getId());
    }

    public void delete(Long id) {
        bookRepository.deleteById(id);
    }

    public void delete(BookEntity addressEntity) {
        try {
            this.delete(addressEntity.getId());
        } catch (Exception exception) {
            exception.getMessage();
        }
    }
}

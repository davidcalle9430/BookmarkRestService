package repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;

import entities.Bookmark;

public interface BookmarkRepository extends JpaRepository<Bookmark, Long> {
	Collection<Bookmark> findByAccountUsername(String username);
}

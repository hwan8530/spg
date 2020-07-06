package com.example.demo.board.reposiroty;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.board.domain.GalleryBoard;

@Repository
public interface GalleryBoardRepository extends JpaRepository<GalleryBoard, Long> {
	public Optional<GalleryBoard> findById(Long id);

	public List<GalleryBoard> findByTitleLike(String title);

	public List<GalleryBoard> findByWriterName(String writerName);
}

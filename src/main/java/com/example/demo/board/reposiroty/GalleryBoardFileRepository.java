package com.example.demo.board.reposiroty;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.board.domain.GalleryBoardFile;

@Repository
public interface GalleryBoardFileRepository extends JpaRepository<GalleryBoardFile, Long>{
	public Optional<GalleryBoardFile> findByStoreFileName(String storeFileName);

	public Optional<GalleryBoardFile> findByOrdinaryFileName(String ordinaryFileName);

	public Optional<GalleryBoardFile> findByGalleryBoardId(Long galleryBoardId);
}

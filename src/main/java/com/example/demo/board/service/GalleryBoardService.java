package com.example.demo.board.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.board.domain.GalleryBoard;
import com.example.demo.board.reposiroty.GalleryBoardRepository;

@Service
public class GalleryBoardService {
	@Autowired
	GalleryBoardRepository galleryBoardRepository;
	
	@Transactional
	public GalleryBoard save(GalleryBoard galleryBoard) {
		this.galleryBoardRepository.save(galleryBoard);
		return galleryBoard;
	}

	@Transactional
	public List<GalleryBoard> findAll() {
		return this.galleryBoardRepository.findAll();
	}

	public GalleryBoardService() {
	}
}

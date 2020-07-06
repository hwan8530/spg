package com.example.demo.board.domain;
import java.sql.Blob;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.type.BlobType;
import org.hibernate.type.descriptor.sql.LongVarbinaryTypeDescriptor;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gallery_board_file")
public class GalleryBoardFile {
	@Id
	@NotBlank
	@Size(max = 60)
	@Column(name = "store_filename")
	private String storeFileName;

	@NotBlank
	@Size(max = 60)
	@Column(name = "ordinary_filename")
	private String ordinaryFileName;

	@NotBlank
	@Column(name = "gallery_board_id")
	private Long galleryBoardId;
	
	@NotBlank
	@Column(name = "data")
	private String data;
	
}

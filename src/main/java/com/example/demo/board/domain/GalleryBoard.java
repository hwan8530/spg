package com.example.demo.board.domain;

import java.util.Calendar;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "gallery_board")
public class GalleryBoard {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@NotBlank
	@Size(max = 40)
	@Column(name = "title")
	private String title;

	@Column(name = "writer_id")
	private long writerId;

	@NotBlank
	@Size(max = 20)
	@Column(name = "writer_name")
	private String writerName;

	@Column(name = "create_date")
	private Calendar createDate;

	@NotBlank
	@Column(name = "content", columnDefinition = "TEXT")
	private String content;

	@OneToMany
	@JoinColumn(name = "gallery_board_id")
	private List<GalleryBoardFile> galleryBoardFile;

	public GalleryBoard() {

	}

	public GalleryBoard(String title, long writerId, String writerName, String content) {
		this.title = title;
		this.writerId = writerId;
		this.writerName = writerName;
		this.content = content;
	}
}

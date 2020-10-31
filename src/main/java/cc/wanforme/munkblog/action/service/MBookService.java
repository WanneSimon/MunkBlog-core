package cc.wanforme.munkblog.action.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import com.github.pagehelper.PageInfo;

import cc.wanforme.munkblog.base.constant.EditorEnum;
import cc.wanforme.munkblog.base.constant.ObjectTypeEnum;
import cc.wanforme.munkblog.base.constant.ValidEnum;
import cc.wanforme.munkblog.base.entity.Book;
import cc.wanforme.munkblog.base.entity.ImageFile;
import cc.wanforme.munkblog.base.service.IBookService;
import cc.wanforme.munkblog.base.service.IEfileService;
import cc.wanforme.munkblog.base.service.IImageFileService;
import cc.wanforme.munkblog.util.MunkBeanUtils;
import cc.wanforme.munkblog.vo.ResMessage;
import cc.wanforme.munkblog.vo.book.BookSearchVo;
import cc.wanforme.munkblog.vo.book.BookVo;


/**
 * @author wanne
 * 2020年9月21日
 */
@Service
public class MBookService {
	private static final Logger log = LoggerFactory.getLogger(MBookService.class);
	
	@Autowired
	private IBookService bookService;
	
	@Autowired
	private IImageFileService imageFileService;
	
	@Autowired
	private IEfileService efileService;
	
	/** 搜索*/
	public ResMessage searchBook(BookSearchVo searchVo) {
		PageInfo<Book> data = bookService.selectBooks(searchVo);
		
		// 封面
		List<Book> books = data.getList();
		List<BookVo> bookVos = new ArrayList<>(books.size());
		books.forEach( e -> {
			BookVo bookVo = new BookVo();
			BeanUtils.copyProperties(e, bookVo);
			
//			List<ImageFile> images = imageFileService.selectByObjectId(ValidEnum.VALID, e.getId());
			List<ImageFile> images = imageFileService.selectByTypeWithObjectId(ValidEnum.VALID, e.getId(), ObjectTypeEnum.BOOK);
			if( images!=null && !images.isEmpty()) {
				bookVo.setCover(images.get(0));
			}
			bookVos.add(bookVo);
		});
		
		
		PageInfo<BookVo> resData = new PageInfo<BookVo>(bookVos);
		BeanUtils.copyProperties(data, resData, "list");
		return ResMessage.newSuccessMessage(resData);
	}
	
	/** 添加*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage addBook(BookVo bookVo) {
		Assert.notNull(bookVo, "没有信息");
		Assert.notNull(bookVo.getName(), "没有书名");
		Assert.notNull(bookVo.getDescription(), "没有描述");
		
		// 书
		Book book = new Book();
		BeanUtils.copyProperties(bookVo, book);
		
		if(book.getEditor() == null) {
			book.setEditor(EditorEnum.DEFAULT.getCode());
		}
		book.setValid(ValidEnum.VALID.getCode());
		
		LocalDateTime now = LocalDateTime.now();
		book.setCreateTime(now);
		book.setUpdateTime(now);
		
		bookService.save(book);
		
		// 图片信息
		ImageFile coverVo = bookVo.getCover();
		if(coverVo != null) {
			Assert.notNull(coverVo.getFileId(), "没有文件id");
			
			ImageFile cover = new ImageFile();
			cover.setObjectId(bookVo.getId());
			cover.setFileId(coverVo.getObjectId());
			cover.setType(ObjectTypeEnum.BOOK.getCode());
			cover.setValid(ValidEnum.VALID.getCode());
			
			imageFileService.save(cover);
			
			BeanUtils.copyProperties(cover, coverVo);
		}
		
		BeanUtils.copyProperties(book, bookVo);
		bookVo.setCover(coverVo);
		return ResMessage.newSuccessMessage("添加成功", bookVo);
	}
	
	/** 更新*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage updateBook(BookVo bookVo) {
		Assert.notNull(bookVo, "没有信息");
		Assert.notNull(bookVo.getId(), "没有id");
		StringBuffer resMsg = new StringBuffer();
		
		Book po = bookService.getById(bookVo.getId());
		if( po == null) {
			return ResMessage.newFailMessage("书籍不存在");
		}
		
		bookVo.setCreateTime(null);
		bookVo.setUpdateTime(null);
		
		// 书名和描述可以均为空，表示更新封面
		if(!StringUtils.isAllBlank(bookVo.getName(),
				bookVo.getDescription())) {
			Assert.notNull(bookVo.getName(), "没有书名");
			Assert.notNull(bookVo.getDescription(), "没有描述");			
			
//			Book book = new Book();
//			BeanUtils.copyProperties(book, bookVo);
//			book.setCreateTime(null);
//			book.setUpdateTime(null);
//			bookService.updateById(book);
			
			// 获取返回信息
//			BeanUtils.copyProperties(book, bookVo);
			
			MunkBeanUtils.copyNotNullProperties(bookVo, po);
			bookService.updateById(po);
			
			BeanUtils.copyProperties(po, bookVo);
			resMsg.append("书信息更新成功 ");
		} else {
			log.info("不需要更新书籍信息: "+ bookVo.getId());
		}
		
		// 更新图片信息
		if( bookVo.getCover() != null ) {
			ImageFile coverVo = bookVo.getCover();
			
//			List<ImageFile> imageFiles = imageFileService.selectAllByObjectId(bookVo.getId());
			List<ImageFile> imageFiles = imageFileService.selectByTypeWithObjectId(ValidEnum.VALID, bookVo.getId(), ObjectTypeEnum.BOOK);
			if(imageFiles == null || imageFiles.isEmpty()) {
				// 保存
				Assert.notNull(coverVo.getFileId(), "没有文件id");
				
				ImageFile cover = new ImageFile();
				cover.setObjectId(bookVo.getId());
				cover.setFileId(coverVo.getFileId());
				cover.setType(ObjectTypeEnum.BOOK.getCode());
				cover.setValid(ValidEnum.VALID.getCode());
				
				imageFileService.save(cover);
				
				bookVo.setCover(cover);
				resMsg.append("封面保存成功");
			} else {
				// 更新
				Assert.notNull(coverVo.getId(), "没有封面id");
				Assert.notNull(coverVo.getFileId(), "没有封面文件id");
				Optional<ImageFile> opt = imageFiles.stream()
					.filter( e -> coverVo.getId() == e.getId())
					.findAny();
				
				// 没找到
				if(!opt.isPresent()) {
					String errorMsg = "未找到图片文件 { objectId: "+bookVo.getId()+", imageFileId: "+coverVo.getId()+" }";
					log.info(errorMsg);
					return ResMessage.newFailMessage(errorMsg);
				}
				
				// 更新文件id
				ImageFile cover = opt.get();
				cover.setFileId(coverVo.getFileId());
				imageFileService.updateById(cover);

				efileService.updateObjectType(coverVo.getFileId(), ObjectTypeEnum.BOOK.getCode());
				
				BeanUtils.copyProperties(cover, coverVo);
				resMsg.append("封面更新成功");
			}
		}
		
		return ResMessage.newSuccessMessage(resMsg.toString(), bookVo);
	}
	
	/** 删除书籍，只改为失效状态，书和图片记录不删除*/
	@Transactional(rollbackFor = Exception.class)
	public ResMessage deleteBook(int bookId) {
		Book book = bookService.getById(bookId);
		book.setValid(ValidEnum.INVALID.getCode());
		bookService.updateById(book);
		
//		List<ImageFile> images = imageFileService.selectByObjectId(ValidEnum.VALID, bookId);
		List<ImageFile> images = imageFileService.selectByTypeWithObjectId(ValidEnum.VALID, bookId, ObjectTypeEnum.BOOK);
		if(images != null) {
			images.forEach( e -> {
				e.setValid(ValidEnum.INVALID.getCode());
				imageFileService.updateById(e);
			});
		}
		
		return ResMessage.newSuccessMessage("删除成功", null);
	}

	/** 获取书籍信息*/
	public ResMessage getBook(int id) {
		Book po = bookService.getById(id);
		
		BookVo vo = new BookVo();
		BeanUtils.copyProperties(po, vo);
		
		List<ImageFile> images = imageFileService.selectByTypeWithObjectId(ValidEnum.VALID, po.getId(), ObjectTypeEnum.BOOK);
		if( images!=null && !images.isEmpty()) {
			vo.setCover(images.get(0));
		}
		
		return ResMessage.newSuccessMessage("获取成功", vo);
	}
	
}

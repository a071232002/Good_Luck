package com.notice.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.notice.model.NoticeVO;
import com.mysql.cj.protocol.x.Notice;
import com.notice.model.NoticeRepository;

@Service("NoticeService")
public class NoticeService {

    @Autowired
    NoticeRepository repository;

    public NoticeVO addNotice(NoticeVO notice) {
    	return repository.save(notice);
    }

    public NoticeVO updateNotice(NoticeVO notice) {
        return repository.save(notice);
    }

    public void deleteNotice(NoticeVO notice) {
        repository.delete(notice);
    }

    public NoticeVO getOneNotice(Integer noticeNo) {
        Optional<NoticeVO> optional = repository.findById(noticeNo);
        return optional.orElse(null);
    }

    public List<NoticeVO> getAll() {
        return repository.findAll();
    }

	public Notice findByNo(Integer valueOf) {
		return null;
	}

}

package com.notice.model;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("NoticeService")
public class NoticeService {

    @Autowired
    NoticeRepository repository;

    public Notice addNotice(Notice notice) {
    	return repository.save(notice);
    }

    public Notice updateNotice(Notice notice) {
        return repository.save(notice);
    }

    public void deleteNotice(Notice notice) {
        repository.delete(notice);
    }

    public Notice getOneNotice(Integer noticeNo) {
        Optional<Notice> optional = repository.findById(noticeNo);
        return optional.orElse(null);
    }

    public List<Notice> getAll() {
        return repository.findAll();
    }
}

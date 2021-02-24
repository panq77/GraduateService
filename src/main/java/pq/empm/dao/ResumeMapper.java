package pq.empm.dao;

import pq.empm.model.Resume;

import java.util.List;

public interface ResumeMapper {


    int insert(Resume record);


    Resume queryById(int rid);

    int deleteById(int rid);

    int updateStat(int rid);

    List<Resume> getListById(Integer pid);
}
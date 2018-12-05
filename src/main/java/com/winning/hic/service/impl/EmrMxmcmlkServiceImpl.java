package com.winning.hic.service.impl;

import com.winning.hic.base.Constants;
import com.winning.hic.model.MBNoteTree;
import com.winning.hic.model.MbzDictInfo;
import com.winning.hic.service.MbzDictInfoService;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import com.winning.hic.model.EmrMxmcmlk;
import com.winning.hic.dao.cmdatacenter.MbzDictInfoDao;
import com.winning.hic.dao.hdw.EmrMxmcmlkDao;
import com.winning.hic.service.EmrMxmcmlkService;  


/**
* @author chensj
* @title EMR_MXMCMLK
* @email chensj@163.com
* @package com.winning.hic.service.impl
* @date 2018-05-23 09:05:13
*/
@Service
public class EmrMxmcmlkServiceImpl implements  EmrMxmcmlkService {

    @Autowired
    private EmrMxmcmlkDao emrMxmcmlkDao;
    @Autowired
    private MbzDictInfoDao mbzDictInfoDao;

    public int createEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.insertEmrMxmcmlk(emrMxmcmlk);
    }

    public int modifyEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.updateEmrMxmcmlk(emrMxmcmlk);
    }

    public int removeEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.deleteEmrMxmcmlk(emrMxmcmlk);
    }

    public EmrMxmcmlk getEmrMxmcmlk(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.selectEmrMxmcmlk(emrMxmcmlk);
    }

    public int getEmrMxmcmlkCount(EmrMxmcmlk emrMxmcmlk){
        return (Integer)this.emrMxmcmlkDao.selectEmrMxmcmlkCount(emrMxmcmlk);
    }

    public List<EmrMxmcmlk> getEmrMxmcmlkList(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.selectEmrMxmcmlkList(emrMxmcmlk);
    }

    public List<EmrMxmcmlk> getEmrMxmcmlkPageList(EmrMxmcmlk emrMxmcmlk){
        return this.emrMxmcmlkDao.selectEmrMxmcmlkPageList(emrMxmcmlk);
    }

    @Override
    public List<MBNoteTree> createEmrMxmcmlkTree() {
        List<String> mbCodeList = mbzDictInfoDao.selectMbzDictInfoListForMB();
        EmrMxmcmlk emrMxmcmlk = new EmrMxmcmlk();
        //获取sys_id
        MbzDictInfo dictInfo = new MbzDictInfo();
        dictInfo.setDictCode(Constants.SYS_ID_DICT);
        dictInfo = mbzDictInfoDao.selectMbzDictInfo(dictInfo);
        emrMxmcmlk.setSysId(dictInfo.getDictValue());
        //获取yljgdm
        dictInfo = new MbzDictInfo();
        dictInfo.setDictCode(Constants.YLJGDM_DICT);
        dictInfo = mbzDictInfoDao.selectMbzDictInfo(dictInfo);
        emrMxmcmlk.setYljgdm(dictInfo.getDictValue());
        emrMxmcmlk.getMap().put("mbCodeList",mbCodeList);
        List<EmrMxmcmlk> parentList = emrMxmcmlkDao.selectEmrMxmcmlkParentList(emrMxmcmlk);
        List<MBNoteTree> mbNoteTrees = new ArrayList<>();
        for (EmrMxmcmlk mxmcmlk1 : parentList) {
            MBNoteTree tree = mxmcmlk1.getMBPNoteTree();
            tree.setParent(true);
            mbNoteTrees.add(tree);
        }
        return mbNoteTrees;
    }

    @Override
    public List<MBNoteTree> getEmrMxmcmlkListTree(EmrMxmcmlk mxmcmlk) {
        List<MBNoteTree> mbNoteTrees = new ArrayList<>();
        List<EmrMxmcmlk> mxmcmlkList = new ArrayList<>();
        if(mxmcmlk.getMldm().equals("B+20")){
             mxmcmlkList = emrMxmcmlkDao.selectEmrMxmcmlkFirstChildList(mxmcmlk);
            mxmcmlk.setMldm("B+98");
            List<EmrMxmcmlk> mxmcmlkList2 = emrMxmcmlkDao.selectEmrMxmcmlkFirstChildList(mxmcmlk);
            mxmcmlk.setMldm("B+21");
            List<EmrMxmcmlk> mxmcmlkList3 = emrMxmcmlkDao.selectEmrMxmcmlkFirstChildList(mxmcmlk);
            mxmcmlkList.addAll(mxmcmlkList2);
            mxmcmlkList.addAll(mxmcmlkList3);
        }else{
            mxmcmlkList = emrMxmcmlkDao.selectEmrMxmcmlkFirstChildList(mxmcmlk);
        }
        for (EmrMxmcmlk emrMxmcmlk : mxmcmlkList) {
            MBNoteTree tree = emrMxmcmlk.getMBNoteTree();
            mbNoteTrees.add(tree);
        }
        return mbNoteTrees;
    }

}
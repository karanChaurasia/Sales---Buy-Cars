/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.RecordInfoProcess;

import java.util.List;



/**
 *
 * @author ANITA-PC
 */
public interface RecordInfoDAO {
    void insert(RecordInfoG_S r);
    void update(RecordInfoG_S r);
    void delete(int riid);
    
    List<RecordInfoG_S> getallCarrecordbyId(int uiid, int rid);
    RecordInfoG_S getrecordbyId(int rid);
    List<RecordInfoG_S>getrecord();
}

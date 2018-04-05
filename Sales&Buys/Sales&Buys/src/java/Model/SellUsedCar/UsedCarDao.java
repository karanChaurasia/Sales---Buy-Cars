
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.SellUsedCar;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author badree.tiwari
 */
public interface UsedCarDao {
    void insert(UsedCarG_S u);
    void update(UsedCarG_S u);
    void delete(int cid);
    
    
    UsedCarG_S getOldCarDetailByID(int cid);
    List<UsedCarG_S> getallrecordbyUserId(int uiid);
    List<UsedCarG_S>getOldCarMinDetail();
    
    ArrayList<UsedCarG_S>used_dta();
}

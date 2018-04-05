/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.AddCarItem;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ANITA-PC
 */
public interface AddItemDAO {
    void insert(AddItemG_S a);
    void update(AddItemG_S a);
    void delete(int cid);
    
    AddItemG_S getDetailbyCarId(int aid);
    List<AddItemG_S>getallDetailbyUserId(int uiid);
    List<AddItemG_S>getNewCarMinDetail();
    List<AddItemG_S>getDetail();
    ArrayList<AddItemG_S>new_dta();
}

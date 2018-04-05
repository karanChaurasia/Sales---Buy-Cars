/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.UpcomingCar;

import java.util.List;

/**
 *
 * @author ANITA-PC
 */
public interface UpcomingCarDAO {
    void insert(UpcomingCarG_S up);
    void update(UpcomingCarG_S up);
    void delete(int cid);
    
    
    UpcomingCarG_S getUpcomingById(int cid);
    List<UpcomingCarG_S>getUpcomingByUiid(int uiid);
    List<UpcomingCarG_S>getUpcoming();
}

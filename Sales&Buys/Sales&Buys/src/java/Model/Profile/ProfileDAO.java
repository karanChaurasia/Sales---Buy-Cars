/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model.Profile;

import java.util.List;
 
/**
 *
 * @author ANITA-PC
 */
public interface ProfileDAO {

    void insert(ProfileG_S p);
    void update(ProfileG_S p);
    void delete(int pid);
    void changepassword(int uiid, String newpass);
    void insertcontactinfo(ProfileG_S p);
    void login(ProfileG_S p);
    
    List<ProfileG_S> getbookedrecordbyuiid(int uiid, int rid);
    ProfileG_S getprofile(int pid);
    ProfileG_S getprofileUsedCarSeller(int cid);
    List<ProfileG_S>getprofile();
    
   
}

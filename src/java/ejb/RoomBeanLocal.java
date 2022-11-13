/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb;

import javax.ejb.Local;

/**
 *
 * @author HP
 */
@Local
public interface RoomBeanLocal {
    public int checkin(int no);
    public int checkout(int no); 
}

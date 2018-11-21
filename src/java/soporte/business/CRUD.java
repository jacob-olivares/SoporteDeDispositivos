/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package soporte.business;

import java.util.ArrayList;


/**
 *
 * @author Informatica
 */
public interface CRUD<Generic> {
    public boolean insert(Generic x);
    public boolean update(Generic x);
    public boolean delete(int x);
    public ArrayList<Generic> select();
}

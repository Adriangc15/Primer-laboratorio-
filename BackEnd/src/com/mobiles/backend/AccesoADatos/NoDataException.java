/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mobiles.backend.AccesoADatos;

/**
 *
 * @author adria
 */
public class NoDataException extends java.lang.Exception{
    public NoDataException(){
        super();
    }
    
    public NoDataException(String msg){
        super(msg);
    }
}

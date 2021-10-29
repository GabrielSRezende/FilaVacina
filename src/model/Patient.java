/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;

/**
 *
 * @author gabri
 */
public class Patient {
        //Attributes
        private String codePat;
		
	private String idadePat;
	
	private boolean areaSaude;
	
	private String addressPat;
	
	private Date datePat;
        
        private char lvlPat;
	
        //Contructor
        public Patient(){

        }
	
        //getters and setters
	public String getCodePat() {
            return codePat;
	}

	public void setCodePat(String codePat) {
            this.codePat = codePat;
	}
        
        public String getIdadePat() {
            return idadePat;
	}

	public void setIdadePat(String idadePat) {
            this.idadePat = idadePat;
	}
        
        public boolean getAreaSaude() {
            return areaSaude;
	}

	public void setAreaSaude(boolean areaSaude) {
            this.areaSaude = areaSaude;
	}
        
        public String getAddressPat() {
            return addressPat;
	}

	public void setAddressPat(String addressPat) {
            this.addressPat = addressPat;
	}
        
        public Date getDatePat() {
            return datePat;
	}

	public void setDatePat(Date datePat) {
		this.datePat = datePat;
	}
        
        //Methods
        public void insertPat(){
            
        }
        
        public void deletePat(){
            
        }
        
        public void updatePat(){
            
        }
        
        public void selectPat(){
            
        }
        
        public void reportPat(){
            
        }
        
        public void orderPat(){
            
        }
}

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;
import org.lsmp.djep.djep.DJep;
import org.nfunk.jep.Node;
import org.nfunk.jep.ParseException;

/**
 *
 * @author Gadiel Us
 */
public class Derivadas {
    private String funcion="";
    private String varible = "x";
    
    DJep djep;
    Node nodofuncion;
    Node nododerivada;
public Derivadas(){


}  
public void setfuncionaderivar(String funcion, String var){
this.funcion=funcion;
this.varible =var;
}
    public String getfuncionderivada(){
    return this.funcion;
    } 
    
    public void derivar(){
     try{
     this.djep=new DJep();
     this.djep.addStandardFunctions();
     this.djep.addStandardConstants();
     this.djep.addComplex();
     this.djep.setAllowUndeclared(true);
     this.djep.setAllowAssignment(true);
     this.djep.setImplicitMul(true);
     this.djep.addStandardDiffRules();
     this.nodofuncion=this.djep.parse(this.funcion);
     
     
     
     Node diff= this.djep.differentiate(nodofuncion, varible);
     this .nododerivada=this.djep.simplify(diff);
     this.funcion=this.djep.toString(this.nododerivada);
     
     } catch (ParseException e) {
         System.out.println("Error"+e.getErrorInfo());
         this.funcion = "Syntax Error";
     }
    }
    
}



/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calculadora;

/**
 *
 * @author Gadiel Us
 */

import org.apache.commons.math4.legacy.analysis.FunctionUtils;
import org.apache.commons.math4.legacy.analysis.UnivariateFunction;
import org.apache.commons.math4.legacy.analysis.differentiation.DerivativeStructure;
import org.apache.commons.math4.legacy.analysis.differentiation.UnivariateDifferentiableFunction;
import org.apache.commons.math4.legacy.analysis.function.Exp;
import org.apache.commons.math4.legacy.analysis.function.Expm1;
import org.apache.commons.math4.legacy.analysis.function.Pow;
import org.apache.commons.math4.legacy.analysis.function.Power;
import org.apache.commons.math4.legacy.analysis.function.Sin;
import org.apache.commons.math4.legacy.analysis.integration.SimpsonIntegrator;
import org.apache.commons.math4.legacy.analysis.integration.UnivariateIntegrator;
import com.fathzer.soft.javaluator.DoubleEvaluator;
import com.fathzer.soft.javaluator.Function;
import org.apache.commons.math4.legacy.exception.TooManyEvaluationsException;

public class Integrales {
    private double ls;
    private double li;
    private String coeficiente;
    private String expresion;
    private double result;
    public void setfuncionaderivar(String funcion, String var, double lims, double linf){
        this.expresion=funcion;
        this.coeficiente =var;
        this.ls = lims;
        this.li = linf;
    }
    
    
    public void Integrar(){
        try {
            DoubleEvaluator evaluator = new DoubleEvaluator();
            UnivariateFunction funcion = x -> {
            // Reemplazar la variable de integración en la expresión por el valor de 'x'
            String expresionConValor = expresion.replace(coeficiente, String.valueOf(x));
            // Evaluar la expresión y devolver el resultado
            return evaluator.evaluate(expresionConValor);
            };
            UnivariateIntegrator integrador = new SimpsonIntegrator();
            
            try {
            double resultado = integrador.integrate(1000, funcion, li, ls);
            result = resultado;
            }catch (TooManyEvaluationsException e) {
    // Manejar la excepción aquí
            System.err.println("Se ha excedido el límite de evaluaciones: " + e.getMessage());
            
    // Puedes tomar medidas como asignar un valor predeterminado o mostrar un mensaje de error.
            }

        } catch (IllegalArgumentException e) {
            result = Double.NaN;
        }
        // Crear una función univariante a partir de la expresión y la variable de integración
        
    }
    public double getfuncionIntegrada(){
        double numeroRedondeado;
        if(Double.isNaN(result)){
            numeroRedondeado = Double.NaN;
        }else{
            numeroRedondeado = Math.round(result * 100.0) / 100.0;
        }

        return numeroRedondeado;
    }
    
    
}

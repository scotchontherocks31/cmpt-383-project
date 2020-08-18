package com.cmpt383.project;

import java.util.ArrayList;
import java.util.List;

import com.cmpt383.project.helpers.Differentiation;
import com.cmpt383.project.helpers.Fibonacci;
import com.cmpt383.project.helpers.Hailstone;
import com.cmpt383.project.parser.tokenizer.TokenizerException;

import java.util.Arrays;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/")
public class CalculatorController {

    String authorName = "Shahriar Kabir Nooh";

    //Demo path for checking server viability
    @GetMapping("about")
    public String getHelloMessage(){
        return "Hello World!";
    }

    @GetMapping("name")
    public String getName(){
        return authorName;
    }

    //Simple operation request processing
    @GetMapping("add/{id1}/{id2}")
    public double getAddResult(@PathVariable("id1") double addVal1, @PathVariable("id2") double addVal2){
        return addVal1+addVal2;
    }

    @GetMapping("subtract/{id1}/{id2}")
    public double getSubtractResult(@PathVariable("id1") double subVal1, @PathVariable("id2") double subVal2){
        return subVal1-subVal2;
    }

    @GetMapping("multiply/{id1}/{id2}")
    public double getMultiplyResult(@PathVariable("id1") double mulVal1, @PathVariable("id2") double mulVal2){
        return mulVal1*mulVal2;
    }

    @GetMapping("divide/{id1}/{id2}")
    public double getDivideResult(@PathVariable("id1") double divideVal1, @PathVariable("id2") double divideVal2){
        return divideVal1/divideVal2;
    }

    //sum parser processing
    @GetMapping("sum/{id}")
    public double getSinResult(@PathVariable("id") String sumStringInit){

        String sumString = sumStringInit.replace("\"", "");
        System.out.println(sumString);
        double sumResult = 0;
        String[] stringNum = sumString.split("\\s*,\\s*");
        System.out.println(Arrays.toString(stringNum));     //print to terminal console to check validity of passed in string
        
        for(int i = 0; i < stringNum.length; i++){
            if(isNumeric(stringNum[i])){
                sumResult += Double.parseDouble(stringNum[i]);
            }
        }
        return sumResult;
    }

    //List processing
    @GetMapping("fib/{id}")
    public String getFibList(@PathVariable("id") double input){

        int fibVal = (int) Math. round(input);
        List<Integer> fibList = new ArrayList<>();
        Fibonacci fibonacci = new Fibonacci(fibVal);
        fibList = fibonacci.fibCollection();
        return fibList.toString();
    }

    @GetMapping("hail/{id}")
    public String getHailList(@PathVariable("id") double input){

        int hailVal = (int) Math. round(input);
        List<Integer> hailList = new ArrayList<>();
        Hailstone hailstone = new Hailstone(hailVal);
        hailList = hailstone.hailCollection();
        return hailList.toString();
    }

    @GetMapping("triples/{id}")
    public String getTriplesList(@PathVariable("id") double input){

        int limit = (int) Math. round(input);
        String triples = pythagoreanTriples(limit);
        return triples;
    }

    //Differentiation handler
    @GetMapping("diff/eqn/{id}")
    public String getDiffEqn(@PathVariable("id") String eqn) throws TokenizerException{
        String realEqn = eqn.replace("\"", "");
        System.out.println(realEqn);
        Differentiation differentiation = new Differentiation(realEqn);
        return differentiation.getDerivative();
    }

    @GetMapping("diff/val/{id1}/{id2}")
    public double getDiffVal(@PathVariable("id1") String eqn, 
                                @PathVariable("id2") double numeric) throws TokenizerException{

        String realEqn = eqn.replace("\"", "");
        System.out.println(realEqn);
        Differentiation differentiation = new Differentiation(realEqn);
        System.out.println(differentiation.getNumeric(numeric));
        return differentiation.getNumeric(numeric);
    }

    //Simple trigonometric values processing
    @GetMapping("sin/{id}")
    public double getSinResult(@PathVariable("id") double sinVal){
        return Math.sin(sinVal);
    }

    @GetMapping("cos/{id}")
    public double getCosResult(@PathVariable("id") double sinVal){
        return Math.cos(sinVal);
    }

    @GetMapping("tan/{id}")
    public double getTanResult(@PathVariable("id") double sinVal){
        return Math.tan(sinVal);
    }

    //ERROR HANDLING
    @ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Bad argument")
    @ExceptionHandler(IllegalArgumentException.class)
    public void badInputExceptionHandler(){
        //Nothing to do
    }

    //Helper functions
    public static boolean isNumeric(String str)
    {
        for (char c : str.toCharArray())
        {
            if (!Character.isDigit(c)) return false;
        }
        return true;
    }

    public String pythagoreanTriples(int limit){
        String result = "";

        for(int i=1; i <= limit; i++){
            for(int j=1; j<=(i+1); j++){
                for(int k=j; k<=(i+1); k++){
                    if(k*k + j*j == i*i){
                        if(i != limit)
                            result += "(" + j + ", " + k + ", " + i +"), ";
                        else
                            result += "(" + j + ", " + k + ", " + i +") ";
                    }
                }
            }
        }
        return result;
    }
    
}
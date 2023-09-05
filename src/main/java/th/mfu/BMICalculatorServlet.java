package th.mfu;

import java.io.IOException;

import org.apache.log4j.pattern.IntegerPatternConverter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/calbmi")
public class BMICalculatorServlet extends HttpServlet{

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //TODO: get parameter from request: "weight" and "height"
        String strHeight = request.getParameter("height");
        String strWeight = request.getParameter("weight");
        //TODO: calculate bmi
        double h = Double.parseDouble(strHeight);
        double w = Double.parseDouble(strWeight);
        int bmi = (int)Math.round(w/(h*h));
        //TODO: determine the built from BMI
        String built;
        if(bmi<18.5){
            built = "underweight";
        }else if(bmi<25){
            built ="normal";
        }else if(bmi<30){
            built = "overweight";
        }else if(bmi<35){
            built = "obese";
        }else{
            built ="extrtemely obese";
        }
        //TODO: add bmi and built to the request's attribute
        request.setAttribute("bmi", bmi);
        request.setAttribute("built", built);
        //TODO: forward to jsp
        request.getRequestDispatcher("bmi_result.jsp").forward(request, response);
    }
    
}

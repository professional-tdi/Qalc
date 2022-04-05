package world.ntdi.mathutils.Api;

import org.json.simple.parser.ParseException;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuadraticMath {
    public static double qalc(String expr) throws IOException, ParseException {
        return Double.parseDouble(MathApi.mathApiResult(expr));
    }

    public static double getX(double a, double b) throws IOException, ParseException {
        return -b / (2 * a);
    }

    public static double getY(double x, String expr) throws IOException, ParseException {
        String expression = expr.replaceAll("x", "(" + x + ")");
        System.out.println(expression);
        return Double.parseDouble(MathApi.mathApiResult(expression));
    }

    public static String getPoints5(double x, String expr) throws IOException, ParseException {
        StringBuilder sb = new StringBuilder();
        double num1 = x-2;
        double num2 = x-1;
        double num3 = x;
        double num4 = x+1;
        double num5 = x+2;

        String expression1 = expr.replaceAll("x", "(" + num1 + ")");
        String expression2 = expr.replaceAll("x", "(" + num2 + ")");
        String expression3 = expr.replaceAll("x", "(" + num3 + ")");
        String expression4 = expr.replaceAll("x", "(" + num4 + ")");
        String expression5 = expr.replaceAll("x", "(" + num5 + ")");

        sb.append("(").append(num1).append(", ").append(getY(num1, expression1)).append(")\n");
        sb.append("(").append(num2).append(", ").append(getY(num2, expression2)).append(")\n");
        sb.append("(").append(num3).append(", ").append(getY(num3, expression3)).append(")\n");
        sb.append("(").append(num4).append(", ").append(getY(num4, expression4)).append(")\n");
        sb.append("(").append(num5).append(", ").append(getY(num5, expression5)).append(")\n");

        return sb.toString();
    }

    public static String getDomainAndRange(double x, double a) {
        if (a >= 0) {
            return "Domain: (-∞, -∞)\nRange: (" + x + ", -∞)";
        } else if (a < 0) {
            return "Domain: (∞, ∞)\nRange: (" + x + ", ∞)";
        }
        return null;
    }

    public static String minOrMax(double a){
        if (a >= 0) {
            return "Maximum Point";
        } else if (a < 0) {
            return "Minimum Point";
        }
        return null;
    }

    public static String getAnswer(String expr) throws IOException, ParseException {
        String expression = expr.replaceAll("x", "(" + 0 + ")");
        return MathApi.mathApiResult(expression);
    }
    
    public static String getDiscriminant(double a, double b, double c) throws IOException, ParseException {
        String expression = "(" + b + ")^2 - 4(" + a + ")(" + c + ")";
        return MathApi.mathApiResult(expression);
    }

    public static List<String> quadForm(double a, double b, double c) throws IOException, ParseException {
        String expression1 = "(-" + b + " + sqrt(" + getDiscriminant(a, b, c) + ")) / 2(" + a + ")";
        String expression2 = "(-" + b + " - sqrt(" + getDiscriminant(a, b, c) + ")) / 2(" + a + ")";
        List<String> list = new ArrayList<String>();
        list.add(MathApi.mathApiResult(expression1));
        list.add(MathApi.mathApiResult(expression2));
        return list;
    }
}

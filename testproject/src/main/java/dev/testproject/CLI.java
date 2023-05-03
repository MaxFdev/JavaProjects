package dev.testproject;

// import java.util.Scanner;
// import org.jfree.chart.ChartFactory;
// import org.jfree.chart.ChartUtils;
// import org.jfree.chart.JFreeChart;
// import org.jfree.data.category.DefaultCategoryDataset;

// import java.util.Scanner;
// import org.knowm.xchart.BitmapEncoder;
// import org.knowm.xchart.CategoryChart;
// import org.knowm.xchart.CategoryChartBuilder;
// import org.knowm.xchart.style.Styler;

public class CLI {
    public static void main(String[] args) {

    }

    // private class a {
    //         private a() {
    //         Scanner scanner = new Scanner(System.in);
    //         System.out.println("Enter stock ticker: ");
    //         String ticker = scanner.nextLine();
    //         // code to retrieve stock data and generate graph
    //         DefaultCategoryDataset dataset = new DefaultCategoryDataset();
    //         dataset.addValue(100, "Stock Value", "Jan");
    //         dataset.addValue(120, "Stock Value", "Feb");
    //         dataset.addValue(110, "Stock Value", "Mar");
    //         JFreeChart chart = ChartFactory.createLineChart(ticker + " Stock Value", "Month", "Value", dataset);
    //         // code to print graph to terminal
    //         try {
    //             ChartUtils.saveChartAsJPEG(new File(ticker + ".jpg"), chart, 500, 300);
    //             System.out.println("Graph saved as " + ticker + ".jpg");
    //         } catch (IOException e) {
    //             System.err.println("Error saving graph");
    //         }
    //     }
    // }


    // private class b {
    //     private b() {
    //         Scanner scanner = new Scanner(System.in);
    //         System.out.println("Enter stock ticker: ");
    //         String ticker = scanner.nextLine();
    //         // code to retrieve stock data and generate graph
    //         CategoryChart chart = new CategoryChartBuilder().width(800).height(600).title(ticker + " Stock Value")
    //                 .xAxisTitle("Month").yAxisTitle("Value").build();
    //         chart.getStyler().setLegendPosition(Styler.LegendPosition.InsideNW);
    //         chart.getStyler().setDefaultSeriesRenderStyle(CategorySeriesRenderStyle.Line);
    //         chart.addSeries(ticker, new String[] { "Jan", "Feb", "Mar" }, new double[] { 100, 120, 110 });
    //         // code to print graph to terminal
    //         try {
    //             BitmapEncoder.saveBitmap(chart, "./" + ticker, BitmapEncoder.BitmapFormat.JPG);
    //             System.out.println("Graph saved as " + ticker + ".jpg");
    //         } catch (IOException e) {
    //             System.err.println("Error saving graph");
    //         }
    //     }
    // }
}

package src;

import java.io.*;

public class NetProfit {
    public static void main(String[] args) throws IOException {


        if (args.length != 1) {
            System.out.println("Usage: java NetProfit <file name>");
            return;
        }


        String filepath = args[0];
        BufferedReader reader = new BufferedReader(new FileReader(filepath)); 

        DoubleQueueImpl queue = new DoubleQueueImpl();
            
        int totalStocks = 0;
        double netProfit = 0;

        String line;

        while ((line = reader.readLine()) != null) {

            //* Parse each line depending on if it is buy or sell
            String[] parts = line.split("\\s+"); // \\s+ => {\\s} = space/tab/new line etc..)  {+} = one or more of the preceding pattern
            
            //! Buy
            if (parts[0].equals("buy")){

                // format = buy X price Y
                int quantity = Integer.parseInt(parts[1]);  // parts 1 = X
                double price = Double.parseDouble(parts[3]);// parts 3 = Y

                queue.enqueue(quantity);
                queue.enqueue(price);
                totalStocks += quantity;
                
            }
            //! Sell
            else if(parts[0].equals("sell")){
                int sellQuantity = Integer.parseInt(parts[1]);
                double sellPrice = Double.parseDouble(parts[3]);

                if(sellQuantity > totalStocks){
                    System.out.println("Error: Not enough stocks to sell");
                    return;
                }


                while (sellQuantity > 0){

                    //* Dequeue first item into availableQuantity and its price into buyPrice
                    int availableQuantity = (int) queue.dequeue();
                    double buyPrice = queue.dequeue();

                    //* Calculate quantity to sell. Limit to available quantity
                    int quantityToSell = Math.min(sellQuantity, availableQuantity);  // Math.min(x, y) => returns the smaller of x and y
                    
                    //* Update netProfit
                    netProfit += (quantityToSell * (sellPrice - buyPrice));

                    //* Update sellQuantity
                    sellQuantity -= quantityToSell; // Removed either availableQuantity or sellQuantity and check later if it was enough

                    //* Update totalStocks
                    totalStocks -= quantityToSell;

                    //* Check if current batch has more sticks to sell, if so add to queue
                    if (quantityToSell < availableQuantity) {
                        queue.enqueue(availableQuantity - quantityToSell);
                        queue.enqueue(buyPrice);
                    }
                }
            }
        }

        System.out.printf("Net Profit/Loss: %.2f\n", netProfit);
        reader.close();
    }
}
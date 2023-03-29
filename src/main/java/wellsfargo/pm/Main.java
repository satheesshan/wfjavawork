package wellsfargo.pm;

import wellsfargo.pm.models.Portfolio;
import wellsfargo.pm.models.Security;
import wellsfargo.pm.models.Transaction;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;

public class Main {

    public static void main(String[] args) {

        // Note keeping the flow for setting the CSV paths CRUDE!
        if (args == null) {
            System.out.println("Please Provide a Valid Path");
            System.exit(0);
        }
        String folderPath = args[0];
        Path path = Paths.get(folderPath);
        if (!Files.isDirectory(path)) {
            System.out.println("Please Provide a valid folder where transactions, portfolio and securities CSV's exist");
            System.exit(0);
        }

        // specialized classes setting up the correct Model Pojo mappers and Collections of Model Pojo's from input CSV'
        SecurityCSVReader securityFileReader = new SecurityCSVReader(folderPath + "\\securities.csv");
        PortfolioCSVReader portfolioFileReader = new PortfolioCSVReader(folderPath + "\\portfolios.csv");
        TransactionCSVReader transactionFileReader = new TransactionCSVReader(folderPath + "\\transactions.csv");

        try {
            // Load the data into Business Model/Pojos
            Map<String, Security> securityMap = securityFileReader.getSecurity();
            Map<String, Portfolio> portfolioMap = portfolioFileReader.getPortfolios();
            List<Transaction> transactionList = transactionFileReader.getTransactions();

            // specialized classes setting up the correct CSV writters for OMS Types
            AAAOMSWriter aaaomsWriter = new AAAOMSWriter(folderPath + "\\oms.aaa");
            aaaomsWriter.export(transactionList, securityMap, portfolioMap);

            BBBOMSWriter bbbomsWriter = new BBBOMSWriter(folderPath + "\\oms.bbb");
            bbbomsWriter.export(transactionList, securityMap, portfolioMap);

            CCCOMSWriter cccomsWriter = new CCCOMSWriter(folderPath + "\\oms.ccc");
            cccomsWriter.export(transactionList, securityMap, portfolioMap);


        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

package CustomDataprovider;

import org.testng.annotations.DataProvider;

public class CustomDataProvider {

    @DataProvider(name = "LogInDataProvider")
    public Object[][] getData(){
        Object[][] data = {{"MyTestAccount","MyTestAccountPwd"},{"abxd@gmail.com","abc"},{"xyz@gmail.com","xyz"}};
        return data;
    }
}

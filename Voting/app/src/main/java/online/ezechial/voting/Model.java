package online.ezechial.voting;

public class Model{
    private DB newDB;
    private Boolean connectCond;
    private Boolean urlSet;
    public Model(){
        newDB = new DB();
        urlSet = false;
        connectCond = false;
    }
    public boolean getConnection(){
        return connectCond;
    }
    public void Run(){
        connectCond = newDB.connectDB();
    }
    public void setServerLocation(String serverLocation){
        newDB.setServerLocation(serverLocation);
        urlSet = true;
    }
    public void insertSmile(){
        newDB.insertData(1);
    };
    public void insertNeutral(){
        newDB.insertData(2);
    }
    public void insertSad(){
        newDB.insertData(3);
    }
}

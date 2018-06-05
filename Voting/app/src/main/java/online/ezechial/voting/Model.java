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
    public boolean insertSmile(){
        return newDB.insertData(1);
    };
    public boolean insertNeutral(){
        return newDB.insertData(2);
    }
    public boolean insertSad(){
        return newDB.insertData(3);
    }
}

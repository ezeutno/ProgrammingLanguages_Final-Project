package online.ezechial.voting;

public class Model {
    DB newDB;
    Boolean connectCond;
    public Model(){
        newDB = new DB();
        connectCond = newDB.connectDB();
    }
    public boolean getConnection(){
        return connectCond;
    }
    public void reRun(){
        connectCond = newDB.connectDB();
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

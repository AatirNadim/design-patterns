package design_patterns.creational;

interface Connection {
    void connect();
}

interface Statement {
    void execute();
}

class PGConnection implements Connection {
    @Override
    public void connect() {
        System.out.println("this is a pg connection");
    }
}

class PGStatement implements Statement {
    @Override
    public void execute() {
    }
}


class MSConnection implements Connection {
    @Override
    public void connect() {

    }
}

interface DBFactory {
    Connection createConnection();
    Statement createStatement();
}


class PGFactory implements DBFactory {
    @Override
    public Connection createConnection() {
        return new PGConnection();
    }

    @Override
    public Statement createStatement() {
        return new PGStatement();
    }
}
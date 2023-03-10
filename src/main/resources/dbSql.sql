CREATE PROCEDURE getUser (userId int)
BEGIN
    SELECT * FROM user
        WHERE id = userId;
end;
# CallableStatement cbst = conn.prepareCall("{call getUser(?)}");
# cbst.setInt(X, 1);
# cbst.execute();
# ResultSet resSet = cbst.getResultSet();
# while...



CREATE PROCEDURE UserCount (OUT cnt int)
BEGIN
    SELECT COUNT(*) INTO cnt FROM user;
end;
# CallableStatement cbst = conn.prepareCall("{call UserCount(?)}");
# cbst.registerOutParameter(x, Type.INTEGER);
# cbst.execute();
# sout(cbst.getInt(x);



CREATE PROCEDURE getUserCount ()
BEGIN
    SELECT COUNT(*) FROM user;
    SELECT COUNT(*) FROM user
        WHERE username = 'Valdis';
end;
# CallableStatement cbst = conn.prepareCall("{call getUserCount()}");
# cbst.execute();
# ResultSet resSet = cbst.getResultSet();
# while...
# cbst.getMoreResults()



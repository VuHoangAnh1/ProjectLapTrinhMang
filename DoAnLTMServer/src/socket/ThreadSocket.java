package socket;

import java.net.Socket;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 *
 * @author DoanNhatNam
 */
public class ThreadSocket extends Thread {

    Socket socket = null;
    private Connection con;
    private Statement stm;
    private ResultSet rs;
    private String sql;

    public ThreadSocket(Socket socket) {

        System.out.println("Call to thread socket. ");
        System.out.println("Socket is connected: " + socket.isConnected());
        System.out.println("Socket address: " + socket.getInetAddress().getHostAddress());
        System.out.println("Socket port: " + socket.getPort());
        this.socket = socket;
    }

    public void run() {
        try {
            // tao luong gui du lieu toi client
            String[] arr = {null};
            String st = "";
            //tao luong nhan du lieu tu client
            //BufferedReader din= new BufferedReader(new InputStreamReader(socket.getInputStream()));
            DataInputStream din = new DataInputStream(socket.getInputStream());
            // tao luong gui du lieu toi client
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            System.out.println("Xu ly du lieu. ");

            while (din.available() != 0) {
                st = din.readUTF();
                System.out.println("Client gui:" + st);
                arr = st.split("#");
                if (null != arr && arr.length == 5) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                    System.out.println("chuoi 3:" + arr[2]);
                    System.out.println("chuoi 4:" + arr[3]);
                    System.out.println("chuoi 5:" + arr[4]);
                }
                if (null != arr && arr.length == 6) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                    System.out.println("chuoi 3:" + arr[2]);
                    System.out.println("chuoi 4:" + arr[3]);
                    System.out.println("chuoi 5:" + arr[4]);
                    System.out.println("chuoi 6:" + arr[5]);
                }
                if (null != arr && arr.length == 4) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                    System.out.println("chuoi 3:" + arr[2]);
                    System.out.println("chuoi 4:" + arr[3]);
                }if (null != arr && arr.length == 3) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                    System.out.println("chuoi 3:" + arr[2]);
                }if (null != arr && arr.length == 2) {

                    System.out.println("chuoi 1:" + arr[0]);
                    System.out.println("chuoi 2:" + arr[1]);
                }else {
                    System.out.println(arr != null ? arr.toString() : "Null");
                }

                if (null != arr && 5== arr.length ) {
                    if (arr[4].equalsIgnoreCase("add")) //goi ham chen csdl vao
                    {
                        insertData(arr[0], arr[1], arr[2],arr[3]);
                    }
                    if (arr[4].equalsIgnoreCase("xoa")) {
                        deleteData(arr[0],arr[1],arr[3]);// goi ham xoa
                    }
                    if (arr[4].equalsIgnoreCase("suadl")) {
                        updateData(arr[0], arr[1], arr[2],arr[3]);//goi ham sua
                    }
                }
                if (null != arr && 4== arr.length ) {
                    if (arr[3].equalsIgnoreCase("dangky")) {
                        DangKy(arr[0], arr[1], arr[2]);
                    }
                    if(arr[3].equalsIgnoreCase("DoiMK")){
                        String result="";
                        if(DoiMK(arr[0], arr[1], arr[2]).equals("SaiMK")){
                            result = "ThatBai";
                            System.out.print(result);
                            Thread.sleep(1000);
                            dos.writeUTF(result);// gui du lieu xuong sever
                            dos.flush();
                        }else
                            result = "ThanhCong";
                            System.out.print(result);
                            Thread.sleep(1000);
                            dos.writeUTF(result);// gui du lieu xuong sever
                            dos.flush();
                            DoiMK(arr[0], arr[1], arr[2]);
                    }
                }
                if (null != arr && 6== arr.length ) {
                    if (arr[5].equalsIgnoreCase("CapNhatThongTin")) {
                        CapNhatThongTin(arr[0], arr[1], arr[2],arr[3],arr[4]);
                    }
                }
                if (null != arr && 2 == arr.length ) {
                    if (arr[1].equalsIgnoreCase("LayThongTin")) {
                        String user = null;
                        String result = "";
                        try {
                            user = xemThongTinND(arr[0]);// gan ham xemdata cho bien sv
                        } catch (Exception e) {
                            result = "DBError";
                            System.out.println("Loi ket noi database: " + e);
                        }
                        if ((null == user || user.isEmpty())
                                && !result.equals("DBError")) {
                            result = "OK";
                        } else if ((null != user && !user.isEmpty())
                                && !result.equals("DBError")) {
                            result = user;
                        }
                        System.out.print(result);
                        dos.writeUTF(result);// gui du lieu xuong sever
                        dos.flush();
                        }
                    if(arr[1].equalsIgnoreCase("search")){
                        String user = null;
                        String students = null;
                        String result = "";
                        try {
                            user = Search(arr[0]);
                            students = xemData();
                        } catch (Exception e) {
                            result = "DBError";
                            System.out.println("Loi ket noi database: " + e);
                        }
                        if(!arr[0].equals("")){
                            if ((null == user || user.isEmpty())
                                    && !result.equals("DBError")) {
                                result = "OK";
                            } else if ((null != user && !user.isEmpty())
                                    && !result.equals("DBError")) {
                                result = user;
                            }
                        }else
                            if ((null == user || user.isEmpty())
                                    && !result.equals("DBError")) {
                                result = "OK";
                            } else if ((null != user && !user.isEmpty())
                                    && !result.equals("DBError")) {
                                result = students;
                            }
                        System.out.print(result);
                        dos.writeUTF(result);// gui du lieu xuong sever
                        dos.flush();
                    }
                    }
                if (null != arr && 3== arr.length ) {
                    if (arr[2].equalsIgnoreCase("dangnhap")) {
                        String students = null;
                        String ketqua = DangNhap(arr[0], arr[1]);
                        if(ketqua == "Admin"){
                            String result = "";
                            try {
                                students = xemData();// gan ham xemdata cho bien sv
                            } catch (Exception e) {
                                result = "DBError";
                                System.out.println("Loi ket noi database: " + e);
                            }
                            if ((null == students || students.isEmpty())
                                    && !result.equals("DBError")) {
                                result = "OK";
                            } else if ((null != students && !students.isEmpty())
                                    && !result.equals("DBError")) {
                                result = students;
                            }
                            System.out.print(result);
                            Thread.sleep(1000);
                            dos.writeUTF(result);// gui du lieu xuong sever
                            dos.writeUTF("Admin");
                            dos.flush();
                            
                        }else if(ketqua == "NguoiDung"){
                            String result = "";
                            try {
                                students = xemData();// gan ham xemdata cho bien sv
                            } catch (Exception e) {
                                result = "DBError";
                                System.out.println("Loi ket noi database: " + e);
                            }
                            if ((null == students || students.isEmpty())
                                    && !result.equals("DBError")) {
                                result = "OK";
                            } else if ((null != students && !students.isEmpty())
                                    && !result.equals("DBError")) {
                                result = students;
                            }
                            System.out.print(result);
                            Thread.sleep(1000);
                            dos.writeUTF(result);// gui du lieu xuong sever
                            dos.writeUTF("NguoiDung");
                            dos.flush();
                        }
                        else{
                            String result = "ThatBai";
                            System.out.print(result);
                            Thread.sleep(1000);
                            dos.writeUTF(result);// gui du lieu xuong sever
                            dos.flush();
                        }
                    }
                }
                String students = null;
                String result = "";
                try {
                    students = xemData();// gan ham xemdata cho bien sv
                } catch (Exception e) {
                    result = "DBError";
                    System.out.println("Loi ket noi database: " + e);
                }

                if ((null == students || students.isEmpty())
                        && !result.equals("DBError")) {
                    result = "OK";
                } else if ((null != students && !students.isEmpty())
                        && !result.equals("DBError")) {
                    result = students;
                }
                System.out.print(result);
                Thread.sleep(1000);
                dos.writeUTF(result);// gui du lieu xuong sever
                dos.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //tao conet den csdl 
    public void ConnectData() throws Exception {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String URL = "jdbc:sqlserver://localhost:1433;databaseName=QuanLyDiemSV2;user=sa;password=123456;encrypt=false";
            con = DriverManager.getConnection(URL);
            stm = con.createStatement();
        } catch (Exception e) {
            System.out.println("khong nap duoc driver" + e);
        }
    }
    public String DoiMK(String masv, String mkcu, String mkmoi) throws Exception{
        ConnectData();
        String ketqua = null;
        sql = "Select * from NguoiDung where MaND = '"+masv+"' and MatKhau = '"+mkcu+"'";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            sql = "UPDATE NguoiDung set MatKhau = '"+mkmoi+"' where MaND = '"+masv+"'";
            int row = stm.executeUpdate(sql);
            System.out.println("update number row: " + row);
            con.close();
            
            return ketqua = "ThanhCong";
        }else
            return ketqua="SaiMK"; 
    }
    public boolean CapNhatThongTin(String masv, String tensv, String email, String sdt, String lop) throws Exception {
        ConnectData();
        //sua ten sv va diem sv khi biet masv
        sql = "UPDATE NguoiDung set TenNd = '" + tensv + "',Email ='" + email + "',SDT='"+sdt+"',LopHoc='"+lop+"' where MaND='" + masv + "'";
        //sql = "UPDATE BangDiem set dltm = '" + diem + "' where MaSV='" + masv + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("update number row: " + row);
        con.close();
        
        return true;
    }
    
    public String xemThongTinND(String mssv) throws Exception {
        ConnectData();
        sql = "select * from NguoiDung where MaND ='" + mssv + "'";
        rs = stm.executeQuery(sql);
        
        StringBuilder thongtin = new StringBuilder();
        if(rs.next()){
                String sCode = rs.getString("MaND");
                String sName = rs.getString("TenNd");
                String sEmail = rs.getString("Email");
                String sSDT = rs.getString("SDT");
                String sClass = rs.getString("LopHoc");

                if (sCode == null) {
                    sCode = "";
                }
                if (sName == null) {
                    sName = "";
                }
                if (sEmail == null) {
                    sEmail = "";
                }
                if (sSDT == null) {
                    sSDT = "";
                }
                if (sClass == null) {
                    sClass = "";
                }
                String thongtinnd = sCode.trim() + "," + sName.trim() + "," + sEmail.trim() + "," + sSDT.trim()+"," + sClass.trim()+";";
                thongtin.append(thongtinnd);    
            System.out.print(thongtin.toString());
            con.close();
        }
        return thongtin.toString();
    }

    public boolean DangKy(String mand, String tennd, String matkhau) throws Exception {
        ConnectData();
        sql = "INSERT INTO NguoiDung(MaND,TenNd,MatKhau) VALUES('" + mand + "','" + tennd + "','" + matkhau + "',0)";
        int row = 0;
        row = stm.executeUpdate(sql);
        System.out.println("so row insert vao: " + row + "\n");
        con.close();
        return true;
    }
    public String DangNhap(String mand, String matkhau) throws Exception {
        ConnectData();
        String result="";
        sql = "Select * From NguoiDung where MaND ='"+mand+"'and MatKhau ='"+matkhau+"'";
        rs = stm.executeQuery(sql);
        if(rs.next()){
            String pq = "Select * From NguoiDung Where MaND = '"+mand+"' and PhanQuyen = 1";
            ResultSet rspq = stm.executeQuery(pq);
            if(rspq.next())
                return result = "Admin";
            else
                return result = "NguoiDung";
        }else
            return result = "ThatBai";
    }
    //nhap du lieu vao csdl
    public boolean insertData(String masv, String tensv, String diem, String monhoc) throws Exception {
        ConnectData();
        sql = "INSERT INTO BangDiem(MaSV,TenSV,dltm,MonHoc) VALUES('" + masv + "','" + tensv + "','" + diem + "','" + monhoc + "')";
        int row = 0;
        row = stm.executeUpdate(sql);
        System.out.println("so row insert vao: " + row + "\n");
        con.close();
        return true;
    }
    public String xemData() throws Exception {
        ConnectData();
        sql = "select * from BangDiem";
        
        rs = stm.executeQuery(sql);
        StringBuilder students = new StringBuilder();

        if (!rs.next()) {
            return "";
        }
        while (rs.next()) {
            String sCode = rs.getString("MaSV");
            String sName = rs.getString("TenSV");
            String sScore = rs.getString("dltm");
            String sSubject = rs.getString("MonHoc");

            if (sCode == null) {
                sCode = "";
            }
            if (sName == null) {
                sName = "";
            }
            if (sScore == null) {
                sScore = "";
            }
            if (sSubject == null) {
                sSubject = "";
            }
            String student = sCode.trim() + "," + sName.trim() +  "," + sSubject.trim()+ "," +sScore.trim()+";";
            students.append(student);
        }
        System.out.print(students.toString());
        con.close();
        return students.toString();
    }

    public String Search(String thongtin) throws Exception {
        ConnectData();
        sql = "select * from BangDiem where MaSV ='"+thongtin+"' or TenSV ='"+thongtin+"' or MonHoc='"+thongtin+"' ";
        rs = stm.executeQuery(sql);
        StringBuilder students = new StringBuilder();

        while (rs.next()) {
            String sCode = rs.getString("MaSV");
            String sName = rs.getString("TenSV");
            String sScore = rs.getString("dltm");
            String sSubject = rs.getString("monhoc");

            if (sCode == null) {
                sCode = "";
            }
            if (sName == null) {
                sName = "";
            }
            if (sScore == null) {
                sCode = "";
            }if (sSubject == null) {
                sCode = "";
            }
            String student = sCode.trim() + "," + sName.trim() + "," + sScore.trim() + "," + sSubject.trim()+";";
            students.append(student);
        }
        System.out.print(students.toString());
        con.close();
        return students.toString();
    }

    public boolean deleteData(String masv, String tensv, String monhoc) throws Exception {
        ConnectData();
        sql = "DELETE FROM BangDiem WHERE MaSV='" + masv + "' and TenSV='"+tensv+"' and MonHoc='"+monhoc+"'";
        int row = stm.executeUpdate(sql);
        System.out.println("so row xoa: " + row);
        con.close();
        return true;
    }

    public boolean updateData(String masv, String tensv, String diem, String monhoc) throws Exception {
        ConnectData();
        //sua ten sv va diem sv khi biet masv
        sql = "UPDATE BangDiem set TenSV = '" + tensv + "',dltm='" + diem + "',MonHoc='"+monhoc+"' where MaSV='" + masv + "'";
        //sql = "UPDATE BangDiem set dltm = '" + diem + "' where MaSV='" + masv + "'";
        int row = stm.executeUpdate(sql);
        System.out.println("update number row: " + row);
        con.close();
        return true;
    }
}

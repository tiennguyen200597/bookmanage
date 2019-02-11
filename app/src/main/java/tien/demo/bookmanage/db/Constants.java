package tien.demo.bookmanage.db;

public interface Constants {
    public  static final boolean isDEBUG=true;
    //khai baos bang nguoi dung
    public  static final String USER_TABLE="nguoiDung";
    public  static final String USER_USER_NAME="userName";
    public  static final String USER_PASSWORD="Password";
    public  static final String USER_PHONE="Phone";
    public  static final String USER_FULL_NAME="hoTen";
    // cau lenh tao bang nguoi dung
    // CREATE TABLE nguoiDung(userName  NVARCHAR(50),  Password NVARCHAR(50)  ,...

    public  static final String CREATE_USER_TABLE="CREATE TABLE "+USER_TABLE+"(" +
            "" +USER_USER_NAME+" NVARCHAR(50),"+
            "" +USER_PASSWORD+" NVARCHAR(50),"+
            "" +USER_PHONE+" NCHAR(10),"+
            "" +USER_FULL_NAME+" NVARCHAR(50)"+
            ")";
    // TYPE BOOK TABLE


    // CREATE TABLE typeBooks (MaTheLoai CHAR(5) PRIMARY KEY NOT NULL,
    // TypeName NVARCHAR(50) NOT NULL,
    // Description NVARCHAR(255),
    // Position INT
    // )

    String TYPE_BOOK_TABLE = "TypeBooks";
    String TB_COLUMN_TYPE_BOOK_ID = "MaTheLoai";
    String TB_COLUMN_TYPE_NAME = "TypeName";
    String TB_COLUMN_DESCRIPTION = "Description";
    String TB_COLUMN_POSITION = "Position";


    String CREATE_TYPE_TABLE = "CREATE TABLE " + TYPE_BOOK_TABLE + "(" +
            "" + TB_COLUMN_TYPE_BOOK_ID + " CHAR(5) PRIMARY KEY NOT NULL," +
            "" + TB_COLUMN_TYPE_NAME + " NVARCHAR(50) NOT NULL," +
            "" + TB_COLUMN_DESCRIPTION + " NVARCHAR(255)," +
            "" + TB_COLUMN_POSITION + " INT" +
            ")";

// BOOK TABLE

    // CREATE TABLE Books (MaSach CHAR(5) PRIMARY KEY NOT NULL,
    // MaTheLoai NCHAR(50),
    // TacGia NVARCHAR(50),
    // NXB NVARCHAR(50),
    // giaBia FLOAT NOT NULL,
    // soLuong INT NOT NULL
    //)
    String TABLE_BOOK = "Books";

    String BOOK_ID = "MaSach";
    String BOOK_TYPE_BOOK_ID = "MaTheLoai";
    String BOOK_AUTHOR = "TacGia";
    String BOOK_PRODUCER = "NXB";
    String BOOK_PRICE = "giaBia";
    String BOOK_QUALITY = "soLuong";


    String CREATE_BOOK_TABLE = "CREATE TABLE " + TABLE_BOOK + "(" +
            "" + BOOK_ID + " CHAR(5) PRIMARY KEY NOT NULL," +
            "" + BOOK_TYPE_BOOK_ID + " NCHAR(50)," +
            "" + BOOK_AUTHOR + " NVARCHAR(50)," +
            "" + BOOK_PRODUCER + " NVARCHAR(50)," +
            "" + BOOK_PRICE + " FLOAT NOT NULL," +
            "" + BOOK_QUALITY + "  INT NOT NULL" +
            ")";
    // khai báo bảng hóa đơn

    String TABLE_INVOICE = "Bill";
    String I_ID = "MaHoaDon";
    String I_DATE = "NgayMua";

    // CREATE TABLE Bill (MaHoaDon NCHAR(7) PRIMARY KEY, NgayMua LONG NOT NULL)

    String CREATE_INVOICE_TABLE = "CREATE TABLE " + TABLE_INVOICE + "(" +
            "" + I_ID + " NCHAR(7) PRIMARY KEY," +
            "" + I_DATE + " LONG NOT NULL" +
            ")";
/// Bill Detail

    /// CREATE TABLE BillDetail (MaHDCT INT PRIMARY KEY AUTOINCREMENT,
    /// MaHoaDon NCHAR(7) FOREIGN KEY NOT NULL,
    // MaSach NCHAR(5) FOREIGN KEY NOT NULL,
    // SoLuongMua INT NOT NULL
    //
    /// )

    String TABLE_INVOICE_DETAIL = "BillDetail";
    String DETAIL_ID = "MaHDCT";
    String DETAIL_INVOICE_ID = "MaHoaDon";
    String DETAIL_BOOK_ID = "MaSach";
    String DETAIL_QUALITY = "SoLuongMua";

    String CREATE_BILL_DETAIL_TABLE = "CREATE TABLE " + TABLE_INVOICE_DETAIL + "(" +
            "" + DETAIL_ID + "  INTEGER PRIMARY KEY AUTOINCREMENT," +
            "" + DETAIL_INVOICE_ID + " NCHAR(7) NOT NULL ," +
            "" + DETAIL_BOOK_ID + " NCHAR(5) NOT NULL ," +
            "" + DETAIL_QUALITY + "  INT NOT NULL" +
            ")";
}

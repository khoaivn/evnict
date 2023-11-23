package com.example.myapplication;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TruDu on 3/25/18.
 */

public class Chung {

    public static class DummyItem {
        public final int id;
        public final int photoId;
        public final String title;
        public final String author;
        public final String content;

        public DummyItem(int id, int photoId, String title, String author, String content) {
            this.id = id;
            this.photoId = photoId;
            this.title = title;
            this.author = author;
            this.content = content;
        }
    }
    public static class Dialog{
        public int id;
        public String title;
        public String content;
        public Dialog(int id, String title, String content) {
            this.id = id;
            this.title = title;
            this.content = content;
        }
    }
    public static int[] index_a1 = {1,3,4,5,7,8,9,12,13,14,16,17,19,
            22,24,25,26,27,28,29,30,31,32,35,36,38,39,45,46,47,48,50,52,53,54,55,56,57,58,59,60,61,65,67,68,70,71,80,83,84,85,86,87,88,89,91,92,97,98,99,100,101,102,103,105,112,113,117,126,127,130,131,
            133,134,136,
            186,188,193,194,197,
            256,257,258,262,263,264,265,266,268,269,270,271,274,275,276,277,278,279,280,281,282,283,284,285,289,290,291,298,312,324,325,345,347,349,351,
            356,359,361,362,364,368,369,372,373,374,375,376,377,378,379,386,389,394,396,397,398,407,408,409,412,417,422,425,428,429,430,431,434,436,437
    };
    public static ArrayList<ArrayList<Dialog>> listDialogA1 = new ArrayList<ArrayList<Dialog>>() {{
        add(listDialogA1P1());
    }};
    public static ArrayList<Dialog> listDialogA1P1(){
        ArrayList<Dialog> list = new ArrayList<>();
        list.add(new Dialog(1,"Đáp án 1", "Các câu khái niệm “khổ giới hạn của đường bộ“, “dải phân cách“, “đuờng phố“, “xe quá tải trọng đường bộ“, “phần đường xe chạy“, “đường chính“, “phương tiện giao thông thô sơ đường bộ“, “vạch kẻ đường“, “đường cao tốc“"));
        list.add(new Dialog(1,"Đáp án 2", "Các câu khái niệm “dừng xe“, “đỗ xe“, “làn xe“, “phương tiện giao thông cơ giới đường bộ“, “hàng nguy hiểm“, “đường ưu tiên“, “vận tải đa phương thức“, “hoạt động vận tải đường bộ“"));
        list.add(new Dialog(1,"Đáp án 1 và 2", "Các câu khái niệm “đường bộ“, “công trình đường bộ“, “văn hóa giao thông“"));
        list.add(new Dialog(1,"Đáp án 2 và 3", "Câu khái niệm “người điều khiển giao thông“"));
        list.add(new Dialog(1,"Đáp án 3", "Câu khái niệm “hàng siêu trường, siêu trọng“"));
        return list;
    }

//    public static ArrayList<DummyItem> listMainA1(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.ic_question_answer_24px,"150 câu hỏi", "Tất cả câu hỏi dùng cho thi GPLX ", "Focusing is about saying No." ));
//        list.add(new DummyItem(2, R.drawable.survey,"8 đề thi", "Đề thi theo chuẩn bộ đề thi thật", "Focusing is about saying No." ));
//        list.add(new DummyItem(3, R.drawable.sign,"Biển báo", "Tất cả biển báo giao thông đường bộ", "Focusing is about saying No." ));
//        list.add(new DummyItem(4, R.drawable.law,"Luật giao thông đường bộ", "Luật, Nghị định, Thông tư về đường bộ", "Focusing is about saying No." ));
//        return list;
//    }
//    public static ArrayList<DummyItem> listMainA2(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.ic_question_answer_24px,"365 câu hỏi", "Tất cả câu hỏi dùng cho thi GPLX ", "Focusing is about saying No." ));
//        list.add(new DummyItem(2, R.drawable.survey,"20 đề thi", "Đề thi theo chuẩn bộ đề thi thật", "Focusing is about saying No." ));
//        list.add(new DummyItem(3, R.drawable.sign,"Biển báo", "Tất cả biển báo giao thông đường bộ", "Focusing is about saying No." ));
//        list.add(new DummyItem(4, R.drawable.law,"Luật giao thông đường bộ", "Luật, Nghị định, Thông tư về đường bộ", "Focusing is about saying No." ));
//        return list;
//    }
//    public static ArrayList<DummyItem> listAll450(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.oto, "Câu 1 - 21", "Khái niệm đường bộ, các thuật ngữ", "Focusing is about saying No."));
//        list.add(new DummyItem(2, R.drawable.oto, "Câu 22 - 131", "Quy tắc tham gia giao thông", "Focusing is about saying No."));
//        list.add(new DummyItem(3, R.drawable.oto, "Câu 132 - 145", "Tốc độ cho phép của ô tô", "Focusing is about saying No."));
//        list.add(new DummyItem(4, R.drawable.oto, "Câu 146 - 170", "Trọng tải của xe ô tô", "Focusing is about saying No."));
//        list.add(new DummyItem(5, R.drawable.oto, "Câu 171 - 175", "Ký hiệu việc bảo quản hàng hóa", "Focusing is about saying No."));
//        list.add(new DummyItem(6, R.drawable.oto, "Câu 176 - 200", "Văn hóa, hành vi lái xe", "Focusing is about saying No."));
//        list.add(new DummyItem(7, R.drawable.oto, "Câu 201 - 235", "Kỹ thuật lái xe ô tô", "Focusing is about saying No."));
//        list.add(new DummyItem(8, R.drawable.oto, "Câu 236 - 255", "Cấu tạo và sửa chữa xe ô tô","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(9, R.drawable.oto, "Câu 256 - 355", "Hệ thống biển báo hiệu đường bộ","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(10, R.drawable.oto, "Câu 356 - 450", "Sa hình", "Action is the foundational key to all success."));
//        return list;
//    }
//    public static ArrayList<DummyItem> listAll600(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.oto, "Câu 1 - 16", "Khái niệm trong giao thông đường bộ", "Focusing is about saying No."));
//        list.add(new DummyItem(2, R.drawable.oto, "Câu 17 - 166", "Quy tắc giao thông đường bộ", "Focusing is about saying No."));
//        list.add(new DummyItem(3, R.drawable.oto, "Câu 167 - 192", "Nghiệp vụ vận tải", "Focusing is about saying No."));
//        list.add(new DummyItem(4, R.drawable.oto, "Câu 193 - 213", "Văn hóa, đạo đức người lái xe", "Focusing is about saying No."));
//        list.add(new DummyItem(5, R.drawable.oto, "Câu 214 - 269", "Kỹ thuật lái xe", "Focusing is about saying No."));
//        list.add(new DummyItem(6, R.drawable.oto, "Câu 270 - 304", "Cấu tạo và sửa chữa xe", "Focusing is about saying No."));
//        list.add(new DummyItem(7, R.drawable.oto, "Câu 305 - 486", "Biển báo hiệu đường bộ", "Focusing is about saying No."));
//        list.add(new DummyItem(8, R.drawable.oto, "Câu 487 - 600", "Giải các thế sa hình và kỹ năng xử lý tình huống giao thông", "Focusing is about saying No."));
//        list.add(new DummyItem(9, R.drawable.oto, "60 câu hỏi điểm liệt", "Các câu hỏi bắt buộc phải trả lời đúng", "Focusing is about saying No."));
//        return list;
//    }
//    public static ArrayList<DummyItem> listListExamA1(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.oto, "Đề số 1", "Của bộ 8 bộ đề chuẩn","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(2, R.drawable.oto, "Đề số 2", "Của bộ 8 bộ đề chuẩn", "Action is the foundational key to all success."));
//        list.add(new DummyItem(3, R.drawable.oto, "Đề số 3", "Của bộ 8 bộ đề chuẩn","Our only limitations are those we set up in our own minds."));
//        list.add(new DummyItem(4, R.drawable.oto, "Đề số 4", "Của bộ 8 bộ đề chuẩn","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(5, R.drawable.oto, "Đề số 5", "Của bộ 8 bộ đề chuẩn","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(6, R.drawable.oto, "Đề số 6", "Của bộ 8 bộ đề chuẩn","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(7, R.drawable.oto, "Đề số 7", "Của bộ 8 bộ đề chuẩn","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(8, R.drawable.oto, "Đề số 8", "Của bộ 8 bộ đề chuẩn","Deciding what not do do is as important as deciding what to do."));
//        return list;
//    }
//    public static ArrayList<DummyItem> listListExamA2(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(0, R.drawable.oto, "Đề thi chọn tự động", "Theo mẫu đề chuẩn của bộ Giao thông vận tải","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(1, R.drawable.oto, "Đề số 1", "Theo chuẩn của bộ Giao thông vận tải","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(2, R.drawable.oto, "Đề số 2", "Theo chuẩn của bộ Giao thông vận tải", "Action is the foundational key to all success."));
//        list.add(new DummyItem(3, R.drawable.oto, "Đề số 3", "Theo chuẩn của bộ Giao thông vận tải","Our only limitations are those we set up in our own minds."));
//        list.add(new DummyItem(4, R.drawable.oto, "Đề số 4", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(5, R.drawable.oto, "Đề số 5", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(6, R.drawable.oto, "Đề số 6", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(7, R.drawable.oto, "Đề số 7", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(8, R.drawable.oto, "Đề số 8", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(9, R.drawable.oto, "Đề số 9", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(10, R.drawable.oto, "Đề số 10", "Theo chuẩn của bộ Giao thông vận tải","Deciding what not do do is as important as deciding what to do."));
//        return list;
//    }
//    public static ArrayList<DummyItem> listSign(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.p101, "Biển báo cấm", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(2, R.drawable.p247, "Biển báo nguy hiểm", "Hình tam giác đều, viền đỏ, nền vàng, hình vẽ màu đen", "Action is the foundational key to all success."));
//        list.add(new DummyItem(3, R.drawable.p301a, "Biển báo hiệu lệnh", "Hình tròn, nền xanh với hình vẽ màu trắng","Our only limitations are those we set up in our own minds."));
//        list.add(new DummyItem(4, R.drawable.p401, "Biển báo chỉ dẫn", "Hình vuông hoặc hình chữ nhật, nền xanh, hình vẽ màu trắng","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(5, R.drawable.p505a, "Biển báo phụ", "Hình vuông hoặc hình chữ nhật, viền đen, nền trắng, hình vẽ màu đen, thường nằm dưới các biển chính để bổ sung làm rõ ý nghĩa các biển chính","Deciding what not do do is as important as deciding what to do."));
//        list.add(new DummyItem(6, R.drawable.p1_1, "Vạch kẻ đường", "Nhằm hướng dẫn, điều khiển giao thông","Deciding what not do do is as important as deciding what to do."));
//        return list;
//    }
//    public static ArrayList<DummyItem> listLaw(){
//        ArrayList<DummyItem> list = new ArrayList<>();
//        list.add(new DummyItem(1, R.drawable.p101, "LUẬT GIAO THÔNG ĐƯỜNG BỘ", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(1, R.drawable.p101, "LUẬT GIAO THÔNG ĐƯỜNG BỘ", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(1, R.drawable.p101, "LUẬT GIAO THÔNG ĐƯỜNG BỘ", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(1, R.drawable.p101, "LUẬT GIAO THÔNG ĐƯỜNG BỘ", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        list.add(new DummyItem(1, R.drawable.p101, "LUẬT GIAO THÔNG ĐƯỜNG BỘ", "Hình tròn, viền đỏ, nền trắng, hình vẽ màu đen","A quitter never wins and a winner never quits."));
//        return list;
//    }
    public static int getIndexA1(int id, int start, int finish){
        int trungbinh = (start + finish) / 2;
        if (index_a1[trungbinh] == id) return trungbinh;
        else if (id < index_a1[trungbinh]) return getIndexA1(id, start, trungbinh - 1);
        else return getIndexA1(id, trungbinh + 1, finish);
    }
    public static ArrayList<DummyItem> chiaLon(ArrayList<DummyItem> dummy_list){
        ArrayList<DummyItem> list = new ArrayList<>();
        int n = dummy_list.size() / 2;
        if (dummy_list.size() % 2 == 0) n--;
        for (int i = 0; i <= n; ++i)
            list.add(dummy_list.get(i));
        return list;
    }
    public static ArrayList<DummyItem> chiaNho(ArrayList<DummyItem> dummy_list){
        ArrayList<DummyItem> list = new ArrayList<>();
        int n = dummy_list.size() / 2;
        if (dummy_list.size() % 2 == 0) n--;
        for (int i = n + 1; i < dummy_list.size(); ++i)
            list.add(dummy_list.get(i));
        return list;
    }
    public static String removeFirstSpace(String string){
        StringBuilder sb = new StringBuilder(string);
        while (sb.charAt(0) == ' '){
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
    static boolean checkInArray(int[] array, int number_question){
        for (int i = 0; i < array.length; i++)
            if (array[i] == number_question)
                return true;
        return false;
    }
//    static String getLoaiBang(Activity activity){
//        SharedPreferences mPref = activity.getSharedPreferences(activity.getString(R.string.type), Context.MODE_PRIVATE);
//        return mPref.getString(activity.getString(R.string.loaibang), activity.getString(R.string.a1));
//    }

}

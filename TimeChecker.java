import java.util.Scanner;

public class TimeChecker {
    public static void main (String[] args) {

	while (true) {
	    System.out.println("------------------------------------------------------");
	    System.out.println("指定する時間範囲を、開始時刻と終了時刻(0~23)で入力してください");
	    System.out.println("例: 6 17");
	    
	    Scanner timeRangeScan = new Scanner(System.in);     // キーボード入力を受け付ける
	    
	    int begin = 0;
	    int end   = 0;
	    
	    try {
		begin = Integer.parseInt(timeRangeScan.next()); // 例ではstart = 6
		if (begin < 0 || begin > 23) {
		    System.out.println("開始時刻が正しく入力されていません。");
		    continue;
		}
	    } catch (NumberFormatException e) {
		System.out.println("開始時刻が正しく入力されていません。");
		continue;
	    }
	    
	    try {
		end   = Integer.parseInt(timeRangeScan.next()); // 例ではend = 17
		if (end < 0 || end > 23) {
		    System.out.println("終了時刻が正しく入力されていません。");
		    continue;
		}
	    } catch (NumberFormatException e) {
		System.out.println("終了時刻が正しく入力されていません。");
		continue;
	    }

	    
	    while (true) {
		System.out.println("------------------------------------------------------");
		System.out.println("範囲に入っているか確かめたい時刻(0~23)を入力してください");
		System.out.println("例: 8");
		
		Scanner timeCheckedScan = new Scanner(System.in);     // キーボード入力を受け付ける
		
		int timeChecked = 0;
		
		try {
		    timeChecked = Integer.parseInt(timeCheckedScan.next()); // 例ではtimeChecked = 8
		    if (timeChecked < 0 || timeChecked > 23) {
		    System.out.println("時刻が正しく入力されていません。");
		    continue;
		}
		} catch (NumberFormatException e) {
		    System.out.println("時刻が正しく入力されていません。");
		    continue;
		}
		
		boolean success = false; // 時間の範囲内に含まれるかどうかのboolean
		
		if (begin > end) {
		    // begin=17, end=6などのbegin>endの場合
		    success = (timeChecked >= begin || timeChecked < end);
		} else if (begin < end){
		    // begin=6, end=17などのbegin<endの場合
		    success = (timeChecked >= begin && timeChecked < end);
		} else {
		    // beign=6,  end=6などのbegin=endの場合
		    success = (timeChecked == begin);
		}
		
		if (success) {
		    System.out.println(timeChecked + "時は、指定した時間の範囲内に含まれます。");
		} else {
		    System.out.println(timeChecked + "時は、指定した時間の範囲内に含まれません。");
		}
	    }
	}
    }
}

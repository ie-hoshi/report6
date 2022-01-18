package jp.ac.uryukyu.ie.e215728;

public class Board {

    //ゲーム実行中フラグ
    static boolean game = true;
  
    //オセロ版に対応した多次元配列
    static String[][] board = new String[3][3];
  
    static final String EMPTY = "　";
    static final String BLACK = "×";
    static final String WHITE = "○";
  
    static String stone;
    static String rev_stone;
  
    static public void initialize() {
  
      //オセロ版の要素を全てクリアする
      for (int i = 0; i < 3; i++) {
  
        for (int j = 0; j < 3; j++) {
  
          board[i][j] = EMPTY;
  
        }
  
      }
  
      //次うつ駒の色を指定
      stone = BLACK;
      rev_stone = WHITE;
  
      //ゲーム実行中フラグ
      game = true;
  
    }
  
    static public void showBoard() {
  
      //まだ空いている座標があるか
      boolean existempty = false;

      //オセロ版を描写する
      int i = 0;
      System.out.println(" |0 |1 |2 ");
      System.out.println("----------");
      for (String[] sarr : board) {
  
        System.out.print(i + "|");
        for (String s : sarr) {
  
          System.out.print(s);
          System.out.print("|");
  
          //空いている座標があるか、各駒数の集計
          if (s.equals(EMPTY)) {
            existempty = true;
          } 
  
        }
        System.out.println();
        System.out.println("----------");
  
        i++;
  
      }
  
      //System.out.println(BLACK + ":" + cnt_black);
      //System.out.println(WHITE + ":" + cnt_white);
      System.out.println("----------");
  
      if (existempty) {
  
        System.out.println(stone + "のターンです");
      } else {
        System.out.println("ゲーム終了！");
        game = false;
      }
  
    }
  
    static public void setStone(int x, int y) {
  
      // 版外の座標を指定した場合
      if (x > 2 || y > 2) {
        System.out.println("その位置に駒はおけません");
      }
  
      // 駒を配置できる場合
      if (board[y][x].equals(EMPTY)) {
        board[y][x] = stone;
  
        
        // 次うつ駒の設定
        String next_rev_storn = stone;
        stone = rev_stone;
        rev_stone = next_rev_storn;
  
        // オセロ版の描写
        showBoard();
  
      } else {
  
        // 既に駒がおいてある位置を指定した場合
        System.out.println("その位置に駒はおけません");
      }
  
    }
}
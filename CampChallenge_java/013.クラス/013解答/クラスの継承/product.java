/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet;

/**
 *
 * @author k-seki
 */
//課題「クラスの作成」で作成したクラスを継承し、以下の機能を持つクラスを作成してください。
//1. ２つの変数の中身をクリアするパブリックなメソッド
class sales extends salesDepartment {

    public void clear() {
        super.code = 0;
        super.name = "名称不明";
    }
}

class product {

    public static void main(String[] args) {
        sales s = new sales();
        s.setCode(2);
        s.setName("吉田茂");
        s.showInfo();

        System.out.println("\n");
        s.clear();
        s.showInfo();
    }
}

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
//以下の機能を持つクラスを作成してください。
//1. パブリックな２つの変数と、２つの変数に値を設定するパブリックなメソッドと、２つの変数の中身をprintするパブリックなメソッド
class salesDepartment {

    public Integer code;
    public String name;

    public void setCode(Integer code) {
        this.code = code;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void showInfo() {
        System.out.print("社員ID：" + code + "\n名前：" + name);
    }
}


class Employee {

    public static void main(String[] args) {
        salesDepartment sd = new salesDepartment();
        sd.setCode(1);
        sd.setName("まねきねこ");
        sd.showInfo();
    }

}

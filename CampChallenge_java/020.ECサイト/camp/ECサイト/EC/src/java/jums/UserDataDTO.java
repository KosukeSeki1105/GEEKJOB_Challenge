/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

//JavaBeansの必要条件
//publicで引数なしのコンストラクタ(初期化処理)を持つ
//フィールドは隠匿されていること
//フィールドは命令規則に沿ったメソッドが用意されている(getter/setterを持つ)
//シリアライズ可能であること

/**
 * 共通 - ユーザー情報保持クラス 
 * ユーザー情報を格納するBeansオブジェクト。
 * 型やフィールド名がDBと連携している。
 * データベースからの格納、
 * 取り出しで取得されたデータを最初に格納する。
 * 
 *ユーザー情報を持ちまわるJavaBeans
 * データベースのカラムと型に対応させている(DTO)。
 * データの挿入、取り出しどちらにも便利.
 * @author guest1Day
 */
public class UserDataDTO {
    
}

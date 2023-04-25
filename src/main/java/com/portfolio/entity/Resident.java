package com.portfolio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data /** Lombokのアノテーションです。「getter/setter、toString、hashCode、equals」のメソッドを生成します */
@Entity /** エンティティクラス（データベースのテーブルにマッピングするクラス）であることを示します */
@Table(name = "resident") /** エンティティが対応する（紐づく）テーブル名を指定します。今回はMySQLの resident テーブルに対応しています。 */
public class Resident {

        /** 性別用の列挙型 */
        public static enum Gender{
            男性,女性
        }

        /** 主キー　自動生成 */
        @Id /** 主キー */
        @GeneratedValue(strategy = GenerationType.IDENTITY) /** (@GeneratedValue):主キーの値を一意に自動生成します
                                                                GenerationType.IDENTITY:自動インクリメントで生成する */
        private Integer id;

        /** 名前　20桁　null不許可 */
        @Column(length = 20, nullable = false) /** フィールドをマッピングするテーブルのカラム（項目）を指定します
                                               name="カラム名"でマッピングするカラム名を指定できます。name属性を省略した場合、フィールド名がマッピングするカラム名となります
                                               length:フィールドの桁数を指定します。桁数指定ができるフィールドは文字列型か配列型のみです。数値型は指定できません。
                                               nullable:フィールドのNOT NULL制約を指定します。値が「true」のときはnull値を許可し、「false」のときはnull値を許可しません。デフォルト値は「true」です。*/
        private String name;

        /** 契約日 */
        @Column(nullable = false)
        @DateTimeFormat(pattern = "yyyy-MM-dd")
        private LocalDate contract_date;

        /** 居住日数 */
        private Integer residence_days;

        /** 性別 */
        @Column(length = 2)
        @Enumerated(EnumType.STRING) /** (@Enumerated):このフィールドの型が列挙型であることを指定します。
                                         EnumType.STRING:テーブルのカラムを文字列型に指定します。 */
        private Gender gender;

        /** 年齢 */
        private int age;

        /** 部屋番号 */
        @Column(length = 3)
        private int room_number;

        /** 削除フラグ */
        private Integer delete_Flag;
}

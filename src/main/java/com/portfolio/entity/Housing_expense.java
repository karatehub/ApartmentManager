package com.portfolio.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data /** Lombokのアノテーションです。「getter/setter、toString、hashCode、equals」のメソッドを生成します */
@Entity /** エンティティクラス（データベースのテーブルにマッピングするクラス）であることを示します */
@Table(name = "housing_expense") /** エンティティが対応する（紐づく）テーブル名を指定します。今回はMySQLの resident テーブルに対応しています。 */
public class Housing_expense {



        /** 主キー　自動生成 */
        @Id /** 主キー */
        @GeneratedValue(strategy = GenerationType.IDENTITY) /** (@GeneratedValue):主キーの値を一意に自動生成します
                                                                GenerationType.IDENTITY:自動インクリメントで生成する */
        private Integer id;

        /** 電気代 */
        private Integer electric_bill;

        /** 水道代 */
        private Integer water_bill;

        /** ネット代 */
        private Integer net_bill;

        /** 家賃 */
        private Integer rent;

        /** 住人のテーブルのID **/
        @ManyToOne
        @JoinColumn(name = "resident_id", referencedColumnName = "id")
        private Resident resident;


}
package com.enokb.librarian.enums;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

public enum BookType {
    NOVEL(0, "小说"),
    LITERATURE(1, "文学"),
    LIFE(2, "传记"),
    CALLIGRAPHY(3, "书法"),
    PHOTOGRAPH(4, "摄影"),
    PAINTING(5, "绘画"),
    MUSIC(6, "音乐"),
    ART(7, "艺术"),
    MANAGER(8, "管理"),
    ECONOMIC(9, "经济"),
    HISTORY(10, "历史"),
    CONSTRUCTION(11, "建筑"),
    PHYSIC(12, "医学"),
    TECHNOLOGY(13, "工业技术"),
    YOUTH_LITERATURE(14, "青春文学"),
    SCIENCE(15, "科普读物"),
    AGRICULTRUE(16, "农业/林业"),
    ENT(17, "娱乐/休闲"),
    SPORT(18, "体育/运动"),
    POLITICS(19, "政治/军事"),
    SINOLOGY(20, "国学/古籍"),
    PHILOSOPHY(21, "哲学/宗教"),
    ELECTROCOMMUNICATION(22, "电子与通信"),
    NATURE(23, "科学与自然"),
    SUCCESS(24, "励志与成功"),
    FINANCE(25, "金融与投资"),
    IT(26, "计算机与互联网"),
    LAW(27, "法律"),
    CULTURE(28, "文化"),
    HOME(29, "家居"),
    MANGA(30, "动漫"),
    CHILDREN(31, "童书"),
    EXAM(32, "考试"),
    PSYCHOLOGY(33, "心理学"),
    SOCIAL(34, "社会科学"),
    FOREIGN_LANGUAGE(35, "外语学习"),
    ENTRANCE(36, "进口原版"),
    FAMILY_EDUCATION(37, "育儿/家教"),
    MOTHERHOOD(38, "孕产/胎教"),
    TOURISM(39, "旅游/地图"),
    COOKING(40, "烹饪/美食"),
    FASHION(41, "时尚/美妆"),
    MAGAZINE(42, "杂志/期刊"),
    MARRIAGE(43, "婚恋与两性"),
    FIT(44, "健身与保健"),
    LOWLEVEL_SUPPLEMENTARY(45, "中小学教辅"),
    HIGHLEVEL_SUPPLEMENTARY(46, "大中专教材教辅"),
    REFERENCE_BOOK(47, "字典词典/工具书");

    private int type;
    private String name;

    BookType(int type, String name) {
        this.type = type;
        this.name = name;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    @JsonValue
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonCreator
    public static BookType forType(int type) {
        for (BookType bookType : values()) {
            if (bookType.getType() == type) {
                return bookType;
            }
        }
        return null;
    }
}
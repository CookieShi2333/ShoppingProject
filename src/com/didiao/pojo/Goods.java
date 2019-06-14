package com.didiao.pojo;
/**
 * @Desc:商品的实体类
 * 
 * @author VULCAN
 * @date 2019/3/19
 */
public class Goods {
	private int id;                 //商品编号
	private String title;           //商品标题
	private double oldMoney;        //价格
	private double money;           //商场价格
    private int goodNumber;         //商品数量
    private String goodIntroduction;//商品简介
    private int sellNumber;        //累计售出
    private String image;          //图片存放地址
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public double getOldMoney() {
		return oldMoney;
	}
	public void setOldMoney(double oldMoney) {
		this.oldMoney = oldMoney;
	}
	public double getMoney() {
		return money;
	}
	public void setMoney(double money) {
		this.money = money;
	}
	public int getGoodNumber() {
		return goodNumber;
	}
	public void setGoodNumber(int goodNumber) {
		this.goodNumber = goodNumber;
	}
	public String getGoodIntroduction() {
		return goodIntroduction;
	}
	public void setGoodIntroduction(String goodIntroduction) {
		this.goodIntroduction = goodIntroduction;
	}
	public int getSellNumber() {
		return sellNumber;
	}
	public void setSellNumber(int sellNumber) {
		this.sellNumber = sellNumber;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
}

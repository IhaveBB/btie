package observer1;

/**
 * @name: Shop
 * @author: IhaveBB
 * @date: 2024-11-07 20:16
 **/
public class Shop extends Subject {
	public void newProduct() {
		System.out.println("商场到新商品喽");
		notice(CategoryEnum.NEW_PRODUCT);
	}

	public void discount() {
		System.out.println("商品降价喽");
		super.notice(CategoryEnum.DISCOUNT);
	}
}

# PizzaFactory
## ÇÁ·ÎÁ§Æ® °³¿ä
ÁöÁ¡¿¡ µû¶ó ½ºÅ¸ÀÏÀÌ ´Ù¸¥ ÇÇÀÚ¸¦ Á¦°øÇÏ´Â ÇÁ·Î±×·¥ÀÌ´Ù.

## ±â¼ú ½ºÅÃ
- Java

## ¼³Ä¡ ¹× »ç¿ë¹ı
1. ¼³Ä¡ ¹æ¹ı


	```bash
	git clone https://github.com/JIMIN-1211/FactoryMethodPattern.git
	cd FactoryMethodPattern

## ÁÖ¿ä ±â´É
- ´º¿å ½ºÅ¸ÀÏ ÇÇÀÚ¸¦ ÁÖ¹®ÇÏ°í ½ÍÀ¸¸é ÇØ´ç ÁöÁ¡¿¡¼­ ÇÇÀÚ¸¦ ÁÖ¹®ÇÏ¸é Ä¡Áî ÇÇÀÚ¸¦ ÁÖ¹®ÇÏ´õ¶óµµ ´º¿å½Ä ÇÇÀÚ¸¦ ¸¸µé¾î¼­ Á¦°øÇØÁØ´Ù. 
- ½Ã¯—°í ½ºÅ¸ÀÏ ÇÇÀÚ ¶ÇÇÑ ÁÖ¹®ÀÌ °¡´ÉÇÏ´Ù. 

## ¹®Á¦ ÇØ°á °úÁ¤
### 1. ±¸»ó Å¬·¡½º¿Í ¼­ºê Å¬·¡½ºÀÇ Â÷ÀÌÁ¡
±¸»ó Å¬·¡½º : ºÎ¸ğ Å¬·¡½ºÀÇ ±â´É¸¸ Á¦°øÇÏ°í »ó¼ÓÀº ºÒ°¡ÇÏ´Ù.   

¼­ºê Å¬·¡½º : ºÎ¸ğ Å¬·¡½ºÀÇ ±â´É È®Àå / º¯°æÇÏ°í »ó¼ÓÀÌ °¡´ÉÇÏ´Ù. 

### 2. ÆÑÅä¸® ¸Ş¼­µå
	ÀÌ ÄÚµå¿¡¼­ º¼ ¶§ ÇÇÀÚ ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÒ °æ¿ì ¿©·¯ Á¾·ùÀÇ ÇÇÀÚ ÀÎ½ºÅÏ½º¸¦ »ı¼ºÇÏ°í Á¦°ÅÇØ¾ßÇÏ´Â °æ¿ì ÀÏÀÏÈ÷ pizzaStoreÀÇ ÄÚµå¸¦ ¸Å¹ø ¼öÁ¤ÇØÁà¾ßÇÑ´Ù. 
	
		```Java
		public class PizzaStore {
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				if(type.equals("cheese"){
					pizza = new CheesePizza(); //ÀÌºÎºĞ
				}else if(type.equals("pepperoni"){
					pizza = new pepperoniPizza(); //ÀÌºÎºĞ
				}
			}
		}
	
	±×·¡¼­ ÀÌ·± º¯È­µÇ´Â ºÎºĞÀ» **Ä¸½¶È­** ÇØ¼­ °´Ã¼ »ı¼º°ú »ç¿ëÀ» ºĞ¸®ÇÑ´Ù. 
	
	±×¸®°í ÀÌ·¸°Ô °´Ã¼ »ı¼ººÎºĞÀ» ÀÎÅÍÆäÀÌ½º ¶Ç´Â Ãß»óÅ¬·¡½º¿¡ Ãß»ó ¸Ş¼­µå·Î ÆÑÅä¸® ¸Ş¼­µå¸¦ Á¤ÀÇÇÏ°í   
	ÀÌ°É »ó¼Ó¹ŞÀº '¼­ºêÅ¬·¡½º'¿¡ µû¶ó °´Ã¼¸¦ »ı¼ºÇÏ´Â ¹æ¹ıÀ» µ¿ÀûÀ¸·Î º¯°æÇÒ ¼ö ÀÖ´Ù. 
	
		```Java
		public abstract class PizzaStore {
	
			public Pizza OrderPizza(String type) {
				Pizza pizza;
				
				pizza = CreatePizza(type);
				
				pizza.prepare();
				pizza.bake();
				pizza.cut();
				pizza.box();
				
				return pizza;
			}
			
			public abstract Pizza CreatePizza(String type);//ÆÑÅä¸® ¸Ş¼­µå
		
		}
		//¼­ºêÅ¬·¡½º
		public class NyPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("cheese")) {
					return new NyStyleCheesePizza();
				}else {
					return new NyStylePepperoniPizza();
				}
			}
		
		}
		//¼­ºêÅ¬·¡½º
		public class ChicagoPizzaStore extends PizzaStore {
		
			@Override
			public Pizza CreatePizza(String type) {
				// TODO Auto-generated method stub
				if(type.equals("Cheese")) {
					return new ChicagoStyleCheesePizza();
				}else {
					return new ChicagoStylePepperoniPizza();
				}
			}
			
		}
		
		
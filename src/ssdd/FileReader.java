package ssdd;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class FileReader {

	public List<Item> loadAllDrinks(){
		try{
			List<Item> result = new ArrayList<Item>();
			List<String> allDrinks = Files.readAllLines(Paths.get("drinks.txt"), Charset.defaultCharset()); //good function from library
			for(String l : allDrinks) {
				String[] drink = l.split("\\|");
				result.add(new Item(drink[0], Double.parseDouble(drink[1]), Integer.parseInt(drink[2])));
			}
			return result;
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
	
	public List<Money> loadAllMoney(){
		try{
			List<Money> result = new ArrayList<Money>();
			List<String> allMoney = Files.readAllLines(Paths.get("money.txt"), Charset.defaultCharset()); //good function from library
			for(String l : allMoney) {
				String[] money = l.split("\\|");
				result.add(new Money(money[0], Double.parseDouble(money[1]), Integer.parseInt(money[2]), Boolean.parseBoolean(money[3])));
			}
			return result;
		}
		catch(IOException e){
			e.printStackTrace();
			return null;
		}
	}
}

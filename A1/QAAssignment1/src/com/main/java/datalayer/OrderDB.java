package com.main.java.datalayer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderDB {

	final Integer QUANTITY_THRESHOLD = 100;
	
	List<String> dealerIds = new ArrayList<>(
			Arrays.asList("XXX-1234-ABCD-1231","XXX-1234-ABCD-1232",
						  "XXX-1234-ABCD-1233","XXX-1234-ABCD-1234",
						  "XXX-1234-ABCD-1235","XXX-1234-ABCD-1236",
						  "XXX-1234-ABCD-1237","XXX-1234-ABCD-1238",
						  "XXX-1234-ABCD-1239","XXX-1234-ABCD-1240"));
	
	List<String> dealerAccessKeys = new ArrayList<>(
			Arrays.asList("kkklas8882kk23nllfjj88290","kkklas8882kk23nllfjj88291",
						   "kkklas8882kk23nllfjj88292","kkklas8882kk23nllfjj88293",
						   "kkklas8882kk23nllfjj88294","kkklas8882kk23nllfjj88295",
						   "kkklas8882kk23nllfjj88296","kkklas8882kk23nllfjj88297",
						   "kkklas8882kk23nllfjj88298","kkklas8882kk23nllfjj88300"));

	List<Integer> outOfOrderPartNumbers = new ArrayList<>(
			Arrays.asList( 1201 , 1202 , 1203 , 1204 , 1205 , 1206 , 1207 , 1208 , 1209 , 1210 ,
						   1211 , 1212 , 1213 , 1214 , 1215 , 1216 , 1217 , 1218 , 1219 , 1220 ));
	
	List<Integer> availablePartNumbers = new ArrayList<>(
			Arrays.asList( 1231 , 1232 , 1233 , 1234 , 1235 , 1236 , 1237 , 1238 , 1239 , 1240 ,
						   1241 , 1242 , 1243 , 1244 , 1245 , 1246 , 1247 , 1248 , 1249 , 1250 ));
	
	List<Integer> nonManufacturedPartNumbers = new ArrayList<>(
			Arrays.asList( 1261 , 1262 , 1263 , 1264 , 1265 , 1266 , 1267 , 1268 , 1269 , 1270 ,
						   1271 , 1272 , 1273 , 1274 , 1275 , 1276 , 1277 , 1278 , 1279 , 1280 , 5678));
	
	public boolean authenticateDealerId(String dealerId) {

		if (dealerIds.contains(dealerId))
			return true;
		return false;
	}

	public boolean authenticateDealerAccessKey(String dealerAccessKey) {

		if (dealerAccessKeys.contains(dealerAccessKey))
			return true;
		return false;
	}

	public boolean checkForOutOfStock(Integer partNumber) {
		if (outOfOrderPartNumbers.contains(partNumber))
			return true;
		return false;
	}

	public boolean checkForItemManufacturedAvailability(Integer partNumber) {
		if (nonManufacturedPartNumbers.contains(partNumber))
			return true;
		return false;
	}

	public boolean checkForItemAvailability(int partNumber) {
		if (availablePartNumbers.contains(partNumber))
			return true;
		return false;
	}
}

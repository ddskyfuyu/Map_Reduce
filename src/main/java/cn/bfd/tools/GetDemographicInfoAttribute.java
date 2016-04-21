package cn.bfd.tools;

import cn.bfd.protobuf.UserProfile2;
import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GetDemographicInfoAttribute {
	private static Logger LOG = Logger.getLogger(GetDemographicInfoAttribute.class);
	
	/*
     *  get the Distribution of DemographicInfo
     *  @param: dg_info, the object of DemographicInfo
     *  @param: result, save the results of the distribution of DemographicInfo
     *  @param: prefix, the prefix string of the Fifth category(/人口属性/互联网/性别)
     *  @return: void
     */
     public static void getSexDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
             											  String prefix,
                                                          Map<String, String> keyMap,
                                                          Map<String, Integer> result){

		 String attr_key = "net_sex";
		 List<String> key_list = new ArrayList<String>();
		 key_list.add(prefix);
		 if(keyMap.containsKey(attr_key)){
			 key_list.add(keyMap.get(attr_key));
			 for(int i = 0; i < dg_info.getSexCount(); ++i){
				 if(key_list.size() < 3){  //Firstly, update the third position
					 key_list.add(dg_info.getSex(i).getValue());
				 }
				 else{
					 key_list.set(2, dg_info.getSex(i).getValue());
				 }
				 String key = StringUtils.join(key_list, "/");
				 LOG.info("Sex: " + key);
				 result.put(key, 1);
			 }
		 }
     }
     
     
     
     /*
      *  get the Distribution of DemographicInfo
      *  @param: dg_info, the object of DemographicInfo
      *  @param: result, save the results of the distribution of DemographicInfo
      *  @param: prefix, the prefix string of the Fifth category(/人口属性/地区地域)
      *  @return: void
      */
      public static void getCityDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
              											   String prefix,
                                                           Map<String, String> keyMap,
                                                           Map<String, String> cityMap,
                                                           Map<String, Integer> result){

		  List<String> key_prov_list = new ArrayList<String>();
		  List<String> key_city_list = new ArrayList<String>();

		  key_prov_list.add(prefix);
		  key_city_list.add(prefix);

		  String attr_prov_key = "net_locations";
		  String attr_city_key ="city_type";



		  //set the prefix of  the province attribute
		  if(keyMap.containsKey(attr_prov_key)){
			  key_prov_list.add(keyMap.get(attr_prov_key));
			  key_prov_list.add("省");
		  }

		  //set the prefix of the city attribute
		  if(keyMap.containsKey(attr_city_key)){
			  key_city_list.add(keyMap.get(attr_city_key));
			  key_city_list.add("市");
		  }

     	 for(int i = 0; i < dg_info.getCityCount(); ++i){
			 String[] ProvAndCity = dg_info.getCity(i).getValue().split("$");
			 if(ProvAndCity.length != 2){
				 continue;
			 }
			 if(key_prov_list.size() > 1){
				 if(key_prov_list.size() < 4){
					 key_prov_list.add(ProvAndCity[0]);
				 }
				 else{
					 key_prov_list.set(3, ProvAndCity[0]);
					 String key = StringUtils.join(key_prov_list, "/");
					 LOG.info("省: " + key);
					 result.put(key, 1);
				 }
			 }

			 if(key_city_list.size() > 1){
				 if(key_city_list.size() < 4){
					 key_city_list.add(ProvAndCity[1]);
				 }
				 else{
					 key_city_list.set(3, ProvAndCity[1]);
					 String key = StringUtils.join(key_city_list, "/");
					 LOG.info("市: " + key);
					 result.put(key, 1);
				 }
			 }

          }
      }
      
      /*
       *  get the Distribution of DemographicInfo
       *  @param: dg_info, the object of DemographicInfo
       *  @param: result, save the results of the distribution of DemographicInfo
       *  @param: prefix, the prefix string of the Fifth category(/人口属性/互联网/年龄段)
       *  @return: void
       */
      public static void getAgesDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
																String prefix,
																Map<String, String> keyMap,
																Map<String, String> ageMap,
																Map<String, Integer> result){

		  String attr_key = "net_age";
		  List<String> key_list = new ArrayList<String>();
		  key_list.add(prefix);
		  if(keyMap.containsKey(attr_key)){
			  key_list.add(keyMap.get(attr_key));
			  for(int i = 0; i < dg_info.getAgesCount(); ++i){
				  if(!ageMap.containsKey(dg_info.getAges(i).getValue())){
					  continue;
				  }
				  String value = ageMap.get(dg_info.getAges(i).getValue());
				  if(key_list.size() < 3){  //Firstly, update the third position
					  key_list.add(value);
				  }
				  else{
					  key_list.set(2, value);
				  }
				  String key = StringUtils.join(key_list, "/");
				  LOG.info("net_age: " + key);
				  result.put(key, 1);
			  }
		  }
      }

      /*
       *  get the Distribution of DemographicInfo
       *  @param: dg_info, the object of DemographicInfo
       *  @param: result, save the results of the distribution of DemographicInfo
       *  @param: prefix, the prefix string of the Fifth category(/人口属性/自然属性/性别)
       *  @return: void
       */
      public static void getBioGenderDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
																	String prefix,
																	Map<String, String> keyMap,
																	Map<String, Integer> result){
    	  if(dg_info.hasBioGender()){
    		  String attr_key = "bioGender";
              List<String> key_list = new ArrayList<String>();
              key_list.add(prefix);
              LOG.info(dg_info.getBioGender());
              LOG.info(keyMap.get(attr_key));
              if(keyMap.containsKey(attr_key)){
		              key_list.add(keyMap.get(attr_key));
	              //key_list.add(attr_key);
	              key_list.add(dg_info.getBioGender().getValue());
	              String key = StringUtils.join(key_list, "/");
				  LOG.info("bioGender: " + key);
	              result.put(key, 1);
              }
    	  }
      }
      
      
      
      /*
       *  get the Distribution of DemographicInfo
       *  @param: dg_info, the object of DemographicInfo
       *  @param: result, save the results of the distribution of DemographicInfo
       *  @param: prefix, the prefix string of the Fifth category(/人口属性/自然属性/年龄段)
       *  @return: void
       */
      public static void getBioAgeDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
																	String prefix,
																	Map<String, String> keyMap,
																	Map<String, String> ageMap,
																	Map<String, Integer> result){
    	  if(dg_info.hasBioAge()){
    		  String attr_key = "bioAge";
              List<String> key_list = new ArrayList<String>();
              LOG.info(dg_info.getBioAge());
              key_list.add(prefix);
              if(keyMap.containsKey(attr_key)){
		          key_list.add(keyMap.get(attr_key));
	              key_list.add(ageMap.get(dg_info.getBioAge().getValue()));
	              LOG.info(dg_info.getBioAge());
	              String key = StringUtils.join(key_list, "/");
	              LOG.info(key);
				  LOG.info("bioAge: " + key);
	              result.put(key, 1);
              }
    	  }
      }

     

      /*
       *  get the Distribution of DemographicInfo
       *  @param: dg_info, the object of DemographicInfo
       *  @param: result, save the results of the distribution of DemographicInfo
       *  @param: prefix, the prefix string of the Fifth category(/人口属性/互联网/婚姻状况)
       *  @return: void
       */
      public static void getMarriedDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
																	String prefix,
																	Map<String, String> keyMap,
																	Map<String, Integer> result){
    	  if(dg_info.hasMarried()){
    		  String attr_key = "dg_Married";
              List<String> key_list = new ArrayList<String>();
              key_list.add(prefix);
              //key_list.add(attr_key);
                  //do something
              if(keyMap.containsKey(attr_key)){
		          key_list.add(keyMap.get(attr_key));
            	  if(dg_info.getMarried()){
                	  key_list.add("已婚");
                      String key = StringUtils.join(key_list, "/");
					  LOG.info("dg_Married: " + key);
                      result.put(key, 1);
                  } 
              }
    	  }
      }
      
      /*
       *  get the Distribution of DemographicInfo
       *  @param: dg_info, the object of DemographicInfo
       *  @param: result, save the results of the distribution of DemographicInfo
       *  @param: prefix, the prefix string of the Fifth category(/人口属性/互联网/是否有子女)
       *  @return: void
       */
      public static void getHasBabyDemographicInfoDistribution(UserProfile2.DemographicInfo dg_info,
																	String prefix,
																	Map<String, String> keyMap,
																	Map<String, Integer> result){
    	  if(dg_info.hasHasBaby()){
    		  String attr_key = "dg_baby";
              List<String> key_list = new ArrayList<String>();
              key_list.add(prefix);
              if(keyMap.containsKey(attr_key)){
		          key_list.add(keyMap.get(attr_key));
	              if(dg_info.getHasBaby()){
	            	  key_list.add("有孩子");
	                  String key = StringUtils.join(key_list, "/");
					  LOG.info("dg_baby: " + key);
	                  result.put(key, 1);
	              }
              }
    	  }
      }



}

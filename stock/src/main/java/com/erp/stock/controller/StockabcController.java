package com.erp.stock.controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.erp.common.entity.ResultPoJo;
import com.erp.stock.util.sslClient;
import io.swagger.annotations.ApiOperation;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.util.EntityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/stock")
public class StockabcController {

    private void loopStockList(Integer pagenum,Integer pagesize,Integer pagecount) throws Exception{
        String url = "https://api.jisuapi.com/stockhistory/list?classid=1&pagenum="+pagenum+"&pagesize="+pagesize+"&appkey=ffcc3c759c5ca0b3";
        HttpClient httpClient= new sslClient();
        HttpGet httpGet =new HttpGet(url);
        HttpResponse response =null;
        String content;
        try{
            response= httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode() ==200){
                content = EntityUtils.toString(response.getEntity(),"utf-8");
                JSONObject jsonObject = JSONUtil.parseObj(content);
                String status = jsonObject.get("status").toString();
                if(status.equals("0")){
                    JSONObject jsonResult = JSONUtil.parseObj(jsonObject.get("result"));
                    Integer total =jsonResult.getInt("totle");
                    pagecount = total/pagesize+1;
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    @PostMapping("/getStockList")
    @ApiOperation(value = "获取股票列表", notes = "获取股票列表")
    public ResultPoJo getStockList() throws Exception {
        //https://blog.csdn.net/ljk126wy/article/details/84136027
        //https://blog.csdn.net/qq_39368007/article/details/104845973
        Integer pagenum=1;
        Integer pagesize=30;
        Integer pagecount=1;
        loopStockList(pagenum,pagesize,pagecount);


//        HttpPost httpPost=new HttpPost(url);
//        List<NameValuePair> parameters =new ArrayList<NameValuePair>();
//        parameters.add(new BasicNameValuePair("grant_type","client_credentials"));
//        UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(parameters, Consts.UTF_8);
//        httpPost.setEntity(formEntity);
//        CloseableHttpResponse response= null;
//        try{
//            response =httpClient.execute(httpPost);
//            int statusCode = response.getStatusLine().getStatusCode();
//            if(statusCode ==200){
//                String content = EntityUtils.toString(response.getEntity(),"UTF-8");
//                EntityUtils.consume(response.getEntity());
//            }
//        }catch (ClientProtocolException e){
//            e.printStackTrace();
//        }catch (IOException e){
//            e.printStackTrace();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        finally {
//            response.close();
//        }
//
        ResultPoJo<String> re =new ResultPoJo<>().setResult("");
        return re;
    }
}
